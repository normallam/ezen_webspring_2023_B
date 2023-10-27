import{Link} from 'react-router-dom';
import styles from '../../css/signup.css' // css파일 호출
import axios from 'axios';
import {useState, useEffect} from 'react';

export default function Info(props){ // 로그인 상태별로, 회원권한(mrol)별로 페이지 접근 제한


    // axios로부터 전달받은 로그인된 회원정보를 상태변수에 저장
    const [member, setMember] = useState(null); // {memail : 'qweqwe' , mname : 'qweqwe'}

    // 로그인 정보를 호출해서 출력하기 [최초 1번 실행]
   useEffect(()=>{
        axios.get('/member/get').then(r=>{setMember(r.data);});
     } ,[ ] )

    // 1. 이름 입력 했을때. 상태 변경
    //function mnameInputChange(e){}
    const mnameInputChange = (e) => {
        console.log(e.target.value) // onchange 이벤트를 실행한 주체자 [e.target] 의 값 호출[.value]
        let mnameInput = e.target.value;
        //setMember(mnameInput); // ?????문제점
        // member 상태변수 전체 수정이 아닌 meber 상태변수내 특정 속성만 변경해야함...member 객체 중에 mname 속성만 교체

        //let changeMember = member;          // 기존 객체를 새로운 객체???에 대입
        //changeMember.mname = mnameInput;    // 객체의 특정 속성만 새로운 값 대입
        //setMember(changeMember);            // 수정된 새로운 객체를 상태변수에 대입
            // 문제점 : setState()는 상태변수의 주소값이 변경될때 반응/랜더링

        //let changeMember = {...member};          // 기존 객체를 새로운 객체???에 대입
            // !! : 1. 객체 복사 방법 {...객체명 }, 2. 배열 복사 방법    (map, ...)
            // ... Spread Operator : 얕은 복제
            // {...객체명}
            // {...객체명, 속성명 : 값 } // 복사 할때 해당 속성명이 있으면 수정/ 없으면 대입
        //changeMember.mname = mnameInput;    // 객체의 특정 속성만 새로운 값 대입
        //setMember(changeMember);            // 수정된 새로운 객체를 상태변수에 대입

        setMember( { ...member , mname : mnameInput } );
        // 요약 : setMember( { ...member , mname : mnameInput } );

    }

    // 2. 전화번호 변경 [바로.. 이벤트 속성 처리]


    // 3. 회원탈퇴 [view요청 -> springcontroller전달 => service전달 -> entity조작 -> 레코드 삭제]
    const onDelete = (e) => {
        if(window.confirm('정말 탈퇴하시겠습니까?')){ // 확인 버튼을 눌렀을 때
            axios
            .delete("/member/delete", {params : {mno : member.mno}})
            .then(r=>{
                if(r.data){
                    alert('회원탈퇴 성공')
                    sessionStorage.removeItem('login_token'); // 로그인 세션 제거
                    window.location.href = "/";
                }else{alert('회원탈퇴 실패');}
            })

        }

    }
    // 4. 회원정보 수정
        // 입력받은 패스워드 값을 저장하는 상태변수
    const [newPassword, setNewPassword] = useState({mpassword:'' , mpassword2:''});
    const onUpdate = (e)=>{

        // 기존 비밀번호 일치한지 유효성검사[x] ---> 백엔드 해야할 일




        // 새로운 비밀번호 2개 일치한지 유효성 검사 ---> 프론트앤드 해야할 일
        if(newPassword.mpassword != newPassword.mpassword2){alert('패스워드가 일치하지않습니다.'); return;}
        // 1. spring 서비스에게 보낼 데이터 구성 dto[mno, mname, mpassword, mphone]
        let info ={
            mno : member.mno,
            mname : member.mname,
            mpassword : newPassword.mpassword, // 새로 만단
            mphone : member.mphone};
            console.log(info);
            axios.put("/member/put", info)
            .then(r=>{
                    if(r.data){
                    alert('회원정보 수정성공')
                    window.location.href = "/";
                    }else{alert('회원정보 수정실패')}
            })

    }


    return(<>
        <div className="loginContainer">
            <h3> ReactEzen Info </h3>
            <form>
                회원등급 <div> {member != null ? member.mrol : ''} </div>
                이메일[아이디] : <input value={member!=null ? member.memail : '' } disabled type="text" placeholder='@포함 7~30글자' className='memail'/>
                새 비밀번호 : <input type="password" placeholder='특수문자 조합 5~30글자' className='mpassword'
                                value={newPassword.mpassword}
                                onChange={(e)=>{setNewPassword({...newPassword, mpassword : e.target.value})}
                                }
                                />
                새 비밀번호 확인 : <input type="password" placeholder='특수문자 조합 5~30글자' className='mpassword2'
                                value={newPassword.mpassword2}
                                onChange={(e)=>{setNewPassword({...newPassword, mpassword2 : e.target.value})}
                                }
                                />



                이름 : <input
                    value={member!=null ? member.mname : '' }
                    type="text"
                    placeholder='이름'
                    className='mname'
                    onChange={mnameInputChange}
                    />

                전화번호 : <input
                        value={member!=null ? member.mphone : '' }
                        type="text" placeholder='연락처' className='mphone'
                        onChange={(e)=>{setMember({...member, mphone : e.target.value});}
                        }
                        />

                <button onClick={onUpdate} type="button">정보 수정</button>
                <button onClick={onDelete} type="button">회원 탈퇴</button>
            </form>
        </div>

    </>)
}