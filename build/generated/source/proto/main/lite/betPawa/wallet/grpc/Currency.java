// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WalletService.proto

package betPawa.wallet.grpc;

/**
 * Protobuf enum {@code betPawa.wallet.grpc.Currency}
 */
public enum Currency
    implements com.google.protobuf.Internal.EnumLite {
  /**
   * <code>EUR = 0;</code>
   */
  EUR(0),
  /**
   * <code>USD = 1;</code>
   */
  USD(1),
  /**
   * <code>GBP = 2;</code>
   */
  GBP(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>EUR = 0;</code>
   */
  public static final int EUR_VALUE = 0;
  /**
   * <code>USD = 1;</code>
   */
  public static final int USD_VALUE = 1;
  /**
   * <code>GBP = 2;</code>
   */
  public static final int GBP_VALUE = 2;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Currency valueOf(int value) {
    return forNumber(value);
  }

  public static Currency forNumber(int value) {
    switch (value) {
      case 0: return EUR;
      case 1: return USD;
      case 2: return GBP;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Currency>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Currency> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Currency>() {
          public Currency findValueByNumber(int number) {
            return Currency.forNumber(number);
          }
        };

  private final int value;

  private Currency(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:betPawa.wallet.grpc.Currency)
}
