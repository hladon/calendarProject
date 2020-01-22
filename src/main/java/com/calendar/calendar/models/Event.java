package com.calendar.calendar.models;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "EVENT")
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
    @Column(name="CREATE_DATE")
    private Date createDate;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndData() {
        return endData;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
