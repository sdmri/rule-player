package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonProperty;
import product.catalogue.entities.Product;

/**
 * Created by shiven on 02-08-2015.
 */
public class CartTotalConditionType implements ConditionType {
    @JsonProperty("val")
    private double value;
    @JsonProperty("fop")
    private FilterOperator filterOperator;

    public CartTotalConditionType() {
    }

    public CartTotalConditionType(double value, FilterOperator filterOperator) {
        this.value = value;
        this.filterOperator = filterOperator;
    }

    @Override
    public boolean evaluate(Product product) {
        if(FilterOperator.GT == filterOperator){
            return product.getSpecialPrice()>value;
        }else {
            return product.getSpecialPrice()<value;
        }
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

        CartTotalConditionType cartTotalConditionType = (CartTotalConditionType) o;

        if (Double.compare(cartTotalConditionType.value, value) != 0) return false;
        if (filterOperator != cartTotalConditionType.filterOperator) return false;

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

