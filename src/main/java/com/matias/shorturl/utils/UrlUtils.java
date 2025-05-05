package com.matias.shorturl.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class UrlUtils {

    public static String generateShortUrl(String url) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(url.getBytes(StandardCharsets.UTF_8));

            byte[] first6bytes = Arrays.copyOf(hashBytes, 6);

            return Base64.getUrlEncoder().withoutPadding().encodeToString(first6bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm error", e);
        }
    }

}
