package gebal_rsp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Game {
    static int cumwin = 0; // 전적 계산을 위한 필드 cumwin(컴퓨터 승 카운터), userwin(유저 승 카운터),  rateall(무승부 카운터)
    static int userwin = 0;
    static int draw = 0;
    static Scanner sc = new Scanner(System.in);

    public static void startGame() {
        System.out.println("가위 or 1 /바위 or 2 / 보 or 3 중 하나를 입력해주세요"); 
        String[] input = {"가위", "바위", "보" };
        String str = sc.next();
        int userNum = 0; // userNum 변수에 각 조건을 통한 값을 초기화 
        if (str.equals("가위") || str.equals("1")) {// str 변수에 가위,1이 입력되면 userNum을 1로 초기화
            userNum = 1; 
            
        } else if (str.equals("바위") || str.equals("2")) {// str 변수에 바위,2가 입력되면 userNum을 2로 초기화
            userNum = 2;
            
        } else if(str.equals("보") || str.equals("3")){// str 변수에 보,3이 입력되면 userNum을 3으로 초기화
            userNum = 3;
            
        }
        Random random = new Random();
        int cumNum = random.random();

        if (cumNum > userNum) {
            if (cumNum == 3 && userNum == 1) {
            	// 3번은 바위이고 1번은 가위이므로 따로 조건문을 돌려 결과 출력
                userwin++;
                System.out.println("Computer : " + input[cumNum-1] + "\nUser :" + input[userNum-1] + "\n결과 : User 승");
             // rok 배열에 인덱스값 으로 cumNum -1 , userNum -1 을 줘서 그 인덱스의 value를 호출한다.
            } else {
                cumwin++;
                System.out.println("Computer : " + input[cumNum-1] + "\nUser :" + input[userNum-1] + "\n결과 : Computer승");
            }
        } else if (cumNum < userNum) {
            if (cumNum == 1 && userNum == 3) {
            	// 3번은 바위이고 1번은 가위이므로 따로 조건문을 돌려 결과 출력
                cumwin++;
                System.out.println("Computer : " + input[cumNum-1] + "\nUser : " + input[userNum-1] + "\n결과 : Computer 승");
            } else {
                userwin++;
                System.out.println("Computer : " + input[cumNum-1] + "\nUser :" + input[userNum-1] + "\n결과 : User 승");
            }
        } else {
            draw++;
            System.out.println("Computer : " + input[cumNum-1] + "\nUser : " + input[userNum-1] + "\n결과 : 무승부");
        }
        gameIng();// 모든 조건문이 종료후 게임 다시하기 메소드 호출
    }

    private static void gameIng() {
        while (true) {
            System.out.println("1.게임계속 2.전적보기 3.종료");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    startGame(); //유저가 1을 입력하면 게임 시작
                    break;
                case 2:
                    gameRate();//유저가 2를 입력하면 전적보기
                    break;
                case 3:
                	//유저가 3을 입력하면 시스템 종료
                    System.out.println("종료");
                    System.exit(0);
            }
        }
    }

    static void gameRate() {
    	//포맷팅을 위해 LocalDateTime의 now()메소드를 사용해 현재 시간 구한다
        LocalDateTime now = LocalDateTime.now();
        // 지정된 패턴을 사용해 포맷터를 만든다
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        // 지정된 포맷터를 사용해 날짜/시간을 포맷한다 
        String formattedDateTime = now.format(formatter);
        
        double result = ((double) userwin / (double) ((cumwin + userwin + draw))) * 100;
        System.out.println(
                formattedDateTime + " 전적 : 승(" + userwin + ") 패 (" + cumwin + ") 무승부 : " + draw + " 승률 (" + (int) result + "% )");
    }
}
