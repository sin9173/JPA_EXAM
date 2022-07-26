package jpabook.jpashop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class MemberOld {

    @Id @GeneratedValue
    private Long id;
    private String username;
}
