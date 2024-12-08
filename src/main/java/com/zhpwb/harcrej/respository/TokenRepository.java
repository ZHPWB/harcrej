package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.token.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends CrudRepository<Token, Integer> {

    @Query("""
            select t from Token t inner join user u on t.user.id = u.id
            where u.id = :userId and (t.expired = false or t.revoked = false)
            """)
    List<Token> findAllValidTokensByUser(Integer userId);
    Optional<Token> findByToken(String token);
}
