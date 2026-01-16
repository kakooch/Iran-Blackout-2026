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
public final class PushOuterClass$ResponseRegisterPush extends GeneratedMessageLite implements U64 {
    private static final PushOuterClass$ResponseRegisterPush DEFAULT_INSTANCE;
    public static final int ENCRYPTION_KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private AbstractC2383g encryptionKey_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushOuterClass$ResponseRegisterPush.DEFAULT_INSTANCE);
        }
    }

    static {
        PushOuterClass$ResponseRegisterPush pushOuterClass$ResponseRegisterPush = new PushOuterClass$ResponseRegisterPush();
        DEFAULT_INSTANCE = pushOuterClass$ResponseRegisterPush;
        GeneratedMessageLite.registerDefaultInstance(PushOuterClass$ResponseRegisterPush.class, pushOuterClass$ResponseRegisterPush);
    }

    private PushOuterClass$ResponseRegisterPush() {
    }

    private void clearEncryptionKey() {
        this.encryptionKey_ = getDefaultInstance().getEncryptionKey();
    }

    public static PushOuterClass$ResponseRegisterPush getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushOuterClass$ResponseRegisterPush parseDelimitedFrom(InputStream inputStream) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(ByteBuffer byteBuffer) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEncryptionKey(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.encryptionKey_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1878n1.a[gVar.ordinal()]) {
            case 1:
                return new PushOuterClass$ResponseRegisterPush();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"encryptionKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushOuterClass$ResponseRegisterPush.class) {
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

    public AbstractC2383g getEncryptionKey() {
        return this.encryptionKey_;
    }

    public static a newBuilder(PushOuterClass$ResponseRegisterPush pushOuterClass$ResponseRegisterPush) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushOuterClass$ResponseRegisterPush);
    }

    public static PushOuterClass$ResponseRegisterPush parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(AbstractC2383g abstractC2383g) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(byte[] bArr) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(InputStream inputStream) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(AbstractC2384h abstractC2384h) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushOuterClass$ResponseRegisterPush parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushOuterClass$ResponseRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
