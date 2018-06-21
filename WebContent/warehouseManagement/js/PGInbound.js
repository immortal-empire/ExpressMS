/**
 * 购货入库的购货单校验函数
 * 
 */
function vaildatePGOrder(){ 
	var check;
	var res = /^[a-zA-Z]{2}[0-9]{6}$/;
	var result=document.getElementsByName("pgorder")[0].value;
	if(result.match(res)){
		document.getElementById("vailda_true").innerHTML="&#x1005;";
		check=true;
	}else{
		document.getElementById("vailda_false").innerHTML="&#x1007;";
		check=false;
	}
	return check;
}