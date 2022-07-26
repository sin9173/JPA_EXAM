package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") //외래키 설정
    private Member member;
}
