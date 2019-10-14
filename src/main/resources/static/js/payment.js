function pname()
{
	var p = document.cookie.split(";");
	    for(i = 0 ;i<p.length;i++)
		{
	    	var h = p[i].split("=");
	    	for(j=0;j<h.length;j++){
	    		if(h[0].trim() == "parentname")
	    			document.getElementById("column").value = h[1]; 
	    	}
	    }
}
function cardnumber()
{
	str = "";count=0;
	//alert("validation");
	inputtxt = document.getElementById("input-field").value;
    var cardno = /^([3]{1}([0-9]){15})?$/;;///^([3]{1}([0-9]){11})?$/;//total 16 art with3
    if(inputtxt.match(cardno))
        {
    	//alert("ok");
    	var a = document.getElementById("input-field").value.split("");
    	document.getElementById("input-field").value ="";
    	for(i=0;i<a.length;i++)
    		{
    		   count++;
    		   if(count%5==0){
    			   str += "-";
    			   count=1;
    		   }
    		   
    			   str +=a[i];
    	       
    		}
    	//alert(str);
    	document.getElementById("input-field").value += str ;
      return true;
        }
      else
        {
    	  document.getElementById("input-field").value ="";
        alert("Not a valid credit card number!");
        //return false;
        }
}
function credit()
{
	  var str = document.getElementById("input-field").value;
	  var patt1 = /^(3[0-9]{11})/g; ;// /^(?:3[47][0-9]{13})/g;    /\[0-9]/g;
	  var result = str.match(patt1);
	  if(result == null)
		  document.getElementById("input-field").value = "";  
	  console.log(result);
}
function ifon()
{
	var str = document.getElementById("input-field").value;
	if(str.length.trim() == 4)
		str = document.getElementById("input-field").value += str = document.getElementById("input-field").value +"-";
}
