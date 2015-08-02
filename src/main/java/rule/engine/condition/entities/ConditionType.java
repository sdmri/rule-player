package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import product.catalogue.entities.Product;

/**
 * Created by shiven on 02-08-2015.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , include = JsonTypeInfo.As.PROPERTY, property = "CON_TYPE")
@JsonSubTypes({@JsonSubTypes.Type(name = "Cart",value = CartTotalConditionType.class),
        @JsonSubTypes.Type(name = "Category",value = CategoryConditionType.class)})
public interface ConditionType {
        public boolean evaluate(Product product);
}
