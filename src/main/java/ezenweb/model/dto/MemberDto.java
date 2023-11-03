package ezenweb.model.dto;

import ezenweb.model.entity.MemberEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto implements UserDetails , OAuth2User {

    // --------------OAuth2User--------------- //

    private Map<String,Object> socialmemberInfo;

    @Override // OAuth2 회원의 정보
    public Map<String, Object> getAttributes() {return null; }

    @Override // OAuth2 회원의 아이디
    public String getName() {return null; }


    // -----------------UserDetails------------------- //

    // Collection : 컬렉션 프레임워크 : set, list, map
    List<GrantedAuthority> 권한목록 ;

    @Override // 계정 권한 목록 [여러개 가능 Collection]
    public Collection<? extends GrantedAuthority> getAuthorities() {return 권한목록; }

    @Override // 계정 비밀번호
    public String getPassword() {return mpassword;}

    @Override // 계정 아이디
    public String getUsername() { return memail;}

    @Override // 계정 만료 여부
    public boolean isAccountNonExpired() {return true; }

    @Override // 계정 잠금 여부   true 열림 false 잠김
    public boolean isAccountNonLocked() {return true;}

    @Override // 계정 증명 여부
    public boolean isCredentialsNonExpired() {return true;}

    @Override  // 계정 활성화 여부 
    public boolean isEnabled() {return true; }


    // ----------------------------------------- //




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
