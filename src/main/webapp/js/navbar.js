$(document).ready(function() {
	$('#sidebarCollapse').click(function() {
		$('#sidebar').toggleClass('active');
	});
});

var state = true;
function toggle(){
	
	if(state){
		document.getElementById("sidebar-body").className = "sidebar-active";
		state = false;
	}
	else
	{
		document.getElementById("sidebar-body").className = "";
		state = true;
	}
	
}