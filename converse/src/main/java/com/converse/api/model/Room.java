package com.converse.api.model;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rooms")
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long roomId;
    @Column(name="status")
    private Status status;
    @Column(name="title")
    private String title;
    @Column(name="topic")
    private String topic;
    @Column(name="max_num_of_participants")
    private int maxNumOfParticipants;

    //true if public false is private
    //@Column(name="accessible")
    //private int Accessible=1;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
   @Column(name="participants")
    private List<User> participants;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private User host;
    @Column(name="livedate")
    private LocalDateTime liveDate;
    @Column(name="category")
    private Category category;
    @Column(name="tag")
    private Tag tag;

    private enum Status {LIVE, UPCOMING}

    public enum Category {MATHEMATICS, SCIENCE, MUSIC, FOREIGN_LANGUAGE, DRAMATIC_ARTS}

    private enum Tag {STUDY_ROOM, DISCUSSION}
}