package com.likelion.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="User")
//@Setter -> 쓰지마라
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//매개변수가 없는 생성자, anotation이랑 똑같음?
//@AllArgsConstructor 종종 문제를 일으킴 , 무엇인지 검색해볼 것.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key로 지정한 것에 선언
    //    @Column(name="username")
    @Column(nullable = false, length = 30) //선택사항인데 속성임, null값 막고 길이 30
    private String name;
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

//    protected User() {}

    @Builder//빌더 패턴 생성자가 만들어진다.
    public User(String name, String email, String password, String address, RoleType roleType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roleType = roleType;
}

    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", roleType=" + roleType +
                '}';
    }


}
