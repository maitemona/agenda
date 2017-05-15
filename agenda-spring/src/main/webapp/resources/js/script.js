$.noConflict();
jQuery( document ).ready(function( $ ) {
	$('#ocultar').hide();
	$("#mailingform select[name=categoria]").on("change",function(e){
		//console.log($('select[name=categoria]').val());
		
		$("#email").empty();
		$("#nombre").empty();
		$('#ocultar').show();
		url='http://localhost:8080/agenda/api/contactos/'+$('select[name=categoria]').val();

		 $.ajax({
			  url : url,
			  dataType : "json",
			  success: function (data) {
				  $.each(data,function(i){
					// var email = data[i].email;
					 console.log("Vuelta"+i);
					// $('#ocultar').show();
			        var txtnombre = "<p>"+data[i].ncontacto+"</p>";
			        $("#nombre").append(txtnombre);
			        var txtemail = "<p>"+data[i].email+"</p>";
			        $("#email").append(txtemail); 	 
				  });
				 },

				 error: function (parsedjson, textStatus, errorThrown) {
					  console.log("parsedJson: " + JSON.stringify(parsedjson));
				  }
		 });
	});
	
	/* $('#fichero').on('change', function(e) {
   	  var fileName = e.target.files[0].name;
   	  $("#archivo").val(fileName);
     });
    */
     
})

