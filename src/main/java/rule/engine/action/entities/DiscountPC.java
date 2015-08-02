package rule.engine.action.entities;

/**
 * Created by shiven on 02-08-2015.
 */
public class DiscountPC implements Action {
    double discountPercent;

    public DiscountPC(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public void printResult() {
        System.out.println("Discount of "+discountPercent+ "% on price");
    }
}
