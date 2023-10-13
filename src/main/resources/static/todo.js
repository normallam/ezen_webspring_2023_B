console.log('todo.js open');

// 1. post ajax

function postTodo(){

    console.log('postTodo 확인');
     let tcontent = document.querySelector('.tcontent').value;
    console.log(tcontent+'들어오니');
    $.ajax({
     url : '/todo',
     type : 'POST',
     contentType:'application/json;',
     data : JSON.stringify({
                  tno : 1,
                  tcontent: tcontent,
                  tstate: true }),
     success : s=> {
        if(s){console.log('Post 통신 확인');getTodo();}
     },

    error : e=>{console.log(e+'Post 에러확인');}

    })
}
// 2. get ajax
getTodo();
function getTodo(){

    console.log('getTodo 확인')

    $.ajax({
     url : '/todo',
     type : 'get',
     data : {  },
     success : r => {
                        console.log(r);
                        let todo_bottom = document.querySelector('.todo_bottom');
                        let html = ``

                for(let i = 0; i < r.length; i++){
                    if(r[i].tstate == true){
                        html +=`<div class="todo">`
                    }else if(r[i].tstate == false){
                        html +=`<div class="todo successTodo">`
                    }

                html +=`

                           <div class="tcontent"> ${r[i].tcontent} </div>
                           <div class="etcbtns">
                               <button onclick="putTodo(${r[i].tno} , ${r[i].tstate})" type="button">상태변경</button>
                               <button onclick="deleteTodo(${r[i].tno})" type="button">제거하기</button>
                           </div>
                       </div>  `;

                }//for
                todo_bottom.innerHTML = html;
            },

    error : e=> {console.log(e+'get 에러확인')}
    });
}

// 3. put ajax
function putTodo(tno, tstate){
    tstate = !tstate;

 $.ajax({
            url: '/todo',
            type: 'put',
            async: false,
            contentType: 'application/json;',
                    data: JSON.stringify({
                    tno: tno,
                    tstate: tstate }),
            success: s => {

                if( s ){
                    console.log('PUTsuccess');
                }
                getTodo();
            },
            error: e => {
                console.log('에러발생');
            }
        })



}
// 4. delete ajax
function deleteTodo(tno){

    console.log('deleteTodo 확인')

    $.ajax({
     url : '/todo',
     type : 'delete',
     async: false,
     data : {tno : tno},
     success : s=>{
        if(s){console.log('Delete 통신 확인')}
        getTodo();
     },
     error : e=>{console.log(e+'Delete 에러확인')}
    });

}