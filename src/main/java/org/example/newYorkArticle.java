package org.example;

public class newYorkArticle {
    String status;
    String copyright;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public org.example.response getResponse() {
        return response;
    }

    public void setResponse(org.example.response response) {
        this.response = response;
    }

    response response = new response();
}
