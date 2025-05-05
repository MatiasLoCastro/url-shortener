package com.matias.shorturl.service;

import com.matias.shorturl.dto.UrlRequest;
import com.matias.shorturl.models.Url;
import reactor.core.publisher.Mono;

public interface UrlService {

    Mono<Url> createShortUrl(UrlRequest urlRequest);

    Mono<Url> getOriginalUrl(UrlRequest urlRequest);


}
