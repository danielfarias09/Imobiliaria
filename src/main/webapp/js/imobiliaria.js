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
    
    var grafico = $("#grafico");
    
    var resourceChart = new Chart(grafico, {
        "type":"doughnut",
        "data":{"datasets":[{
            "backgroundColor":[
                "#3366CC",
                "#DC3912",
                "#FF9900",
                "#109618",
                "#990099",
                "#3B3EAC"
              ],
             "hoverBackgroundColor":[
                 "#3366CC",
                 "#DC3912",
                 "#FF9900",
                 "#109618",
                 "#990099",
                 "#3B3EAC"
              ],
             "data":[0.0,0.0,8.31,10.43,84.69,0.84]},
             {
                 "backgroundColor":[
                     "#3366CC",
                     "#DC3912",
                     "#FF9900",
                     "#109618",
                     "#990099",
                     "#3B3EAC"
             ],
             "hoverBackgroundColor":[
                 "#3366CC",
                 "#DC3912",
                 "#FF9900",
                 "#109618",
                 "#990099",
                 "#3B3EAC"
             ],
             "data":[8.31,95.96]}],
             "labels":["resource-group-1","resource-group-2","Data Services - Basic Database Days","Data Services - Basic Database Days","Azure App Service - Basic Small App Service Hours","resource-group-2 - Other"]
            }
    });
    
//    var myChart = new Chart(grafico, {
//        type: 'doughnut',
//        data: {
//            labels: ["Apartamento", "Casa", "Escritório"],
//            datasets: [{
//                label: 'Tipos de Moradas',
//                data: [30, 18, 9],
//                backgroundColor: [
//                    '#FF5733',
//                    '#FFFF33',
//                    '#336BFF',
//                    '#33FF38',
//                    '#8B33FF',
//                    '#FFA233'
//                ],
//                borderWidth: 1
//            },
//            {
//                label: 'Tipologia',
//                type: 'doughnut',
//                labels: ["T1", "T2", "T3", "T4"],
//                data: [15, 8, 9, 7],
//                backgroundColor: [
//                    'rgba(255, 99, 132, 0.2)',
//                    'rgba(54, 162, 235, 0.2)',
//                    'rgba(255, 206, 86, 0.2)',
//                    'rgba(75, 192, 192, 0.2)',
//                    'rgba(153, 102, 255, 0.2)',
//                    'rgba(255, 159, 64, 0.2)'
//                ],
//                borderWidth: 1
//            }]
//        },
//        options: {
//            cutoutPercentage: 50
//        }
//    });
    
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