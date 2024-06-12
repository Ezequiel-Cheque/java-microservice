package io.bootify.my_app_bootify.repos;

import io.bootify.my_app_bootify.domain.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, UUID> {
}
