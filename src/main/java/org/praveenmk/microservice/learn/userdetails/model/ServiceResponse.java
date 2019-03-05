package org.praveenmk.microservice.learn.userdetails.model;

public class ServiceResponse {
    private long id;
    private String statusMessage;

    public ServiceResponse() {
    }

    public ServiceResponse(long id, String statusMessage) {
        this.id = id;
        this.statusMessage = statusMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
