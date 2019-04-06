package com.ayudantia.demoproyecto.Validators;

import com.ayudantia.demoproyecto.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ayudantia.demoproyecto.Services.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;


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
            errors.rejectValue("username","Size.userForm.username");
        }
        if(userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");
        if(user.getPassword().length()<6 || user.getPassword().length()>32){
            errors.rejectValue("password","Size.userForm.password");
        }
        if(!user.getPasswordConfirm().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm","Diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"correo","NotEmpty");
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
        if(!(pattern.matcher(user.getCorreo()).matches())){
            errors.rejectValue("correo","Inv.userForm.correo");
        }
    }
}
