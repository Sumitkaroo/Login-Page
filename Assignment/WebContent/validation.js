function validation()

{

var a = document.form.uname.value;
if(a=="")
{
	alert("Please enter the username");
document.form.uname.focus();	
	return false;
}


var a = document.form.upass.value;
if(a=="")
{
	alert("Please Enter Your Password");
document.form.upass.focus();
return false;
}
}