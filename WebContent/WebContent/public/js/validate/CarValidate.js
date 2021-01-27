$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#carForm").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
				licensePlate:{
					required: true,
					maxlength: 50,
				},
				carType:{
					maxlength: 50
				},
				carColor:{
					maxlength: 50,
					notNumb: true
				},
				company:{
					required: true,
					maxlength: 50
				},
				parkingLot:{
					required: true,
				},
			},
			messages: {
				licensePlate:{
					required: "Please enter license plate",
					maxlength: "Max length is 50 charaters",
				},
				carType:{
					required: "Please enter car type",
					maxlength: "Max length is 50 charaters"
				},
				carColor:{
					maxlength: "Max length is 50 charaters",
					notNumb: "Characters only"
				},
				company:{
					required: "Please choose company"
				},
				parkingLot:{
					required: "Please enter parking lot"
				},
			},
		});
	});