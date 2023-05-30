package ru.users.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.users.model.dto.ext.request.FollowRequest;

import java.time.OffsetDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "subscriptions")
public class Follow {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "following_id")
    private Long followingId;

    @Column(name = "follower_id")
    private Long followerId;

    @Builder.Default
    @Column(name = "followed_at")
    private OffsetDateTime followedAt = OffsetDateTime.now();

    public static Follow of(FollowRequest request) {
        return Follow.builder()
                .followingId(request.getFollowingId())
                .followerId(request.getFollowerId())
                .build();
    }
}
