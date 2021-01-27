$(document).ready(
	function(){
		$.validator.addMethod("checkDate", function(value){
			var dateInput = document.getElementById("date-published").value;
			var inputDate = new Date(dateInput);
			var currDate = new Date();
			inputDate.setHours(0,0,0,0);
			currDate.setHours(0,0,0,0);
			if(inputDate.getTime() > currDate.getTime()){
				return false;
			} else{
				return true;
			}
		}, ""
	);
		$("#bookingForm").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');	
				label.insertAfter(element);
			},
			rules:{
				title:{
					required: true,
					maxlength: 50
				},
				pageCount:{
					required: true,
					digits: true
				},
				price:{
					required: true,
					digits: true
				},
				datePublished:{
					required: true,
					checkDate: true
				},
				authorId:{
					required: true,
					digits: true
				},
				status:{
					required: true,
				},
			},
			messages: {
				title:{
					required: "Please enter book title",
					maxlength: "Max length is 50 charaters"
				},
				pageCount:{
					required: "Please enter page count",
					digits: "Number only"
				},
				price:{
					required: "Please enter book price",
					digits: "Number only"
				},
				datePublished:{
					required: "Please choose date",
					checkDate: "Date input must be less than the current date"
				},
				authorId:{
					required: "Please enter author id",
					digits: "Number only"
				},
				status:{
					required: "Please choose status"
				},
			},
		});
	});