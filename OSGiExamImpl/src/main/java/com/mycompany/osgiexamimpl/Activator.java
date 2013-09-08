package com.mycompany.osgiexamimpl;

import com.mycompany.osgiexamapi.Hello;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(final BundleContext context) throws Exception {
        System.out.println(String.format("start::%s", Activator.class.getCanonicalName()));
        context.registerService(Hello.class.getName(), new HelloImpl(), null);
        System.out.println(String.format("activated::%s as %s", HelloImpl.class.getName(), Hello.class.getName()));
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        context.ungetService(context.getServiceReference(Hello.class.getName()));
        System.out.println(String.format("deactivated::%s", Hello.class.getName()));
        System.out.println(String.format("stop::%s", Activator.class.getCanonicalName()));
    }
}
