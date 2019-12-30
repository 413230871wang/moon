package com.moon.base.basic.annotation;

public class TFqlTwoLoanApply {
    @IgnoreParam
    public String listId;
    /**
     * 对公必传
     **/
    //收款账号类型
    @IgnoreParam(value = "no")
    public String loanAcType;

    //开户行全称
    @IgnoreParam(value = "no")
    public String openBankName;

    //开户行所在省份
    @IgnoreParam(value = "no")
    public String openBankProvince;

    //开户行所在城市
    @IgnoreParam(value = "no")
    public String openBankCity;

    //支行行号
    @IgnoreParam(value = "no")
    public String bankBranchNo;



    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getLoanAcType() {
        return loanAcType;
    }

    public void setLoanAcType(String loanAcType) {
        this.loanAcType = loanAcType;
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public String getOpenBankProvince() {
        return openBankProvince;
    }

    public void setOpenBankProvince(String openBankProvince) {
        this.openBankProvince = openBankProvince;
    }

    public String getOpenBankCity() {
        return openBankCity;
    }

    public void setOpenBankCity(String openBankCity) {
        this.openBankCity = openBankCity;
    }

    public String getBankBranchNo() {
        return bankBranchNo;
    }

    public void setBankBranchNo(String bankBranchNo) {
        this.bankBranchNo = bankBranchNo;
    }
}