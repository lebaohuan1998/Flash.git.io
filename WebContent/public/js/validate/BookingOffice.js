console.log("fas");

$(document).ready(function() {
	$.validator.addMethod("notNumb", function(value){
		var reg = /^\D*$/;
		return value.trim().match(reg);
	}, "");
	$.validator.addMethod("greaterThan", 
		function(value, element, params) {
			if (!/Invalid|NaN/.test(new Date(value))) {
				return new Date(value) > new Date($(params).val());
			}
			return isNaN(value) && isNaN($(params).val()) 
				|| (Number(value) > Number($(params).val())); 
		},'Must be greater than {0}.');


	$("#bookingOfficeForm").validate({
		errorElement: 'div',
			errorPlacement: function(label, element) {
				console.log(element);
				if (element[0].classList[1] == "pick-date") {
					label.addClass('alert alert-danger p-1 my-1');
					label.insertAfter(element.parent().parent());	
				} else {
					label.addClass('alert alert-danger p-1 my-1');	
					label.insertAfter(element);
				}
				
			},
		rules: {
			bookingofficename: {
				required: true,
				minlength: 2,
				maxlength: 50,
				notNumb: true
			},
			trip: {
				required: true,
				
			},
			phonenumber: {
				required: true,
				minlength: 8,
				maxlength: 50,
				digits: true
			},
			place: {
				required: true,
				
			},

			price: {
				required: true,
				minlength: 1,
				maxlength: 50,
				digits: true
			},

			contractdeadlineFrom: {			
				required: true,
			},
			
			contractdeadlineTo: {			
				required: true,
			},


		},
		messages: {
			bookingofficename:{
				required: "Please enter booking office name",
				minlength: "Booking office name must consist of at least 2 characters",
				maxlength: "Booking office name max 50 characters",
				notNumb: "Must be a characters"
			},
			trip: {
				required: "Please select option",

			},
			phonenumber: {
				required: "Please enter phone number",
				minlength: "Phone number must be at least 8 characters",
				maxlength: "Phone number max 50 characters",
				digits: "Must be number"
			},

			place:{
				required: "Please choose place"
			},

			price: {
				required: "Please enter price",
				minlength: "Price must be at least 1 characters",
				maxlength: "Price max 50 characters",
				digits: "Must be number"
			},
			contractdeadlineFrom: {
				required: "Please enter contract deadline from"
			},
			contractdeadlineTo: {
				required: "Please enter contract deadline to"
			},
		}
	});
});