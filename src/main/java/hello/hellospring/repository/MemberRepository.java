package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); //optional -> null이 있을수도 없을수도 있을때 사용
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
