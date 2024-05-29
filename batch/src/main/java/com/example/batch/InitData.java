package com.example.batch;

import com.example.batch.test.BatchEntity;
import com.example.batch.test.Member;
import com.example.batch.test.SampleRepository;
import com.example.batch.test.job.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitData {
    private final SampleRepository sampleRepository;
    private final MemberRepository memberRepository;

    @EventListener(value = ApplicationReadyEvent.class)
    @Transactional
    public void initData() {
        BatchEntity batch1 = new BatchEntity("Test1");
        BatchEntity batch2 = new BatchEntity("Test2");

        sampleRepository.save(batch1);
        sampleRepository.save(batch2);

        Member member1 = new Member("member1", "A",100);
        Member member2 = new Member("member2", "B",10000);
        Member member3 = new Member("member3", "C",9999);
        Member member4 = new Member("member4", "A",20000);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
    }
}
