/**
 * 
 */
$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#registerphotoormodel-form").validate({
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
                fullname:{
					required: true,
					maxlength: 50,
				},
				nghedanh:{
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
				sothecancuoc:{
					required: true,
                    minlength: 12,
					maxlength: 12,
				}
			},
			messages: {
				email:{
					required: "Please enter email !",
					maxlength: "Max length is 50 charaters",
					email: "Enter email follow xxx@cc"
                },
                fullname:{
                    required: "Please enter name!",
                    maxlength: "max length is 50 charaters"
                    
                },
                nghedanh:{
					maxlength: "max length is 50 charaters",
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
				sothecancuoc:{
					required: "please enter so the can cuoc",
                    minlength: "phone number is 12 digits",
					maxlength: "phone number is 12 digits",
				}
                
				
			},
		});
	});