package eu.xauth.core.model;

import static eu.xauth.core.test.TestUtils.randomLocalDate;
import static eu.xauth.core.test.TestUtils.randomString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IdentifierDocumentTest {

  @Test
  void testBuilder() {

    var id = randomUUID();
    var type = DocumentType.builder().build();
    var documentNr = randomString();
    var validFrom = randomLocalDate();
    var validTo = randomLocalDate();

    var document =
        IdentifierDocument.builder()
            .id(id)
            .type(type)
            .documentNr(documentNr)
            .validFrom(validFrom)
            .validTo(validTo)
            .build();

    assertEquals(id, document.id());
    assertEquals(type, document.type());
    assertEquals(documentNr, document.documentNr());
    assertEquals(validFrom, document.validFrom());
    assertEquals(validTo, document.validTo());
  }
}
