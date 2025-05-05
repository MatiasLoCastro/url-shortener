package com.matias.shorturl.service.impl;

import com.matias.shorturl.dto.UrlRequest;
import com.matias.shorturl.models.Url;
import com.matias.shorturl.repository.UrlRepository;
import com.matias.shorturl.service.UrlService;
import com.matias.shorturl.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    @Override
    public Mono<Url> createShortUrl(UrlRequest urlRequest) {

        Url url = Url.builder()
                .originalUrl(urlRequest.originalUrl())
                .shortCode(generateShortUrl(urlRequest.originalUrl()))
                .build();

        return urlRepository.save(url);
    }

    @Override
    public Mono<Url> getOriginalUrl(UrlRequest urlRequest) {
        return null;
    }

    private String generateShortUrl(String url) {
        return UrlUtils.generateShortUrl(url);
    }


}
