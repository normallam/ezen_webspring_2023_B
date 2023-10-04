package day02.servlet;

import lombok.*;

import java.time.LocalDate;
@Getter // 각 필드별 get 메소드 자동생성
@Setter // 각 필드별 set 메소드 자동생성
@ToString // 객체에 필드정보를 출력하는 tostring 메소드 자동생성
@NoArgsConstructor  //빈생성자
@AllArgsConstructor // 풀생성자
@Builder  // 빌더패턴 : 객체 생성 시 사용할 수 있는 함수
public class TodoDto {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
