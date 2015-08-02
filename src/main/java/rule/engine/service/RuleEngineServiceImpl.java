package rule.engine.service;

import org.codehaus.jackson.map.ObjectMapper;
import product.catalogue.entities.Product;
import rule.engine.action.entities.Action;
import rule.engine.condition.entities.ConditionExpression;
import rule.engine.rule.entities.Rule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by shiven on 01-08-2015.
 */
public class RuleEngineServiceImpl implements RuleEngineService{

    private List<Rule> rules = new ArrayList<Rule>();

    public void addRule(String conditionJson , Action action) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        ConditionExpression conditionExpressionMapped = mapper.readValue(conditionJson, ConditionExpression.class);
        Rule ruleToAdd = new Rule();
        ruleToAdd.setConditionExpression(conditionExpressionMapped);
        ruleToAdd.setAction(action);
        rules.add(ruleToAdd);
    }

    public boolean executeAllRules(Set<Product> products){
        boolean evalResult = false;
        if(products!=null){
            // Execute rule engine on each product individually
            for(Product product : products){
                // Execute each rule until we find one that
                // is applicable
                for(Rule rule : rules){
                    if(rule.execute(product)){
                        System.out.println("Evaluated to true for product "+product.getId());
                        evalResult = true;
                        break;
                    }
                }
            }
        }
        return evalResult;
    }
}
