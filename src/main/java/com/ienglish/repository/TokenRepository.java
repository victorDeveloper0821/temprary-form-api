package com.ienglish.repository;

import com.ienglish.domain.TokenInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<TokenInfo,Long> {
    /**
     * find record with token
     * @param token
     * @return
     */
    Optional<TokenInfo> findByToken(String token);

    /**
     * 取得 token 的 service 類型
     * @param TokenType
     * @return
     */
//    List<TokenReserve> findByTokenType(String TokenType);

    List<TokenInfo> findByTokenContaining(String TokenType);

    @EntityGraph(value = "TokenWithHistory", type = EntityGraph.EntityGraphType.LOAD)
    List<TokenInfo> findAll();
}
