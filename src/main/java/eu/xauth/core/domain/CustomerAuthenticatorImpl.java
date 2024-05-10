package eu.xauth.core.domain;

import static eu.xauth.core.model.AuthenticationResult.EMERGENCY;
import static eu.xauth.core.model.AuthenticationResult.FAILED;
import static eu.xauth.core.model.AuthenticationResult.SUCCESS;
import static java.util.stream.Collectors.toSet;

import eu.xauth.core.model.AuthenticationResult;
import eu.xauth.core.model.Customer;
import eu.xauth.core.model.IdentifierDocument;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

public class CustomerAuthenticatorImpl implements CustomerAuthenticator {

  @Override
  public AuthenticationResult authenticate(Customer customer, String code) {
    return Optional.of(customer)
        .map(Customer::passCode)
        .filter(passCode -> StringUtils.equals(code, passCode))
        .map(passCode -> SUCCESS)
        .orElseGet(() -> authenticateNotPassed(customer, code));
  }

  @Override
  public Set<IdentifierDocument> getDocuments(Customer customer, Collection<UUID> documentIds) {
    return customer.identifiers().values().stream()
        .filter(customerDoc -> documentIds.stream().anyMatch(id -> id.equals(customerDoc.id())))
        .collect(toSet());
  }

  public AuthenticationResult authenticateNotPassed(Customer customer, String code) {
    return Optional.of(customer)
        .map(Customer::emergencyCode)
        .filter(emergencyCode -> StringUtils.equals(code, emergencyCode))
        .map(emergencyCode -> EMERGENCY)
        .orElse(FAILED);
  }
}
