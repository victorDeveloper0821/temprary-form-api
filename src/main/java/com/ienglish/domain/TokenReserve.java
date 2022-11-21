package com.ienglish.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

/**
 * Form 表單 token 產生的 id
 */
@Entity
@Data
@Table(name = "token_info")
public class TokenReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rsv_id", nullable = false)
    private Long rsv_id;

    @Column(length = 20, nullable = false)
    private String first_name;

    @Column(length = 20, nullable = false)
    private String last_name;

    // token 字串
    private String token;
    // service type
    @Column(length = 10, nullable = false)
    private String token_type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tokenReserve")
    private Set<TokenHistory> historySet;

}