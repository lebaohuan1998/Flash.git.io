$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#register-form").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
				email:{
					required: true,
					maxlength: 50,
					email: true,
                },
                fullName:{
					required: true,
					maxlength: 50,
				},
				password:{
                    required: true,
                    maxlength: 16,
                    minlength: 8,
                },
                repassword: {
                    equalTo: "#password",
                    required: true,
                    maxlength: 16,
                    minlength: 8,
                },
                phone:{
                    required: true,
                    minlength: 10,
					maxlength: 10,
				},
			},
			messages: {
				email:{
					required: "Please enter email !",
					maxlength: "Max length is 50 charaters",
					email: "Enter email follow xxx@cc"
                },
                fullName:{
                    required: "Please enter name!",
                    maxlength: "max length is 50 charaters"
                    
                },
				password:{
					required: "Please enter password ",
                    maxlength: "Max length is 16 charaters",
                    minlength: "Min lenght is 8 charaters"
                },
                repassword:{
                    equalTo: "re-password not same password",
					required: "Please enter password ",
                    maxlength: "Max length is 16 charaters",
                    minlength: "Min lenght is 8 charaters"
                },
                phone:{
                    required: "please enter phone",
                    minlength: "phone number is 10 digits",
					maxlength: "phone number is 10 digits"
				},
                
				
			},
		});
	});