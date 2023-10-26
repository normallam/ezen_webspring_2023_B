package petexample;

import ezenweb.model.entity.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity // 해당 클래스를 DB테이블과 매핑 [엔티티클래스 <---> db테이블(엔티티 1개 객체 <---> 테이블내 레코드 1개)]
@Table(name = "product") // db테이블명 정의 [ 생략시 해당 클래스명이 곧 db테이블 명으로 자동 생성]
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto.incerment
    private int pno; // 1. 제품번호
    @Column(name="pname", length = 20, nullable = false, unique = true)
    String pname; // 2. 제품이름
    @Column(name = "pname", nullable = false)
    int pprice; // 3. 제품가격

   /* @ManyToOne(mappedBy = "unitpriceEntity")
    @JoinColumn(name ="unitprice_uno")
    private int uno; // 4. 거래처재고번호
*/



}
