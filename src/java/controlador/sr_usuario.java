/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Users;

/**
 *
 * @author E7440
 */
public class sr_usuario extends HttpServlet {
    Users users;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            if("agregar".equals(request.getParameter("btn_agregar"))) {
            users = new Users(Integer.valueOf(request.getParameter("username"),request.getParameter("password"), Boolean.valueOf(request.getParameter("estado")),Integer.valueOf(request.getParameter("drop_cargo")));
            //Boton Agregar
            if (users.agregar()>0){
                response.sendRedirect("menu.jsp");
                out.println("<h1> Ingreso Exitoso </h1>");
                out.println("<a href='menu.jsp'>regresar</a>");
            }else{
                out.println("<h1> Error..... </h1>");
                out.println("<a href='menu.jsp'>Regresar</a>");
            }
            }

}
     }

}