$(document).ready(function(){
	$('td.status[value=PLACED]').css('color','#0c31cc');
	$('td.status[value=IN_PROCESSING]').css('color','#cc960c');
	$('td.status[value=DELIVERED]').css('color','#0ccc0f');
})

$(document).ready(function(){
	
    var dataTable = $('#myTable').DataTable({

        "pageLength": 4,

        'aoColumnDefs':[{

            'bSortable': false,

            'aTargets':['nosort'],

        }] ,

        "aoColumns":[
        	
            null,

            null,

            null,

            null,

            null,

            null

        ],

        "order":false,

        "bLengthChange": false,

        "dom":'<"top">ct<"top"p><"clear">'

    });
})