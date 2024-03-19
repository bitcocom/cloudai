function updateDetail(num){
    fetch("http://localhost:8081/myweb/api/board/"+num)
    .then(function(res){
          return res.json();
     })
    .then(function(board){
           let updateFrom=`
             <form>
                 <input type="hidden" name="num" value="${board.num}" id="num"/>
                  <table class="table table-bordered">
                     <tr>
                       <td>번호</td>
                       <td>${board.num}</td>
                     </tr>
                     <tr>
                        <td>제목</td>
                        <td><input type="text" class="form-control" id="title" name="title" value="${board.title}"/></td>
                      </tr>
                      <tr>
                         <td>내용</td>
                         <td><textarea rows="10" class="form-control" id="content" name="content">${board.content}</textarea></td>
                       </tr>
                  </table>
                  <button type="button" class="btn btn-sm btn-primary" onClick="goUpdatePost(${board.num})">수정</button>
                  <button type="reset" class="btn btn-sm btn-danger">취소</button>
                  <button type="button" class="btn btn-sm btn-info" onClick="location.href='/myweb/rest/list'">목록</button>
                  </form>
            `;
            document.getElementById("updateForm").innerHTML=updateFrom;
     })
    .catch(function(error){
         console.log(error);
      });
}
function goUpdatePost(num){
    let num1=parseInt(document.getElementById("num").value);
    let title=document.getElementById("title").value;
    let content=document.getElementById("content").value;
    let updateData={
       num : num1,
       title : title,
       content : content
    }
    // 수정하기(POST)
   fetch("http://localhost:8081/myweb/api/board/"+num,{
        method : "PUT",
        headers: {
                 "Content-Type" : "application/json"
             },
        body : JSON.stringify(updateData)
       })
   .then(function(res){
         // if
          location.href="/myweb/rest/list";
     })
   .catch(function(error){
        console.log(error);
     });
}