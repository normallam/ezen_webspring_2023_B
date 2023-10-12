console.log('todo.js open');
@ResponseBody

// 1. post ajax
$.ajax({
 url : '/todo',
 type : 'POST',
 dataType : ,
 data : {  },
 success : function(data){
 error : function (e){console.log(e)}

});

// 2. get ajax
$.ajax({
 url : '/todo',
 type : 'get',
 dataType : ,
 data : {  },
 success : function(data){

        let todolist = document.queryselector('tcontent');

 }
 error : function (e){console.log(e)}
});


// 3. put ajax
$.ajax({
 url : '/todo',
 type : 'put',
 dataType : ,
 data : {  },
 success : function(data){
 error : function (e){console.log(e)}
});
// 4. delete ajax
$.ajax({
 url : '/todo',
 type : 'delete',
 dataType : ,
 data : {  },
 success : function(data){
 error : function (e){console.log(e)}
});