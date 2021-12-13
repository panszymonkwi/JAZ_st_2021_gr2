package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.contract.MovieDto;

@Service
@Slf4j
public class MoviesService {
    private RestTemplate restTemplate = new RestTemplate();
    public MovieDto getMovie() {
        String response = restTemplate.getForObject("https://api.themoviedb.org/3/movie/550?api_key=", String.class);
        log.info(response);
        return null;
    }
}
