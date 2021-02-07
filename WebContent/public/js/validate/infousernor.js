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
		$("#update-form").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
                user:{
					required: true,
					maxlength: 50,
				},
				dob:{
					required: true,
				},
                phone:{
                    required: true,
                    minlength: 10,
					maxlength: 10,
				},
				address:{
					required: true,
					maxlength: 50,
				},
			},
			messages: {
				
                user:{
                    required: "Please enter name!",
                    maxlength: "max length is 50 charaters"
                    
                },
                dob:{
					required: "Chọn ngày sinh",
				},
                phone:{
                    required: "please enter phone",
                    minlength: "phone number is 10 digits",
					maxlength: "phone number is 10 digits"
				},
				address:{
					required: "Please enter địa chỉ",
					maxlength: "max length is 50 charaters",
				},
                
				
			},
		});
		/*----------------------*/
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#update-pass").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
               oldpass:{
                    required: true,
                    maxlength: 16,
                    minlength: 8,
                },
                newpass:{
                    required: true,
                    maxlength: 16,
                    minlength: 8,
                },
                renewpass: {
                    equalTo: "#password",
                    required: true,
                    maxlength: 16,
                    minlength: 8,
                },
			},
			messages: {
				
               oldpass:{
					required: "Please enter password ",
                    maxlength: "Max length is 16 charaters",
                    minlength: "Min lenght is 8 charaters"
                },
                 newpass:{
					required: "Please enter password ",
                    maxlength: "Max length is 16 charaters",
                    minlength: "Min lenght is 8 charaters"
                },
                renewpass:{
                    equalTo: "re-password not same password",
					required: "Please enter password ",
                    maxlength: "Max length is 16 charaters",
                    minlength: "Min lenght is 8 charaters"
                },
			},
		});
	});