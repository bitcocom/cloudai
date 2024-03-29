function getBoardDetail(num){
      // 상세보기
      fetch("http://localhost:8081/myweb/api/board/"+num)
      .then(function(res){
         if(!res.ok){
             throw new Error("Network response was not ok");
          }
          return res.json(); // JSON
       })
      .then(function(board){
          // 상세보기 UI 동적으로 만들기(HTML - table)
          let boardTable=`
              <table class="table table-bordered">
                  <tr>
                    <td>번호</td>
                    <td>${board.num}</td>
                  </tr>
                   <tr>
                    <td>제목</td>
                    <td>${board.title}</td>
                    </tr>
                   <tr>
                     <td>내용</td>
                     <td>${board.content}</td>
                     </tr>
                     <tr>
                          <td>작성자</td>
                          <td>${board.writer}</td>
                           </tr>
                      <tr>
                           <td>조회수</td>
                           <td>${board.cnt}</td>
                     </tr>
              </table>
              <button type="button" class="btn btn-primary btn-sm" onClick="goUpdateGet(${board.num})">수정</button>
              <button type="button" class="btn btn-danger btn-sm" onClick="goDelete(${board.num})">삭제</button>
              <button type="button" class="btn btn-info btn-sm">목록</button>
           `;
           document.getElementById("getDetail").innerHTML=boardTable;
       })
      .catch(function(error){
           console.log(error);
      });
 }

 function goDelete(num){
    let deleteUrl="http://localhost:8081/myweb/api/board/"+num;
    fetch(deleteUrl, {
        method : "DELETE"
      })
    .then(function(res){
       console.log("1", res);
       console.log("2",res.ok);
        if(!res.ok){
            throw new Error("Network response was not ok");
        }
         location.href="/myweb/rest/list";
      })
    .catch(function(error){
        console.log(error);
     });
  }

  function goUpdateGet(num){
       location.href="/myweb/rest/update/"+num; // RouterController
  }