package free_board01_member.vo;

import java.util.Date;

public class MemberVO {
    private String id;
    private String name;
    private String pw;
    private String email;
    private Date registerDate;

    public String getId() {
        return id;
    }

    public MemberVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MemberVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPw() {
        return pw;
    }

    public MemberVO setPw(String pw) {
        this.pw = pw;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MemberVO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public MemberVO setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
