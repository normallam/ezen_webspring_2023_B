// ----------------------------- JS 형식 --------------------------------//
import { useState } from 'react'; // 리액트 내장함수 중에 useState 훅 중의 하나의 함수
export default function 상태관리컴포넌트(props){



    let value1 = 10;
    function value1증가(e){value1++;}
    //useState함수에 매개변수 전달하고 2개를 가지는 배열 리턴
        /*
            useState
                [0] : 값
                    - 지역변수x, 재랜더링할때 재선언x, 랜더링할때 상태[데이터]유지
                [1] : 그 값을 수정할 수 있는 함수. bound dispatchSetState
                    - * 해당 컴포넌트만 재실행[랜더링]
                    - setValue2(변경할값) : 변경할값에 계산식 있을경우 앞에서 계산후 대입
            let [변수명, set함수명] = useState(초기값)
        */
    let 상태함수 = useState('훅이란 무엇인가?');
    console.log(상태함수);
    console.log(상태함수[0]);
    console.log(상태함수[1]);

    let [value2, setValue2] = useState(10);
    function value2증가(e){
        value2++
        setValue2(value2++);
    }

    alert('컴포넌트 랜더링중 / 함수(재)실행');

    let value3 = '텍스트입력';

    let [value4, setValue4] = useState('텍스트입력');
    // - 입력값이 체인지 될때마다 실행되는 함수
    const value4변경 = (체인지이벤트결과, value ) => {setValue4(체인지이벤트결과.target.value);}
    // e => onChange
    // e.target => 해당 이벤트를 실행한 마크업/컴포넌트
    // document.querySelector('input').value;
    // ------------------------JSX 형식---------------------------//
    return(<>
    {/* */}
        <div>{value1} <button onClick={ value1증가 }> value1증가 </button> </div>
        <div>{value2} <button onClick={ value2증가 }> value2증가 </button> </div>
         <div> <input type="text"/> </div>
        <div> <input type="text" value={ value3 }/> </div>
        <div> <input type="text" value={ value4 } onChange={value4변경}/> </div>
        <div> <input type="text" value={ value4 } onChange={e=>value4변경(e,3)}/> </div>

    </>);
    // ------------------------JSX 형식 END------------------------//
}

// ----------------------------- JS 형식 END----------------------------//