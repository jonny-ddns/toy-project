package free_board01_member;

import free_board01_member.config.Assembler;
import free_board01_member.service.memberService.MemberService;
import free_board01_member.vo.MemberVO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Assembler assembler = new Assembler();
    private static final MemberService memberService = assembler.getMemberService();
    private static final String ONLY_NUMBER = "숫자만 입력바랍니다";
    private static MemberVO memberVO;

    public static void main(String[] args) {
        try {
            while(true){
                memberRequest();
            }
        } catch (IOException ignored) {
        }
    }

    public static void boardRequest() throws IOException {

    }


    public static void memberRequest() throws IOException {
        printHelp();
        String input = reader.readLine();
        System.out.println("입력값 = " + input);

        if(!isNumber(input)){
            System.out.println(ONLY_NUMBER);
            return;
        }
        int request = Integer.parseInt(input);

        switch (request){
            case 0: //종료
                exit();

            case 1: //가입
                String id = "";
                while(true){
                    System.out.print("id : ");
                    id = reader.readLine().trim();
                    break;
                }
                memberService.memberSearch(id);

                System.out.print("name : ");
                String name = reader.readLine().trim();

                System.out.print("pw : ");
                String pw = reader.readLine().trim();

                System.out.print("email : ");
                String email = reader.readLine().trim();

                memberVO = new MemberVO();
                memberVO.setId(id)
                        .setPw(pw)
                        .setName(name)
                        .setEmail(email)
                        .setRegisterDate(new Date());
                memberService.memberInsert(memberVO);
                break;

            case 2: //정보 확인
                System.out.print("검색할 id : ");
                String searchId = reader.readLine().trim();
                memberVO = memberService.memberRead(searchId);
                if(memberVO.getId() == null){
                    System.out.println("검색결과가 없습니다");
                } else {
                    System.out.println(memberVO);
                }
                
                break;

            case 3: //정보 수정
                boolean search = false;
                String updateId = null;
                int count = 3;
                for (int i = 1; i <= count; i++) {
                    System.out.print("수정할 id : ");
                    updateId = reader.readLine().trim();
                    search = memberService.memberSearch(updateId);
                    if(search) {
                        break;
                    }
                    System.out.println("다시 입력해주세요");
                }
                if(!search){
                    break;
                }

                System.out.print("수정할 name : ");
                String updateName = reader.readLine().trim();

                System.out.print("수정할 pw : ");
                String updatePw = reader.readLine().trim();

                System.out.print("수정할 email : ");
                String updateEmail = reader.readLine().trim();

                memberVO.setId(updateId)
                        .setPw(updateName)
                        .setName(updatePw)
                        .setEmail(updateEmail);
                memberService.memberUpdate(memberVO);
                break;

            case 4: //정보 삭제
                System.out.print("삭제할 id : ");
                String deleteId = reader.readLine().trim();
                boolean result = memberService.memberDelete(deleteId);
                if(result){
                    System.out.println("회원정보 삭제되었습니다");
                } else {
                    System.out.println("삭제된 정보가 없습니다");
                }
                break;

            case 5: //정보 현황
                List<MemberVO> list = memberService.memberAll();
                if(list.isEmpty()){
                    System.out.println("회원 검색결과가 없습니다");
                    break;
                }
                System.out.println("전체 회원 현황");
                for (MemberVO member : list) {
                    System.out.println(member);
                }
                System.out.println("end");
                break;

            default:
                System.out.println("숫자를 다시 입력해주세요");
        }
    }

    public static void printHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------------------")
            .append("\n원하는 서비스를 선택하세요")
            .append("\n 0. 프로그램 종료")
            .append("\n 1. 회원 가입")
            .append("\n 2. 회원정보 확인")
            .append("\n 3. 회원정보 수정")
            .append("\n 4. 회원정보 삭제")
            .append("\n 5. 전체회원 현황")
            .append("\n-------------------------")
            .append("\n입력 : ");
        System.out.print(sb);
        sb.setLength(0);
    }

    public static boolean isNumber(String s) {
        boolean isNumber = false;
        try {
            Integer.parseInt(s);
            isNumber = true;
        } catch (NumberFormatException ignored) {
            System.out.println("숫자변환 실패");
        }
        return isNumber;
    }

    public static void exit() throws IOException {
        reader.close();
        System.exit(0);
    }
}
