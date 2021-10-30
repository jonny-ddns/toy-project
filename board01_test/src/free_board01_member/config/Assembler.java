package free_board01_member.config;

import free_board01_member.service.memberService.MemberService;
import free_board01_member.service.memberService.MemoryMemberServiceImpl;

public class Assembler {
    public MemberService getMemberService() {
        return new MemoryMemberServiceImpl();
    }
}
