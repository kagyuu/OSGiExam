package com.mycompany.osgiexamejb;

import com.mycompany.osgiexamapi.GoodBye;
import javax.ejb.Stateless;

@Stateless
public class GoodByeEjb implements GoodBye {

    @Override
    public String sayGoodBye(String name) {
        return "GoodBye " + name;
    }
}
