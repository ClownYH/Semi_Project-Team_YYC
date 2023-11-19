package com.yyc.user_management.app;

import java.util.Scanner;
import com.yyc.user_management.view.UserView;

public class Application01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. 회원가입 \n2. 로그인 \n9. 종료");
            int choice = sc.nextInt();
            switch (choice) {
                // 회원가입 프로그램
                case 1:
                    UserView.userRegisterProgram();
                    break;

                // 로그인 - 회원인증
                case 2:
                    UserView.userLoginProgram();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                // 프로그램 종료
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;

            }
        }



    }
}
