package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ReceiptMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ReceiptMessage DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TRANSFER_INFO_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$MapValue message_;
    private CollectionsStruct$MapValue transferInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ReceiptMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ReceiptMessage messagingStruct$ReceiptMessage = new MessagingStruct$ReceiptMessage();
        DEFAULT_INSTANCE = messagingStruct$ReceiptMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ReceiptMessage.class, messagingStruct$ReceiptMessage);
    }

    private MessagingStruct$ReceiptMessage() {
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransferInfo() {
        this.transferInfo_ = null;
        this.bitField0_ &= -3;
    }

    public static MessagingStruct$ReceiptMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.message_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.message_ = collectionsStruct$MapValue;
        } else {
            this.message_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.message_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTransferInfo(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.transferInfo_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.transferInfo_ = collectionsStruct$MapValue;
        } else {
            this.transferInfo_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.transferInfo_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ReceiptMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessage(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.message_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    private void setTransferInfo(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.transferInfo_ = collectionsStruct$MapValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ReceiptMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "message_", "transferInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ReceiptMessage.class) {
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

    public CollectionsStruct$MapValue getMessage() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.message_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public CollectionsStruct$MapValue getTransferInfo() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.transferInfo_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTransferInfo() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingStruct$ReceiptMessage messagingStruct$ReceiptMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ReceiptMessage);
    }

    public static MessagingStruct$ReceiptMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ReceiptMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ReceiptMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
