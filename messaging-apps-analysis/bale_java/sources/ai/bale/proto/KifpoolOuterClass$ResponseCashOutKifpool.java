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
public final class KifpoolOuterClass$ResponseCashOutKifpool extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseCashOutKifpool DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REFERENCE_NO_FIELD_NUMBER = 1;
    private long referenceNo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseCashOutKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseCashOutKifpool kifpoolOuterClass$ResponseCashOutKifpool = new KifpoolOuterClass$ResponseCashOutKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseCashOutKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseCashOutKifpool.class, kifpoolOuterClass$ResponseCashOutKifpool);
    }

    private KifpoolOuterClass$ResponseCashOutKifpool() {
    }

    private void clearReferenceNo() {
        this.referenceNo_ = 0L;
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReferenceNo(long j) {
        this.referenceNo_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseCashOutKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"referenceNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseCashOutKifpool.class) {
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

    public long getReferenceNo() {
        return this.referenceNo_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseCashOutKifpool kifpoolOuterClass$ResponseCashOutKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseCashOutKifpool);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseCashOutKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
