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
public final class Crowdfunding$RequestGetParticipants extends GeneratedMessageLite implements U64 {
    private static final Crowdfunding$RequestGetParticipants DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 3;
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    public static final int OFFSET_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int limit_;
    private MessagingStruct$HistoryMessageIdentifier messageId_;
    private int offset_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Crowdfunding$RequestGetParticipants.DEFAULT_INSTANCE);
        }
    }

    static {
        Crowdfunding$RequestGetParticipants crowdfunding$RequestGetParticipants = new Crowdfunding$RequestGetParticipants();
        DEFAULT_INSTANCE = crowdfunding$RequestGetParticipants;
        GeneratedMessageLite.registerDefaultInstance(Crowdfunding$RequestGetParticipants.class, crowdfunding$RequestGetParticipants);
    }

    private Crowdfunding$RequestGetParticipants() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOffset() {
        this.offset_ = 0;
    }

    public static Crowdfunding$RequestGetParticipants getDefaultInstance() {
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

    public static Crowdfunding$RequestGetParticipants parseDelimitedFrom(InputStream inputStream) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(ByteBuffer byteBuffer) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    private void setMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.messageId_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    private void setOffset(int i) {
        this.offset_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K.a[gVar.ordinal()]) {
            case 1:
                return new Crowdfunding$RequestGetParticipants();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0003\u0004\u0004\u0004", new Object[]{"bitField0_", "messageId_", "limit_", "offset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Crowdfunding$RequestGetParticipants.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public MessagingStruct$HistoryMessageIdentifier getMessageId() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.messageId_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public int getOffset() {
        return this.offset_;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Crowdfunding$RequestGetParticipants crowdfunding$RequestGetParticipants) {
        return (a) DEFAULT_INSTANCE.createBuilder(crowdfunding$RequestGetParticipants);
    }

    public static Crowdfunding$RequestGetParticipants parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(AbstractC2383g abstractC2383g) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(byte[] bArr) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(byte[] bArr, C2394s c2394s) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(InputStream inputStream) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(AbstractC2384h abstractC2384h) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Crowdfunding$RequestGetParticipants parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Crowdfunding$RequestGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
