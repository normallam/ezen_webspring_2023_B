console.log('phone.js open');

// 1. post ajax

function postPhone(){

    console.log('postphone 확인');
    let pname = document.querySelector('.pname').value;
    let pphone = document.querySelector('.pphone').value;
    console.log(pname+'들어오니');
    console.log(pphone+'들어오니');
    $.ajax({
         url : '/phone',
         type : "post",
         contentType:'application/json;charset=UTF-8',
         data : JSON.stringify({
                      pname : pname,
                      pnumber: pphone
                      }),
         success : s => {
            if(s){console.log('Post 통신 확인');getphone();}
         },
         error: e =>{console.log(e+'Post 에러확인');}
         })

}


// 2. get ajax
getphone();
function getphone(){

    console.log('getphone 확인')

     let phone_bottom = document.querySelector('.phone_bottom');
      let html = ``;
    $.ajax({
             url : '/phone',
             type : "get",
             contentType:'application/json;charset=UTF-8',
             data : { },
             success : s => {
                        console.log("이거 뭘까요");
                        console.log(s);

                        s.forEach(t=>{
                             html+=
                            `        <div class="pnoo">
                                        <span class="pname">${t.pname}</span>
                                        <span class="pphone">${t.pnumber}</span>
                                        <button onclick="putphone(${t.pno})">수정</button>
                                        <button onclick="deletePhone(${t.pno})">삭제</button>
                                    </div>`;

                         })
                            phone_bottom.innerHTML=html;
             },
             error: e =>{console.log(e+'get 에러확인');}

    })
}
// 3. put ajax
//3.PUT
function putphone(pno){
 let pname=prompt('수정할 이름');
 let pnumber=prompt('수정할 번호');
    $.ajax({
        url : '/phone',
        method : "put",
        data : JSON.stringify({
                                pname:pname,
                                pnumber:pnumber,
                                pno:pno

                                   }),
        contentType: "application/json;charset=UTF-8",
        success : r=>{
            console.log('put 통신성공');console.log(r);
           getphone();
             },


        error : e=>{console.log('put통신실패')},


    });
   }





// 4. delete ajax
function deletePhone(pno){ console.log("들어오냐 삭제"); console.log(pno+"pno이거임");
    $.ajax({
        url : '/phone',
        method : "delete",
        data : {pno:pno},
        success : r=>{
            console.log('delete 통신성공');console.log(r);
           getphone();
            } ,
        error : e=>{console.log('delete통신실패')} ,
   });
}