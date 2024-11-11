package com.project.skhu.reply.dto;

import com.project.skhu.reply.Entity.replyEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReplyResponseDTO {
private int Id;
private String replyContent;
private LocalDateTime RegDate;

public static ReplyResponseDTO from(replyEntity replyEntity){
    return ReplyResponseDTO.builder()
            .Id(replyEntity.getId())
            .replyContent(replyEntity.getReplyContent())
            .RegDate(replyEntity.getRegDate())
            .build();
}
}
