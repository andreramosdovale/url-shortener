package br.com.andreramosdovale.url_shortener.repository;

import br.com.andreramosdovale.url_shortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortenerUrl(String shortenerUrl);
}
