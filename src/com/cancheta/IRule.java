package com.cancheta;

/** 
 * 
*/
public interface IRule<I, O> {
    boolean matches(I input);
    O process(I input);
}