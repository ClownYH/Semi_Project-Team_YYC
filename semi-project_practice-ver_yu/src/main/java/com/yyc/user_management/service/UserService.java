package com.yyc.user_management.service;

import com.yyc.user_management.model.dao.UserDAO;
import com.yyc.user_management.model.dto.UserDTO;
import com.yyc.user_management.view.UserView;

import static com.yyc.user_management.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    private UserDAO userDAO;

    public UserService (String url){
        this.userDAO = new UserDAO(url);
    }

    public int registUser(UserDTO newUser){
        Connection con = getConnection();

        int result = userDAO.registUser(con, newUser);

        close(con);
        return result;
    }

    public int checkUserId(String userId){
        Connection con = getConnection();

        int result = userDAO.checkUserId(con, userId);

        close(con);
        if (result == 0){
            return 1;
        }else {
            System.out.println("중복되는 아이디가 있습니다.\n아이디를 다시 입력해주세요: ");
            return 0;
        }

    }


    public void userLogin(UserDTO loginUser) {
        Connection con = getConnection();

        int result = userDAO.checkUserId(con, loginUser.getUserID());

        if (result == 1){
            userDAO.checkUserPassword(con, loginUser);
            ResultSet rset = userDAO.findUser(con, loginUser);
            UserView.userManagementProgram(con, rset);
        }else {
            System.out.println("로그인 정보가 존재하지 않습니다. 다시 입력해주세요");
        }



    }

    public void updateUserInfo(UserDTO newUserInfo){
        Connection con = getConnection();

        userDAO.updateUser(con, newUserInfo);
    }
}
