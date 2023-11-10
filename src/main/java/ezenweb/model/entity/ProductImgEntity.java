package ezenweb.model.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity@Table(name="productimg")// 해당 클래스를 db테이블과 매핑 [ 엔티티클래스 <----> db테이블 ( 엔티티 객체 1개 <---> db테이블내 레코드 1개  ) ]
// db테이블명 정의 [ 생략시 해당 클래스명이 db테이블 명으로 자동 생성 ]
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Getter
@Setter
@ToString
@Builder
public class ProductImgEntity extends BaseTime{/*제품 이미지파일*/
    @Id private String uuidFile;    // 이미지식별이름[PK]
    @Column private String realFileName;// 이미지실제이름

    // fk 만들기
    @JoinColumn(name="pno") @ManyToOne
    private ProductEntity productEntity;

}
