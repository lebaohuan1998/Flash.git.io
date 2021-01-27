console.log("fas");

$(document).ready(function() {
	$.validator.addMethod("notNumb", function(value){
		var reg = /^\D*$/;
		return value.trim().match(reg);
	}, ""
	);
	$("#ticketForm").validate({
		errorElement: 'div',
		errorPlacement: function(label, element) {
			label.addClass('alert alert-danger p-1 my-1');	
			label.insertAfter(element);
		},
		rules:{
			customerName:{
				required: true,
				maxlength: 50,
				notNumb: true
			},
			licensePlate:{
				required: true,
				maxlength: 50
			},
			trip:{
				required: true,
				
			},
		},
		messages: {
			customerName:{
				required: "Please enter your name",
				maxlength: "Max length is 50 charaters",
				notNumb: "Must be a characters"
			},
			licensePlate:{
				required: "Please choose car",
			},
			trip:{
				required: "Please choose trip",
				
			},
		},
	});
});