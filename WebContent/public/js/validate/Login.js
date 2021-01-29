$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#login-form").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
				username:{
					required: true,
					maxlength: 50,
					email: true,
				},
				password:{
                    required: true,
                    maxlength: 16,
                    minlength: 8,
				},
			},
			messages: {
				username:{
					required: "Please enter email !",
					maxlength: "Max length is 50 charaters",
					email: "Enter email follow xxx@cc"
				},
				password:{
					required: "Please enter password ",
                    maxlength: "Max length is 16 charaters",
                    minlength: "Min lenght is 8 charaters",
				},
				
			},
		});
	});