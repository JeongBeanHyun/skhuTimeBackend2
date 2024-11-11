package com.project.skhu.user.dto;

import com.project.skhu.user.Entity.User;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignUpResponseDTO {

    private String studentId;
    private String userName;
    private String userPass;
    private String userEmail;

    public UserSignUpResponseDTO(User saved) {
        this.studentId = saved.getStudentId();
        this.userPass = saved.getUserPass();
        this.userEmail = saved.getUserEmail();
        this.userName = saved.getUserName();
    }
}
