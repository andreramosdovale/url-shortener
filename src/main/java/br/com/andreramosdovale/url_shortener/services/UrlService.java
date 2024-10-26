package br.com.andreramosdovale.url_shortener.services;

import br.com.andreramosdovale.url_shortener.model.Url;
import br.com.andreramosdovale.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVXZWYabcdefghijklmnopqrstuvxzwy";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        Url url = new Url();
        url.createUrl(originalUrl, shortUrl);
        urlRepository.save(url);

        return shortUrl;
    }

    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        int length = ThreadLocalRandom.current().nextInt(MIN_LENGTH, MAX_LENGTH + 1);
        for (int i = 0; i < length; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(CHARACTERS.length());
            shortUrl.append(CHARACTERS.charAt(randomIndex));
        }
        return shortUrl.toString();
    }
}