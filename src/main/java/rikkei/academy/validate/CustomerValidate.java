package rikkei.academy.validate;


import org.springframework.validation.Errors;

import rikkei.academy.model.Customer;

public class CustomerValidate {
    public void checkValidate(Customer c, Errors error){
        if(c.getName().trim().equals("")){
            error.rejectValue("name","name.empty");
        }else  if (c.getName().length()<5){
            error.rejectValue("name","name.length");
        }
        if (c.getAge()<18){
            error.rejectValue("age","age.size");
        }
    }
}
