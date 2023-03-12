package com.example.advengtest.models;

import com.example.advengtest.models.enums.PerformerType;
import com.example.advengtest.models.enums.State;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private State state;

    private Date creationDate;

    private Date updateStateDate;

    private String info;

    private PerformerType type;

    @ManyToOne
    private Subproject subproject;

    public Task() {
    }

    public Task(String title, State state, Date creationDate, String info, PerformerType type, Subproject subproject) {
        this.title = title;
        this.state = state;
        this.creationDate = creationDate;
        this.info = info;
        this.type = type;
        this.subproject = subproject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateStateDate() {
        return updateStateDate;
    }

    public void setUpdateStateDate(Date updateStateDate) {
        this.updateStateDate = updateStateDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public PerformerType getType() {
        return type;
    }

    public void setType(PerformerType type) {
        this.type = type;
    }

    public Subproject getSubproject() {
        return subproject;
    }

    public void setSubproject(Subproject subproject) {
        this.subproject = subproject;
    }
}
