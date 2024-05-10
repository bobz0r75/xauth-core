package eu.xauth.core.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record Issuer(
    UUID id,
    String name,
    Country country,
    LocalDate validFrom,
    LocalDate validTo) {}
