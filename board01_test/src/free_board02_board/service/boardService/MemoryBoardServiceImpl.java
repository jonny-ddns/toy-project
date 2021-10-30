package free_board02_board.service.boardService;

import free_board02_board.vo.BoardVO;

import java.util.ArrayList;
import java.util.List;

public class MemoryBoardServiceImpl implements BoardService {
    private static List<BoardVO> boardList;

    public MemoryBoardServiceImpl() {
        boardList = new ArrayList<>();
    }

    private static List<BoardVO> getBoardList() {
        return boardList;
    }

    @Override
    public boolean boardSearch(int seq) {
        System.out.println("MemoryBoardServiceImpl.boardSearch");
        List<BoardVO> list = getBoardList();
        for (BoardVO board : list) {
            if(board.getSeq() == seq){
                return true;
            }
        }
        return false;
    }

    @Override
    public void boardInsert(BoardVO vo) {
        System.out.println("MemoryBoardServiceImpl.boardInsert");
        List<BoardVO> list = getBoardList();
        list.add(vo);
    }

    @Override
    public BoardVO boardRead(int seq) {
        System.out.println("MemoryBoardServiceImpl.boardRead");
        List<BoardVO> list = getBoardList();
        BoardVO result = new BoardVO();
        for (BoardVO board : list) {
            if(board.getSeq() == seq) {
                result.setSeq(board.getSeq())
                    .setWriter(board.getWriter())
                    .setTitle(board.getTitle())
                    .setContent(board.getContent())
                    .setRegisterDate(board.getRegisterDate());
                break;
            }
        }
        return result;
    }

    @Override
    public void boardUpdate(BoardVO vo) {
        System.out.println("MemoryBoardServiceImpl.boardUpdate");
        int seq = vo.getSeq();
        List<BoardVO> list = getBoardList();
        BoardVO result = null;
        for (BoardVO board : list) {
            if(board.getSeq() == seq){
                result.setTitle(vo.getTitle())
                    .setContent(vo.getContent());
            }
        }
    }

    @Override
    public boolean boardDelete(int seq) {
        System.out.println("MemoryBoardServiceImpl.boardDelete");
        List<BoardVO> list = getBoardList();
        for (BoardVO board : list) {
            if(board.getSeq() == seq) {
                list.remove(board);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BoardVO> boardAll() {
        System.out.println("MemoryBoardServiceImpl.boardAll");
        return getBoardList();
    }
}
