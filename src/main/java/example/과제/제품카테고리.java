package example.과제;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class 제품카테고리 {
    private int 카테고리번호;
    private String 카테고리이름;
    @Builder.Default
    private List <제품> 카테고리내제품리스트 = new ArrayList<>();
}
