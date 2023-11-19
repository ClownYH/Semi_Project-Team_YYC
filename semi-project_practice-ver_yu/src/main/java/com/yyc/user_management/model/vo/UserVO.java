package com.yyc.user_management.model.vo;

public class UserVO {

    private int userNo;
    String userName;
    String userBirthday;
    String gender;
    String contactNo;

    public UserVO() {
    }

    public UserVO(int userNo, String userName, String userBirthday, String gender, String contactNo) {
        this.userNo = userNo;
        this.userName = userName;
        this.userBirthday = userBirthday;
        this.gender = gender;
        this.contactNo = contactNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserGender() {
        return gender;
    }

    public void setUserGender(String userGender) {
        this.gender = userGender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userGender='" + gender + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
