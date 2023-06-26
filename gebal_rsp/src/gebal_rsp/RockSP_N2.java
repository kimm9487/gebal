package gebal_rsp;

import java.util.*;

class User {
    String username;

    public User(String username) {
        this.username = username; 
    }
}

public class RockSP_N2 {

    public static void main(String[] args) {
        boolean logMenu = true;
        while (logMenu) {
            System.out.println("1.회원가입 2.로그인");
            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    Registration.registerUser();//Registration 클래스 호출 
                    break;
                case 2:
                    login();
                    logMenu = false;// 로그인이 성공했으므로 반복문을 종료
                    break;
                case 3:
                    Game.startGame();
                    break;
            }

        }
        System.out.println("게임을 시작합니다");

        while (!logMenu) {
            System.out.println("1.게임시작 2.현재 전적보기 3.끝내기");
            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    Game.startGame();
                    break;
                case 2:
                    Game.gameRate();
                    break;
                case 3:
                    logMenu = false;
            }
        }

    }

    
    /*
     * 로그인을 수행하는 메서드
     * 사용자로부터 아이디를 입력받아 등록된 사용자 목록(Registration.users)에서 일치하는 아이디를 찾아 로그인 여부를 확인
     * 일치하는 아이디가 있을 경우 로그인 성공 메시지를 출력하고 추가 작업을 수행
     * 일치하는 아이디가 없을 경우 로그인 실패 메시지를 출력
     */
    
    private static void login() {
        boolean loggedIn = false; // 로그인 여부를 나타내는 변수
        while (!loggedIn) {
            System.out.print("아이디: ");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

         // 등록된 사용자 목록(Registration.users)에서 입력한 아이디와 일치하는 사용자를 찾아 로그인 여부 확인
            for (User user : Registration.users) {
                if (user.username.equals(username)) {
                    loggedIn = true; // 로그인에 성공하면 loggedIn을 true로 변경
                    break;
                }
            }

            if (loggedIn) {
                System.out.println("로그인 성공!");
                // 로그인에 성공한 후에 실행할 작업을 추가합니다
            } else {
                System.out.println("로그인 실패. 아이디를 확인하세요.");
            }
        }
    }

}
