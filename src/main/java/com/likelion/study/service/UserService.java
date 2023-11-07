package com.likelion.study.service;

import com.likelion.study.dao.UserRepository;
import com.likelion.study.domain.User;
import com.likelion.study.dto.UserRequest;
import com.likelion.study.dto.UserRes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

@Transactional //이게 뭔지 알아버셈.
    public UserRes save(UserRequest request) {
        User user = request.toEntity();
        User savedUser = userRepository.save(user);

        return UserRes.fromEntity(user);
    }
}