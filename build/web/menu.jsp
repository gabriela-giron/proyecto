<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="modelo.Users"%>
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
            <div class="navigation">
                <ul>
                    <li>
                        <a href="/">
                            <span class="welcome">welcome, ${username.username}</span>
                        </a>
                    </li>
                    <li>
                        <a href="/">
                            <span class="welcome">view profile</span>
                        </a>
                    </li>
                    <li>
                        <a href="/">
                            <span class="welcome">settings</span>
                        </a>
                    </li>
                    <li>
                        <a href="login_servlet?action=logout">
                            <span class="welcome">logout</span>
                        </a>
                    </li>
                </ul>
            </div>
        <div class="options">
            <p>Registros disponibles</p>
            <ul>
                <li class="registros">
                    <a href='clientes.jsp'>Clientes</a>
                    <a href="vendedores.jsp">Vendedores</a>
                    <a href='proveedores.jsp'>Proveedores</a>
                    <a href='usuarios.jsp'>Usuarios</a>
                </li>
            </ul>
        </div>
        <div class="users-table">
            <table class="table table-striped">
                <thead>
                <th> Username </th>
                <th>Puesto </th>
                </thead>
                <tbody id="tbl_proveedores">
                    <%
                        Users user = new Users();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla = user.leer();
                        for (int t=0;t<tabla.getRowCount();t++ ){
                            out.println("<tr data-id=" + tabla.getValueAt(t, 0)+ ">");
                            out.println("<td>" + tabla.getValueAt(t, 1)+"</td>");
                            out.println("<td>" + tabla.getValueAt(t, 2)+ "</td>");
                            out.println("</tr>");
                        }
                        %>
                </tbody>
            </table>
            <button type="submit" name="agregar" value="agregar" class="form_button_1">nuevo</button>
        </div>
        <div class="productos">
            <p>tabla productos</p>
        </div>
       </div>
    </body>
</html>
