package com.yyc.user_management.controller;

import com.yyc.user_management.model.dto.UserDTO;
import com.yyc.user_management.model.vo.UserVO;
import com.yyc.user_management.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserCtr {

    private UserService userService;

    public UserCtr(UserService userService) {
        this.userService = userService;
    }

    public String registUser(UserDTO newUser){
        if (Objects.isNull(newUser)){
            return "회원정보가 존재하기 않아요, 입력해주세요: ";
        }
        if (newUser.getUserName() == null || newUser.getUserName().equals(" ")){
            return "회원이름을 등록해주세요";
        }
        // 입력한 회원의 생일이 생일 형식에 맞는지 확인하는 컨트롤러 알고림즘 필요
        if (newUser.getUserBirthday() == null || newUser.getUserBirthday().equals(" ")){
            return "생일을 입력해주세요";
        }
        // 회원의 성별을 맞게 입력했는지 확인하는 알고리즘 필요
        if (newUser.getGender() == null || newUser.getGender().equals(" ")){
            return "회원의 성별을 제대로 입력해주세요";
        }
        if (newUser.getContactNo() == null || newUser.getContactNo().equals(" ")){
            return "전화번호는 필수입니다~";
        }
        if (newUser.getUserName() == null || newUser.getUserNickname().equals(" ")){
            return "회원 닉네임을 등록해주세요";
        }

        // 유효성 검사가 끝난 유저
        int result = userService.registUser(newUser);

        if (result <= 0){
            return "등록중 오류가 발생됨";
        }else {
            return "회원가입을 축하합니다!";
        }
    }


    public void userLogin(UserDTO loginUser) {
        if (Objects.isNull(loginUser)){
            System.out.println("로그인 정보가 존재하기 않아요, 입력해주세요: ");
        }

        // 유효성 검사가 끝난 로그인 유저
        userService.userLogin(loginUser);

    }

    public String updateUser(UserDTO newUserInfo){
        if(Objects.isNull(newUserInfo)){
            return "변경할 내용이 존재하지 않습니다.";
        }

        userService.updateUserInfo(newUserInfo);
        return "성공적으로 변경되었습니다.";
    }
}


