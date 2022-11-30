package com.ienglish.repository;

import com.ienglish.domain.TokenHistory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenHistoryRepository extends CrudRepository<TokenHistory,Long> {
    @EntityGraph(value = "historyGraph")
    public List<TokenHistory> findAll();
    @EntityGraph(value = "historyGraph")
    public Optional<TokenHistory> findByTokenOrderByStatusTimeStampDesc(String token);
}
