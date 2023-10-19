//  컴포넌트 호출 하기 : import 컴포넌트명  from '파일경로';
import Todo from './Todo.js';
export default function TodoList(props){

    // 만약에 AJAX가 response 한 데이터
    let response = [
            {name : '리액트배우기' , content : '안녕하세요1'} ,

        ];

    return(<>
        <div className="TodoListBox">
            {
                 response.map((r)=>{

                    return(<Todo name={r.name} content={r.content} />);
                 })

            }

        </div>

    </>)
}