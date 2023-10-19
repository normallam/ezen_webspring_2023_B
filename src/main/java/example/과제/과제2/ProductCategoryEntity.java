package example.과제.과제2;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당 클래스를 DB테이블과 매핑 [엔티티클래스 <---> db테이블(엔티티 1개 객체 <---> 테이블내 레코드 1개)]
@Table(name = "ProductCategoryEntity") // db테이블명 정의 [ 생략시 해당 클래스명이 곧 db테이블 명으로 자동 생성]
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auuto.increment
    private int pcno;
    private String pcname;


    @Builder.Default // 빌더패턴 사용시 해당 필드의 값을 기본값으로 사용
    @OneToMany(mappedBy = "productCategoryEntity")
    private List<ProductEntity> productEntityList = new ArrayList<>();


}
