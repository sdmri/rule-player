package rule.engine.service;

import org.junit.Assert;
import org.junit.Test;
import product.catalogue.entities.Category;
import product.catalogue.entities.Product;
import rule.engine.action.entities.FreeProduct;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RuleEngineServiceTest {
    private static String conditionJson = "{\"EX_TYPE\":\"Complex\",\"exps\":[{\"EX_TYPE\":\"Simple\",\"cType\":{\"CON_TYPE\":\"Cart\",\"val\":5000.0,\"fop\":\"GT\"},\"op\":\"OR\"},{\"EX_TYPE\":\"Complex\",\"exps\":[{\"EX_TYPE\":\"Simple\",\"cType\":{\"CON_TYPE\":\"Cart\",\"val\":3000.0,\"fop\":\"GT\"},\"op\":\"AND\"},{\"EX_TYPE\":\"Simple\",\"cType\":{\"CON_TYPE\":\"Category\",\"cIds\":[201,200,202],\"exclude\":true},\"op\":null}],\"op\":null}],\"op\":null}";

    // Rule applicable on product
    @Test
    public void testApplicableRules() throws Exception {

        Product product = new Product(11,"abs",4000.1,3500.0);
        product.addCategory(new Category(180,"cat1"));

        RuleEngineService ruleEngineService = new RuleEngineServiceImpl();
        ruleEngineService.addRule(conditionJson, new FreeProduct("XYZ"));

        Set<Product> products = new HashSet<Product>();
        products.add(product);

        boolean result = ruleEngineService.executeAllRules(products);
        Assert.assertTrue("Expected result of rule execution to be true",result);
    }

    // Rule not applicable on the product
    @Test
    public void testNonApplicableRule() throws Exception {
        Product product = new Product(11,"abs",1000.1,1100.0);
        product.addCategory(new Category(180,"cat1"));

        RuleEngineService ruleEngineService = new RuleEngineServiceImpl();
        ruleEngineService.addRule(conditionJson, new FreeProduct("XYZ"));

        Set<Product> products = new HashSet<Product>();
        products.add(product);

        boolean result = ruleEngineService.executeAllRules(products);
        Assert.assertFalse("Expected result of rule execution to be false",result);
    }

}