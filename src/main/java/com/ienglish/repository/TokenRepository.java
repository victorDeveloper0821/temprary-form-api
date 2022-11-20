package com.ienglish.repository;

import com.ienglish.domain.TokenReserve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<TokenReserve,Long> {
    /**
     * find record with token
     * @param token
     * @return
     */
//    Optional<TokenReserve> findByToken(String token);

    /**
     * 取得 token 的 service 類型
     * @param TokenType
     * @return
     */
//    List<TokenReserve> findByTokenType(String TokenType);

//    @Query("select t from TokenReserve t where t.status = ?1")
//    List<TokenReserve> findByStatus(@NonNull Integer status);
}
