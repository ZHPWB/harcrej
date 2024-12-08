package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);
}
