package ru.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.users.model.entity.Follow;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long>  {

    List<Follow> findByFollowerId(Long followerId);

    List<Follow> findByFollowingId(Long followingId);

    Optional<Follow> findByFollowingIdAndFollowerId(Long following, Long follower);

    @Transactional
    @Modifying
    @Query("DELETE FROM Follow f WHERE f.id = :id")
    int deleteByFollowId(Long id);
}
