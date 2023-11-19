package com.yyc.user_management.model.dao;

import com.yyc.user_management.model.dto.UserDTO;
import com.yyc.user_management.view.UserView;

import static com.yyc.user_management.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class UserDAO {
    Properties prop = new Properties();

    public UserDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int registUser(Connection con, UserDTO newUser) {
        PreparedStatement pstmt = null;
        int result = 0;


        try {
            pstmt = con.prepareStatement(prop.getProperty("insertUser"));
            pstmt.setString(1, newUser.getUserID());
            pstmt.setString(2, newUser.getUserPassword());
            pstmt.setString(3, newUser.getUserNickname());
            pstmt.setString(4, newUser.getUserName());
            pstmt.setString(5, newUser.getUserBirthday());
            pstmt.setString(6, newUser.getGender());
            pstmt.setString(7, newUser.getContactNo());


            result = pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int checkUserId(Connection con, String userId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement(prop.getProperty("checkUserId"));
            pstmt.setString(1, userId);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void checkUserPassword(Connection con, UserDTO loginUser) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement(prop.getProperty("userLogin"));
            pstmt.setString(1, loginUser.getUserID());
            rset = pstmt.executeQuery();

            if (rset.next()) {
                if(rset.getString(2).equals(loginUser.getUserPassword())){
                    System.out.println("환영합니다 "+rset.getString(3)+"님!");
                }else {
                    System.out.println("입력하신 비밀번호가 틀립니다.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet findUser(Connection con, UserDTO userDTO){
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement(prop.getProperty("findUser"));
            pstmt.setString(1, userDTO.getUserID());
            rset = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rset;

    }

    public void updateUser(Connection con, UserDTO userDTO){
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(prop.getProperty("updateUser"));

            pstmt.setString(1, userDTO.getUserNickname());

            pstmt.setString(2, userDTO.getUserID());
            pstmt.executeUpdate();

            System.out.println("변경이 완료되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}