package Book.DoanThiYenVy.entity;

import Book.DoanThiYenVy.repository.IuserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


public class CustomUserDetail implements UserDetails {
    private final User user;
    private final IuserRepository userRepository;
    public CustomUserDetail(User user, IuserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(userRepository.getRolesOfUser(user.getId()))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
    @Override
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername() {

        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
