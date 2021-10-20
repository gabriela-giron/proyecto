<%-- 
    Document   : index
    Created on : 12/10/2021, 20:48:30
    Author     : jmess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo_proveedor.Proveedor"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores_Web</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        
        <h1>Formulario Proveedores</h1>
        <!-- Button to Open the Modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalProveedor" onclick="limpiar()">Nuevo</button>

<!-- The Modal -->
<div class="modal" id="modalProveedor">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal bodygem  -->
      <div class="modal-body">
          <form action="sr_proveedor" metohod="post" class="form-group">
                            <label for="lbl_id"><b>ID </b></label>
                            <input type="text" name="id" id="id"class="form-control"  value="0" readonly>
                            <label for="lbl_codigo"> <b>Código Proveedor: </b> </label>
                            <input type="text" name="codigo" id="codigo" required="required" class="form-control" placeholder="Ejemplo: C0001">
                            <label for="lbl_nombre"> <b>Nombre: </b></label>
                            <input type="text" name="nombre" id="nombre" required="required" class="form-control" placeholder="Ejemplo: Nombre1 Nombre2">
                            <label for="lbl_nombre"> <b>Apellido: </b></label>
                            <input type="text" name="apellido" id="apellido" required="required" class="form-control" placeholder="Ejemplo: Apellido1 Apellido2">
                            <label for="lbl_direccion"> <b>Dirección: </b></label>
                            <input type="text" name="direccion" id="direccion" required="required" class="form-control" placeholder="Ejemplo:  # Casa, Calle, Zona, Ciudad">
                            <label for="lbl_telefono"> <b> Teléfono: </b></label>
                            <input type="tel" name="telefono" id="telefono" required="required" class="form-control" placeholder="Ejemplo: 7888-7888">
                            <label for="lbl_correo"> <b>Correo:</b> </label>
                            <input type="email" name="correo" id="correo" required="required" class="form-control" placeholder="Ejemplo: ejemplo@mail.com">
                            <br>
                            <button value="agregar" name="btn_agregar" id="btn_agregar" class="btn btn-primary btn-lg"> Agregar </button>
                            <button value="modificar" name="btn_modificar" id="btn_modificar" class="btn btn-success btn-lg"> Modificar </button>
                            <button value="eliminar" name="btn_eliminar" id="btn_eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false"> Eliminar </button>
                            <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
          
                            
          </form>
            <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
      </div>
    </div>
  </div>
</div>
            
            <table class="table table-striped">
                <thead>
                <th>Código </th>
                <th>Nombre </th>
                <th>Apellido </th> 
                <th>Direccion</th>
                <th>Telefono</th> 
                <th>Correo</th> 
                </thead>
                <tbody id="tbl_proveedores">
                    <%
                        Proveedor proveedor = new Proveedor();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla = proveedor.leer();
                        for (int t=0;t<tabla.getRowCount();t++ ){
                            out.println("<tr data-id=" + tabla.getValueAt(t, 0)+ ">");
                            out.println("<td>" + tabla.getValueAt(t, 1)+"</td>");
                            out.println("<td>" + tabla.getValueAt(t, 2)+ "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 3)+ "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 4)+ "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 5)+"</td>");
                            out.println("<td>" + tabla.getValueAt(t, 6)+ "</td>");
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
        $("#codigo").val('');
        $("#nombre").val('');
        $("#apellido").val('');
        $("#direccion").val('');
        $("#telefono").val('');
        $("#correo").val('');
 
    }
   
    $('#tbl_proveedores').on('click','tr td',function(evt){
       var target, id, codigo, nombre, apellido, telefono, direccion, correo; 
       target = $(event.target);
       id = target.parent().data('id');
       codigo = target.parent("tr").find("td").eq(0).html();
       nombre = target.parent("tr").find("td").eq(1).html();
       apellido = target.parent("tr").find("td").eq(2).html();
       direccion = target.parent("tr").find("td").eq(3).html();
       telefono = target.parent("tr").find("td").eq(4).html();
       correo = target.parent("tr").find("td").eq(5).html();
 
       $("#id").val(id);
       $("#codigo").val(codigo);
       $("#nombre").val(nombre);
       $("#apellido").val(apellido);
       $("#direccion").val(direccion);
       $("#telefono").val(telefono);
       $("#correo").val(correo);
       $("#modalProveedor").modal('show');
    });
        </script>
    </body>
</html>
