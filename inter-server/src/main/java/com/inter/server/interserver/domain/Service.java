package com.inter.server.interserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "clients-1")
    private Integer user_id;

    @NotNull(message = "clients-2")
    private String path;

    @NotNull(message = "clients-3")
    private String code;

    @NotNull(message = "clients-3")
    private byte enabled;

    public Service() {
    }

    public Service(Integer user_id, String path, String code, byte enabled) {
        this.user_id = user_id;
        this.path = path;
        this.code = code;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", path='" + path + '\'' +
                ", code='" + code + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}


