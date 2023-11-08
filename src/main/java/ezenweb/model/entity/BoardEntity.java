package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

//----------------------- 1. 엔티티를 이용한 테이블 생성할떄 -------------------------------
@Entity // 해당 클래스를 엔티티로 사용
@Table( name = "board" ) // 테이블명 설정
@DynamicInsert //  @ColumnDefault 가 적용될수 있도록 해주는 어노테이션
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString @Builder
public class BoardEntity extends BaseTime { // 테이블 설계
    // 필드 설계
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // mysql : auto_increment
    private int bno;
    @Column( name = "btitle" , length = 200 , nullable = false ) // 생략가능 [ 필드 속성을 커스텀 하기 위해서 작성 ]
    private String btitle;
    @Column( columnDefinition = "longtext" , nullable = true ) // db에서 longtext 사용하는데.. java 문자열 처리가 String[최대255] 밖에 없네..
    private String bcontent;
    @Column
    @ColumnDefault("0") // "'문자처리'" vs "숫자"
    private int bview;
    // private LocalDateTime bdate; // BaseTime 클래스로부터 상속받으면 자동..
    // [ BaseTime 클래스가 상속해주는 필드 : 1.작성일 2.수정일 ]
    @Column( columnDefinition = "longtext" , nullable = true )
    private String bfile;

    // FK
    @ToString.Exclude // toString() 함수에서 제외되는 필
    @JoinColumn( name="mno" ) // FK 필드로 사용 ( name="fk필드명" )
    @ManyToOne // 다수가 하나에게  [ FK ] // 실제 DB에는 엔티티의 ID(PK) 만 저장
    private MemberEntity memberEntity;

    // entity -> dto [ 상황에 따라 여러개 선언 ]
    // 1. [ 전체=>게시판출력페이지 ] 출력 할때.
    public BoardDto alltodto() {
        return BoardDto.builder()
                .bno( this.bno ).btitle( this.btitle )
                .bcontent( this.bcontent ).bfile( this.bfile )
                .bview( this.bview )
                .mno( this.memberEntity.getMno() )  // 작성자 번호 [ fk ]
                .cdate( toTimeOrDate( this.getCdate() ) )
                .udate( toTimeOrDate( this.getUdate() ) )
                .memail( this.memberEntity.getMemail().split("@")[0] ) // 작성자 아이디 [ fk에 연결된 레코드의 필드 ]
                .build();
    }
}

/*
    -----------------------  2. 직접 DDL 작성해서 테이블 생성할때. -------------------------------
    create table board(
        bno int auto_increment,
        btitle varchar(255) not null,
        bcontent longtext ,
        bview int default 0,
        cdate datetime default now() ,
        udate detetime default now() ,
        bfile longtext , ;
        mno int
        primary key (bno) ,
    );

   -------------------------- *. 실제 jpa가 엔티티클래스를 이용한 테이블 생성할때 사용된 SQL -------------
     create table board (
       bno integer not null auto_increment,
        cdate datetime(6),
        udate datetime(6),
        bcontent longtext,
        bfile longtext,
        btitle varchar(200) not null,
        bview integer default 0,
        mno integer,
        primary key (bno)
    )
 */