package eu.xauth.core.model;

import java.util.Map;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record Customer(
    UUID id,
    String honorific,
    String firstName,
    String familyName,
    String passCode,
    String emergencyCode,
    Map<String, IdentifierDocument> identifiers) {}
