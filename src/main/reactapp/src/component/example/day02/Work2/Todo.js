// CSS 파일 호출 하기 : import styles from 'CSS파일경로'
import styles from './todo.css'
export default function Comment(props){
    return(<>

        <div className ="todowrap">
                    <h1> 나만의 할일 목록 </h1>
                    <div className="todo_top">
                        <input className="tcontent" type ="text"/>
                        <button onClick="postTodo()" type="button"> 등록 </button>
                    </div>

                    <div className ="todo_bottom">
                    <div className="tcontent"> {props.name} </div>
                    <div className="tcontent"> {props.content} </div>
                           <div className="etcbtns">
                               <button onClick="putTodo()" type="button">상태변경</button>
                               <button onClick="deleteTodo()" type="button">제거하기</button>
                           </div>
                       </div>
                    </div>
                </div>


    </>)

}