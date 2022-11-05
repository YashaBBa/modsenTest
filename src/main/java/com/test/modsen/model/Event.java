package com.test.modsen.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String subject;
    private String organizer;

    private Timestamp time;
    private String place;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", organizer='" + organizer + '\'' +
                ", time=" + time.toString() +
                ", place='" + place + '\'' +
                '}';
    }
}
