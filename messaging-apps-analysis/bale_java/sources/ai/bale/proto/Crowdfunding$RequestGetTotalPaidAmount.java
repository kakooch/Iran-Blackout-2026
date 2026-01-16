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
public final class Crowdfunding$RequestGetTotalPaidAmount extends GeneratedMessageLite implements U64 {
    private static final Crowdfunding$RequestGetTotalPaidAmount DEFAULT_INSTANCE;
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier messageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$HistoryMessageIdentifier.a aVar) {
            q();
            ((Crowdfunding$RequestGetTotalPaidAmount) this.b).setMessageId((MessagingStruct$HistoryMessageIdentifier) aVar.a());
            return this;
        }

        private a() {
            super(Crowdfunding$RequestGetTotalPaidAmount.DEFAULT_INSTANCE);
        }
    }

    static {
        Crowdfunding$RequestGetTotalPaidAmount crowdfunding$RequestGetTotalPaidAmount = new Crowdfunding$RequestGetTotalPaidAmount();
        DEFAULT_INSTANCE = crowdfunding$RequestGetTotalPaidAmount;
        GeneratedMessageLite.registerDefaultInstance(Crowdfunding$RequestGetTotalPaidAmount.class, crowdfunding$RequestGetTotalPaidAmount);
    }

    private Crowdfunding$RequestGetTotalPaidAmount() {
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    public static Crowdfunding$RequestGetTotalPaidAmount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.messageId_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.messageId_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.messageId_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.messageId_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseDelimitedFrom(InputStream inputStream) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(ByteBuffer byteBuffer) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.messageId_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K.a[gVar.ordinal()]) {
            case 1:
                return new Crowdfunding$RequestGetTotalPaidAmount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Crowdfunding$RequestGetTotalPaidAmount.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getMessageId() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.messageId_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Crowdfunding$RequestGetTotalPaidAmount crowdfunding$RequestGetTotalPaidAmount) {
        return (a) DEFAULT_INSTANCE.createBuilder(crowdfunding$RequestGetTotalPaidAmount);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(AbstractC2383g abstractC2383g) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(byte[] bArr) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(byte[] bArr, C2394s c2394s) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(InputStream inputStream) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(AbstractC2384h abstractC2384h) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Crowdfunding$RequestGetTotalPaidAmount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Crowdfunding$RequestGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
