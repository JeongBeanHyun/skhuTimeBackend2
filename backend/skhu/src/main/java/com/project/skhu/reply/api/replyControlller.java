package com.project.skhu.reply.api;

import com.project.skhu.reply.dto.ReplyRequestDTO;
import com.project.skhu.reply.dto.ReplyResponseDTO;
import com.project.skhu.reply.service.replyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/reply")
@Slf4j
public class replyControlller {

private final replyService replyservice;

@PostMapping("/save")
    public  ResponseEntity<ReplyResponseDTO> save(@RequestBody ReplyRequestDTO dto){
    log.info("dto controller-{}", dto.getReplyContent());
    return new ResponseEntity<>(replyservice.save(dto), HttpStatus.CREATED);
}

@GetMapping("/{Id}")
    public ResponseEntity<ReplyResponseDTO> findByReplyKey(@PathVariable int Id){
    ReplyResponseDTO findKey = replyservice.findByReply(Id);
    return new ResponseEntity<>(replyservice.findByReply(Id), HttpStatus.OK );
}

@PatchMapping("/{Id}")
    public ResponseEntity<ReplyResponseDTO> updateByReplyKey(@PathVariable int Id, @RequestBody ReplyRequestDTO replyRequestDTO){
    return new ResponseEntity<>(replyservice.updateByReply(Id, replyRequestDTO), HttpStatus.OK);
}

@DeleteMapping("/{Id}")
    public ResponseEntity<ReplyResponseDTO> deleteByReplyKey(@PathVariable int Id){
    replyservice.deleteByReply(Id);
    return new ResponseEntity<>(HttpStatus.OK);
}

}
