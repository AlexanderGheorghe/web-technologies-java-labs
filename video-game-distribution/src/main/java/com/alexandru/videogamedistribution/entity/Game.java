package com.alexandru.videogamedistribution.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.sql.Date;
import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Please fill in the name field.")
    private String name;
    @NotBlank(message = "Please fill in the developer field.")
    private String developer;
    @NotBlank(message = "Please fill in the release date field.")
    @PastOrPresent(message = "Date must be past or present.")
    private Date releaseDate;
    @NotBlank(message = "Please fill in the genre field")
    private String genre;
    @Min(0)
    @Max(100)
    private float price;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Purchase> purchases;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Review> reviews;

    public Game(String name, String developer, Date releaseDate) {
        this.name = name;
        this.developer = developer;
        this.releaseDate = releaseDate;
    }
}
