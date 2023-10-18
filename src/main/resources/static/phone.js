console.log('phone.js open');

// 1. post ajax

function postphone(){

    console.log('postphone 확인');
    let pname = document.querySelector('pname').value;
    let pphone = document.querySelector('pphone').value;
    console.log(pname+'들어오니');
    console.log(pphone+'들어오니');
    $.ajax({
         url : '/index',
         type : 'POST',
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
    $.ajax({
             url : '/index',
             type : 'get',
             contentType:'application/json;charset=UTF-8',
             data : { }
             success : s => {
                        console.log(s);
                        let phone_bottom = document.querySelector('.phone_bottom');
                        let html = ``
                        r.forEach(t=>{
                             html+=
                            `        <div class="pno">
                                        <span class="pname">${t.name}</span>
                                        <span class="pphone">${t.number}</span>
                                        <button onclick="putPhone(${t.pno})">수정</button>
                                        <button onclick="deletePhone(${t.pno})">삭제</button>
                                    </div>`



                if(s){console.log('Post 통신 확인');getphone();}
             },
             error: e =>{console.log(e+'Post 에러확인');}
             })




}

// 3. put ajax
//3.PUT
function putPhone(pno){
 let pname=prompt('수정할 이름');
 let pnumber=prompt('수정할 번호');
    $.ajax({
        url : "/index",
        method : "put",
        data : JSON.stringify({
                                name:pname,
                                number:pnumber,
                                pno:pno

                                   }),
        contentType: "application/json;charset=UTF-8",
        success : r=>{
            console.log('put 통신성공');console.log(r)
            doGet()
             },


        error : e=>{console.log('put통신실패')},


    });
   }





// 4. delete ajax
function deletePhone(pno){
    $.ajax({
        url : "/index",
        method : "delete",
        data : {pno:pno},
        success : r=>{
            console.log('delete 통신성공');console.log(r)
            doGet()
            } ,
        error : e=>{console.log('delete통신실패')} ,
   });

}