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
import modelo_proveedor.Proveedor;
/**
 *
 * @author jmess
 */
public class sr_proveedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Proveedor proveedor; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_proveedor</title>");            
            out.println("</head>");
            out.println("<body>");
            
            proveedor = new Proveedor(Integer.valueOf(request.getParameter("id")),request.getParameter("codigo"),request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("direccion"),request.getParameter("telefono"),request.getParameter("correo"));
            if("agregar".equals(request.getParameter("btn_agregar"))) {
            //Boton Agregar
                if (proveedor.agregar()>0){
                    response.sendRedirect("proveedores.jsp");
                    out.println("<h1> Ingreso Exitoso </h1>");
                    out.println("<a href='menu.jsp'>regresar</a>");
                }else{
                    out.println("<h1> Error..... </h1>");
                    out.println("<a href='menu.jsp'>Regresar</a>");
                }
            }
            proveedor = new Proveedor(Integer.valueOf(request.getParameter("id")),request.getParameter("codigo"),request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("direccion"),request.getParameter("telefono"),request.getParameter("correo"));
            //Boton Modificar
            if("modificar".equals(request.getParameter("btn_modificar"))) {
            //Boton Agregar
            if (proveedor.modificar()>0){
                response.sendRedirect("menu.jsp");
                out.println("<h1> Modificación Exitosa </h1>");
                out.println("<a href='menu.jsp'>regresar</a>");
            }else{
                out.println("<h1> Error..... </h1>");
                out.println("<a href='menu.jsp'>Regresar</a>");
            }
            }
            proveedor = new Proveedor(Integer.valueOf(request.getParameter("id")),request.getParameter("codigo"),request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("direccion"),request.getParameter("telefono"),request.getParameter("correo"));
            //Boton eliminar
            if("eliminar".equals(request.getParameter("btn_eliminar"))) {
            
            //Boton Agregar
            if (proveedor.eliminar()>0){
                response.sendRedirect("menu.jsp");
                out.println("<h1> Se Eliminó Exitosamente </h1>");
                out.println("<a href='menu.jsp'>regresar</a>");
            }else{
                out.println("<h1> Error..... </h1>");
                out.println("<a href='menu.jsp'>Regresar</a>");
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
