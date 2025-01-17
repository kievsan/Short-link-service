package ru.mail.kievsan.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class LinkRequest {
    UUID userId;
    String originalURL;
    int clicks;
}
