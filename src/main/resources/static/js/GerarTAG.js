function setarForm(formulario, url) {
	jQuery(document).ready(function(){
		jQuery(formulario).submit(function(){
			var dados = jQuery( this ).serialize();
			
			$.blockUI(); //Bloquear UI
	
			jQuery.ajax({
				type: "POST",
				url: url,
				data: dados,
				success: function( data ) {
	//				alert( data );
					$.unblockUI(); //Desbloquear UI
					setTimeout(
			                  function() {
			                     location.reload();
			                  }, 0001); 
				}
			});
			return false;
		});
	});
};

setarForm("#frmUrls", "/tag/cadastro/customer/url");
setarForm("#frmTrackedHtmlControl", "/tag/cadastro/customer/trackedhtmlcontrol");
setarForm("#frmModalContent", "/tag/cadastro/customer/modalcontent");
setarForm("#frmUserTrackingConfiguration", 	"/tag/cadastro/customer/userTrackingConfiguration");
setarForm("#frmUserTCTB", "/tag/cadastro/customer/userTrackingConfigurationTriggerButton");
