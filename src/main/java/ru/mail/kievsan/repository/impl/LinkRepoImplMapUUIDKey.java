package ru.mail.kievsan.repository.impl;

import ru.mail.kievsan.model.entity.Link;
import ru.mail.kievsan.repository.LinkRepo;

import java.util.*;

public class LinkRepoImplMapUUIDKey implements LinkRepo {

    private final Map<UUID, Link> links = new HashMap<>();

    @Override
    public Optional<Link> save(Link link) {
        return Optional.ofNullable(links.put(link.getId(), link));
    }

    @Override
    public Optional<Link> remove(Link link) {
        return Optional.ofNullable(links.remove(link.getId()));
    }

    @Override
    public Optional<Link> findByShortLink(String shortLink) {
        for (Link link: links.values()) {
          if (link.getLink().equals(shortLink)) return Optional.of(link);
        }
        return Optional.empty();
    }

    @Override
    public List<Link> findByUserId(UUID userId) {
        List<Link> userLinks = new ArrayList<>();
        for (Link link: links.values()) {
            if (link.getUserId().equals(userId)) userLinks.add(link);
        }
        return userLinks;
    }
}
