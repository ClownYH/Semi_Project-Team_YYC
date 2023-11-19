package com.yyc.user_management.model.dto;

public class UserDTO {
    String userID;
    String userPassword;
    String userNickname;
    String userName;
    String userBirthday;
    String gender;
    String contactNo;

    public UserDTO() {
    }

    public UserDTO(String userID, String userPassword, String userName, String userBirthday, String gender, String contactNo, String userNickname) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userBirthday = userBirthday;
        this.gender = gender;
        this.contactNo = contactNo;
        this.userNickname = userNickname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
