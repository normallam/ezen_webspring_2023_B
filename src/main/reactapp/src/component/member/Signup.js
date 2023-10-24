import{Link} from 'react-router-dom';
import styles from '../../css/signup.css' // css파일 호출
import axios from 'axios';

export default function Signup(props){
    // 1. 회원가입 버튼을 클릭했을때
    const onSignup = (e) => {console.log(e);
        // 2. 입력받은 데이터 구성
        let info ={
                memail : document.querySelector('.memail').value,
                mpassword : document.querySelector('.mpassword').value,
                mname : document.querySelector('.mname').value,
                mphone : document.querySelector('.mphone').value
        }; console.log(info);
       // 3. 유효성 검사


        // 4. 통신
        axios
            .post('http://192.168.17.34:80/member/post',info)
            .then(r=>{
                if(r.data){
                    alert('회원가입 성공');
                    window.location.href='/login';
                }else{
                    alert('회원가입 실패');
                }

            });



    }


    return(<>
        <div className="loginContainer">
            <h3> 회원가입 페이지 </h3>
            <form>
                이메일[아이디] : <input type="text" placeholder='@포함 7~30글자' className='memail'/><br/>
                비밀번호 : <input type="text" placeholder='특수문자 조합 5~30글자' className='mpassword'/><br/>
                이름 : <input type="text" placeholder='이름' className='mname'/><br/>
                전화번호 : <input type="text" placeholder='연락처' className='mphone'/><br/>
                <button onClick={onSignup} type="button">회원가입</button>
            </form>
        </div>
    </>)
}