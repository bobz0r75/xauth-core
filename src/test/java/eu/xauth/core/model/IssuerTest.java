package eu.xauth.core.model;

import static eu.xauth.core.test.TestUtils.randomLocalDate;
import static eu.xauth.core.test.TestUtils.randomString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IssuerTest {

  @Test
  void testBuilder() {

    var id = randomUUID();
    var name = randomString();
    var country = Country.builder().build();
    var validFrom = randomLocalDate();
    var validTo = randomLocalDate();

    var issuer =
        Issuer.builder()
            .id(id)
            .name(name)
            .country(country)
            .validFrom(validFrom)
            .validTo(validTo)
            .build();

    assertEquals(id, issuer.id());
    assertEquals(name, issuer.name());
    assertEquals(country, issuer.country());
    assertEquals(validFrom, issuer.validFrom());
    assertEquals(validTo, issuer.validTo());
  }
}
