package eu.xauth.core.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record IdentifierDocument(
    UUID id,
    DocumentType type,
    String documentNr,
    LocalDate validFrom,
    LocalDate validTo) {}
