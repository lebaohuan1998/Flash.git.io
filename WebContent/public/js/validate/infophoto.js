/**
 * 
 */$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#show").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
               nghedanh:{
					required: true,
					maxlength: 50,
				},
				
			},
			messages: {
				
                nghedanh:{
                	required: "Nhập Nghệ danh!",
					maxlength: "Tối đa 50 ký tự"
				},
				
				
			},
		});
		/*----------------------*/
		$("#updateinfo-form").validate({
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
				address: {
					required: true,
					maxlength: 100,
				},
				dob:{
					required: true,
				},
                phone:{
                    required: true,
                    digits: true,
                    minlength: 10,
					maxlength: 10,
				},
				tcc:{
					required: true,
					digits: true,
                    minlength: 12,
					maxlength: 12,
				}
			},
			messages: {
				
                user:{
                    required: "Tên không được để trống!",
                    maxlength: "Tên không được quá 50 chữ cái"
                    
                },
                address: {
					required: "Nhập địa chỉ trên CMT/CCCD",
					maxlength: "Tối đa 100 ký tự",
				},
                dob:{
					required: "Chọn ngày sinh",
				},
                phone:{
                    required: "Nhập số điện thoại",
                    digits: "Ký tự là số",
                    minlength: "Số điện thoại gồm 10 số",
					maxlength: "Số điện thoại gồm 10 số"
				},
				tcc:{
					required: "Nhập số thẻ căn cước",
					digits: "Ký tự là số",
                    minlength: "Tối thiểu 9 số",
					maxlength: "Tối đa 12 số",
				}
				
			},
		});
		/*----------------------*/
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#updatepass-form").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
               oldpassword:{
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
				
               oldpassword:{
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