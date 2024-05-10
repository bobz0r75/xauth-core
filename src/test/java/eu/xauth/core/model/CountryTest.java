package eu.xauth.core.model;

import static eu.xauth.core.test.TestUtils.randomString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountryTest {

  @Test
  void testBuilder() {

    var id = randomUUID();
    var name = randomString();
    var localName = randomString();
    var isoCode = randomString(2).toUpperCase();

    var country = Country.builder().id(id).name(name).localName(localName).isoCode(isoCode).build();

    assertEquals(id, country.id());
    assertEquals(name, country.name());
    assertEquals(localName, country.localName());
    assertEquals(isoCode, country.isoCode());
  }
}
