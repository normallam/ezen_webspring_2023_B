import axios from 'axios';
import CategoryWrite from './CategoryWrite';


import {useContext} from 'react';
import {SocketContext} from '../Index.js'

export default function ProductWrite(props){

    // 1. 상위 컴포넌트에 있는 context의 들어있는 클라이언트소켓 꺼내기
    const clientSocket = useContext(SocketContext).current;

    /*console.log(useContext(SocketContext))*/

    // 1. 제품등록
    const onProductAdd = (e)=>{


        let productForm = document.querySelectorAll('.productForm')[0];
        let productFormData = new FormData(productForm);

        axios.post('/product', productFormData)
            .then(r=>{
                if(r.data){
                     // [소켓3] : 서버에게 메세지 보내기
                     clientSocket.send('새로운 제품이 등록 되었습니다.');
                     productForm.reset();
                }
                else{alert("제품등록 실패")}
            });
    }
    // 2. 제품출력 AXIOS // 컴포넌트가 열렸을 때, 등록되었을때[재랜더링]
   /* const printProduct = (e)=>{
        axios.get('/product/category').then(r=>{console.log(r.data); set})
    }*/

    return(<>
       <div style={{width : '300px', margin: '0 auto'}}>
         <h3> 제품 등록 </h3>
         <form className='productForm'>
             <select name='pcno'>
                {
                    props.categoryList.map((c)=>{

                        return(<>
                            <option value={c.pcno}>{c.pcname}</option>
                        </>)
                    })
                }
             </select>
             <input type="text" name="pname" placeholder="제품명"/> <br/>
             <textarea name="pcomment" placeholder="제품설명"> </textarea> <br/>
             <input type="text" name="pprice" placeholder="제품가격"/> <br/>
             <input type="text" name="pstock" placeholder="초기재고"/> <br/>
             <input type="file" name="fileList" multiple/><br/>
             <button type="button" onClick={onProductAdd}>등록</button>
         </form>
        </div>
    </>)
}