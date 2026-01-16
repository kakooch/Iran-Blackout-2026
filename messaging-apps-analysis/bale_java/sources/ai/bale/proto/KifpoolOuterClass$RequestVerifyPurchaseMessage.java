package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestVerifyPurchaseMessage extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestVerifyPurchaseMessage DEFAULT_INSTANCE;
    public static final int HISTORYID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier historyId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestVerifyPurchaseMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestVerifyPurchaseMessage kifpoolOuterClass$RequestVerifyPurchaseMessage = new KifpoolOuterClass$RequestVerifyPurchaseMessage();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestVerifyPurchaseMessage;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestVerifyPurchaseMessage.class, kifpoolOuterClass$RequestVerifyPurchaseMessage);
    }

    private KifpoolOuterClass$RequestVerifyPurchaseMessage() {
    }

    private void clearHistoryId() {
        this.historyId_ = null;
        this.bitField0_ &= -2;
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeHistoryId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.historyId_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.historyId_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.historyId_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.historyId_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHistoryId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.historyId_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestVerifyPurchaseMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "historyId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestVerifyPurchaseMessage.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getHistoryId() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.historyId_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasHistoryId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestVerifyPurchaseMessage kifpoolOuterClass$RequestVerifyPurchaseMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestVerifyPurchaseMessage);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestVerifyPurchaseMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
