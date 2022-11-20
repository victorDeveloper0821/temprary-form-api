package com.ienglish.tempForm;

import com.ienglish.domain.FormContent;
import com.ienglish.repository.FormRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableJpaRepositories("com.ienglish.repository")
public class JPAUnitTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FormRepository repository;

    @Test
    public void should_find_all_tutorials() {
        FormContent tut1 = new FormContent();
        tut1.setForm_id(1L);
        tut1.setFirst_name("aa");
        tut1.setLast_name("bb");
        tut1.setMsisdn("0122949543");
        repository.save(tut1);

        FormContent tut2 = new FormContent();
        tut1.setForm_id(2L);
        tut2.setFirst_name("cc");
        tut2.setLast_name("dd");
        tut2.setMsisdn("0162979543");
        repository.save(tut2);

        Iterable<FormContent> forms = repository.findAll();

        assertThat(forms).hasSize(2).contains(tut1, tut2);
    }
}
