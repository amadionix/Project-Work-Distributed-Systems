// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PushNotificationService.proto

package my.grpc.gateway;

public final class PushNotificationServiceOuterClass {
  private PushNotificationServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface NotificationMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:my.grpc.gateway.NotificationMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string notification = 1;</code>
     */
    java.lang.String getNotification();
    /**
     * <code>string notification = 1;</code>
     */
    com.google.protobuf.ByteString
        getNotificationBytes();
  }
  /**
   * Protobuf type {@code my.grpc.gateway.NotificationMessage}
   */
  public  static final class NotificationMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:my.grpc.gateway.NotificationMessage)
      NotificationMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use NotificationMessage.newBuilder() to construct.
    private NotificationMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private NotificationMessage() {
      notification_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private NotificationMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              notification_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_NotificationMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_NotificationMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.class, my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.Builder.class);
    }

    public static final int NOTIFICATION_FIELD_NUMBER = 1;
    private volatile java.lang.Object notification_;
    /**
     * <code>string notification = 1;</code>
     */
    public java.lang.String getNotification() {
      java.lang.Object ref = notification_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        notification_ = s;
        return s;
      }
    }
    /**
     * <code>string notification = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNotificationBytes() {
      java.lang.Object ref = notification_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        notification_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getNotificationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, notification_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNotificationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, notification_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage)) {
        return super.equals(obj);
      }
      my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage other = (my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage) obj;

      boolean result = true;
      result = result && getNotification()
          .equals(other.getNotification());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + NOTIFICATION_FIELD_NUMBER;
      hash = (53 * hash) + getNotification().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code my.grpc.gateway.NotificationMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:my.grpc.gateway.NotificationMessage)
        my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_NotificationMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_NotificationMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.class, my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.Builder.class);
      }

      // Construct using my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        notification_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_NotificationMessage_descriptor;
      }

      public my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage getDefaultInstanceForType() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.getDefaultInstance();
      }

      public my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage build() {
        my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage buildPartial() {
        my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage result = new my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage(this);
        result.notification_ = notification_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage) {
          return mergeFrom((my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage other) {
        if (other == my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.getDefaultInstance()) return this;
        if (!other.getNotification().isEmpty()) {
          notification_ = other.notification_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object notification_ = "";
      /**
       * <code>string notification = 1;</code>
       */
      public java.lang.String getNotification() {
        java.lang.Object ref = notification_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          notification_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string notification = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNotificationBytes() {
        java.lang.Object ref = notification_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          notification_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string notification = 1;</code>
       */
      public Builder setNotification(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        notification_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string notification = 1;</code>
       */
      public Builder clearNotification() {
        
        notification_ = getDefaultInstance().getNotification();
        onChanged();
        return this;
      }
      /**
       * <code>string notification = 1;</code>
       */
      public Builder setNotificationBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        notification_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:my.grpc.gateway.NotificationMessage)
    }

    // @@protoc_insertion_point(class_scope:my.grpc.gateway.NotificationMessage)
    private static final my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage();
    }

    public static my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<NotificationMessage>
        PARSER = new com.google.protobuf.AbstractParser<NotificationMessage>() {
      public NotificationMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new NotificationMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<NotificationMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<NotificationMessage> getParserForType() {
      return PARSER;
    }

    public my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface AckMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:my.grpc.gateway.AckMessage)
      com.google.protobuf.MessageOrBuilder {
  }
  /**
   * Protobuf type {@code my.grpc.gateway.AckMessage}
   */
  public  static final class AckMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:my.grpc.gateway.AckMessage)
      AckMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AckMessage.newBuilder() to construct.
    private AckMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AckMessage() {
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AckMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_AckMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_AckMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.class, my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.Builder.class);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage)) {
        return super.equals(obj);
      }
      my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage other = (my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage) obj;

      boolean result = true;
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code my.grpc.gateway.AckMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:my.grpc.gateway.AckMessage)
        my.grpc.gateway.PushNotificationServiceOuterClass.AckMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_AckMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_AckMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.class, my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.Builder.class);
      }

      // Construct using my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.internal_static_my_grpc_gateway_AckMessage_descriptor;
      }

      public my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage getDefaultInstanceForType() {
        return my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.getDefaultInstance();
      }

      public my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage build() {
        my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage buildPartial() {
        my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage result = new my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage(this);
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage) {
          return mergeFrom((my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage other) {
        if (other == my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage.getDefaultInstance()) return this;
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:my.grpc.gateway.AckMessage)
    }

    // @@protoc_insertion_point(class_scope:my.grpc.gateway.AckMessage)
    private static final my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage();
    }

    public static my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AckMessage>
        PARSER = new com.google.protobuf.AbstractParser<AckMessage>() {
      public AckMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new AckMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AckMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AckMessage> getParserForType() {
      return PARSER;
    }

    public my.grpc.gateway.PushNotificationServiceOuterClass.AckMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_my_grpc_gateway_NotificationMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_my_grpc_gateway_NotificationMessage_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_my_grpc_gateway_AckMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_my_grpc_gateway_AckMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035PushNotificationService.proto\022\017my.grpc" +
      ".gateway\"+\n\023NotificationMessage\022\024\n\014notif" +
      "ication\030\001 \001(\t\"\014\n\nAckMessage2s\n\027PushNotif" +
      "icationService\022X\n\006notify\022$.my.grpc.gatew" +
      "ay.NotificationMessage\032$.my.grpc.gateway" +
      ".NotificationMessage(\0010\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_my_grpc_gateway_NotificationMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_my_grpc_gateway_NotificationMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_my_grpc_gateway_NotificationMessage_descriptor,
        new java.lang.String[] { "Notification", });
    internal_static_my_grpc_gateway_AckMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_my_grpc_gateway_AckMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_my_grpc_gateway_AckMessage_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
