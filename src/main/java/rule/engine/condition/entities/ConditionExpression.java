package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import product.catalogue.entities.Product;

import java.util.Queue;

/**
 * Created by shiven on 02-08-2015.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , include = JsonTypeInfo.As.PROPERTY, property = "EX_TYPE")
@JsonSubTypes({@Type(name = "Simple",value = SimpleConditionExpression.class),
               @Type(name = "Complex",value = ComplexConditionExpression.class)})
public interface ConditionExpression {
    public boolean evaluate(Product product);
}
