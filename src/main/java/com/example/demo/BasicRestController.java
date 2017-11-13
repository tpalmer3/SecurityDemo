package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class BasicRestController {

    @RequestMapping(path="/home")
    @PreAuthorize("hasPermission('manager', 'manager')")
    public String helloWorld() {
        return "Hello, World!";
    }

    @RequestMapping(path="/hello")
    //@PreAuthorize("hasPermission('manager', 'manager')")
    @PreAuthorize("hasRole('Judo')")
    public String hello() {
        return "Hello, " + world();
    }

    @PreAuthorize("hasPermission('nope', 'manager')")
    @RequestMapping(path="/world")
    public String world() {
        return "World!";
    }

    @RequestMapping(path="/security")
    @PreAuthorize("hasPermission('nope', 'manager')")
    public String security(Authentication a) {
        return a.toString();
    }
}
