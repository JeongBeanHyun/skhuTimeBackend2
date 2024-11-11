package com.project.skhu.reply.service;

import com.project.skhu.reply.Entity.replyEntity;
import com.project.skhu.reply.ReplyRepository;
import com.project.skhu.reply.dto.ReplyRequestDTO;
import com.project.skhu.reply.dto.ReplyResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class replyService {
    private final ReplyRepository replyRepository;

    @Transactional
    public ReplyResponseDTO save(ReplyRequestDTO dto) {
        log.info("dto값 들어왔냐-{}", dto.getReplyContent());
        replyEntity entity = dto.toEntity();
        replyRepository.save(entity);
        return ReplyResponseDTO.from(entity);
    }

    @Transactional
    public ReplyResponseDTO findByReply(int Id){
        replyEntity entity = replyRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글"));
        return ReplyResponseDTO.from(entity);
    }

    @Transactional
    public ReplyResponseDTO updateByReply(int Id, ReplyRequestDTO dto){
        replyEntity entity = replyRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글"));
        entity.update(dto);
        return ReplyResponseDTO.from(entity);
    }

    @Transactional
    public void deleteByReply(int Id){
        replyEntity targetReply = replyRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글"));
        replyRepository.delete(targetReply);
    }
}
