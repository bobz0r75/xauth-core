package eu.xauth.core.test;

import static eu.xauth.core.test.TestConstants.PASS_CODE_MAX;
import static eu.xauth.core.test.TestConstants.PASS_CODE_TEMPLATE;
import static eu.xauth.core.test.TestConstants.RANDOM_STRING_LENGTH;
import static java.lang.Integer.MAX_VALUE;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestUtils {

  private static final Random random = new SecureRandom();

  public static LocalDate randomLocalDate() {
    var now = LocalDate.now();
    return randomLocalDate(now.minusYears(1L), now);
  }

  public static LocalDate randomLocalDate(LocalDate from, LocalDate to) {
    if (from.isAfter(to)) {
      return randomLocalDate(to, from);
    }
    return from.plusDays(randomInt((int) DAYS.between(from, to)));
  }

  public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
    return randomItem(clazz.getEnumConstants());
  }

  public static <T> T randomItem(T[] array) {
    return array[randomInt(array.length)];
  }

  public static String randomString() {
    return randomString(RANDOM_STRING_LENGTH);
  }

  public static String randomString(int length) {
    return randomAlphabetic(length);
  }

  public static String randomPassCode() {
    return PASS_CODE_TEMPLATE.formatted(randomInt(PASS_CODE_MAX));
  }

  private static int randomInt() {
    return randomInt(MAX_VALUE);
  }

  private static int randomInt(int bound) {
    return random.nextInt(bound);
  }
}
