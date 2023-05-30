package ru.users.repository;

import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.users.model.entity.User;
import ru.users.model.internal.UserStatus;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNickName(String nickName);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.status = :status WHERE user.id = :userId")
    int deleteUserById(@Param("userId") Long userId, @Param("status") UserStatus status);
}
