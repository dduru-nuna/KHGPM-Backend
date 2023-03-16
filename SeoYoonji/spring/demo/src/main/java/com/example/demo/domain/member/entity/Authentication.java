package com.example.demo.domain.member.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString(exclude = "member")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "authentication_type")
public abstract class Authentication {
    public static final String BASIC_AUTH = "BASIC";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne(fetch = FetchType.LAZY)  //LAZY 쓰는게 더 근본. 비용이 덜 든다. 하지만 모든 db를 가져오지 않기 때문에 여러 문제 발생 가능
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "authentication_type", nullable = false, insertable = false, updatable = false)
    private String authenticationType;

    public Authentication (Member member, String authenticationType) {
        this.member = member;
        this.authenticationType = authenticationType;
    }
}
