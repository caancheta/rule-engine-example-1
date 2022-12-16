package com.cancheta;

import com.cancheta.Phone.OSType;

public class Main {

    public static void main(String[] args) {
        RuleEngine ruleEngine = new RuleEngine();
        ruleEngine
            .registerRule(new AndroidPhoneRule<>())
            .registerRule(new IPhoneRule<>());
        Phone androidPhone = new Phone(OSType.ANDROID);
        Phone retPhone = ruleEngine.rule(androidPhone);

        System.out.println("Output Phone: " + retPhone.getModelName());
    }

}