/*
    컴포넌트 만들기
        - 리액트 2가지 컴포넌트 [클래스형 컴포넌트 vs 함수형 컴포넌트]
        - 1. 리액트 컴포넌트 만들때 사용하는 확장자 .jsx 사용한 파일 생성
        - 2. function 컴포넌트명(){ } [*영문일때는 꼭 첫글자를 대문자]
            - js 함수 선언 비슷
        - 3. export default 컴포넌트명;
            - 해당 jsx파일을 import 했을 때 내보내기 할 컴포넌트 선언
        - 4. 컴포넌트(함수)
 */

 function 컴포넌트1(){
    return <h1> 컴포넌트란 무엇인가.. </h1>
 }

 export default 컴포넌트1;