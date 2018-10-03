package com.myapp.movieservice.service;

import com.myapp.movieservice.domian.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Optional<Movie> find(int id);

    List<Movie> list();
}
