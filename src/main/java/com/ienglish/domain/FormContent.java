package com.ienglish.domain;

import lombok.Data;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;


/**
 * 表單回應的內容
 */
@Entity
@Table(name = "Form")
@Data
@NamedEntityGraph(name = "form-token-relation"
        , attributeNodes = {
        @NamedAttributeNode(value = "token", subgraph = "token.basic")
        , @NamedAttributeNode("content")
        , @NamedAttributeNode("done")
}
        , subgraphs = {
        @NamedSubgraph(name = "token.basic"
                , attributeNodes = {
                @NamedAttributeNode("first_name"),
                @NamedAttributeNode("last_name"),
                @NamedAttributeNode("email"),
                @NamedAttributeNode("token"),
                @NamedAttributeNode("token_type")

        })})
public class FormContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long form_id;

    private String content;

    private Boolean done;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id")
    private TokenInfo token;
}
