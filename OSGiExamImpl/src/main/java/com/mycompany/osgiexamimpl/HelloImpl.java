package com.mycompany.osgiexamimpl;

import com.mycompany.osgiexamapi.Hello;

public class HelloImpl implements Hello {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }    
}
