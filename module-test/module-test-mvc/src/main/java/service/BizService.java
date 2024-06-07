package service;

import lombok.RequiredArgsConstructor;
import market.Market;
import member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MarketRepository;
import repository.MemberRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class BizService {
    private final MemberRepository memberRepository;
    private final MarketRepository marketRepository;

    public void saveMember(Member member) {
        memberRepository.save(member);
    }
    public void saveMarket(Market market) {
        marketRepository.save(market);
    }
}
