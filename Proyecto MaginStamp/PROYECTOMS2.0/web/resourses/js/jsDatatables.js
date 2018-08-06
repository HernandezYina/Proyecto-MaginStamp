/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*---------------------------------
 DATATABLES
 ----------------------------------*/
$(document).ready(function() {
    $('#tablaCotizacion').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            //'copy', 
            'csv', 'excel', 'pdf',
            'print'
        ]
    } );
    
    
    
    
    
} );

/*---------------------------------
 DATATABLES TRADUCCION
 ----------------------------------*/
//$('#tablaCotizacion').DataTable( {
//    language: {
//        "processing":     "Procesando...",
//        "search":         "Buscar:",
//        "lengthMenu":    "Mostrar _MENU_ registros",
//        "info":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
//        "infoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
//        "infoFiltered":   "(filtrado de un total de _MAX_ registros)",
//        "infoPostFix":    "",
//        "loadingRecords": "Cargando...",
//        "zeroRecords":    "No se encontraron resultados",
//        "emptyTable":     "Ning&uacute;n dato disponible en esta tabla",
//        paginate: {
//            "first":      "Primero",
//            "previous":   "Anterior",
//            "next":       "Siguiente",
//            "last":       "ultimo"
//        },
//        aria: {
//            "sortAscending":  ": Activar para ordenar la columna de manera ascendente",
//            "sortDescending": ": Activar para ordenar la columna de manera descendente"
//        }
//    }
//} );