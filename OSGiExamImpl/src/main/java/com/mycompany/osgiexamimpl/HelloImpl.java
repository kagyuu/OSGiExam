package com.mycompany.osgiexamimpl;

import com.mycompany.osgiexamapi.Hello;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component(name="hello-service")
@Service
public class HelloImpl implements Hello {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }    
}
