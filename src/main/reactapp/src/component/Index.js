/*
    Index : 여러 컴포넌트들을 연결하는 최상위 컴포넌트
        - 가상URL 정의해서 컴포넌트
*/
import { BrowserRouter, Routes, Route, Link }from 'react-router-dom';
import Header from './Header';
import Main from './Main';
import Footer from './Footer';

import ExampleList from './example/ExampleList';

import 컴포넌트1 from './example/day01/1_컴포넌트';
import 컴포넌트2 from './example/day01/2_컴포넌트';
import 컴포넌트3 from './example/day01/3_컴포넌트';
import 컴포넌트4 from './example/day01/4_컴포넌트';
import 과제01 from './example/day01/과제1_도서목록';
import 과제02 from './example/day02/Work2/TodoList';

/* Member import*/
import Login from './member/Login';
import Signup from './member/Signup';
import Info from './member/Info';

import BoardList from './board/BoardList';
import BoardWrite from './board/BoardWrite';
import BoardView from './board/BoardView';
import BoardUpdate from './board/BoardUpdate';
/*Product import*/
import ProductAdmin from './product/ProductAdmin';


import CSS적용컴포넌트 from './example/day02/1_CSS적용컴포넌트';
import CommentList from './example/day02/CommentList';
import Axios컴포넌트 from './example/day04/1_Axios컴포넌트';

/* 리액트 훅 라이브러리 */
import { useState, useEffect, useRef, createContext } from 'react';
/* MUI 라이브러리 호출*/
import { useSnackbar } from 'notistack'; // npm i notistack

/* 리액트 Context 변수 */
export const SocketContext = createContext();




export default function Index(props){
    /*MUI 라이브러리 객체 호출*/
    const { enqueueSnackbar } = useSnackbar();
    // 일반변수 : let 변수명 = 10 : 함수 안에서 선언됬으므로 함수 재실행/재 랜더링 될때 초기화 반복적으로 이뤄짐
    // Ref상태변수 : let 변수명 = useRef(10) : 함수 안에서 선언이 되었지만 해당 컴포넌트 업데이트(재랜더링)될 떄 초기화
        // 웹소켓은 반복적으로 초기화 되면 안되니까 일단 변수보다는 useRef에 저장하면 좀 더 효율적인 메모리 관리 가능
    // 2. 웹소켓
    // =================소켓=================== //

    // * 웹소켓 객체를 담을 useRef 변수 생성
    let clientSocket = useRef(null);

    // 만약에 웹소켓 객체가 비어있으면
    if(!clientSocket.current){
        // 1. 서버소켓과 연결하기
        clientSocket.current = new WebSocket("ws://localhost:80/chat");
        // 2. 클라이언트소켓의 각 기능/메소드 들의 기능 구현하기
            // 1. 클라이언트소켓과 연동 성공했을때. 이후 행동/메소드 정의
                clientSocket.current.onopen = (e)=>{console.log(e);} // e : 매개변수명

                // 2. 클라이언트소켓과 연동 오류가 발생했을때 이후 행동/메소드 정의
                clientSocket.current.onerror = (e)=>{console.log(e);}

                // 3. 클라이언트소켓과 연동이 끊겼을때 이후 행동/메소드 정의
                clientSocket.current.onclose = (e)=>{console.log(e);}

                // 4. 클라이언트소켓으로부터 메세지를 받았을때 이후 행동/메소드 정의
                clientSocket.current.onmessage = (e)=>{

                 enqueueSnackbar('This is a success message!', { variant :'success'});
                }

    }

    // =================소켓=================== //

    return(<>
        <div className="webContainer">
            <SocketContext.Provider value={clientSocket}>
                <BrowserRouter>
                    <Header />
                    <Routes>
                        {/*Main*/}
                        <Route path = '/' element = { <Main />} />

                        {/*Example*/}
                        <Route path = '/example' element = { < ExampleList/>}/>
                        <Route path = '/example/day01/컴포넌트1' element = { < 컴포넌트1/>}/>
                        <Route path = '/example/day01/컴포넌트2' element = { < 컴포넌트2/>}/>
                        <Route path = '/example/day01/컴포넌트3' element = { < 컴포넌트3/>}/>
                        <Route path = '/example/day01/컴포넌트4' element = { < 컴포넌트4/>}/>
                        <Route path = '/example/day02/CSS적용컴포넌트' element = { < CSS적용컴포넌트/>}/>
                        <Route path = '/example/day02/CommentList' element = { < CommentList/>}/>

                        <Route path = '/example/day01/과제1_도서목록' element = { <과제01/>}/>
                        <Route path = '/example/day02/Work2/TodoList' element = { <과제02/>}/>
                         <Route path = '/example/day04/Axios컴포넌트' element = { <Axios컴포넌트/>}/>

                        {/*MEMBER*/}
                        <Route path='/login' element={<Login />}/>
                        <Route path='/info' element={<Info />}/>
                        <Route path='/signup' element={<Signup />}/>

                        {/*board*/}
                        <Route path='/board/list' element={<BoardList />}/>
                        <Route path='/board/write' element={<BoardWrite />}/>
                        <Route path='/board/view' element={<BoardView />}/>
                        <Route path='/board/update' element={<BoardUpdate />}/>

                        {/*admin*/}
                        <Route path='/admin/product' element={<ProductAdmin />}/>

                    </Routes>
                    <Footer />
                </BrowserRouter>
            </SocketContext.Provider>
        </div>
    </>)
}
