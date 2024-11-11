package com.project.skhu.reply.Entity;

import com.project.skhu.reply.dto.ReplyRequestDTO;
import com.project.skhu.reply.dto.ReplyResponseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class replyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="reg_date")
    @CreationTimestamp
    private LocalDateTime RegDate;

    @Column(name="reply_content")
    private String ReplyContent;

    @Builder
    public replyEntity(String ReplyContent){
        this.ReplyContent = ReplyContent;
    }

    public void update(ReplyRequestDTO dto) {
        this.ReplyContent = dto.getReplyContent();
    }

    //@ManyToOne
    //@JoinColumn(name="Student_id")
    //private User StudentId;


}
