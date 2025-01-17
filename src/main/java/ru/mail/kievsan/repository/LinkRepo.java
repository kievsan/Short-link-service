package ru.mail.kievsan.repository;

import ru.mail.kievsan.model.entity.Link;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LinkRepo {
    Optional<Link> save(Link link);
    Optional<Link> remove(Link link);
    Optional<Link> findByShortLink(String link);
    List<Link> findByUserId(UUID userId);
}
