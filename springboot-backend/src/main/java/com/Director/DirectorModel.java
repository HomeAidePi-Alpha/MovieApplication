package com.Director;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Connor Hunter        connh321@gmail.com
 * <p>
 * A model for a director in the director table
 */
@Entity
@Table(name = "director")
public class DirectorModel {

    //non-parameterized constructor
    public DirectorModel() {
    }

    //parameterized constructor
    public DirectorModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Long did;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    ///
    ///GETTERS AND SETTERS
    ///

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
