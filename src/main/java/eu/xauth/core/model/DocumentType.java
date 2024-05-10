package eu.xauth.core.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record DocumentType(
    UUID id,
    String name,
    DocumentBaseType type,
    Issuer issuer,
    LocalDate validFrom,
    LocalDate validTo) {}
