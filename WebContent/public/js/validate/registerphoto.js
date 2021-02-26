/**
 * 
 */
$(document).ready(
	function() {
		$.validator.addMethod("notNumb", function(value) {
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
			rules: {
				email: {
					required: true,
					maxlength: 50,
					email: true,
				},
				fullname: {
					required: true,
					maxlength: 50,
				},
				nghedanh: {
					required: true,
					maxlength: 50,
				},
				password: {
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
				phone: {
					required: true,
					digits: true,
					minlength: 10,
					maxlength: 10,
				},
				thecancuoc: {
					required: true,
					digits: true,
					minlength: 9,
					maxlength: 12,
				},
				address: {
					required: true,
					maxlength: 100,
				},
			},
			messages: {
				email: {
					required: "Nhập email !",
					maxlength: "Tối đa 50 ký tự",
					email: "Nhập mail theo định dạng"
				},
				fullname: {
					required: "Nhập họ và tên!",
					maxlength: "Tối đa 50 ký tự"
				},
				nghedanh: {
					required: "Nhập Nghệ danh!",
					maxlength: "Tối đa 50 ký tự"
				},
				password: {
					required: "Nhập mật khẩu",
					maxlength: "Tối đa 16 ký tự",
					minlength: "Tối thiểu 8 ký tự"
				},
				repassword: {
					equalTo: "Nhập giống mật khẩu trên",
					required: "Nhập mật khẩu",
					maxlength: "Tối đa 16 ký tự",
					minlength: "Tối thiểu 8 ký tự"
				},
				phone: {
					required: "Nhập số điện thoại",
					digits: "Ký tự là số",
					minlength: "Gồm 10 số",
					maxlength: "Gồm 10 số"
				},
				thecancuoc: {
					required: "Nhập số thẻ căn cước",
					digits: "Ký tự là số",
					minlength: "Tối thiểu 9 số",
					maxlength: "Tối đa 12 số",
				},
				address: {
					required: "Nhập địa chỉ trên CMD/CCCD",
					maxlength: "Tối đa 100 ký tự",
				}

			},
		});
	});