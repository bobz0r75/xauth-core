package eu.xauth.core.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestConstants {

  /** Maximum value of a test code. */
  public static final int PASS_CODE_MAX = 999999;

  /** Template for the test code (6-digit numeric string). */
  public static final String PASS_CODE_TEMPLATE = "%06d";

  /** Length of the random strings used in tests. */
  public static final int RANDOM_STRING_LENGTH = 16;
}
