package rule.engine.action.entities;

/**
 * Created by shiven on 02-08-2015.
 */
public class FreeProduct implements Action {

    String productName;

    public FreeProduct(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void printResult() {
        System.out.println("You get a free product : "+ productName);
    }
}
