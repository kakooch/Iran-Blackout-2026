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
public final class MessagingStruct$ServiceExNewUserWelcome extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExNewUserWelcome DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExNewUserWelcome.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExNewUserWelcome messagingStruct$ServiceExNewUserWelcome = new MessagingStruct$ServiceExNewUserWelcome();
        DEFAULT_INSTANCE = messagingStruct$ServiceExNewUserWelcome;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExNewUserWelcome.class, messagingStruct$ServiceExNewUserWelcome);
    }

    private MessagingStruct$ServiceExNewUserWelcome() {
    }

    public static MessagingStruct$ServiceExNewUserWelcome getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExNewUserWelcome();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExNewUserWelcome.class) {
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

    public static a newBuilder(MessagingStruct$ServiceExNewUserWelcome messagingStruct$ServiceExNewUserWelcome) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExNewUserWelcome);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExNewUserWelcome parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExNewUserWelcome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
