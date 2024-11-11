package com.project.skhu.user.service;

import com.project.skhu.user.Entity.User;
import com.project.skhu.user.dto.LoginRequestDTO;
import com.project.skhu.user.dto.LoginResponseDTO;
import com.project.skhu.user.dto.UserRequestSignUpDTO;
import com.project.skhu.user.dto.UserSignUpResponseDTO;
import com.project.skhu.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
   // private final PasswordEncoder passwordEncoder;

    //회원가입 요청 처리 서비스
    public UserSignUpResponseDTO create(UserRequestSignUpDTO dto) {
        String studentId = dto.getStudentId();

        //학번 중복 검사
        if(isDuplicate(studentId)){
            log.warn("학번이 중복됩니다. -{}", studentId);
            throw new RuntimeException("중복된 학번입니다.");
        }
        // 패스워드 인코딩
        //지역변수 삽입 alt + enter
//        String encoded = passwordEncoder.encode(dto.getUserPass());
//        dto.setUserPass(encoded);

        User saved = userRepository.save(dto.toEntity());
        log.info("회원가입 정상 수행됨 -{}", saved);

        return new UserSignUpResponseDTO(saved);
    }

    //로그인 요청 처리 서비스
    public LoginResponseDTO authenicate(LoginRequestDTO dto) {
      User user =  userRepository.findById(dto.getStudentId())
                .orElseThrow(
                        () -> new RuntimeException("가입된 회원이 아닙니다."));

        //패스워드 검증
        String userPass = dto.getUserPass();
        String encodedPassword = user.getUserPass();

//        if(!passwordEncoder.matches(userPass, encodedPassword)){
//            throw new RuntimeException("비밀번호가 틀렸습니다.");
//        }
        if(userPass.equals(user.getUserPass())){
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }
        log.info("{}님 로그인 성공!", user.getUserName());

        return new LoginResponseDTO(user);
    }

    public void deleteUser(String studentId) {
        User targetUser = userRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        userRepository.delete(targetUser);
    }



    //메서드 추출 ctrl + alt + m
    //학번 중복 검사
    private boolean isDuplicate(String studentId) {
        return userRepository.existsById(studentId);
    }



}
