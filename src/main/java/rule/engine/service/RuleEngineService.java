package rule.engine.service;

import product.catalogue.entities.Product;
import rule.engine.rule.entities.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by shiven on 01-08-2015.
 */
public class RuleEngineService {

    private List<Rule> rules = new ArrayList<Rule>();

    public void addRule(Rule ruleToAdd){
        rules.add(ruleToAdd);
    }

    public void executeAllRules(Set<Product> products){
        if(products!=null){
            // Execute rule engine on each product individually
            for(Product product : products){
                // Execute each rule until we find one that
                // is applicable
                for(Rule rule : rules){
                    if(rule.execute(product)){
                        break;
                    }
                }
            }
        }
    }
}
