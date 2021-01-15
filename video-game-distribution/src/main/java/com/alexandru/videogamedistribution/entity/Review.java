package com.alexandru.videogamedistribution.entity;

import com.alexandru.videogamedistribution.embeddable.UserGameId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Reviews")
public class Review {
    @EmbeddedId
    private UserGameId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameId")
    private Game game;

    private Date createdOn = new Date();
    @Min(value = 1, message = "Rating must be at least 1.")
    @Min(value = 3, message = "Rating must be at most 5.")
    private int rating;

    @Size(max = 255)
    private String text;
}
