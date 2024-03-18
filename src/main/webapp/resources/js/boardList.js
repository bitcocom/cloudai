function boardList(){
   // 서버통신 : ajax -> jQuery(X)
   // fetch().then().then()
   fetch("http://localhost:8081/myweb/api/board")
   .then(function(res){ // res->JSON String
         if(!res.ok){
             throw new Error("Network response was not ok");
         }
         //console.log(res);
         return res.json(); // JavaScript Object 변경
      })
   .then(function(boards){
          console.log(boards); // ?
          let boardListTable=document.getElementById("boardList");
          let tbody=boardListTable.querySelector("tbody");
          tbody.innerHTML='';
          boards.forEach(function(board){
          let tr=document.createElement("tr"); // <tr></tr>
          tr.innerHTML='<td>'+board.num+'</td>'+
                                       '<td>'+board.title+'</td>'+
                                       '<td>'+board.writer+'</td>'+
                                       '<td>'+board.indate+'</td>'+
                                       '<td>'+board.cnt+'</td>';
            tbody.append(tr);
           });
     });
}