package gelvikh.yuri.webInterfaceForREST_API.service;

import gelvikh.yuri.webInterfaceForREST_API.model.ShopUser;
import gelvikh.yuri.webInterfaceForREST_API.repository.ShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagerService {

    private final PasswordEncoder passwordEncoder;
    private final ShopUserRepository shopUserRepository;
    public ShopUser save(ShopUser newUser) throws Exception {
        if (shopUserRepository.findByUsername(newUser.getUsername()).isPresent()){
            throw new RuntimeException("User with this username already exists");
        }
        ShopUser savedUser = new ShopUser();
        savedUser.setUsername(newUser.getUsername());
        savedUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        savedUser.setRoles("USER");
        return shopUserRepository.save(savedUser);
    }
}
