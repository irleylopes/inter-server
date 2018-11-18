package com.inter.server.interserver.domain.response;

public class ClientResponse {

    private Long id;

    private String username;

    public ClientResponse(Long id, String name) {
        this.id = id;
        this.username = name;
    }

    public ClientResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
