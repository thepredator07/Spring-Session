package com.example.redissession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {
    private final String HOME_VIEW_COUNT="HOME_VIEW_COUNT";

    @GetMapping("/")
    public String fun(Principal principal, HttpSession session){
        incrementCount(session,HOME_VIEW_COUNT);
        return("Hello"+principal.getName());
    }
    @GetMapping("/count")
    public String count(HttpSession session){
        return "Home view Count"+ session.getAttribute(HOME_VIEW_COUNT);
    }
    private void incrementCount(HttpSession session,String attr){
        var homeViewCount=session.getAttribute(attr)==null?0:(Integer)session.getAttribute(attr);
        session.setAttribute(attr,homeViewCount+1);
    }
}
