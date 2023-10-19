package example.과제.과제2;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity // 해당 클래스를 엔티티로 사용
@Table(name = "OrderEntity") // 테이블명 설정
@DynamicInsert // @ColumDefault가 적용될 수 있도록 해주는 어노테이션
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;
    private int omoney;

    // FK
    @ToString.Exclude // tostring() 함수에서 제외되는 필드
    @JoinColumn(name="pno") // FK 필드로 사용(name="fk필드명")
    @ManyToOne // 다수가 하나에게 [FK] // 실제 DB에는 엔티티의 ID(PK)만 저장
    private ProductEntity productEntity;



}
