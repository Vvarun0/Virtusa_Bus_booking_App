alert("js");
	function dateValidator() {
		alert("date");
		var d = new Date();
		var aa;
		aa = document.getElementById('dateOfJourney').value;
		if (aa === '')
			return false;
		if ((Date.parse(aa) - Date.parse(new Date()) < 0)) 
		{
			alert('change date');
		}
	}