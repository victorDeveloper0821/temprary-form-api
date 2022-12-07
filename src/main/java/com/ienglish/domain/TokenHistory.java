package com.ienglish.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@ToString(exclude = {"tokenInfo"})
@Data
@EqualsAndHashCode(exclude="tokenInfo")
@Table(name = "token_history")
@NamedEntityGraph(name="historyGraph"
        ,attributeNodes = {@NamedAttributeNode(value = "tokenInfo",subgraph = "token.basic")}
        , subgraphs = {@NamedSubgraph(name = "token.basic",attributeNodes = {
        @NamedAttributeNode("first_name"),
        @NamedAttributeNode("last_name"),
        @NamedAttributeNode("token_type")

})})
public class TokenHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long token_id;

    @Column(length = 20, nullable = false)
    private String first_name;

    @Column(length = 20, nullable = false)
    private String last_name;

    // 電話號碼
    @Column(length = 16, nullable = false)
    private String msisdn;

    // email address
    @Column(length = 80)
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

    @JsonIgnore
    @ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "reserve_id")
    private TokenInfo tokenInfo;

    @Column(name = "statusTimeStamp", nullable = false, updatable = false)
    @CreationTimestamp
    private Date statusTimeStamp;
}
