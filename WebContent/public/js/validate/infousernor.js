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
                    required: "Tên không được để trống!",
                    maxlength: "Tên không được quá 50 chữ cái"
                    
                },
                dob:{
					required: "Chọn ngày sinh",
				},
                phone:{
                    required: "Nhập số điện thoại",
                    minlength: "Số điện thoại gồm 10 số",
					maxlength: "Số điện thoại gồm 10 số"
				},
				address:{
					required: "Nhập địa chỉ",
					maxlength: "Địa chỉ không  được quá 50 chữ cái",
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
					required: "Nhập mật khẩu cũ ",
                    maxlength: "Mât khẩu tối đa 16 chữ cái",
                    minlength: "Mật khẩu tối thiểu 8 chữ cái"
                },
                 newpass:{
					required: "Nhập mật khẩu mới ",
                    maxlength: "Mât khẩu tối đa 16 chữ cái",
                    minlength: "Mật khẩu tối thiểu 8 chữ cái"
                },
                renewpass:{
                    equalTo: "Nhập giống mật khẩu trên",
					required: "Nhập lại mật khẩu ",
                    maxlength: "Mât khẩu tối đa 16 chữ cái",
                    minlength: "Mật khẩu tối thiểu 8 chữ cái"
                },
			},
		});
	});