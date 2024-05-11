package eu.xauth.core.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record Claimant(
    UUID id,
    String name,
    String description,
    LocalDate validFrom,
    LocalDate validTo,
    Claimant parent) {}
