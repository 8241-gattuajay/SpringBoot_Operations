package com.example.Arithmetic_Operations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerArithmetic {
    @GetMapping("/calculate")
    public double calculate(
            @RequestParam String operation,
            @RequestParam double num1,
            @RequestParam double num2){
        switch (operation.toLowerCase()){
            case "add":
                return num1+num2;
            case "sub":
                return num1-num2;
            case "multiply":
                return num1*num2;
            case "div":
                if(num2!=0){
                    return num1/num2;
                }else{
                    throw new ArithmeticException("should not be zero");
                }
            default:
                throw new IllegalArgumentException("Invalid :"+operation);
        }
    }
}
