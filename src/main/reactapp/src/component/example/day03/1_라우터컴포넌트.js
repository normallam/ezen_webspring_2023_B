/*
    컴포넌트 만들기
            - 파일명 : 아무거나.js 혹은 아무거나.jsx [ 권장 : 컴포넌트명과 동일 ]
            - 컴포넌트 원형
                - 컴포넌트명 : 첫글자는 대문자 [ 무조건 , 카멜 표기법 ]
                        export default function 컴포넌트( props ){
                            return(<></>)
                        }

         컴포넌트 랜더링
            - 최상위 랜더링(가장 먼저 랜더링) : index.js

        - 라우터 : 가상 url 만들기
                - 상세 라우터 : 연결 경우를 자동으로 전환해주는 기계
                - 리엑트 라우터 : 가상 경로[url] 를 만들어서 컴포넌트를 전환해주는 라이브러리
                - 설치
                    1. https://www.npmjs.com/
                    2. router-dom 검색
                    3. 리액트 버전 주의!!!!
                        npm i router-dom [ 2.2.11 ]
                        npm i react-router-dom [ 6.17.0 ] 수업 버전!!!
                    4. 터미널(alt+f12)
                        1. 터미널 종료
                        2. 리액트 프로젝트 이동 [ cd src/main/reactapp ]
                - 해당 파일에서 외부라이브러리 import
                    <BrowserRouter>
                                        <Routes >
                                            <Route path='컴포넌트URL' element = { <컴포넌트명 /> } />
                                        </Routes >
                    </BrowserRouter>

                - 다른 컴포넌트에서 컴포넌트(페이지) 전환
                    라우터 경로란 : Route path
                    1. <a href=''> </a>                 페이지 리로드 o
                    2. <Link to='라우터경로'> </a>        페이지 리로드 x


*/
import { BrowserRouter , Routes , Route , Link }from "react-router-dom"; // npm i react-router-dom 설치 후 가능
import 컴포넌트1 from '../day01/1_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트2 from '../day01/2_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트3 from '../day01/3_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트4 from '../day01/4_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출

export default function 라우터컴포넌트(props){
    return(<>



       <BrowserRouter> {/*브라우저 라우터 시작*/}
            <고정컴포넌트/>{/*BrowserRouter 안에 있고 Routes 밖에 있는 컴포넌트*/}
            <Routes> {/*화면이 전환되는 컴포넌트들의 URL 정의 공간*/}
                   <Route path='/day01/컴포넌트1' element = { <컴포넌트1/> }/>   {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
                   <Route path='/day01/컴포넌트2' element = { <컴포넌트2/> }/>   {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
                   <Route path='/day01/컴포넌트3' element = { <컴포넌트3/> }/>   {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
                   <Route path='/day01/컴포넌트4' element = { <컴포넌트4/> }/>   {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
            </Routes>
       </BrowserRouter> {/*브라우저 라우터 끝*/}
    </>)
}

function 고정컴포넌트(props){
    return(<>
        <div>
            <a href='/day01/컴포넌트1'>컴포넌트1</a>
            <a href='/day01/컴포넌트2'>컴포넌트2</a>
            <a href='/day01/컴포넌트3'>컴포넌트3</a>
            <a href='/day01/컴포넌트4'>컴포넌트4</a>
        </div>
        <div>
            <Link to='/day01/컴포넌트1'>컴포넌트1</Link>
            <Link to='/day01/컴포넌트2'>컴포넌트2</Link>
            <Link to='/day01/컴포넌트3'>컴포넌트3</Link>
            <Link to='/day01/컴포넌트4'>컴포넌트4</Link>
        </div>
    </>) }