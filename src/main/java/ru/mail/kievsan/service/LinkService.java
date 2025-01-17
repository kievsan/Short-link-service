package ru.mail.kievsan.service;

import ru.mail.kievsan.conf.PropertiesLoader;
import ru.mail.kievsan.model.dto.LinkRequest;
import ru.mail.kievsan.model.entity.Link;
import ru.mail.kievsan.repository.LinkRepo;

import java.time.LocalDateTime;
import java.util.UUID;

public class LinkService {

    LinkRepo linkRepo;

    public LinkService(LinkRepo linkRepo) {
        this.linkRepo = linkRepo;
    }

    public Link createLink(LinkRequest linkRequest) {
        Link link = Link.builder()
                .id(UUID.randomUUID())
                .userId(linkRequest.getUserId())
                .url(linkRequest.getOriginalURL())
                .clicksLeft(linkRequest.getClicks())
                .expirationDate(createExpirationDate())
                .link(createShortLink())
                .build();
        return linkRepo.save(link).orElseThrow();
    }

    public static String createShortLink() {
        // TODO
        return "jhvfkjh";
    }

    public static LocalDateTime createExpirationDate() {
        return LocalDateTime.now()
                .plusDays(PropertiesLoader.loadLifetimeDays())
                .plusHours(PropertiesLoader.loadLifetimeHours());
    }

}
