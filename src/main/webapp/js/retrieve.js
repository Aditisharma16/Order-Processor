$(document).ready(function(){
	$('td.status[value=PLACED]').css('color','#0c31cc');
	$('td.status[value=IN_PROCESSING]').css('color','#cc960c');
	$('td.status[value=DELIVERED]').css('color','#0ccc0f');
})
$(document).ready(function(){
    $('#myTable').DataTable();
});

function loadProductDetails(p){ 
			if(p!=null)
			$("#viewModal").modal('show'); 
			}
