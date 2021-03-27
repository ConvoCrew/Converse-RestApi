package com.converse.api.model;

import lombok.*;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RoomByUser {
    private Room room;
    private Long hostId;
}
