package ezenweb.model.entity;

import ezenweb.model.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity // 해당 클래스를 DB테이블과 매핑 [엔티티클래스 <---> db테이블(엔티티 1개 객체 <---> 테이블내 레코드 1개)]
@Table(name = "member") // db테이블명 정의 [ 생략시 해당 클래스명이 곧 db테이블 명으로 자동 생성]
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberEntity extends BaseTime {
    @Id // 해당 필드를 PK로 선정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto.incerment
    private int mno;
    @Column(name = "memail" , length = 50, nullable = false , unique = true ) // 해당 필드 선정 [속성]
    // name = "필드명", length=글자수, nullable=false -> not null null불가, unique = true 중복불가
    private String memail;
    @Column(length = 30, nullable = false)
    private String mpassword;
    @Column(length = 20, nullable = false)
    private String mname;
    @Column(length = 13, nullable = false, unique = true)
    private String mphone;
        
    @Column 
    @ColumnDefault("'user'") // @ColumnDefault("초기값") @ColumnDefault(문자일 경우 ''작은 따옴표 넣어줘야함)
    private String mrole; // 6.회원등급( 일반회원=user, 관리자회원=admin )

    // entity --> dto 변환 함수
        // service에서 entity정보를 controller로 이동하기 위해서
    public MemberDto toDto(){return MemberDto.builder().
            mno(this.mno).memail(this.memail).mpassword(this.mpassword).mname(this.mname)
            .mphone(this.mphone).mrole(this.mrole)
            //cdate
            .cdate(this.cdate)
            //udate
            .udate(this.udate)
            .build();
    }



}

