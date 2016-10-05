var naoDesabilita = false;
$('form').one('submit', function() {
	if (naoDesabilita == false)
		$(this).find('button').attr('disabled','disabled');
	naoDesabilita = true
});

function confirmSubmit(form, message){
	naoDesabilita=false;
	if (confirm(message)){
		return true;
	} else {
		console.log(form.getElementsByTagName('button')[0].getAttribute("disabled"));
		naoDesabilita=true;
		return false;
	}
}