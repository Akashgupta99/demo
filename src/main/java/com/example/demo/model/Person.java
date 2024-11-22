package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            if(((Person) obj).getId() == null && ((Person) obj).getName() == null) {
                return false;
            }
            if(((Person) obj).getId() == null) {
                return name.equals(((Person) obj).getName());
            }
            else if(((Person) obj).getName() == null) {
                return id.equals(((Person) obj).getId());
            }
            return id.equals(((Person) obj).getId()) && name.equals(((Person) obj).getName());
        }
        return false;
    }
}
