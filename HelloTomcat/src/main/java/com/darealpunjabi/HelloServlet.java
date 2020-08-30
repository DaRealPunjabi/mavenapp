package com.darealpunjabi;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        // Very simple - just return some plain text
        //PrintWriter writer = response.getWriter();
        //writer.print("Hello World");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();        
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Sample Application Servlet Page</title>");
        writer.println("</head>");
        writer.println("<body bgcolor=white>");

        writer.println("<h1>");
        writer.println("Hello World, Version 1");
        writer.println("</h1>");
 
        writer.println("</body>");
        writer.println("</html>");



    }
}