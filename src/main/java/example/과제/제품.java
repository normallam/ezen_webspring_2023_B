package example.과제;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class 제품 {
    private int 제품번호;
    private String 제품명;
    private List<주문> 주문리스트이름;
    @ToString.Exclude
    private 제품카테고리 카테고리이름 ;
}
