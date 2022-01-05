package com.liftoff.soloproject;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity{
    @NotBlank
    @Size(min=3, max=50)
    private String eventName;

    private String eventDate;
    private String eventDescription;
    //TODO: make this Optional?

    //TODO: Should the options for locations & times be within arrays? ManyToMany?
    @ManyToMany
    private List locationOptions = new ArrayList();

    @ManyToMany
    private List timeOptions = new ArrayList();

    public Event(){}

    public Event(String eventName, String eventDate, String eventDescription, List locationOptions, List timeOptions) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.locationOptions = locationOptions;
        this.timeOptions = timeOptions;
    }

    //TODO: Generate G&S & methods. Update toString as needed.

    @Override
    public String toString() {
        return eventName;
    }
}
