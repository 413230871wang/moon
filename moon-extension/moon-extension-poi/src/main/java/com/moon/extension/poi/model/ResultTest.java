package com.moon.extension.poi.model;

public class ResultTest {
    private String idNo;

    private String comments;

    private String colleaguesLike;

    private String userCharacter;

    private String bookLooking;

    private String userName;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getColleaguesLike() {
        return colleaguesLike;
    }

    public void setColleaguesLike(String colleaguesLike) {
        this.colleaguesLike = colleaguesLike == null ? null : colleaguesLike.trim();
    }

    public String getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(String userCharacter) {
        this.userCharacter = userCharacter == null ? null : userCharacter.trim();
    }

    public String getBookLooking() {
        return bookLooking;
    }

    public void setBookLooking(String bookLooking) {
        this.bookLooking = bookLooking == null ? null : bookLooking.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}