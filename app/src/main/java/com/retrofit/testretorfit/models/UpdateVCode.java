package com.retrofit.testretorfit.models;

public class UpdateVCode {
    private String VCode, dbid, Resp;

    public UpdateVCode(String VCode, String dbid) {
        this.VCode = VCode;
        this.dbid = dbid;
    }

    public String getResp() {
        return Resp;
    }

    public void setResp(String resp) {
        Resp = resp;
    }

    public String getVCode() {
        return VCode;
    }

    public void setVCode(String VCode) {
        this.VCode = VCode;
    }

    public String getDbid() {
        return dbid;
    }

    public void setDbid(String dbid) {
        this.dbid = dbid;
    }
}
