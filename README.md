# rule-player
Builds and evaluates rules

A simple implementation of a well defined rule engine for a product catalogue.
A rule consists of a condition expression along with an action to perform(in case condition evaluates to true)
User interface is provided by RuleEngineService
Any number of rules can be added to the rule engine via RuleEngineService
To evaluate, the service accepts a set of products. All rules are executed on each product and actions executed wherever applicable. 
