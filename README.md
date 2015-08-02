# rule-player
Builds and evaluates rules

A simple implementation of a well defined rule engine for a product catalogue.
A rule consists of a condition expression along with an action to perform(in case condition evaluates to true)
User interface is provided by RuleEngineService
Any number of rules can be added to the rule engine via RuleEngineService
To evaluate, the service accepts a set of products. All rules are executed on each product and actions executed wherever applicable. 

Condition expressions can be defined using jsons are representation:

eg. 
{cart_total > 5000}
OR
{price > 3000 AND category_id NOT IN “200,201,202”}

can be represented in a simple json as -

{
    "EX_TYPE": "Complex",
    "exps": [
        {
            "EX_TYPE": "Simple",
            "cType": {
                "CON_TYPE": "Cart",
                "val": 5000,
                "fop": "GT"
            },
            "op": "OR"
        },
        {
            "EX_TYPE": "Complex",
            "exps": [
                {
                    "EX_TYPE": "Simple",
                    "cType": {
                        "CON_TYPE": "Cart",
                        "val": 3000,
                        "fop": "GT"
                    },
                    "op": "AND"
                },
                {
                    "EX_TYPE": "Simple",
                    "cType": {
                        "CON_TYPE": "Category",
                        "cIds": [
                            201,
                            200,
                            202
                        ],
                        "exclude": true
                    }
                }
            ]
        }
    ]
}


Building project:
--------------------

Use maven to build this project from pom.xml kept under root

Executing project:
---------------------

Contains executable junit tests under src/test/java.

An executable jar generated after the build process can be included in java modules to use this rule engine api. 
