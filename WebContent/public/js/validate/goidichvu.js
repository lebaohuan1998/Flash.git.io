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

		$("#tao_sua-form2").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');
				label.insertAfter(element);
			},
			rules: {
				tengoi: {
					required: true,
					maxlength: 50,
				},
				mota: {
					required: true,
					maxlength: 500,
				},
				price: {
					required: true,
					maxlength: 11,
				},
			},
			messages: {

				tengoi: {
					required: "Nhập tên gói dịch vụ ",
					maxlength: "Tên tối đa 50 ký tự",
				},
				mota: {
					required: "Mô tả gói dịch vụ",
					maxlength: "Nội dung tối đa 500 ký tự",
				},
				price: {
					required: "Nhập giá tiền",
					maxlength: "Nhập tối đa 11 số",
				},
			},
		});
		$("#tao_sua-form1").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');
				label.insertBefore(element);
			},
			rules: {
				tengoi: {
					required: true,
					maxlength: 50,
				},
				mota: {
					required: true,
					maxlength: 500,
				},
				file: {
					required: true,
				},
				price: {
					required: true,
					maxlength: 11,
				},
			},
			messages: {

				tengoi: {
					required: "Nhập tên gói dịch vụ ",
					maxlength: "Tên tối đa 50 ký tự",
				},
				mota: {
					required: "Mô tả gói dịch vụ",
					maxlength: "Nội dung tối đa 500 ký tự",
				},
				file: {
					required: "Mời chọn ảnh(tối đa 20 hình)",
				},
				price: {
					required: "Nhập giá tiền",
					maxlength: "Nhập tối đa 11 số",
				},
			},
		});
	});