var req;
function validate() {
	/*
	 * XMLHTTPRequest
	 * 1. 创建对象
	 * 2. 建立要连接的URL
	 * 3. 打开到服务器的连接
	 * 4. 设置回调函数
	 * 5. 发送请求
	 *
	 */
	
	if(window.XMLHttpRequest) {
		//非IE浏览器
		req = new XMLHttpRequest();
	}else if(window.ActiveXObject) {
		//IE浏览器
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//打开到服务器的连接，false代表同步处理
	req.open("post","addWarehouseServlet?action=validate",false);
	
	req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

	req.onreadystatechange = updatePage;
	
	req.send("waretype="+document.getElementById("cware").value);
}

function updatePage() {
	if(req.readyState == 4) {//响应完成
		if(req.status == 200) {//没有异常
			var result = req.responseText;
			if(result == "true") {
				document.getElementById("typeres").innerHTML = "true";
				document.getElementByID("addbtn").disabled  = false;
			}else {
				document.getElementById("typeres").innerHTML = "已存在中心库房";
				document.getElementByID("addbtn").disabled  = true;
				//var oImg = document.createElement('img');   //创建一个img标签
				//oImg.src = '../image/backgound.jpg';    //给img标签添加src属性
				
				//document.getElementById("res").appendChild(oImg);
			}
		}
	}
}