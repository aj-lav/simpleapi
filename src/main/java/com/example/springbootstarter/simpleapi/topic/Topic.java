package com.example.springbootstarter.simpleapi.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

// We need to create table with following details as column (id, name, description).
// We have JPA to do all this work, mapping entity class and to convert it too. This can be achieved by @entity.
@Entity
public class Topic {

    @Id      // @Id makes String id as the primary key. It is a field annotation.
    private String id;
    private String name;
    private String description;

    public Topic() {
    }

    public Topic(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
