package com.Studio;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Connor Hunter        connh321@gmail.com
 * <p>
 * A model for a studio in the studio table
 */
@Entity
@Table(name = "studio")
public class StudioModel {

    //non-parameterized constructor
    public StudioModel() {
    }

    //parameterized constructor
    public StudioModel(String name) {
        this.name = name;
    }

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Long sid;

    @Column
    private String name;

    ///
    ///GETTERS AND SETTERS
    ///

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
