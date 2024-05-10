package eu.xauth.core.domain;

import static eu.xauth.core.model.AuthenticationResult.EMERGENCY;
import static eu.xauth.core.model.AuthenticationResult.FAILED;
import static eu.xauth.core.model.AuthenticationResult.SUCCESS;
import static eu.xauth.core.test.TestUtils.randomPassCode;
import static eu.xauth.core.test.TestUtils.randomString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import eu.xauth.core.model.Customer;
import eu.xauth.core.model.IdentifierDocument;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerAuthenticatorImplTest {

  @InjectMocks private CustomerAuthenticatorImpl customerAuthenticator;

  private String passCode;
  private String emergencyCode;
  private Customer customer;
  private UUID passportId;
  public String idName;
  public String passportName;

  @BeforeEach
  void setUp() {
    passCode = randomPassCode();
    emergencyCode = randomPassCode();
    passportId = randomUUID();
    idName = randomString();
    passportName = randomString();
    customer = createCustomer();
  }

  @Test
  void testAuthenticationSuccess() {
    assertSame(SUCCESS, customerAuthenticator.authenticate(customer, passCode));
  }

  @Test
  void testEmergencyAuthentication() {
    assertSame(EMERGENCY, customerAuthenticator.authenticate(customer, emergencyCode));
  }

  @Test
  void testAuthenticationFailure() {
    assertSame(FAILED, customerAuthenticator.authenticate(customer, randomPassCode()));
  }

  @Test
  void testGetDocuments() {
    var docs = customerAuthenticator.getDocuments(customer, Set.of(passportId));
    assertEquals(1, docs.size());
    docs.forEach(doc -> assertEquals(passportId, doc.id()));
  }

  private Customer createCustomer() {
    return Customer.builder()
        .id(randomUUID())
        .passCode(passCode)
        .emergencyCode(emergencyCode)
        .identifiers(
            Map.of(
                idName, IdentifierDocument.builder().id(randomUUID()).build(),
                passportName, IdentifierDocument.builder().id(passportId).build()))
        .build();
  }
}
