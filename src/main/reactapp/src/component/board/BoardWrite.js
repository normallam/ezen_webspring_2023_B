import axios from 'axios';

export default function BoardWrite(props){

    const boardWrite = (e)=>{
        // 1. 폼(변수=name) 가져오기[ 첨부파일 ]
        let boardForm = document.querySelectorAll('.boardForm')[0];
        let boardFormData = new FormData(boardForm);

        // 2. axios 전송
        axios.post("/board" , boardFormData)
            .then(result => {
                if(result.data){
                    alert('글등록 성공');
                    window.location.href='/board/list';

                }else{alert('글등록 실패');}



            console.log(result)});

    }



    return(<>
        <div>
            <h3> 게시물 쓰기 </h3>
                <form className="boardForm">
                    제목 : <input className="title" placeholder='제목' type="text" name="btitle" /> <br/>
                    내용 : <textarea className="context" placeholder='내용' type="text" name="bcontent"></textarea> <br/>
                    <input type="file"/>
                    <button type="button" onClick={boardWrite}> 글등록 </button>
                </form>
        </div>
    </>)
}