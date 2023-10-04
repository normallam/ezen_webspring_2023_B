package day01.webMvc;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder

public class WebDto { // todo 클래스
    private int tno; //todo 번호
    private String title; // todo 내용
    private LocalDate duedate; // todo 작성일
    private boolean finished; // todo 실행여부


}
