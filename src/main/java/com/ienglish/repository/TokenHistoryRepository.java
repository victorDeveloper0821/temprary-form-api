package com.ienglish.repository;

import com.ienglish.domain.TokenHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenHistoryRepository extends CrudRepository<TokenHistory,Long> {
}
