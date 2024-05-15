package com.example.cacheTest.repository;

import com.example.cacheTest.Domain.Member;
import com.example.cacheTest.Domain.Members;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@CacheConfig(cacheNames = "members")
public class MemberRepository {

    private final Map<Long, Member> store = new LinkedHashMap<>();

    private static Long calculateId = 1L;

    //key의 ''안에 all은 문자 값으로 저장이 된다.
    @Cacheable(key = "'all'")
    public Members findAll() {
        List<Member> members = store.values().stream().toList();
        log.info("Repository findAll {}", members);
        return new Members(members);
    }

    //여기서 key의 #memberId는 memberId 변수 값을 참조해 해당 값을 캐시 키를 설정
    //#result는 메서드의 반환 값을 나타내며 반환 값이 null이 아닐 때만 캐싱을 수행하는 것을 의미
    @Cacheable(key = "#memberId", unless = "#result == null")
    public Member findById(Long memberId) {
        Member member = store.get(memberId);
        log.info("Repository find {}",member);
        return member;
    }
    //CacheEvict로 all key 캐시 삭제 새로운 객체를 추가하기 때문
    //CachePut 새로운 멤버를 캐시에 저장
    @CachePut(key = "#member.id")
    @CacheEvict(key = "'all'")
    public Member save(Member member) {
        Long newId = calculateId++;
        member.setId(newId);

        log.info("Repository save {}", member);
        store.put(member.getId(), member);
        return member;
    }

    @CachePut(key = "#member.id")
    @CacheEvict(key = "'all'")
    public Member update(Member member) {
        log.info("Repository update {}", member);
        store.put(member.getId(), member);
        return member;
    }

    @Caching(evict = {
            @CacheEvict(key = "'all'"),
            @CacheEvict(key = "#member.id")
    })
    public void delete(Member member) {
        log.info("Repository delete {}", member);
        store.remove(member.getId());
    }


}
