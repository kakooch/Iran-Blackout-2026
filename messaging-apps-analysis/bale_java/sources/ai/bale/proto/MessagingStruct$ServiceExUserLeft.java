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
public final class MessagingStruct$ServiceExUserLeft extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExUserLeft DEFAULT_INSTANCE;
    public static final int LEFT_UID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int leftUid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExUserLeft.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExUserLeft messagingStruct$ServiceExUserLeft = new MessagingStruct$ServiceExUserLeft();
        DEFAULT_INSTANCE = messagingStruct$ServiceExUserLeft;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExUserLeft.class, messagingStruct$ServiceExUserLeft);
    }

    private MessagingStruct$ServiceExUserLeft() {
    }

    private void clearLeftUid() {
        this.leftUid_ = 0;
    }

    public static MessagingStruct$ServiceExUserLeft getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExUserLeft parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLeftUid(int i) {
        this.leftUid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExUserLeft();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"leftUid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExUserLeft.class) {
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

    public int getLeftUid() {
        return this.leftUid_;
    }

    public static a newBuilder(MessagingStruct$ServiceExUserLeft messagingStruct$ServiceExUserLeft) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExUserLeft);
    }

    public static MessagingStruct$ServiceExUserLeft parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExUserLeft parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserLeft) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
