package eu.xauth.core.model;

import static eu.xauth.core.test.TestUtils.randomLocalDate;
import static eu.xauth.core.test.TestUtils.randomString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClaimantTest {

  @Test
  void testBuilder() {

    var id = randomUUID();
    var name = randomString();
    var description = randomString();
    var validFrom = randomLocalDate();
    var validTo = randomLocalDate();

    var claimant =
        Claimant.builder()
            .id(id)
            .name(name)
            .description(description)
            .validFrom(validFrom)
            .validTo(validTo)
            .parent(null)
            .build();

    assertEquals(id, claimant.id());
    assertEquals(name, claimant.name());
    assertEquals(description, claimant.description());
    assertEquals(validFrom, claimant.validFrom());
    assertEquals(validTo, claimant.validTo());
  }
}
