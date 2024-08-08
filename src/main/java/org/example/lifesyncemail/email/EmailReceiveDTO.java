package org.example.lifesyncemail.email;

public class EmailReceiveDTO {

    private String email;
    private Integer token;

    public Integer getToken() {
        return this.token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
