package com.project.skhu.board.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = "user")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @Column(name = "chat_id")
    private String ChatId;


    @Column(name = "student_name")
    private String StudentName;


    @Column(name = "chat_content")
    private String ChatContent;


    @Column(name = "time")
    private LocalDateTime Time;


    @Column(name = "unreadcount")
    private int UnReadCount;


}
