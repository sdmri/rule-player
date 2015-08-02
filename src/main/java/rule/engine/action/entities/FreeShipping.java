package rule.engine.action.entities;

/**
 * Created by shiven on 02-08-2015.
 */
public class FreeShipping implements Action {
    @Override
    public void printResult() {
        System.out.println("Shipping is on us!!");
    }
}
