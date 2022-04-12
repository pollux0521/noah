package pollux.noah.domain.account;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userno;
    
    private String username;
    private String pw;
    private String email;
    private String role;
    private Timestamp regTs;
    private String regIp;
    private Timestamp updTs;
    private String updIp;
    private Timestamp delTs;
    private String delIp;

    
    @Builder
    public UserEntity(String username, String pw, String email, String role, Timestamp regTs, String regIp){
        this.username = username;
        this.pw = pw;
        this.email = email;
        this.role = role;
        this.regTs = regTs;
        this.regIp = regIp;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection < GrantedAuthority > collectors = new ArrayList<>();
        collectors.add(()->{ return "계정등록";});
        return collectors;
    }


    @Override
    public String getPassword() {
        
        return this.pw;
    }


    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}