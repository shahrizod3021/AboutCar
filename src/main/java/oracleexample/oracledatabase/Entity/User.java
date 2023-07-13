package oracleexample.oracledatabase.Entity;

import lombok.*;
import oracleexample.oracledatabase.Entity.AbsEntities.AbsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "foydalanuvchi")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User extends AbsEntity implements UserDetails {

    private String name;

    private String surname;

    private String phoneNumber;

    private String password;

    @ManyToOne
    private Role role;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
