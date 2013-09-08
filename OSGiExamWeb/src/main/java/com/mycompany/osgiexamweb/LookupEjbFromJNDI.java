package com.mycompany.osgiexamweb;

import com.mycompany.osgiexamapi.GoodBye;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LookupEjbFromJNDI", urlPatterns = {"/LookupEjbFromJNDI"})
public class LookupEjbFromJNDI extends HttpServlet {

    @EJB(lookup = "java:global/com.mycompany.OSGiExamEjb_1.0.0.SNAPSHOT/GoodByeEjb")
    private GoodBye goodbye;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>@EJB</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>lookup EJB Object by @EJB</h1>");
            out.println(goodbye.sayGoodBye("Sachi"));
            out.println("<br/><br/><font color=\"gray\">GoodBye Class is ");
            out.println(goodbye.getClass().getCanonicalName());
            out.println("@");
            out.println(goodbye.hashCode());
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
