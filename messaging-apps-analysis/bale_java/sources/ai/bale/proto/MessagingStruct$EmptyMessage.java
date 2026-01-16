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
public final class MessagingStruct$EmptyMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$EmptyMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$EmptyMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$EmptyMessage messagingStruct$EmptyMessage = new MessagingStruct$EmptyMessage();
        DEFAULT_INSTANCE = messagingStruct$EmptyMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$EmptyMessage.class, messagingStruct$EmptyMessage);
    }

    private MessagingStruct$EmptyMessage() {
    }

    public static MessagingStruct$EmptyMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$EmptyMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$EmptyMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$EmptyMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$EmptyMessage.class) {
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

    public static a newBuilder(MessagingStruct$EmptyMessage messagingStruct$EmptyMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$EmptyMessage);
    }

    public static MessagingStruct$EmptyMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$EmptyMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$EmptyMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$EmptyMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$EmptyMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$EmptyMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$EmptyMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$EmptyMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$EmptyMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$EmptyMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$EmptyMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
