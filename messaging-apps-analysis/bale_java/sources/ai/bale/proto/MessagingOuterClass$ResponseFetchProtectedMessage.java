package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageContainer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseFetchProtectedMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseFetchProtectedMessage DEFAULT_INSTANCE;
    public static final int HISTORY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$MessageContainer history_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseFetchProtectedMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseFetchProtectedMessage messagingOuterClass$ResponseFetchProtectedMessage = new MessagingOuterClass$ResponseFetchProtectedMessage();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseFetchProtectedMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseFetchProtectedMessage.class, messagingOuterClass$ResponseFetchProtectedMessage);
    }

    private MessagingOuterClass$ResponseFetchProtectedMessage() {
    }

    private void clearHistory() {
        this.history_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeHistory(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.history_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.history_ = messagingStruct$MessageContainer;
        } else {
            this.history_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.history_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHistory(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.history_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseFetchProtectedMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "history_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseFetchProtectedMessage.class) {
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

    public MessagingStruct$MessageContainer getHistory() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.history_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    public boolean hasHistory() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$ResponseFetchProtectedMessage messagingOuterClass$ResponseFetchProtectedMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseFetchProtectedMessage);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseFetchProtectedMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseFetchProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
