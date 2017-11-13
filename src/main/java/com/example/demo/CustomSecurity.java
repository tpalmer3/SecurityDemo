package com.example.demo;


import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomSecurity implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        System.out.println("Inside Method Security");
        if (targetDomainObject instanceof String && permission instanceof String) {
            if(targetDomainObject.equals("nope"))
                return false;
            if(targetDomainObject.equals(permission))
                return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}