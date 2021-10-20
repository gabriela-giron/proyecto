<%-- 
    Document   : index
    Created on : 11/10/2021, 18:35:58
    Author     : Luyi_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="modelo_cliente.clientes"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body >
        <h1>Formulario para cliente</h1>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalCliente">Nuevo</button>
        
        <!-- The Modal -->
<div class="modal" id="modalCliente">
  <div class="modal-dialog">
    <div class="modal-content">
        
        <!-- Modal body -->
      <div class="modal-body">
            <form action="sr_cliente" method="post" class="form-group">
                <label for="lbl_id"><b>ID:</b></label>
                <input type="text" class="form-control " name="id"  id="id" value="0" readonly>
                <label for="lbl_nombres"><b>Nombres:</b></label>
                <input type="text" class="form-control " name="nombre"  id="nombre" placeholder="Nombre1 Nombre2" required>
                <label for="lbl_apellidos"><b>Apellidos:</b></label>
                <input type="text" class="form-control " name="apellido"  id="apellido" placeholder="Apellido1 Apellido2" required>
                <label for="lbl_apellidos"><b>direccion:</b></label>
                <input type="text" class="form-control " name="direccion"  id="direccion" placeholder="000000000" required>
                <label for="lbl_apellidos"><b>telefono:</b></label>
                <input type="text" class="form-control " name="telefono"  id="telefono" placeholder="000000000" required>
                <label for="lbl_apellidos"><b>Nit:</b></label>
                <input type="text" class="form-control " name="nit"  id="nit" placeholder="000000000" required>
                
                   
                <button value="agregar" name="btn_agregar" id="btn_agregar" class="btn btn-primary btn-lg"> Agregar </button>
                <button type="button" class="btn btn-warning btn-lg" data-bs-dismiss="modal">Close</button>
                    
            </form>
            <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
            </div>
        </div>
      </div>
    </div>
        <table class="table table-striped">
                <thead>
                <th>Nombre </th>
                <th>Apellido </th> 
                <th>Direccion </th>
                <th>Telefono </th>
                <th>Nit</th>
                </thead>
                <tbody id="tbl_clientes">
                    <%
                        clientes cliente = new clientes();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla = cliente.leer();
                        for (int t=0;t<tabla.getRowCount();t++ ){
                            out.println("<tr data-id=" + tabla.getValueAt(t, 0)+ ">");
                            out.println("<td>" + tabla.getValueAt(t, 1)+"</td>");
                            out.println("<td>" + tabla.getValueAt(t, 2)+ "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 3)+ "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 4)+ "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 5)+ "</td>");
                            out.println("</tr>");
                        }
                        %>
            </tbody>
        </table>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script type="text/javascript">
    function limpiar(){
        $("#id").val(0);
       $("#nombre").val('');
       $("#apellido").val('');
       $("#direccion").val('');
       $("#telefono").val('');
       $("#nit").val('');
 
    }
   
    $('#tbl_clientes').on('click','tr td',function(evt){
       var target,id,nombre,apellido,direccion,telefono,nit; 
       target = $(event.target);
       id = target.parent().data('id');
       codigo = target.parent("tr").find("td").eq(0).html();
       nombre = target.parent("tr").find("td").eq(1).html();
       apellido = target.parent("tr").find("td").eq(2).html();
       direccion = target.parent("tr").find("td").eq(3).html();
       telefono = target.parent("tr").find("td").eq(4).html();
       nit = target.parent("tr").find("td").eq(5).html();
 
       $("#id").val(id);
       $("#nombre").val(nombre);
       $("#apellido").val(apellido);
       $("#direccion").val(direccion);
       $("#telefono").val(telefono);
       $("#nit").val(nit);
       $("#modalCliente").modal('show');
    });
    
        </script>
    </body>
</html>
