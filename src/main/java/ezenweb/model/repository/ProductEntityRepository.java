package ezenweb.model.repository;

import ezenweb.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, String> {

    // 1. 모든 제품의 제품명과 재고수 검색
    @Query(value = "select pname, pstock from product",nativeQuery = true) // mysql 사용했던 sql문을 사용가능
    List<Map<Object,Object>> findByBarChart();

    // 2. 모든 카테고리의 재품 수 검색
    @Query(value = "select p.pcname, count(*) as count\n" +
            "\t from product p inner join productcategory pc\n" +
            "    on p.pcno = pc.pcno\n" + // on절 : pk-fk 교/합 집합 위한 조건절 vs where 일반조건
            "    group by p.pcname" // group by 필드명 : ~~별(그룹)
            ,nativeQuery = true)
    List<Map<Object,Object>> findByPieChart();

    /*
    
        DTO, ENTITY 아닌 타입이 정해져있지 않는 MAP<Object, Object> 사용
            { key , value } 
             필드명, 필드에 해당하는 값
            : entry 이라고 부름
                    
            MAP = { key , value }, { key , value }, { key , value }
                    필드명, 값        필드명, 값        필드명, 값
            : 여러개 entry 모이면 MAP (*** 레코드 한 줄)
            
            LIST = [MAP, MAP, MAP] 
            
            : 여러개 MAP 저장하기 위해서 LIST (*** 여러 레코드)
    */
    
    
    
}
