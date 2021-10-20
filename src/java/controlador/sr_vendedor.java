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
import modelo_vendedor.vendedor;

/**
 *
 * @author E7440
 */
public class sr_vendedor extends HttpServlet {
            vendedor vendedor;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srv_vendedor</title>");            
            out.println("</head>");
            out.println("<body>");
 
            vendedor = new vendedor(Integer.valueOf(request.getParameter("id")),request.getParameter("codigo"),request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("telefono"),request.getParameter("direccion"));
// Boton agregar 
            if ("agregar".equals(request.getParameter("btn_agregar"))){
             if (vendedor.agregar()>0){
                out.println("<h1>Ingreso Exitoso</h1>");
                out.println("<a href='menu.jsp'>Regresar</a>");
           }else{
               out.println("<h1>Error, no se ingreso </h1>");
               out.println("<a href='index.jsp'>Regresar</a>");
             }
             }
            
            // Boton modificar 
            if ("modificar".equals(request.getParameter("btn_modificar"))){
             if (vendedor.modificar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> Error, no se modifico... </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
            // Boton eliminar 
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
             if (vendedor.eliminar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> Error, no se elimino </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
