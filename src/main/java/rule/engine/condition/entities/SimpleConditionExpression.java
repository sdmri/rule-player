package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonProperty;
import product.catalogue.entities.Product;

import java.util.Queue;

/**
 * Created by shiven on 01-08-2015.
 */
public class SimpleConditionExpression implements ConditionExpression{
    @JsonProperty("cType")
    ConditionType conditionType;
    @JsonProperty("op")
    Operator operator;

    public boolean evaluateExpression(Product product){
        return false;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public boolean evaluate(Product product) {
        return false;
    }

    @Override
    public String toString() {
        return "SimpleConditionExpression{" +
                "conditionType=" + conditionType +
                ", operator=" + operator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleConditionExpression that = (SimpleConditionExpression) o;

        if (conditionType != null ? !conditionType.equals(that.conditionType) : that.conditionType != null)
            return false;
        if (operator != that.operator) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionType != null ? conditionType.hashCode() : 0;
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
