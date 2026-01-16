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
public final class ReactionsOuterClass$RequestBindMoneyRequestDetails extends GeneratedMessageLite implements U64 {
    private static final ReactionsOuterClass$RequestBindMoneyRequestDetails DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ReactionsOuterClass$RequestBindMoneyRequestDetails.DEFAULT_INSTANCE);
        }
    }

    static {
        ReactionsOuterClass$RequestBindMoneyRequestDetails reactionsOuterClass$RequestBindMoneyRequestDetails = new ReactionsOuterClass$RequestBindMoneyRequestDetails();
        DEFAULT_INSTANCE = reactionsOuterClass$RequestBindMoneyRequestDetails;
        GeneratedMessageLite.registerDefaultInstance(ReactionsOuterClass$RequestBindMoneyRequestDetails.class, reactionsOuterClass$RequestBindMoneyRequestDetails);
    }

    private ReactionsOuterClass$RequestBindMoneyRequestDetails() {
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.message_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.message_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.message_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.message_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseDelimitedFrom(InputStream inputStream) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(ByteBuffer byteBuffer) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessage(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.message_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1889r1.a[gVar.ordinal()]) {
            case 1:
                return new ReactionsOuterClass$RequestBindMoneyRequestDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReactionsOuterClass$RequestBindMoneyRequestDetails.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getMessage() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.message_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ReactionsOuterClass$RequestBindMoneyRequestDetails reactionsOuterClass$RequestBindMoneyRequestDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(reactionsOuterClass$RequestBindMoneyRequestDetails);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(byte[] bArr) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(InputStream inputStream) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
