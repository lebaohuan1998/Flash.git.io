$(document).ready(
	function(){
		$.validator.addMethod("notNumb", function(value){
			var reg = /^\D*$/;
			return value.trim().match(reg);
		}, ""
		);
		$("#tripForm").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
				destination:{
					required: true,
					maxlength: 50,
					notNumb: true
				},
				departureTime:{
					required: true,
					maxlength: 50
				},
				driver:{
					required: true,
					maxlength: 50,
					notNumb: true
				},
				carType:{
					required: true,
					maxlength: 50
				},
				maximumOnlineTicketNumber:{
					required: true,
					digits: true,
					maxlength: 50
				},
				departureDate:{
					required: true,
				},
			},
			messages: {
				destination:{
					required: "Please enter destination",
					maxlength: "Max length is 50 charaters",
					notNumb: "Must be a characters"
				},
				departureTime:{
					required: "Please enter departure time",
					maxlength: "Max length is 50 charaters"
				},
				driver:{
					required: "Please enter driver",
					maxlength: "Max length is 50 charaters",
					notNumb: "Must be a characters"
				},
				carType:{
					required: "Please enter car type",
					maxlength: "Max length is 50 charaters"
				},
				maximumOnlineTicketNumber:{
					required: "Please enter author id",
					digits: "Must be a number",
					maxlength: "Max length is 50 number"
				},
				departureDate:{
					required: "Please choose date"
				},
			},
		});
	});