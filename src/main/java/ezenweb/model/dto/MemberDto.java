package ezenweb.model.dto;

import ezenweb.model.entity.MemberEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int mno;

    private String memail;

    private String mpassword;

    private String mname;

    private String mphone;

    private String mrole;

    // +baseTime
    private LocalDateTime cdate;
    private LocalDateTime udate;


    // dto --> entity 변환 함수
        // service에서 dto 정보를 db테이블 매핑에 저장하기 위해서
    public MemberEntity toEntity(){ //toEntity()
        return MemberEntity.builder().
        mno(this.mno).memail(this.memail).mpassword(this.mpassword).mname(this.mname)
                .mphone(this.mphone).mrole(this.mrole)
                //cdate

                //udate

                .build();

    }

}
