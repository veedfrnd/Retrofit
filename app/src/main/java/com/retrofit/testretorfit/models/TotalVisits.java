package com.retrofit.testretorfit.models;


import com.google.gson.annotations.SerializedName;

public class TotalVisits {
    @SerializedName("CHECKIN")
    private String cHECKIN;

    @SerializedName("CHECKOUT")
    private String cHECKOUT;
    @SerializedName("CHECKOUTSTATUS")
    private String cHECKOUTSTATUS;
    private String dATE;
    private String inMetersCHECKIN;
    private String inMetersCHECKOUT;
    @SerializedName("MINUTESCOUNT")
    private String mINUTESCOUNT;
    private String nAME;
    private String nEARBY;
    private String oRemark;
    private String rRemamrk;
    @SerializedName("SM_NAME")
    private String sMNAME;
    private String sNAME;
    private String xRemark;

    public String getCHECKIN() {
        return cHECKIN;
    }

    public void setCHECKIN(String cHECKIN) {
        this.cHECKIN = cHECKIN;
    }

    public String getCHECKOUT() {
        return cHECKOUT;
    }

    public void setCHECKOUT(String cHECKOUT) {
        this.cHECKOUT = cHECKOUT;
    }

    public String getCHECKOUTSTATUS() {
        return cHECKOUTSTATUS;
    }

    public void setCHECKOUTSTATUS(String cHECKOUTSTATUS) {
        this.cHECKOUTSTATUS = cHECKOUTSTATUS;
    }

    public String getDATE() {
        return dATE;
    }

    public void setDATE(String dATE) {
        this.dATE = dATE;
    }

    public String getInMetersCHECKIN() {
        return inMetersCHECKIN;
    }

    public void setInMetersCHECKIN(String inMetersCHECKIN) {
        this.inMetersCHECKIN = inMetersCHECKIN;
    }

    public String getInMetersCHECKOUT() {
        return inMetersCHECKOUT;
    }

    public void setInMetersCHECKOUT(String inMetersCHECKOUT) {
        this.inMetersCHECKOUT = inMetersCHECKOUT;
    }

    public String getMINUTESCOUNT() {
        return mINUTESCOUNT;
    }

    public void setMINUTESCOUNT(String mINUTESCOUNT) {
        this.mINUTESCOUNT = mINUTESCOUNT;
    }

    public String getNAME() {
        return nAME;
    }

    public void setNAME(String nAME) {
        this.nAME = nAME;
    }

    public String getNEARBY() {
        return nEARBY;
    }

    public void setNEARBY(String nEARBY) {
        this.nEARBY = nEARBY;
    }

    public String getORemark() {
        return oRemark;
    }

    public void setORemark(String oRemark) {
        this.oRemark = oRemark;
    }

    public String getRRemamrk() {
        return rRemamrk;
    }

    public void setRRemamrk(String rRemamrk) {
        this.rRemamrk = rRemamrk;
    }

    public String getSMNAME() {
        return sMNAME;
    }

    public void setSMNAME(String sMNAME) {
        this.sMNAME = sMNAME;
    }

    public String getSNAME() {
        return sNAME;
    }

    public void setSNAME(String sNAME) {
        this.sNAME = sNAME;
    }

    public String getXRemark() {
        return xRemark;
    }

    public void setXRemark(String xRemark) {
        this.xRemark = xRemark;
    }

}