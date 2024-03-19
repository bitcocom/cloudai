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
                  <button type="button" class="btn btn-sm btn-primary">수정</button>
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