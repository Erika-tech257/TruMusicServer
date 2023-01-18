package com.example.MusicApp.models;

import com.example.MusicApp.utility.CustomDateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

//@Table(name = "Event")
//@Entity
//@Builder
//@ToString
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Event implements Serializable {
    public String name;

    public Event() {
    }

    public Event(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }


}