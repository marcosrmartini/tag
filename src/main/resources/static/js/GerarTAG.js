$(function() {
    $('#btnUserTCTB').click(saveForm);
});


function saveForm(){
    $.ajax({
        method: "POST",
        url: "/cadastro/customer/userTrackingConfigurationTriggerButton",
        data: $('#frmUserTCTB').serialize(),
        success: function(status){
            if(status) {
                //here you check the response from your controller and add your business logic
            }
        }
    });
}