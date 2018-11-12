package com.inter.server.interserver.domain.response;

public class ClientResponse {

    private Long id;

    private String name;

    public ClientResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
