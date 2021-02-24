
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
					required: "Nhập email!",
					maxlength: "Tối đa 50 ký tự",
					email: "Nhập mail theo định dạng"
				},
				password:{
					required: "Nhập mật khẩu! ",
                    maxlength: "Tối đa 16 ký tự",
                    minlength: "Tối thiểu 8 ký tự"
				},

			},
		});
	});