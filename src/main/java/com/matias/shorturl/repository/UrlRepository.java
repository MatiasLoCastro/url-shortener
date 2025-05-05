package com.matias.shorturl.repository;

import com.matias.shorturl.models.Url;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UrlRepository extends ReactiveCrudRepository<Url, Long> {

    Mono<Url> findByShortCode(String shortCode);

    Mono<Url> findByOriginalUrl(String originalUrl);


}
