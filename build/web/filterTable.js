/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready( function () {
//    $('.histtable').DataTable();
     $('.histtable').DataTable({
         "language":{
             "lengthMenu":"Mostrar _MENU_ registros",
             "zeroRecords":"No se encontraron resultados",
             "info":"Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
             "infoEmpty":"Mostrando registros del 0 al 0 un total de 0 registros",
             "infoFiltered":"(filtrado de un total de _MAX_ registros)",
             "sSearch":"Buscar:",
             "oPaginate":{
                 "sFirst":"Primero",
                 "sLast":"Ultimo",
                 "sNext":"Siguiente",
                 "sPrevious":"Anterior"
             },
             "sProcessing":"Procesando...",
         }
         
     });
} );