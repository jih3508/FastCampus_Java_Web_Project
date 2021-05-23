package com.example.study.controller.api;


import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/workUser")
public class WorkController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        UserApiRequest userApiRequest = request.getData();


        userRepository.findByEmail(userApiRequest.getEmail()).e
                .ifPresent(user->Header.ERROR("409 Conflict, 중복된 이메일 있습니다.")).;
            User user = User.builder()
                    .account(userApiRequest.getAccount())
                    .password(userApiRequest.getPassword())
                    .status("REGISTERED")
                    .phoneNumber(userApiRequest.getPhoneNumber())
                    .email(userApiRequest.getPhoneNumber())
                    .registeredAt(LocalDateTime.now())
                    .build();

            User newUser = userRepository.save(user);

            return (Header<UserApiResponse>)response(newUser);
        }else{
            return Header.ERROR("409 Conflict, 중복된 이메일 있습니다.");
        }

        /*
        return userRepository.findByEmail(userApiRequest.getEmail())
                .ifPresent(user ->Header.ERROR("409 Conflict, 중복된 이메일 있습니다."))
                .orElseGet(() ->{
                    User user = User.builder()
                            .account(userApiRequest.getAccount())
                            .password(userApiRequest.getPassword())
                            .status("REGISTERED")
                            .phoneNumber(userApiRequest.getPhoneNumber())
                            .email(userApiRequest.getPhoneNumber())
                            .registeredAt(LocalDateTime.now())
                            .build();

                    User newUser = userRepository.save(user);

                    return (Header<UserApiResponse>)response(newUser);
                });

         */

    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user){
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);
    }
}
