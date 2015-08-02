package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Created by shiven on 02-08-2015.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , include = JsonTypeInfo.As.PROPERTY, property = "CON_TYPE")
@JsonSubTypes({@JsonSubTypes.Type(name = "Cart",value = CartTotal.class),
        @JsonSubTypes.Type(name = "Category",value = Category.class)})
public interface ConditionType {
}
