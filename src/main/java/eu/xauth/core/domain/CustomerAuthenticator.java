package eu.xauth.core.domain;

import eu.xauth.core.model.AuthenticationResult;
import eu.xauth.core.model.Customer;
import eu.xauth.core.model.IdentifierDocument;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public interface CustomerAuthenticator {

  /**
   * Authenticates the customer.
   *
   * @param customer The customer to authenticate.
   * @param code The submitted code by which the authentication happens.
   * @return The authentication result.
   */
  AuthenticationResult authenticate(Customer customer, String code);

  /**
   * Returns the documents of the customer by the set of their IDs.
   *
   * @param customer The customer.
   * @param documentIds The set of the required IDs.
   * @return The documents.
   */
  Set<IdentifierDocument> getDocuments(Customer customer, Collection<UUID> documentIds);
}
