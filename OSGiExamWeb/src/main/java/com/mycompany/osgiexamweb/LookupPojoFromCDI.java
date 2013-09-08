package com.mycompany.osgiexamweb;

import com.mycompany.osgiexamapi.Hello;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LookupPojoFromCDI", urlPatterns = {"/LookupPojoFromCDI"})
public class LookupPojoFromCDI extends HttpServlet {

    @Resource
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
            out.println("<title>@Resource</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>lookup POJO by @Resource</h1>");
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
