package com.project.skhu.user.api;

import com.project.skhu.user.dto.LoginRequestDTO;
import com.project.skhu.user.dto.LoginResponseDTO;
import com.project.skhu.user.dto.UserRequestSignUpDTO;
import com.project.skhu.user.dto.UserSignUpResponseDTO;
import com.project.skhu.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user") // "/board"
public class userController {

    private final UserService userService;

    @PostMapping("/join")// "/register"
    private ResponseEntity<?> create( @RequestBody UserRequestSignUpDTO dto){
        log.info("/user/join POST -{}", dto);
        UserSignUpResponseDTO responseDTO = userService.create(dto);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@Validated  @RequestBody LoginRequestDTO dto){
        log.info("로그인 요청 들어옴");
        LoginResponseDTO responseDTO = userService.authenicate(dto);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteUser(@PathVariable String studentId){
        log.info("회원 탈퇴 요청");
        userService.deleteUser(studentId);
        return ResponseEntity.ok().build();
    }

}
