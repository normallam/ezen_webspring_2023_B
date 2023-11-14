package ezenweb.controller;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import ezenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
// 카테고리

    @Autowired
    private ProductService productService;

    // 1. 카테고리 등록
    @PostMapping("/category")
    public boolean addCategory(@RequestBody ProductCategoryDto productCategoryDto){
        return productService.addCategory(productCategoryDto);

    }

    // 2. 카테고리 출력
    @GetMapping("/category")
    public List<ProductCategoryDto> printCategory(){
        return productService.printCategory();

    }
    // 3. 카테고리 수정
    @PutMapping("/category")
    public boolean updateCategory(@RequestBody ProductCategoryDto productCategoryDto){
        return  productService.updateCategory(productCategoryDto);
    }

    // 4. 카테고리 삭제
    @DeleteMapping("/category")
    public boolean deleteCategory(@RequestParam int pcno){
        return productService.deleteCategory(pcno);
    }

    // -------------------- 제품등록 ---------------------- //
    @PostMapping("") // 요청 : / 응답 :
    public boolean onProductAdd(ProductDto productDto){
        return productService.onProductAdd(productDto);
    }

    @GetMapping("") // 요청 : / 응답 :
    public List<ProductDto> onProductAll(){
        System.out.println("컨트롤러 들어옴");
        return productService.onProductAll();
    }

    @PutMapping("") // 요청 : / 응답 :
    public boolean onProductUpdate(@RequestBody ProductDto productDto){

        return productService.onProductUpdate(productDto);
    }

    @DeleteMapping("") // 요청 : / 응답 :
    public boolean onProductDelete(@RequestParam String pno){
        return productService.onProductDelete(pno);
    }

}
