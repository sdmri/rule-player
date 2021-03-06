package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonProperty;
import product.catalogue.entities.Product;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by shiven on 02-08-2015.
 */
public class ComplexConditionExpression implements ConditionExpression {

    @JsonProperty("exps")
    private Queue<ConditionExpression> conditionExpressions = new ArrayDeque<ConditionExpression>();
    @JsonProperty("op")
    private Operator operator;

    @Override
    public boolean evaluate(Product product) {
        boolean result = false;
        for(ConditionExpression conditionExpression : conditionExpressions){
            result = conditionExpression.evaluate(product);
            if(Operator.AND == conditionExpression.getOperator() && !result){
                // If this condition expression evaluates to false and the next condition is AND'ed
                // return
                return false;
            }else if(Operator.OR == conditionExpression.getOperator() && result) {
                // if current condition is true and the next expression is OR'ed , do not evaluate further
                return true;
            }
        }
        return result;
    }

    @Override
    public Operator getOperator() {
        return operator;
    }

    public void addConditionExpression(ConditionExpression conditionExpression) {
        conditionExpressions.add(conditionExpression);
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "ComplexConditionExpression{" +
                "conditionExpressions=" + conditionExpressions +
                ", operator=" + operator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexConditionExpression that = (ComplexConditionExpression) o;

        if (conditionExpressions != null ? !conditionExpressions.equals(that.conditionExpressions) : that.conditionExpressions != null)
            return false;
        if (operator != that.operator) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionExpressions != null ? conditionExpressions.hashCode() : 0;
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
