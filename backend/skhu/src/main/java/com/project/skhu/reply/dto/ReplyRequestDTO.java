package com.project.skhu.reply.dto;

import com.project.skhu.reply.Entity.replyEntity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyRequestDTO {


    private String replyContent;


    public replyEntity toEntity(){
        return replyEntity.builder()
                .ReplyContent(replyContent)
                .build();
    }

}
