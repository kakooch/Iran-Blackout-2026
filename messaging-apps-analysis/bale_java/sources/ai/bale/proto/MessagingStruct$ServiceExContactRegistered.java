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
public final class MessagingStruct$ServiceExContactRegistered extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExContactRegistered DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExContactRegistered.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExContactRegistered messagingStruct$ServiceExContactRegistered = new MessagingStruct$ServiceExContactRegistered();
        DEFAULT_INSTANCE = messagingStruct$ServiceExContactRegistered;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExContactRegistered.class, messagingStruct$ServiceExContactRegistered);
    }

    private MessagingStruct$ServiceExContactRegistered() {
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static MessagingStruct$ServiceExContactRegistered getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExContactRegistered parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExContactRegistered();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"uid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExContactRegistered.class) {
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

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(MessagingStruct$ServiceExContactRegistered messagingStruct$ServiceExContactRegistered) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExContactRegistered);
    }

    public static MessagingStruct$ServiceExContactRegistered parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExContactRegistered parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
