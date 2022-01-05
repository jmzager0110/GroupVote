package com.liftoff.soloproject.models;

import com.liftoff.soloproject.models.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Event extends AbstractEntity {
    @NotBlank(message = "Event Name is required")
    @Size(min=3, max=50)
    private String eventName;

    private String eventDescription;
    //TODO:Make this Optional


    private String eventDate;

    //TODO: Should the options for locations & times be within arrays?

    public Event(){}

    public Event(String aEventName, String aEventDate) {
        super();
        this.eventName = aEventName;
        this.eventDate = aEventDate;
        //TODO: Finish Constructor with voting options
    }

    public Event(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    //TODO: Generate G&S & other methods once voting options are configured.


}
