package com.myapp.movieservice.service;

import com.myapp.movieservice.domian.Movie;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movies;

    @PostConstruct
    protected void init() {
        movies = new ArrayList<>();
        movies.add(new Movie(1, "The Shawshank Redemption ", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."));
        movies.add(new Movie(2, " The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."));
        movies.add(new Movie(3, "The Dark Knight ", "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice."));
        movies.add(new Movie(4, " The Godfather: Part II ", "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate."));
        movies.add(new Movie(5, "Pulp Fiction ", "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption."));
    }

    @Override
    public Optional<Movie> find(int id) {
        return movies
                .stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }

    @Override
    public List<Movie> list() {
        return movies;
    }
}
