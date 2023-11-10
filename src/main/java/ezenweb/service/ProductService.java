package ezenweb.service;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.entity.ProductCategoryEntity;
import ezenweb.model.repository.ProductCategoryEntityRepository;
import ezenweb.model.repository.ProductEntityRepository;
import ezenweb.model.repository.ProductImgEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    // 0. 리포지토리
    @Autowired private ProductCategoryEntityRepository productCategoryEntityRepository;
    @Autowired private ProductEntityRepository productEntityRepository;
    @Autowired private ProductImgEntityRepository productImgEntityRepository;
    
    // 0 . 다른 서비스
    @Autowired private FileService fileService;
    // -------------------카테고리 ------------------//
    // 1. 카테고리 등록
    @Transactional public boolean addCategory(ProductCategoryDto productCategoryDto){
        // 1. DTO --> 엔티티
        // 2. 리포지토리를 이요한 엔티티 세이브
        // 3. 성공시 true 실패시 false
        return productCategoryEntityRepository.save(
                ProductCategoryEntity.builder().pcname(productCategoryDto.getPcname()).build()
                ).getPcno()>=1 ? true : false;
    }
    
    // 2. 카테고리 출력
    @Transactional public List<ProductCategoryDto> printCategory(){
        // 1. 모든 엔티티 호출 // 2. 모든 엔티티리스트 -> dto리스트변환 // 3. dto리스트 반환
        return productCategoryEntityRepository.findAll().stream().map( // 모든 dto들을 리턴시킨다
                e -> {return ProductCategoryDto.builder().pcno(e.getPcno()).pcname(e.getPcname()).build();}
                // 엔티티를 dto로 변환시켜서
        ).collect(Collectors.toList()); // collection => list,map 중에 map을 List로 반환하겠다.
    }


    // 3. 카테고리 수정
    @Transactional public boolean updateCategory(ProductCategoryDto productCategoryDto){
        // 1. 수정할 엔티티 찾는다[pcno] 2. 찾은 엔티티가 존재하면 수정 o 아니면 수정 x // 3. 성공시 true 실패시 false
        Optional<ProductCategoryEntity> productCategoryEntityOptional
            = productCategoryEntityRepository.findById(productCategoryDto.getPcno());
        if(productCategoryEntityOptional.isPresent()){
            ProductCategoryEntity productCategoryEntity = productCategoryEntityOptional.get();

        return true;
        }
    return false;
    }


    // 4. 카테고리 삭제
    @Transactional public boolean deleteCategory(int pcno){
        // 1. 삭제할 엔티티 찾는다 // 2. 찾은 엔티티가 존재하면 삭제  o 아니면 삭제 x // 3. 성공시 true 실패시 false
        ProductCategoryEntity productCategoryEntity = toEntity(pcno);
        System.out.println("pcno");
        if(productCategoryEntity != null){productCategoryEntityRepository.delete(productCategoryEntity); return true;}
        return false;
    }

    // 5. 부가적인 엔티티검색용 함수
    public ProductCategoryEntity toEntity(int pcno){
        Optional<ProductCategoryEntity> productCategoryEntityOptional = productCategoryEntityRepository.findById(pcno);
        return productCategoryEntityOptional.isPresent() ? productCategoryEntityOptional.get() : null;

    }


}
