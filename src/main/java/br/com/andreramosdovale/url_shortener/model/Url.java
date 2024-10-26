package br.com.andreramosdovale.url_shortener.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime expirationDateTime;

    public Url() {}

    public void createUrl(String _originalUrl, String _shortUrl) {
        this.originalUrl = _originalUrl;
        this.shortUrl = _shortUrl;
        this.expirationDateTime = LocalDateTime.now().plusDays(30);
    }
}
