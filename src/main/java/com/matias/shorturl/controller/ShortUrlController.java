package com.matias.shorturl.controller;

import com.matias.shorturl.dto.UrlRequest;
import com.matias.shorturl.models.Url;
import com.matias.shorturl.repository.UrlRepository;
import com.matias.shorturl.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("url")
public class ShortUrlController {

    private final UrlRepository urlRepository;
    private final UrlService urlService;

    public ShortUrlController(UrlRepository urlRepository, UrlService urlService) {
        this.urlRepository = urlRepository;
        this.urlService = urlService;
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<Url>> createShortUrl(@Valid @RequestBody UrlRequest urlRequest) {
        return urlService.createShortUrl(urlRequest)
                .map(ResponseEntity::ok);
    }


    @GetMapping
    public Flux<Url> getAllUrls() {
        return urlRepository.findAll();
    }


}
