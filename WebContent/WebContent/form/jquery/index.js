function isEmail(inputEmail) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(inputEmail);
}
function validatePassword(inputPassword) {
    return inputPassword.length > 4;
}
function myclick()
{
document.getElementById("dt1").hidden=false;
document.getElementById("dt2").hidden=false;
document.getElementById("dt3").hidden=false;
document.getElementById("dt4").hidden=false;
document.getElementById("ndt").hidden=true;
}
function myclick1()
{
document.getElementById("ndt").hidden=false;
document.getElementById("dt1").hidden=true;
document.getElementById("dt2").hidden=false;
document.getElementById("dt4").hidden=false;
document.getElementById("dt3").hidden=false;
}
$(document).ready(function () {
    $('#email').change(function () {
        var email = $(this).val().trim();
        // alert(`email = ${JSON.stringify(email)}`)
        if (!isEmail(email)) {
            //Error ?
            $(".emailError").html("Email is not valid format");
        } else {
            $(".emailError").html("");
        }
    });
    $('#password').change(function () {
        var password = $(this).val();
        if (!validatePassword(password)) {
            $(".passwordError").html("Password must be at least 5 characters");
        } else {
            $(".passwordError").html("");
        }
    });
});