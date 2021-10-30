package free_board01_member.service.memberService;

import free_board01_member.vo.MemberVO;
import java.util.List;

public interface MemberService {
    boolean memberSearch(String id);
    void memberInsert(MemberVO vo);
    MemberVO memberRead(String id);
    void memberUpdate(MemberVO vo);
    boolean memberDelete(String id);
    List<MemberVO> memberAll();
}
