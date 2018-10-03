package com.myapp.movieservice.api;

import com.myapp.movieservice.domian.Movie;
import com.myapp.movieservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/movie")
public class MovieApi {
    Logger log = Logger.getLogger(MovieApi.class.getName());

    private MovieService movieService;

    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        Optional<Movie> user = movieService.find(id);
        if (!user.isPresent()) {
            log.warning(String.format("User not found with movie id %s", id));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Movie>> list() {
        return ResponseEntity.ok(movieService.list());
    }
}
