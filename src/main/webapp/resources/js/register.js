// 등록 버튼 클릭시 호출되는 함수
function goRegister(){
      // let title=$("#title").val();
      let title=document.getElementById("title").value;
      let content=document.getElementById("content").value;
      let writer=document.getElementById("writer").value;
      // JavaScript Object ->JSON
      let obj={
          title : title,
          content : content,
          writer : writer
      };
      // POST(url, data(JSON), MIME Type...Key)
      fetch("http://localhost:8081/myweb/api/board",{
            method : 'POST',
            headers : {
                  'Content-Type' : 'application/json'
            },
            body : JSON.stringify(obj)
          })
          .then(function(res){
               if(!res.ok){
                  throw new Error("Network response was not ok");
               }
               // 등록이 성공후에는 다시 리스트페이지로....
               location.href='/myweb/rest/list';
            })
          .catch(function(error){
              console.log(error);
          });
}