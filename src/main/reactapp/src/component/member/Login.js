
import{Link} from 'react-router-dom';
import styles from '../../css/login.css' // css파일 호출
import axios from 'axios';

export default function Login(props){
    // 로그인 버튼을 클릭했을 떄
    function onLogin(e){console.log(e);

        // 2. axios를 이용한  restApi로 spring Controller 전달할 데이터 전달
            // 3. 데이터 구성
            let info={
                memail : document.querySelector('.memail').value,
                mpassword : document.querySelector('.mpassword').value
            }; console.log(info);
            // 4. !! AXIOS 통신 [*SPRING CONTROLLER 매핑 확인 후]
            axios
                .post('http://192.168.17.34:80/member/login',info)
                .then(r=>{
                    if(r.data){
                        alert('로그인 성공');
                        window.location.href='/';
                    }else{
                        alert('로그인 실패');
                    }
                });
            // Cors policy 오류 발생 해결방안
                // - 스프링 controller 클래스 @CrossOrgin



    }

    return(<>
        <div className="loginContainer">
            <h3> 로그인 페이지 </h3>
                <form>
                    이메일[아이디] : <input type="text" placeholder='email address' className='memail' /><br/>
                    비밀번호 : <input type="password" placeholder='password' className='mpassword'/><br/>
                    {/*Link컴포넌트 사용하려면 import*/}
                    <Link to=''>아이디찾기</Link> <Link to=''>비밀번호찾기</Link>
                    <button onClick={onLogin} type="button">로그인</button>
                </form>
        </div>
    </>)
}