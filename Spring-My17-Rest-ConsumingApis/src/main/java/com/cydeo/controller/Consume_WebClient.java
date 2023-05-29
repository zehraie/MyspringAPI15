package com.cydeo.controller;

import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }
    //create own API, by reactiveWay
    //returning more than one , not List because list block one request have for next one, so it flux
    @GetMapping("/flux-movie-cinema")
    public Flux<MovieCinema> readAllCinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }
}
