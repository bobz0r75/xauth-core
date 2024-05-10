package eu.xauth.core.model;

import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record Country(UUID id, String name, String localName, String isoCode) {}
