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
				thecancuoc:{
					required: true,
                    minlength: 12,
					maxlength: 12,
				}
			},
			messages: {
				email:{
					required: "Nhập email !",
					maxlength: "Tối đa 50 ký tự",
					email: "Nhập mail theo định dạng"
                },
                fullname:{
                    required: "Nhập họ và tên!",
                    maxlength: "Tối đa 50 ký tự"
                },
                nghedanh:{
                	required: "Nhập họ và tên!",
					maxlength: "Tối đa 50 ký tự"
				},
				password:{
					required: "Nhập mật khẩu",
                    maxlength: "Tối đa 16 ký tự",
                    minlength: "Tối thiểu 8 ký tự"
                },
                repassword:{
                    equalTo: "Nhập giống mật khẩu trên",
					required: "Nhập mật khẩu",
                    maxlength: "Tối đa 16 ký tự",
                    minlength: "Tối thiểu 8 ký tự"
                },
                phone:{
                    required: "Nhập số điện thoại",
                    minlength: "Gồm 10 số",
					maxlength: "Gồm 10 số"
				},
				thecancuoc:{
					required: "Nhập số thẻ căn cước",
                    minlength: "Gồm 12 số",
					maxlength: "Gồm 12 số",
				}
                
				
			},
		});
	});