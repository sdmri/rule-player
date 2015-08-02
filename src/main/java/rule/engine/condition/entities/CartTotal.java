package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by shiven on 02-08-2015.
 */
public class CartTotal implements ConditionType {
    @JsonProperty("val")
    private double value;
    @JsonProperty("fop")
    private FilterOperator filterOperator;

    public CartTotal() {
    }

    public CartTotal(double value, FilterOperator filterOperator) {
        this.value = value;
        this.filterOperator = filterOperator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public FilterOperator getFilterOperator() {
        return filterOperator;
    }

    public void setFilterOperator(FilterOperator filterOperator) {
        this.filterOperator = filterOperator;
    }

    @Override
    public String toString() {
        return "CartTotal{" +
                "value=" + value +
                ", filterOperator=" + filterOperator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartTotal cartTotal = (CartTotal) o;

        if (Double.compare(cartTotal.value, value) != 0) return false;
        if (filterOperator != cartTotal.filterOperator) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (filterOperator != null ? filterOperator.hashCode() : 0);
        return result;
    }
}

