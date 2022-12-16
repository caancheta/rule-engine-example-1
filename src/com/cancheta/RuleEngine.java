package com.cancheta;

import java.util.*;

public class RuleEngine {
    List<IRule<Phone,Phone>> rulesList = new ArrayList<>();

    public Phone rule (Phone phone) {
        return rulesList.stream()
            .filter(rule -> rule.matches(phone))
            .map(rule -> rule.process(phone))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No matching rule found"));
    }

    // Leverages builder pattern to extend rules set
    public RuleEngine registerRule(IRule<Phone,Phone> rule) {
        rulesList.add(rule);
        return this;
    }
}
