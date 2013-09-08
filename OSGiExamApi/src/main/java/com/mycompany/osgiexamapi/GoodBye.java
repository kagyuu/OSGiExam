package com.mycompany.osgiexamapi;

import javax.ejb.Local;

@Local
public interface GoodBye {
    String sayGoodBye(String name);
}
