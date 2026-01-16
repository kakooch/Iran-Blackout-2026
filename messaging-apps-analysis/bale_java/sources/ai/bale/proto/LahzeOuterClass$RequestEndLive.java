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
public final class LahzeOuterClass$RequestEndLive extends GeneratedMessageLite implements U64 {
    private static final LahzeOuterClass$RequestEndLive DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long key_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LahzeOuterClass$RequestEndLive.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeOuterClass$RequestEndLive lahzeOuterClass$RequestEndLive = new LahzeOuterClass$RequestEndLive();
        DEFAULT_INSTANCE = lahzeOuterClass$RequestEndLive;
        GeneratedMessageLite.registerDefaultInstance(LahzeOuterClass$RequestEndLive.class, lahzeOuterClass$RequestEndLive);
    }

    private LahzeOuterClass$RequestEndLive() {
    }

    private void clearKey() {
        this.key_ = 0L;
    }

    public static LahzeOuterClass$RequestEndLive getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeOuterClass$RequestEndLive parseDelimitedFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(ByteBuffer byteBuffer) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKey(long j) {
        this.key_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1903w0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeOuterClass$RequestEndLive();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"key_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeOuterClass$RequestEndLive.class) {
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

    public long getKey() {
        return this.key_;
    }

    public static a newBuilder(LahzeOuterClass$RequestEndLive lahzeOuterClass$RequestEndLive) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeOuterClass$RequestEndLive);
    }

    public static LahzeOuterClass$RequestEndLive parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(byte[] bArr) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeOuterClass$RequestEndLive parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeOuterClass$RequestEndLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
