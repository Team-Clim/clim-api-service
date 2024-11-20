package com.example.climserver.domain.user.dao;

import com.example.climserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    Optional<User> findByRoomNumber(Integer roomNumber);

    boolean existsByEmail(String email);
}
