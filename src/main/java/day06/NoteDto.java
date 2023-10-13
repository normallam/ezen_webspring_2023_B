package day06;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder


// Dto 사용처 :
    // AJAX(JSON/TEXT/FORM) -- DTO --> Controller
public class NoteDto {
    private int no; // 게시물 번호
    private String title; // 게시물내용
    private String writer; // 작성자
    private String password; // 패스워드
    private LocalDateTime date; // 작성일
    // + DB

    // *dto를 엔티티로 변환해주는 함수[service에서 사용]
    public NoteEntity toEntity(){
        return NoteEntity.builder()
                .date(this.date).writer(this.writer)
                .password(this.password).title(this.title).no(this.no).build();
    }


}
