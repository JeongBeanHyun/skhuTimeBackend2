package com.project.skhu.user.dto;

import com.project.skhu.user.Entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestSignUpDTO {

    //이름, 학번, 이메일, 비밀번호, 비밀번호 확인
    @NotBlank
    private String studentId;

    @NotBlank
    @Size(min = 2)
    private String userName;

    @NotBlank
    @Size(min = 8, max = 20)
    private String userPass;

    @NotBlank
    @Email
    private String userEmail;


    public User toEntity() {
        return User.builder()
                .StudentId(this.studentId)
                .userPass(this.userPass)
                .userName(this.userName)
                .userEmail(this.userEmail)
                .build();
    }
}
