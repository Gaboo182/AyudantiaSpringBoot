package com.ayudantia.demoproyecto.Validators;

import com.ayudantia.demoproyecto.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ayudantia.demoproyecto.Services.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass){
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","NotEmpty");
        if(user.getUsername().length() <6 || user.getUsername().length()>32){
            errors.rejectValue("username","Size.userform.username");
        }
    }
}
