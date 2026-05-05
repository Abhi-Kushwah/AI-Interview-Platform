

package com.aiinterview.repository;

import com.aiinterview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Email se user fetch karega (safe way)
    Optional<User> findByEmail(String email);
}