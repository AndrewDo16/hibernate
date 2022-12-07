package ru.example.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "movie_name")
    String movieName;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director directors;

    public Movie() {

    }

    public Movie(String movieName, Director director) {
        this.movieName = movieName;
        this.directors = director;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Director getDirector() {
        return directors;
    }

    public void setDirector(Director director) {
        this.directors = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", director=" + directors +
                '}';
    }
}
