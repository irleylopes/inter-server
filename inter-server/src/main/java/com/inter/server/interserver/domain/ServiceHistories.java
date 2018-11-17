package com.inter.server.interserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class ServiceHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "clients-1")
    private Integer service_id;

    @NotNull(message = "clients-2")
    private String executionTime;

    @NotNull(message = "clients-3")
    private Timestamp cocreated_atde;

    public ServiceHistories() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public Timestamp getCocreated_atde() {
        return cocreated_atde;
    }

    public void setCocreated_atde(Timestamp cocreated_atde) {
        this.cocreated_atde = cocreated_atde;
    }

    @Override
    public String toString() {
        return "ServiceHistories{" +
                "id=" + id +
                ", service_id=" + service_id +
                ", executionTime='" + executionTime + '\'' +
                ", cocreated_atde=" + cocreated_atde +
                '}';
    }
}