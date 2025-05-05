package com.matias.shorturl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UrlRequest(

        @NotBlank(message = "URL must not be blank")
        @Pattern(regexp = "^(https?://)?([\\w.-]+)(:[0-9]{2,5})?(/\\\\S*)?$",
                flags = Pattern.Flag.CASE_INSENSITIVE,
                message = "Invalid URL format")
        String originalUrl
) {

}
