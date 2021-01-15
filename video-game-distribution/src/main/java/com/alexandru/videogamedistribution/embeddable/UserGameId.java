package com.alexandru.videogamedistribution.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class UserGameId implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "game_id")
    private int gameId;
}
