package com.converse.api.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Schedule {
    @ManyToMany
    private List<Room> hosting;
    @ManyToMany
    private List<Room> attending;
}