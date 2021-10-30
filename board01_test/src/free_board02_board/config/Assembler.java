package free_board02_board.config;

import free_board02_board.service.boardService.BoardService;
import free_board02_board.service.boardService.MemoryBoardServiceImpl;
import free_board02_board.service.memberService.MemberService;
import free_board02_board.service.memberService.MemoryMemberServiceImpl;
import free_board02_board.vo.BoardVO;
import free_board02_board.vo.MemberVO;

public class Assembler {
    public MemberService getMemberService() {
        return new MemoryMemberServiceImpl();
    }
    public MemberVO getMemberVO() {
        return new MemberVO();
    }
    public BoardVO getBoardVO() {
        return new BoardVO();
    }
    public BoardService getBoardService() {
        return new MemoryBoardServiceImpl();
    }
}
