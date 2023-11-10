/*  mui Tab[탭 메뉴] import*/
import * as React from 'react';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import TabContext from '@mui/lab/TabContext'; // npm i @mui/lab 설치 필수
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';

import CategoryWrite from './CategoryWrite';
import ProductWrite from './ProductWrite';
import ProductList from './ProductList';
import ProductInfo from './ProductInfo';


import axios from 'axios';
import {useEffect, useState} from 'react';

export default function ProductAdmin(props){

    // 0. 출력할 카테고리 목록을 저장하는 상태변수
        const [ categoryList, setCategoryList ] = useState([]);
        const [ memailCheck, setMemailCheck ] =useState([]);


        // 1. 카테고리 등록(controller 보고 함) AXIOS // 등록버튼을 클릭했을 때
        const addCategory = (e)=>{
            const info ={pcname : document.querySelector('.pcname').value}
            axios.post('/product/category',info)
                .then(r=>{
                    if(r.data){alert("카테고리등록성공"); printCategory()}
                    else{alert("카테고리등록실패")}
                 });
        }
        // 2. 카테고리 출력 AXIOS // 컴포넌트가 열렸을 떄 , 등록되었을 떄[재랜더링]
        const printCategory = (e)=>{
            axios.get('/product/category').then(r => {console.log(r.data); setCategoryList(r.data);});
         }



    // 2.
     const [value, setValue] = React.useState('1');
    // 3.
     const handleChange = (event, newValue) => {
        setValue(newValue);
      };


    return(<>
         <h3> 제품 관리 페이지 </h3>
        {/* 4. */}
            <Box sx={{ width: '100%', typography: 'body1' }}>
              <TabContext value={value}>
                <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
                  <TabList
                    onChange={handleChange}
                    aria-label="lab API tabs example"
                    indicatorColor="secondary"
                    centered
                    >
                    <Tab label="카테고리 등록" value="1" /> {/*value : 탭순서번호(식별)*/}
                    <Tab label="제품 등록" value="2" />
                    <Tab label="제품 목록" value="3" />
                    <Tab label="제품 상태" value="4" />
                  </TabList>
                </Box>
                {/* 탭 선택시 출력되는 내용들*/}
                <TabPanel value="1"><CategoryWrite
                                     categoryList={categoryList}
                                     printCategory={printCategory}
                                        /> </TabPanel>
                <TabPanel value="2"><ProductWrite
                                     categoryList={categoryList}
                                     printCategory={printCategory}

                                        /> </TabPanel>
                <TabPanel value="3"><ProductList/> </TabPanel>
                <TabPanel value="4"><ProductInfo/> </TabPanel>
              </TabContext>
            </Box>
    </>)
}