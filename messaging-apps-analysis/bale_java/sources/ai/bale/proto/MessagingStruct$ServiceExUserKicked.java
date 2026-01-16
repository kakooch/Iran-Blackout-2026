package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExUserKicked extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExUserKicked DEFAULT_INSTANCE;
    public static final int KICKED_UID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int kickedUid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExUserKicked.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExUserKicked messagingStruct$ServiceExUserKicked = new MessagingStruct$ServiceExUserKicked();
        DEFAULT_INSTANCE = messagingStruct$ServiceExUserKicked;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExUserKicked.class, messagingStruct$ServiceExUserKicked);
    }

    private MessagingStruct$ServiceExUserKicked() {
    }

    private void clearKickedUid() {
        this.kickedUid_ = 0;
    }

    public static MessagingStruct$ServiceExUserKicked getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExUserKicked parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKickedUid(int i) {
        this.kickedUid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExUserKicked();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"kickedUid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExUserKicked.class) {
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

    public int getKickedUid() {
        return this.kickedUid_;
    }

    public static a newBuilder(MessagingStruct$ServiceExUserKicked messagingStruct$ServiceExUserKicked) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExUserKicked);
    }

    public static MessagingStruct$ServiceExUserKicked parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExUserKicked parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserKicked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
