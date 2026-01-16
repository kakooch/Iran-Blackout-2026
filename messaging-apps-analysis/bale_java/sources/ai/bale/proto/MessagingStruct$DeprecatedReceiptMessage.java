package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import com.google.protobuf.r0;
import ir.nasim.EnumC5852Lc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MessagingStruct$DeprecatedReceiptMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$DeprecatedReceiptMessage DEFAULT_INSTANCE;
    public static final int ORGINAL_MESSAGE_FIELD_NUMBER = 1;
    public static final int ORGINAL_MESSAGE_RID_FIELD_NUMBER = 4;
    public static final int ORGINAL_MESSAGE_UID_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int RECEIPT_TYPE_FIELD_NUMBER = 2;
    public static final int TRANSFER_INFO_FIELD_NUMBER = 3;
    private int bitField0_;
    private CollectionsStruct$Int64Value orginalMessageRid_;
    private StringValue orginalMessageUid_;
    private MessagingStruct$Message orginalMessage_;
    private int receiptType_;
    private com.google.protobuf.J transferInfo_ = com.google.protobuf.J.e();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$DeprecatedReceiptMessage.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        MessagingStruct$DeprecatedReceiptMessage messagingStruct$DeprecatedReceiptMessage = new MessagingStruct$DeprecatedReceiptMessage();
        DEFAULT_INSTANCE = messagingStruct$DeprecatedReceiptMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DeprecatedReceiptMessage.class, messagingStruct$DeprecatedReceiptMessage);
    }

    private MessagingStruct$DeprecatedReceiptMessage() {
    }

    private void clearOrginalMessage() {
        this.orginalMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOrginalMessageRid() {
        this.orginalMessageRid_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOrginalMessageUid() {
        this.orginalMessageUid_ = null;
        this.bitField0_ &= -5;
    }

    private void clearReceiptType() {
        this.receiptType_ = 0;
    }

    public static MessagingStruct$DeprecatedReceiptMessage getDefaultInstance() {
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

    private void mergeOrginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.orginalMessage_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.orginalMessage_ = messagingStruct$Message;
        } else {
            this.orginalMessage_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.orginalMessage_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeOrginalMessageRid(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.orginalMessageRid_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.orginalMessageRid_ = collectionsStruct$Int64Value;
        } else {
            this.orginalMessageRid_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.orginalMessageRid_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeOrginalMessageUid(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.orginalMessageUid_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.orginalMessageUid_ = stringValue;
        } else {
            this.orginalMessageUid_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.orginalMessageUid_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.orginalMessage_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setOrginalMessageRid(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.orginalMessageRid_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setOrginalMessageUid(StringValue stringValue) {
        stringValue.getClass();
        this.orginalMessageUid_ = stringValue;
        this.bitField0_ |= 4;
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
                return new MessagingStruct$DeprecatedReceiptMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0001\u0000\u0000\u0001ဉ\u0000\u0002\f\u00032\u0004ဉ\u0001\u0005ဉ\u0002", new Object[]{"bitField0_", "orginalMessage_", "receiptType_", "transferInfo_", b.a, "orginalMessageRid_", "orginalMessageUid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DeprecatedReceiptMessage.class) {
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

    public MessagingStruct$Message getOrginalMessage() {
        MessagingStruct$Message messagingStruct$Message = this.orginalMessage_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public CollectionsStruct$Int64Value getOrginalMessageRid() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.orginalMessageRid_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public StringValue getOrginalMessageUid() {
        StringValue stringValue = this.orginalMessageUid_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
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

    public boolean hasOrginalMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOrginalMessageRid() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOrginalMessageUid() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(MessagingStruct$DeprecatedReceiptMessage messagingStruct$DeprecatedReceiptMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DeprecatedReceiptMessage);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DeprecatedReceiptMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DeprecatedReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
