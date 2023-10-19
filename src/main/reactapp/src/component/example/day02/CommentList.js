//  컴포넌트 호출 하기 : import 컴포넌트명  from '파일경로';
import Comment from './Comment.js';
export default function CommentList(props){

    // 만약에 AJAX가 response 한 데이터
    let response = [
            {name : '유재석' , content : '안녕하세요1'} ,
            {name : '강호동' , content : '안녕하세요2'} ,
            {name : '신동엽' , content : '안녕하세요3'}
        ];

    return(<>
        <div className="commentListBox">
            {
                 response.map((r)=>{

                    return(<Comment name={r.name} content={r.content} />);
                 })

            }

        </div>

    </>)
}