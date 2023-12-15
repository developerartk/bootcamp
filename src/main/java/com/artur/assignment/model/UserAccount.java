package com.artur.assignment.model;

import com.artur.assignment.model.state.State;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_account")
public class UserAccount implements Account{

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "account_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name = "status")
    private State status;

    public UserAccount(String name, String email, String password, State status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public UserAccount() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
}
