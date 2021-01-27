$(document).ready(function() {
	$.validator.addMethod("notNumb", function(value){
		var reg = /^\D*$/;
		return value.trim().match(reg);
	}, "");
	
	$.validator.addMethod("isNum", function(value){
		var reg = /[+-]?([0-9]*[.])?[0-9]+/;
		return value.trim().match(reg);
	}, "");
	
	$("#parkingLotForm").validate({
		errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
		rules: {
			parkingName: {
				required: true,
				minlength: 2,
				maxlength: 50,
				notNumb: true
			},	
            place: {
				required: true,			
			},
			area: {
				required: true,
				isNum: true
				
			},
			price: {
				required: true,				
				maxlength: 50,
				isNum: true
			},
		},
		messages: {
			parkingName:{
				required: "Please enter parking name",
				minlength: "Booking office name must consist of at least 2 characters",
				maxlength: "Booking office name max 50 characters",
				notNumb: "Must be a characters"
			},

			place:{
				required: "Please choose place",
				isNum: "Must be number"
			},
            
            area:{
				required: "Please enter area",			
				isNum: "Must be number"
			},


			price: {
				required: "Please enter price",				
				maxlength: "Price max 50 characters",
				digits: "Must be number"
			},
			

		}
	});
});