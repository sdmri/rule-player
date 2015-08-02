package rule.engine.action.entities;

/**
 * Created by shiven on 02-08-2015.
 */
public class DiscountFlat implements Action {

    private int discount;

    public DiscountFlat(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public void printResult() {
        System.out.println("Flat discount of "+discount);
    }
}
