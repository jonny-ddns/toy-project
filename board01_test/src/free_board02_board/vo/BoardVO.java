package free_board02_board.vo;

import java.util.Date;

public class BoardVO {
    private int seq;
    private String writer;
    private String title;
    private String content;
    private Date registerDate;

    public int getSeq() {
        return seq;
    }

    public BoardVO setSeq(int seq) {
        this.seq = seq;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public BoardVO setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BoardVO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BoardVO setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public BoardVO setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "seq=" + seq +
                ", id='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
