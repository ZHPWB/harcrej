package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.exception.ChangedPasswordException;
import com.zhpwb.harcrej.model.ChangePasswordRequest;
import com.zhpwb.harcrej.model.UserEntity;
import com.zhpwb.harcrej.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (UserEntity) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        // check if current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new ChangedPasswordException("Incorrect password");
        }
        // check if new passwords match
        if (!request.getNewPassword().equals(request.getConfirmationPassword())){
            throw new ChangedPasswordException("Passwords do not match");
        }
        // update and save password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}
