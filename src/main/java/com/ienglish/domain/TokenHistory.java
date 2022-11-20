package com.ienglish.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "token_history")
public class TokenHistory {
    @Id
    private Long token_id;

    @Column(length = 20, nullable = false)
    private String first_name;

    @Column(length = 20, nullable = false)
    private String last_name;

    // 電話號碼
    @Column(length = 16, nullable = false)
    private String msisdn;

    // email address
    @Column(length = 20)
    private String email;

    // token 狀態
    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private Short status;

    // token 字串
    private String token;

    // service type
    @Column(length = 10, nullable = false)
    private String token_type;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "reserve_id")
    private TokenReserve tokenReserve;

}
