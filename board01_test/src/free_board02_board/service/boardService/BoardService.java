package free_board02_board.service.boardService;

import free_board02_board.vo.BoardVO;

import java.util.List;

public interface BoardService {
    boolean boardSearch(int seq);
    void boardInsert(BoardVO vo);
    BoardVO boardRead(int seq);
    void boardUpdate(BoardVO vo);
    boolean boardDelete(int seq);
    List<BoardVO> boardAll();
}