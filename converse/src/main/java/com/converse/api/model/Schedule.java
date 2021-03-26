package com.converse.api.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
@Embeddable
public class Schedule {
    @ManyToMany
    private List<Room> hosting;
    @ManyToMany
    private List<Room> attending;

}