package ru.users.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.users.model.dto.ext.request.UserRequest;
import ru.users.model.internal.Gender;
import ru.users.model.internal.UserStatus;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "brith_date")
    private LocalDate brithDate;

    @Column(name = "email")
    private String email;

    @Builder.Default
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    @Builder.Default
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    public static User of(UserRequest request) {
        return User.builder()
                .nickName(request.getNickName())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(Gender.fromValue(request.getGender()))
                .brithDate(LocalDate.parse(request.getBrithDate()))
                .email(request.getEmail())
                .build();
    }

  /*  @PreUpdate
    private void setLastModifiedTime() {
        setModifiedTime();
    }

    @PrePersist
    private void setCreateDateAndUpdateAt() {
        this.setCreateDate(LocalDate.now());
        setModifiedTime();
    }

    private void setModifiedTime() {
        this.setUpdatedAt(LocalDateTime.now());
    }*/
}
