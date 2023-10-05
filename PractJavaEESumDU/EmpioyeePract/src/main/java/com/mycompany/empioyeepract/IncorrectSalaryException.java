package com.mycompany.empioyeepract;

public class IncorrectSalaryException extends Exception{
    public IncorrectSalaryException() {
    }
    public IncorrectSalaryException(String msg) {
        super(msg);
    }
}