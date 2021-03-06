package com.mycompany.osgiexamweb;

import com.mycompany.osgiexamapi.Hello;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.osgicdi.OSGiService;

@WebServlet(name = "LookupPojoFromOSGi", urlPatterns = {"/LookupPojoFromOSGi"})
public class LookupPojoFromOSGi extends HttpServlet {

    @Inject
    @OSGiService(dynamic = true)
    private Hello hello;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>@OSGi</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>lookup POJO by @Inject @OSGiService</h1>");
            out.println(hello.sayHello("Sachi"));
            out.println("<br/><br/><font color=\"gray\">Hello Class is ");
            out.println(hello.getClass().getCanonicalName());
            out.println("@");
            out.println(hello.hashCode());
            out.println("</font>");
        } catch (Exception ex) {
            out.println("<pre>");
            ex.printStackTrace(out);
            out.println("</pre>");
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}
