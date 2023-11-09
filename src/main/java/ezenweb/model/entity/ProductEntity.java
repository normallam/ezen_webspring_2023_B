package ezenweb.model.entity;

import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity@Table(name="product")
public class ProductEntity {/*제품 테이블*/
    @Id private String pno;     // 제품번호[pk]
    @Column private String pname;   // 제품명
    @Column( columnDefinition = "TEXT") private String pcomment;// 제품설명
    @Column private int pprice;     // 제품가격
    @Column @ColumnDefault("0") private byte pstate;    // 제품상태 [ 0: 판매중, 1: 판매중지, 2:재고없음, 3: 폐기 등등]
    @Column @ColumnDefault("0") private int pstock;     // 제품재고

    // FK 만들기
    @JoinColumn(name="pcno") @ManyToOne
    private ProductCategoryEntity productCategoryEntity;

    // 양방향 만들기
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity", cascade = CascadeType.ALL)
    List<ProductImgEntity> ProductImgEntityList = new ArrayList<>();
    //@OneToMany(mappedBy ="fk 사용중인 엔티티클래스 필드명")
}
