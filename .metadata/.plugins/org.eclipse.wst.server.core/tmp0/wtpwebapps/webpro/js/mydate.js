/**
 * 
 */

function proc1(){
	var now = new Date();
	
	var today1 = now.toLocaleString();
	var today2 = now.toLocaleDateString();
	var today3 = now.toLocaleTimeString();
	
	var out = document.querySelector('div');
	
	//출력내용 생성
	var str = today1 + "<br>";
	str += today2 + "<br>";
	str += today3 + "<br>";
	
	out.innerHTML = str;
}