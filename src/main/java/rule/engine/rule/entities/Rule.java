package rule.engine.rule.entities;

import product.catalogue.entities.Product;
import rule.engine.action.entities.Action;
import rule.engine.condition.entities.ConditionExpression;

/**
 * Created by shiven on 01-08-2015.
 */
public class Rule {
    private ConditionExpression conditionExpression;
    private Action action;

    public boolean execute(Product product){
        if(conditionExpression.evaluate(product)){
            action.printResult();
            return true;
        }
        return false;
    }

    public ConditionExpression getConditionExpression() {
        return conditionExpression;
    }

    public Action getAction() {
        return action;
    }

    public void setConditionExpression(ConditionExpression conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "conditionExpression=" + conditionExpression +
                ", action=" + action +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        if (action != null ? !action.equals(rule.action) : rule.action != null) return false;
        if (conditionExpression != null ? !conditionExpression.equals(rule.conditionExpression) : rule.conditionExpression != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionExpression != null ? conditionExpression.hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }
}
