package com.cancheta.Rules.Impl;

import com.cancheta.Models.Phone;
import com.cancheta.Rules.IRule;

public class AndroidPhoneRule<I, O> implements IRule<Phone, Phone>{

    @Override
    public Phone process(Phone input) {
        input.setModelName("Pixel 7");
        return input;
    }

    @Override
    public boolean matches(Phone input) {
        return input.getOsType().equals(Phone.OSType.ANDROID);
    }
    
}
