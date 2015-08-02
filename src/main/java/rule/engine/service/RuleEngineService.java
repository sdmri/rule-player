package rule.engine.service;

import product.catalogue.entities.Product;
import rule.engine.action.entities.Action;

import java.io.IOException;
import java.util.Set;

/**
 * Service exposed to users to add and evaluate rules
 *
 * Created by shiven on 02-08-2015.
 */
public interface RuleEngineService {
    /**
     * Adds a new rule to the engine with the action being executed when
     * associated condition is true
     *
     * @param conditionJson
     * @param action
     * @throws IOException
     */
    public void addRule(String conditionJson , Action action) throws IOException;

    /**
     * Executes all rules and returns true after executing action on the first applicable one
     * Returns false if none of the rules are applicable
     *
     * @param products
     */
    public boolean executeAllRules(Set<Product> products);
}
