package com.cancheta;

import java.util.*;

import com.cancheta.Models.Phone;
import com.cancheta.Rules.IRule;

public class RuleEngine {
    // Persisted rules set. In this example, this is an in-mem rules set.
    List<IRule<Phone,Phone>> rulesList = new ArrayList<>();

    public Phone rule (Phone phone) {
        // Inference Engine
        return rulesList.stream()
            .filter(rule -> rule.matches(phone)) // MATCH the 'fact' / data to the appropriate rule
            .map(rule -> rule.process(phone)) // EXECUTE the process that MATCH the rule
            .findFirst() // RESOLVE conflicts (i.e. 'facts' that match multiple rules
            .orElseThrow(() -> new RuntimeException("No matching rule found"));
    }

    // Leverages builder pattern to extend rules set
    public RuleEngine registerRule(IRule<Phone,Phone> rule) {
        rulesList.add(rule);
        return this;
    }
}
