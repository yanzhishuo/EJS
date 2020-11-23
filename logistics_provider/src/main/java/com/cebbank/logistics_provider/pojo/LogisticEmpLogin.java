package com.cebbank.logistics_provider.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticEmpLogin {
    private Integer logisticEmpLoginId;


    private String logisticEmpLoginPhone;
    private String logisticEmpLoginPassword;


//    private String logisticEmpLoginAccount;
//    private String logisticEmpFaceToken;
//    private String logisticEmpCreateTime;
//    private String logisticEmpUpdateTime;
//    private String logisticEmpLoginStatus;

    @Override
    public String toString() {
        return "LogisticEmpLogin{" +
                "logisticEmpLoginId=" + logisticEmpLoginId +
                ", logisticEmpLoginPhone='" + logisticEmpLoginPhone + '\'' +
                ", logisticEmpLoginPassword='" + logisticEmpLoginPassword + '\'' +
                '}';
    }

    public Integer getId() {
        return logisticEmpLoginId;
    }

    public void setId(Integer id) {
        this.logisticEmpLoginId = id;
    }

    public String getPhone() {
        return logisticEmpLoginPhone;
    }

    public void setPhone(String phone) {
        this.logisticEmpLoginPhone = phone;
    }

    public String getPassword() {
        return logisticEmpLoginPassword;
    }

    public void setPassword(String password) {
        this.logisticEmpLoginPassword = password;
    }

}
