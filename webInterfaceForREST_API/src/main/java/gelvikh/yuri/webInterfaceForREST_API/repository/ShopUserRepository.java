package gelvikh.yuri.webInterfaceForREST_API.repository;

import gelvikh.yuri.webInterfaceForREST_API.model.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopUserRepository extends JpaRepository<ShopUser, Long> {
    Optional<ShopUser> findByUsername(String username);
}
