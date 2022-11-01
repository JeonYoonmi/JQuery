/**
 * 
 */
currentPage = 1;

//updateReply = function(){
//function updateReply(){
updateReply = () => {
	$.ajax({
		url : '/boardpro/replyUpdate.do',
		data : { "renum" : vidx ,
				 "cont" : modifycont },
		method : 'post',	//type : 'post'
		success : function(res){
//			alert(res.sw);
			if(res.sw == "성공") cp3.html(modiout);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

deleteReplyServer = function(but){
	$.ajax({
		url : '/boardpro/replyDelete.do',
		data : { "renum" : vidx },
		type : 'get',
		success : function(res){
//			alert(res.sw);
			//화면에서 삭제 - but를 기준으로 rep-body를 검색해서 삭제
			$(but).parents('.rep-body').remove();
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

replyListServer = function(but){	//but : 등록버튼, a태그
	$.ajax({
		url : '/boardpro/replyList.do',
		data : { "bonum" : vidx },
		type : 'get',
		success : function(res){
			rcode = "";
			$.each(res, function(i, v){
				cont = v.cont;
				content = cont.replace(/\r/g, "").replace(/\n/g, "<br>");
				rcode += '<div class="rep-body">';
			    rcode += '<p class="p1">';
			    rcode += '작성자 : <span class="spw">'+ v.name +'</span>&emsp;&emsp;&emsp;';
			    rcode += '날짜 : ' + v.redate;
			    rcode += '</p>';
			    rcode += '<p class="p2">';
			    rcode += '<input idx="'+ v.renum +'" type="button" value="댓글수정" class="action" name="r_modify">';
			    rcode += '<input idx="'+ v.renum +'" type="button" value="댓글삭제" class="action" name="r_delete">';
			    rcode += '</p><br><br>';
			    rcode += '<p class="p3">';
			    rcode += content;
			    rcode += '</p>';
				rcode += '</div>';
			})
			
			$(but).parents('.panel').find('.rep-body').remove();
			
			$(but).prev().val(""); //등록버튼을 기준으로 입력한 댓글 내용을 지우기
//			$(but).parents('.panel').find('textarea').val("");	//a태그를 클릭했을 경우를 고려했지만 글 쓰는거는 a태그를 클릭했을 때는 관계가 없기 때문에 이 방법으로 안해도 됨
			
			$(but).parents('.panel').find('.panel-body').append(rcode);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

replySaveServer = function(but){	//but : 등록버튼
	$.ajax({
		url : '/boardpro/replySave.do',
		data : reply,	//name, cont, bonum(num)
		type : 'post',
		success : function(res){
//			alert(res.sw);
			//댓글리스트 출력
			replyListServer(but);
		},
		error : function(xhr){
			
		},
		dataType : 'json'
	})
}

updateHitServer = function(){
	$.ajax({
		url : '/boardpro/updateHit.do',
		data : { "num" : vnum },
		type : 'get',
		success : function(res){
//			alert(res.sw);
			vhit = parent.find('.hit').text();
			parent.find('.hit').text(parseInt(vhit) + 1);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
	})
}

modifyServer = function(){
	$.ajax({
		url : '/boardpro/modify.do',
		data : formdata,
		type : 'post',
		//지금 비동기 방식이라 success안에 ajax를 쓰지 않으면 어떤게 먼저 수헹되는지 모르는데 동기 방식으로 억지로 바꾸는 방법
//		async: false,
		success : function(res){
//			alert(res.sw);
			listPageServer(currentPage);
			//만약 이 ajax가 실행되고 나서 또 ajax를 사용하고 싶을경우에는 이 자리에 쓰면 된다
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

deleteServer = function(){
	$.ajax({
		url : '/boardpro/delete.do',
		data : { "num" : vidx },
		type : 'get',
		success : function(res){
//			alert(res.sw);
//			listPageServer(현재페이지 번호);
//			listPageServer(1);	//삭제하고 나서 1페이지로 가고 싶을 경우
			listPageServer(currentPage);	//삭제하고 나서 그 페이지에 계속 머물게 히고 싶을 경우
		},
		// 에러가 없거나 확인할 필요가 없다면 생략해도 좋다
//		error : function(xhr){
//			alert("상태 : " + xhr.status);
//		},
		dataType : 'json'
	})
}

writeSendServer = function(){
	//입력한 모든 값을 가져온다.
	formdata = $('#wform').serializeJSON();
	
	$('#wform .wtxt').val("");
	$('#writeModal').modal('hide');
		
	$.ajax({
			url : '/boardpro/write.do',
			data : formdata,
			type : 'post',
			success : function(res){
				//만약에 다른 페이지로 넘어가고 싶다면 ajax를 사용하지 않고  location.href을 사용한다.
//				alert(res.sw);
				currentPage = 1;
				listPageServer(currentPage);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType :  'json'
		})
}

listPageServer = function(page){
	//html
	type = $('#stype option:selected').val().trim();
	word = $('#sword').val().trim();
	
	$.ajax({
		url : '/boardpro/List.do',
		type : 'post',
		data : { "page" : page,
				 "stype" : type,
				 "sword" : word },
		success : function(res){
			code = '<div class="container">';
			code += '<div class="panel-group" id="accordion">';
			$.each(res.datas, function(i,v){
				cont = v.content;
				content = cont.replace(/\r/g, "").replace(/\n/g,"<br>");
				
				code += '<div class="panel panel-default">';
			    code += '<div class="panel-heading">';
			    code += '<h4 class="panel-title">';
			    code += '<a idx="' + v.num + '" data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.num +'">'+ v.subject +'</a>';
			    code += '</h4>';
			    code += '</div>';
			    code += '<div id="collapse'+ v.num +'" class="panel-collapse collapse">';
			    code += '<div class="panel-body">';
			    code += '<p class="p1">';
			    code += '작성자 : <span class="spw">'+ v.writer +'</span>&emsp;&emsp;&emsp;';
			    code += '이메일 : <span class="spe">'+ v.mail +'</span>&emsp;&emsp;&emsp;&emsp;&emsp;';
			    code += '조회수 : <span class="hit">'+ v.hit +'</span> &emsp;';
			    code += '날짜 : ' + v.wdate;
			    code += '</p>';
			    code += '<p class="p2">';
			    code += '<input idx="'+ v.num +'" type="button" value="수정" class="action" name="modify">';
			    code += '<input idx="'+ v.num +'" type="button" value="삭제" class="action" name="delete">';
			    code += '</p><br><br>';
			    code += '<p class="p3">';
			    code += content;
			    code += '</p>';
			    code += '<p class="p4">';
			    code += '<textarea cols="116"></textarea>';
			    code += '<input idx="'+ v.num +'" type="button" value="등록" class="action" name="reply">';
			    code += '</p>';
			    code += '</div>';
			    code += '</div>';
			    code += '</div>';
			})
			code += '<div>';
			code += '</div>';
			
			$('#d1').html(code);
			
			
			//이전버튼
			pager = "";
			if(res.startpage > 1){
				pager += '<ul class="pagination">';
				pager += '<li class="page-item"><a class="page-link previous" href="#">Previous</a></li>';
				pager += '</ul>';
			}
			
			//페이지 번호
			pager += '<ul class="pagination pager">';
			for(i=res.startpage; i<=res.endpage; i++){
				if(i==currentPage){
					pager += '<li class="page-item active"><a class="page-link" href="#">'+ i +'</a></li>';
				}else{
					pager += '<li class="page-item"><a class="page-link" href="#">' + i + '</a></li>';
				}
			}
			pager += '</ul>';
			
			//다음버튼
			if(res.totalpage > res.endpage){
				pager += '<ul class="pagination">';
				pager += '<li class="page-item"><a class="page-link next" href="#">Next</a></li>';
				pager += '</ul>';
			}
			
			$('#pagelist').empty();
			$('#pagelist').append(pager);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);	//200 : json오류, 404 : 페이지 이름, 500 : 콘솔창
		},
		dataType : 'json'
	})
}


listServer = function()	{
	
	$.ajax({
		url : '/boardpro/List.do',
		type : 'get',
		success : function(res){
			code = '<div class="container">';
			code += '<div class="panel-group" id="accordion">';
			$.each(res, function(i,v){
				code += '<div class="panel panel-default">';
			    code += '<div class="panel-heading">';
			    code += '<h4 class="panel-title">';
			    code += '<a data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.num +'">'+ v.subject +'</a>';
			    code += '</h4>';
			    code += '</div>';
			    code += '<div id="collapse'+ v.num +'" class="panel-collapse collapse">';
			    code += '<div class="panel-body">';
			    code += '<p class="p1">';
			    code += '작성자 : '+ v.writer +' &emsp;&emsp;&emsp;';
			    code += '이메일 : '+ v.mail +' &emsp;&emsp;&emsp;&emsp;&emsp;';
			    code += '조회수 : <span class="hit">'+ v.hit +'</span> &emsp;';
			    code += '날짜 : ' + v.wdate;
			    code += '</p>';
			    code += '<p class="p2">';
			    code += '<input idx="'+ v.num +'" type="button" value="수정" class="action" name="modify">';
			    code += '<input idx="'+ v.num +'" type="button" value="삭제" class="action" name="delete">';
			    code += '</p><br><br>';
			    code += '<p class="p3">';
			    code += v.content;
			    code += '</p>';
			    code += '<p class="p4">';
			    code += '<textarea cols="116"></textarea>';
			    code += '<input idx="'+ v.num +'" type="button" value="등록" class="action" name="reply">';
			    code += '</p>';
			    code += '</div>';
			    code += '</div>';
			    code += '</div>';
			})
			code += '<div>';
			code += '</div>';
			
			$('#d1').html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);	//200 : json오류, 404 : 페이지 이름, 500 : 콘솔창
		},
		dataType : 'json'
	})
}
