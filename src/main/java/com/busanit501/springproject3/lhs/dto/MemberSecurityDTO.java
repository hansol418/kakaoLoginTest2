package com.busanit501.springproject3.lhs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
//@AllArgsConstructor
// @AllArgsConstructor 대신에 권한도, 시큐리티에서 가져와서, 사용자정의해야하서.
public class MemberSecurityDTO extends User implements OAuth2User {
    private String mid;
    private String mpw;
    private String email;
    private String memberName;
    private String address;
    private boolean del;
    private boolean social;
    private String uuid;
    private String fileName;
    //소셜 로그인 정보
    private Map<String, Object> props;
    // 소셜 프로필 이미지 만 뽑기
    private String profileImageServer;

    //생성자
    public MemberSecurityDTO(
            //로그인한 유저이름.
            String username,String password,String email,
            boolean del, boolean social,
            String uuid, String fileName,
            String profileImageServer,
            //GrantedAuthority 를 상속한 클래스는 아무나 올수 있다. 타입으로
            Collection<? extends GrantedAuthority> authorities,
            String memberName,
            String address
    ){
        super(username, password, authorities);
        this.mid = username;
        this.mpw = password;
        this.email = email;
        this.profileImageServer = profileImageServer;
        this.del = del;
        this.social = social;
        this.uuid = uuid;
        this.fileName = fileName;
        this.memberName = memberName;
        this.address = address;
    }

    // 카카오 인증 연동시 , 필수 재정의 메서드
    @Override
    public Map<String, Object> getAttributes() {
        return this.getProps();
    }

    @Override
    public String getName() {
        return this.mid;
    }
}

