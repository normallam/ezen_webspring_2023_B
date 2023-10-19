package example.과제.과제2;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당 클래스를 DB테이블과 매핑 [엔티티클래스 <---> db테이블(엔티티 1개 객체 <---> 테이블내 레코드 1개)]
@Table(name = "ProductEntity") // db테이블명 정의 [ 생략시 해당 클래스명이 곧 db테이블 명으로 자동 생성]
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductEntity {
    @Id // 해당 필드를 PK로 선정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto.incerment
    private int pno;
    private String pname;

    // FK
    @ToString.Exclude // tostring() 함수에서 제외되는 필드
    @JoinColumn(name="pcno") // FK 필드로 사용(name="fk필드명")
    @ManyToOne // 다수가 하나에게 [FK] // 실제 DB에는 엔티티의 ID(PK)만 저장
    private ProductCategoryEntity productCategoryEntity;


    @Builder.Default // 빌더패턴 사용시 해당 필드의 값을 기본값으로 사용
    @OneToMany(mappedBy = "productEntity")
    private List<OrderEntity> orderEntityList = new ArrayList<>();


}
