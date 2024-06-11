package gelvikh.yuri.webInterfaceForREST_API.security;

import gelvikh.yuri.webInterfaceForREST_API.repository.ShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopUserDetailService implements UserDetailsService {
    private final ShopUserRepository shopUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.shopUserRepository.findByUsername(username)
                .map(user -> User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRoles())
                        .build())
                .orElseThrow(()  -> new UsernameNotFoundException("User not found"  + username));
    }
}
