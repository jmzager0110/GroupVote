package com.liftoff.soloproject;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity{
    @NotNull
    @Size(min=3, max=50)
    private String eventName;
    //TODO: Should the options for locations & times be within arrays?

    public Event(){}

    public Event(String aEventName) {
        super();
        this.eventName = aEventName;
        //TODO: Finish Constructor with voting options
    }

    //TODO: Generate G&S only, toString is complete.

    @Override
    public String toString() {
        return eventName;
    }
}
