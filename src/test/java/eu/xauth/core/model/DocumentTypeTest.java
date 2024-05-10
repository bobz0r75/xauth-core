package eu.xauth.core.model;

import static eu.xauth.core.test.TestUtils.randomEnum;
import static eu.xauth.core.test.TestUtils.randomLocalDate;
import static eu.xauth.core.test.TestUtils.randomString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DocumentTypeTest {

  @Test
  void tesBuilder() {

    var id = randomUUID();
    var name = randomString();
    var type = randomEnum(DocumentBaseType.class);
    var validFrom = randomLocalDate();
    var validTo = randomLocalDate();

    var documentType =
        DocumentType.builder()
            .id(id)
            .name(name)
            .type(type)
            .validFrom(validFrom)
            .validTo(validTo)
            .build();

    assertEquals(id, documentType.id());
    assertEquals(name, documentType.name());
    assertEquals(type, documentType.type());
    assertEquals(validFrom, documentType.validFrom());
    assertEquals(validTo, documentType.validTo());
  }
}
