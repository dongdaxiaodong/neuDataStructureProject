package com.bladejava.controller;


import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;

@Path
public class indexControl {

    @GetRoute
    public String index(){
        return "index.html";
    }
}
