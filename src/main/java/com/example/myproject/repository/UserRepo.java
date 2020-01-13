package com.example.myproject.repository;

import com.example.myproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository for {@link User}
 *
 * @author Samoylenko Victor
 * @version 1.0
 */

public interface UserRepo extends JpaRepository<User, Long> {
        User findByUsername(String username);
}
