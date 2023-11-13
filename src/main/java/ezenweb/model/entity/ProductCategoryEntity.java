package ezenweb.model.entity;

import example.객체연관관계.하위클래스;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity@Table(name="productcategory") // 해당 클래스를 db테이블과 매핑 [ 엔티티클래스 <----> db테이블 ( 엔티티 객체 1개 <---> db테이블내 레코드 1개  ) ]
 // db테이블명 정의 [ 생략시 해당 클래스명이 db테이블 명으로 자동 생성 ]
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Getter
@Setter @ToString @Builder
public class ProductCategoryEntity extends BaseTime{/*제품 카테고리*/
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pcno;       // 카테고리 번호[PK]
    @Column
    private String pcname;  // 카테고리명

    // 양방향 만들기
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "productCategoryEntity", cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude List<ProductEntity> ProductEntityList = new ArrayList<>();

    /*
        fetch : 양방향일때 참조를 불러오는 로딩 옵션    // DB랑 상관없음 => 엔티티랑 연관됨
            fetch = FetchType.LAZY            : 참조를 사용할때 로딩   [지연 로딩] 자바에서.get~~ 할때 객체 참조해서 불러오고 // 실무에서 사용
            fetch = FetchType.EAGER [ 기본값 ] : 참조값을 즉시 로딩    [즉시 로딩] db에서 select 할 때 객체 참조해서 불러오고

    
        cascade : 영속성 제약조건 (엔티티 객체 기준) / 서로 연관된 객체들(부-자)끼리 영향을 끼치게 할껀지
            [REMOVE+PERSIST]   cascade = CascadeType.ALL       : REMOVE 와 PERSIST 둘 다 적용 [주로 권장되는 것]
            [모두제거]          cascade = CascadeType.REMOVE    : 부모가 엔티티객체가 삭제될때 자식도 같이 삭제[부모와 자식 엔티티를 모두 제거]
            [영속성]           cascade = CascadeType.PERSIST   : 부모 호출할 때 자식도 하나로 인식[부모와 자식 엔티티를 한번에 영속화]
                - 부모를 저장하면 자식도 같이 저장
            [병합]            cascade = CascadeType.MERGE     : 부모의 엔티티객체가 수정될때 자식객체도 조회후 업데이트
            [새로고침]          cascade = CascadeType.REFRESH   : 부모의 엔티티객체가 업데이트 되면 자식객체 값 새로고침
            [영속성제거]         cascade = CascadeType.DETACH    : 영속성 제거
    */

 
   

}
