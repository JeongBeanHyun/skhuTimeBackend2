package com.project.skhu.user.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "student_id")
    private String StudentId; //학번 겸 아이디

    @Column(name = "user_name", nullable = false)
    private String userName; // 회원 이름

    @Column(name = "user_pass", nullable = false)
    private String userPass; // 비밀번호

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail; // 회원 이메일



}
