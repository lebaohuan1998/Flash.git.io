


$(document).ready(function() {

	$(".img-container1").popupLightbox({
		width: 700,
		height: 500
	});
});


$(document).ready(function() {

	$(".lightbox").popupLightbox({
		width: 600,
		height: 450
	});
});












$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
$("#rating-form").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
				
				input9Rating:{
                    required: true,
                    minlength: 1,
				},
				
				
				inputComment:{
                    required: true,
                    maxlength: 400,
                    minlength: 20,
				},
			},
			messages: {
			
			
				input9Rating:{
					required: " Nhập chưa nhập bầu chọn! ",
                    minlength: "Tối thiểu 20 ký tự",
				},
	
				inputComment:{
					required: " Nhập chưa nhập nội dung bình luận! ",
                    maxlength: "Tối đa 400 ký tự",
                    minlength: "Tối thiểu 20 ký tự",
				},

			},
		});
	});