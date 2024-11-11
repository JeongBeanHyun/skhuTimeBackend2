package com.project.skhu.user.dto;

import com.project.skhu.user.Entity.User;

public class LoginResponseDTO {

    private String studentId;
    private String userPass;

    public LoginResponseDTO(User user) {
        this.studentId = user.getStudentId();
        this.userPass = user.getUserPass();
    }
}
