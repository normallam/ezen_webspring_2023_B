package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString@Builder

public class 회원 {
    private int 회원번호;
    private String 회원아이디;
    private String 회원이름;
    // 리스트 : 1명회원(객체)는 여러개의 게시물 가질 수 있으니까
    @Builder.Default //  빋러패턴 사용시 해당 필드는 기본값으로 사용.
    private List<게시물> 내가쓴글 = new ArrayList<>();
}
