package com.converse.api.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Schedule {
    private List<Room> hosting;
    private List<Room> attending;

}
