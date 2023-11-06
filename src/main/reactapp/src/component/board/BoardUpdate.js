import {BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import axios from 'axios'
import {useSearchParams} from 'react-router-dom';
import {useParams} from 'react-router-dom'
import {useState, useEffect} from 'react'


export default function BoardUpdate(props){

    const [searchParams, setSearchParams] = useSearchParams();
    const bno = searchParams.get('bno');

    // 1. 현재 게시물의 정보를 가지는 상태관리 변수
    const [board, setBoard] = useState({})

    // 2. 개별 게시물 출력 요청
    const onGet = (e) => {
        axios.get('/board/doGet', {params:{bno : bno}})
            .then(r=>{setBoard(r.data);})

    }
    useEffect(()=>{onGet()}, [])

    // 2. 개별 게시물 수정 요청
    const boardUpdate = (e) => {
         const boardForm = document.querySelectorAll('.boardForm')[0]
        const boardFormData = new FormData(boardForm);

        boardFormData.set('bno',bno);

        axios.put('/board', boardFormData)
            .then(r =>{
                if(r.data) {alert('글수정 성공');
                    window.location.href = '/board/view?bno=' + bno;
                }else{alert('글수정 실패')}
            } )

    }

    return(<>
        <div>
            <h3> 게시물 수정 {bno} </h3>
            <form className="boardForm">

                <input className="title"
                    placeholder='제목'
                    name ="btitle"
                    value={board.btitle}
                     onChange={(e)=>{
                        setBoard({...board, btitle : e.target.value})
                     }}
                       /> <br/>
                <textarea className="bcontext"
                 placeholder='내용'
                  value={board.bcontent}
                   name="bcontent"
                  onChange={(e)=>{
                    setBoard({...board, bcontent : e.target.value})
                  }}
                   ></textarea> <br/>

                <input type="file"/>
                <button type="button" onClick={boardUpdate}> 수정 </button>
            </form>
        </div>
    </>)



}