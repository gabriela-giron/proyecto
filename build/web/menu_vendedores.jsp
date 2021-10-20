<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="modelo_vendedor.vendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Montserrat&display=swap" rel="stylesheet">
        <title>Menu</title>
    </head>
    <body>
        <div class="container">
            <img src="img/logo_idream_blanco.png" alt="logo"/>
            <div class="navigation-vendedor">
                <ul>
                    <li>
                        <a href="/">
                            <span class="welcome-vend">welcome, ${username.username}</span>
                        </a>
                    </li>
                    <li>
                        <a href="/">
                            <span class="welcome-vend">view profile</span>
                        </a>
                    </li>
                    <li>
                        <a href="/">
                            <span class="welcome-vend">settings</span>
                        </a>
                    </li>
                    <li>
                        <a href="login_servlet?action=cerrar">
                            <span class="welcome-vend">log out</span>
                        </a>
                    </li>
                </ul>
            </div>
              <div class="options">
            <p>Registros disponibles</p>
            <ul>
                <li class="registros">
                    <a href='clientes.jsp'>Clientes</a>
                    <a href='proveedores.jsp'>Proveedores</a>
                    <a href='usuarios.jsp'>Productos</a>
                </li>
            </ul>
        </div>
        <div class="vendors-table">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Codigo</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                </thead>
                <tbody id="tbl_vendedores">
                    <% 
                    vendedor vende = new vendedor();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = vende.leer();
                    for (int t=0;t<tabla.getRowCount();t++){
                        out.println("<tr data-id=" + tabla.getValueAt(t,0)+ ">");
                        out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
                        out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
                        out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
                        out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
                        out.println("<td>" + tabla.getValueAt(t,5) + "</td>");

                        out.println("</tr>");

                    }
                    %>

                    </tbody>
                  </table>
            <button type="submit" name="agregar" value="agregar" class="form_button_1">agregar</button>
            <button type="submit" name="modificar" value="modificar" class="form_button_2">modificar</button>
            <button type="submit" name="eliminar" value="eliminar" class="form_button_3">eliminar</button> 
        </div>
        <div class="productos">
            <p>tabla productos</p>
        </div>
       </div>
    </body>
</html>