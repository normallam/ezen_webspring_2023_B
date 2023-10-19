// 리액트 확장자 : jsx, js

    // 1. css속성 [카멜표기법 background-color --> backgroundColor]이 정의된 객체 선언
    // 1-2. 마크업 style속성 = {CSS속성이 있는 객체}

    // 2-1. 마크업 style속성={{속성:속성값, 속성:속성값}}

    // 3. css 파일에서 순수 css 문법
        // 1. 마크업에



// 1. 컴포넌트 문법 원형
import style from './컴포넌트.css';
export default function CSS컴포넌트(props){

    // 1. CSS를 객체에 속성[카멜표기법]으로 선언하기
    let cssStyle = {
        backgroundColor: 'red',
        width: '500px', height: '280px',
        margin: '0 auto'

    }

    return(<>
        <div style={ cssStyle }> CSS 적용하는 방법1 </div>
        {/*style 속성에 {{속성명:속성값, 속성명:속성값}}*/}
        <div style ={ {
                             backgroundColor: 'blue',
                             width: '500px', height: '280px',
                             margin: '0 auto'

                         }}> CSS 적용하는 방법1 </div>
        <div class="box3"> CSS 적용하는 방법3 </div>
        <div> CSS 적용하는 방법3 </div>

    </>);
}
