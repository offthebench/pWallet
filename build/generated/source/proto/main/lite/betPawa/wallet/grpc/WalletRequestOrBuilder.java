// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WalletService.proto

package betPawa.wallet.grpc;

public interface WalletRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:betPawa.wallet.grpc.WalletRequest)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>optional int32 userId = 1;</code>
   */
  int getUserId();

  /**
   * <code>optional double amount = 2;</code>
   */
  double getAmount();

  /**
   * <code>optional string currency = 3;</code>
   */
  java.lang.String getCurrency();
  /**
   * <code>optional string currency = 3;</code>
   */
  com.google.protobuf.ByteString
      getCurrencyBytes();
}
