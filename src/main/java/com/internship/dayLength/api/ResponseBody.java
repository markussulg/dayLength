package com.internship.dayLength.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBody {
    private DayLength result;
    private String status;

    public ResponseBody(@JsonProperty(value = "results") DayLength result, @JsonProperty(value = "status") String status) {
        this.result = result;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "result=" + result +
                ", status='" + status + '\'' +
                '}';
    }

    public DayLength getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }
}
