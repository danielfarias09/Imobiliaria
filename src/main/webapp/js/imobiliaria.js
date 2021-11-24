$(document).ready( function () {
//    $('.table').DataTable(
//            {
//                "language" : {
//                    "paginate" : {
//                        "first" : "Primeiro",
//                        "previous" : '<i class="fa fa-chevron-left"></i>',
//                        "next" : '<i class="fa fa-chevron-right"></i>',
//                        "last" : "Ultimo"
//                    },
//                    "sProcessing" : "A processar...",
//                    "sLengthMenu" : "_MENU_ Elementos por página",
//                    "sZeroRecords" : "Sem resultados.",
//                    "sInfo" : "N.º de Resultados _TOTAL_",
//                    "sInfoEmpty" : "N.º de Resultados 0",
//                    "sInfoFiltered" : "(filtrado de _MAX_ registos no total)",
//                    "sInfoPostFix" : "",
//                    "sSearch" : "Procurar:",
//                    "sUrl" : ""
//                },
//                "ordering": false,
//                // REORDER THE DOM ELEMENTS
//                "dom" : '<lf>rt<"row"<"col-md-3 col-sm-6 col-xs-12"i><"#export-placeholder.col-md-3 col-sm-6 col-xs-12"><"col-md-6 col-sm-12 col-xs-12"p>>'
//     });
    
    
} );

function pesquisar(){
    var url = '/imoveis/filtrar';
    
    var filtro = {
            descricao: $('#descricao').val(),
            precoMin: $('#precoMin').val(),
            precoMax: $('#precoMax').val(),
            tipo: $('#tipo').val()
    };
    
    $.ajax({
        url : url,
        type : "POST",
        data : filtro,
        success : function(data) {
            $('tbody#tabela-imoveis').replaceWith(data);
        }
    });   
}

function deletar(id) {
    var url = '/imoveis/' + id;
    $.ajax({
        url: url,
        type: "DELETE",
        success: function (data) {
            $('tbody#tabela-imoveis').replaceWith(data);
        }
    });
}