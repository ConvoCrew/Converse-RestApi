package com.converse.api.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private List<Room> hosting;
    private List<Room> attending;
}
