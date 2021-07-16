package org.test.model.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Person extends PanacheEntityBase{
    @NotBlank(message= "The ID of the person associated with the account is required and may not be blank")
    @Id
    private String id;
    
    private String name;    
    private String lastName;

    @ElementCollection()
    @CollectionTable(name = "person_emails", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "email_address")
    private List<String> emailAddresses;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }
    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    
}
