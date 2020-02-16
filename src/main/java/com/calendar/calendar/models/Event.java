package com.calendar.calendar.models;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "EVENT")
@Data
public class Event {

    @Id
    @SequenceGenerator(name = "EVENT_SEQUENCE", sequenceName = "EVENT_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_SEQUENCE")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATA")
    private Date endData;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CREATE_DATE")
    private Date createDate;


}
