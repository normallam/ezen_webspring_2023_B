import axios from 'axios';
import {useEffect, useState} from 'react';

import Category from './Category';

export default function CategoryWrite(props){

    // 0. 출력할 카테고리 목록을 저장하는 상태변수
    const [ categoryList, setCategoryList ] = useState([]);
    const [ memailCheck, setMemailCheck ] =useState([]);


    // 1. 카테고리 등록(controller 보고 함) AXIOS // 등록버튼을 클릭했을 때
    const addCategory = (e)=>{
        const info ={pcname : document.querySelector('.pcname').value}
        axios.post('/product/category',info)
            .then(r=>{
                if(r.data){alert("카테고리등록성공"); props.printCategory()}
                else{alert("카테고리등록실패")}
             });
    }
    // 2. 카테고리 출력 AXIOS // 컴포넌트가 열렸을 떄 , 등록되었을 떄[재랜더링]
    const printCategory = (e)=>{
        axios.get('/product/category').then(r => {console.log(r.data); setCategoryList(r.data);});
     }
     useEffect(()=>{printCategory()}, []) // 등록되었을떄

    // 3. 카테고리 수정 AXIOS // 수정 버튼을 클릭했을 떄
    const updateCategory = (e , pcno)=>{
        const info = { pcno : pcno }
        axios.put('/product/category', info).then(r=>{console.log(r.data);});
     }
    // 4. 카테고리 삭제 AXIOS // 삭제 버튼을 클릭했을 때
    const deleteCategory = (e , pcno)=>{
        axios.delete('/product/category' , {params : {pcno : pcno}})
        .then(r=>{console.log(r.data);props.printCategory();});
     }


    return(<>
         <div style={{width:'300px', margin : '0 auto'}} className="CategoryContainer">
            <h3> 카테고리 등록 </h3>
                <form>
                    <input type="text" className="pcname" placeholder="등록할 카테고리명"/>
                    <button type="button" onClick={addCategory}>등록</button>
                </form>

                <h3> 카테고리 출력 </h3>
                {
                    props.categoryList.map((c)=>{
                    return <Category category={c} deleteCategory={deleteCategory} />
                    })
                }
         </div>
    </>)
}