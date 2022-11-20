package com.ienglish.repository;

import com.ienglish.domain.FormContent;
import com.ienglish.model.PersonalInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormRepository extends CrudRepository<FormContent,Long> {
//    Optional<FormContent> findByToken(String token);

    /**
     * 欄位 group by 姓名, 手機號, 電子信箱
     * @return
     */
//    @Query("select f.name,f.email, f.msisdn from FormContent f group by f.name,f.email, f.msisdn")
//    List<PersonalInfo> groupByPersonalInfo();
}
