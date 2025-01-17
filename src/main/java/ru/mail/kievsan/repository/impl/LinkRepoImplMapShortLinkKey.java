package ru.mail.kievsan.repository.impl;

import ru.mail.kievsan.model.entity.Link;
import ru.mail.kievsan.repository.LinkRepo;

import java.util.*;

public class LinkRepoImplMapShortLinkKey implements LinkRepo {

    private final Map<String, Link> links = new HashMap<>();

    @Override
    public Optional<Link> save(Link link) {
        return Optional.ofNullable(links.put(link.getLink(), link));
    }

    @Override
    public Optional<Link> remove(Link link) {
        return Optional.ofNullable(links.remove(link.getLink()));
    }

    @Override
    public Optional<Link> findByShortLink(String shortLink) {
       return links.containsKey(shortLink) ? Optional.of(links.get(shortLink)) : Optional.empty();
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
