package controller;

import lombok.RequiredArgsConstructor;
import member.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BizService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final BizService bizService;

    @GetMapping("/member")
    public String saveMember() {
        Member member = new Member("member1", 10);
        return "OK";
    }
}
