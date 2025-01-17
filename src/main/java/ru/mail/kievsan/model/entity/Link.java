package ru.mail.kievsan.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Link {

    private UUID id;
    private String url;
    private String link;
    private UUID userId;
    private int clicksLeft;
    private LocalDateTime expirationDate;

}
