package com.cancheta;

public class IPhoneRule<I, O> implements IRule<Phone, Phone> {

    @Override
    public Phone process(Phone input) {
        input.setModelName("IPhone 13");
        return input;
    }

    @Override
    public boolean matches(Phone input) {
        return input.getOsType().equals(Phone.OSType.IOS);
    }
    
}
