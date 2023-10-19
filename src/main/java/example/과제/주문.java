package example.과제;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class 주문 {
    private int 주문번호;
    private int 주문가격;
    private 제품 구입한제품번호;
}
