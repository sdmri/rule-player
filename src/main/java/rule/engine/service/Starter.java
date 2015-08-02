package rule.engine.service;

import org.codehaus.jackson.map.ObjectMapper;
import rule.engine.condition.entities.*;

import java.io.IOException;

/**
 * Created by shiven on 02-08-2015.
 */
public class Starter {

    public static void main(String args[]){
        SimpleConditionExpression cond1 = new SimpleConditionExpression();
        cond1.setConditionType(new CartTotal(3000, FilterOperator.GT));
        cond1.setOperator(Operator.AND);
        ComplexConditionExpression complex1= new ComplexConditionExpression();
        complex1.addConditionExpression(cond1);
        SimpleConditionExpression cond2 = new SimpleConditionExpression();
        Category cat1 = new Category();
        cat1.addCategoryId(200);
        cat1.addCategoryId(201);
        cat1.addCategoryId(202);
        cat1.setExclusion(true);
        cond2.setConditionType(cat1);
        complex1.addConditionExpression(cond2);
        ComplexConditionExpression overall = new ComplexConditionExpression();
        SimpleConditionExpression cond3 = new SimpleConditionExpression();
        cond3.setConditionType(new CartTotal(5000, FilterOperator.GT));
        cond3.setOperator(Operator.OR);
        overall.addConditionExpression(cond3);
        overall.addConditionExpression(complex1);

        System.out.println("expression "+overall);

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println ("json ->" +mapper.writeValueAsString(overall));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
