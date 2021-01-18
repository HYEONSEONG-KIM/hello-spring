package hello.hellospring.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY->따로 쿼리를 날려주지 않고 DB에서 자동 생성되는것
    private  Long id;


    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
