package com.project.skhu.chat.api;

import com.project.skhu.chat.service.chatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chatRoom")
public class chatRoomController {

    private final chatRoomService chatRoomService;

    @PostMapping()
    public ResponseEntity<?> save(){

        return null;
    }

}
