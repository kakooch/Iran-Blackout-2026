package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.EnumC5852Lc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MessagingStruct$DeprecatedReceipt extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$DeprecatedReceipt DEFAULT_INSTANCE;
    public static final int ORIGINAL_MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RECEIPT_TYPE_FIELD_NUMBER = 2;
    public static final int TRANSFER_INFO_FIELD_NUMBER = 3;
    private int bitField0_;
    private MessagingStruct$Message originalMessage_;
    private int receiptType_;
    private com.google.protobuf.J transferInfo_ = com.google.protobuf.J.e();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$DeprecatedReceipt.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        MessagingStruct$DeprecatedReceipt messagingStruct$DeprecatedReceipt = new MessagingStruct$DeprecatedReceipt();
        DEFAULT_INSTANCE = messagingStruct$DeprecatedReceipt;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DeprecatedReceipt.class, messagingStruct$DeprecatedReceipt);
    }

    private MessagingStruct$DeprecatedReceipt() {
    }

    private void clearOriginalMessage() {
        this.originalMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReceiptType() {
        this.receiptType_ = 0;
    }

    public static MessagingStruct$DeprecatedReceipt getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableTransferInfoMap() {
        return internalGetMutableTransferInfo();
    }

    private com.google.protobuf.J internalGetMutableTransferInfo() {
        if (!this.transferInfo_.n()) {
            this.transferInfo_ = this.transferInfo_.s();
        }
        return this.transferInfo_;
    }

    private com.google.protobuf.J internalGetTransferInfo() {
        return this.transferInfo_;
    }

    private void mergeOriginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.originalMessage_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.originalMessage_ = messagingStruct$Message;
        } else {
            this.originalMessage_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.originalMessage_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DeprecatedReceipt parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOriginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.originalMessage_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setReceiptType(EnumC5852Lc4 enumC5852Lc4) {
        this.receiptType_ = enumC5852Lc4.getNumber();
    }

    private void setReceiptTypeValue(int i) {
        this.receiptType_ = i;
    }

    public boolean containsTransferInfo(String str) {
        str.getClass();
        return internalGetTransferInfo().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DeprecatedReceipt();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0000\u0001ဉ\u0000\u0002\f\u00032", new Object[]{"bitField0_", "originalMessage_", "receiptType_", "transferInfo_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DeprecatedReceipt.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MessagingStruct$Message getOriginalMessage() {
        MessagingStruct$Message messagingStruct$Message = this.originalMessage_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public EnumC5852Lc4 getReceiptType() {
        EnumC5852Lc4 enumC5852Lc4J = EnumC5852Lc4.j(this.receiptType_);
        return enumC5852Lc4J == null ? EnumC5852Lc4.UNRECOGNIZED : enumC5852Lc4J;
    }

    public int getReceiptTypeValue() {
        return this.receiptType_;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getTransferInfo() {
        return getTransferInfoMap();
    }

    public int getTransferInfoCount() {
        return internalGetTransferInfo().size();
    }

    public Map<String, CollectionsStruct$RawValue> getTransferInfoMap() {
        return Collections.unmodifiableMap(internalGetTransferInfo());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getTransferInfoOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetTransferInfo = internalGetTransferInfo();
        return jInternalGetTransferInfo.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetTransferInfo.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getTransferInfoOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetTransferInfo = internalGetTransferInfo();
        if (jInternalGetTransferInfo.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetTransferInfo.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean hasOriginalMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$DeprecatedReceipt messagingStruct$DeprecatedReceipt) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DeprecatedReceipt);
    }

    public static MessagingStruct$DeprecatedReceipt parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(byte[] bArr) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(InputStream inputStream) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DeprecatedReceipt parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
