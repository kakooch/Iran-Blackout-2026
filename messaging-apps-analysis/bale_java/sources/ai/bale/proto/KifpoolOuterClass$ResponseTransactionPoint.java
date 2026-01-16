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
public final class KifpoolOuterClass$ResponseTransactionPoint extends GeneratedMessageLite implements U64 {
    public static final int CALCULATEDPOINT_FIELD_NUMBER = 1;
    private static final KifpoolOuterClass$ResponseTransactionPoint DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POINT_FIELD_NUMBER = 2;
    public static final int UNITAMOUNT_FIELD_NUMBER = 3;
    private long calculatedPoint_;
    private long point_;
    private long unitAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseTransactionPoint.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseTransactionPoint kifpoolOuterClass$ResponseTransactionPoint = new KifpoolOuterClass$ResponseTransactionPoint();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseTransactionPoint;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseTransactionPoint.class, kifpoolOuterClass$ResponseTransactionPoint);
    }

    private KifpoolOuterClass$ResponseTransactionPoint() {
    }

    private void clearCalculatedPoint() {
        this.calculatedPoint_ = 0L;
    }

    private void clearPoint() {
        this.point_ = 0L;
    }

    private void clearUnitAmount() {
        this.unitAmount_ = 0L;
    }

    public static KifpoolOuterClass$ResponseTransactionPoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalculatedPoint(long j) {
        this.calculatedPoint_ = j;
    }

    private void setPoint(long j) {
        this.point_ = j;
    }

    private void setUnitAmount(long j) {
        this.unitAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseTransactionPoint();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002", new Object[]{"calculatedPoint_", "point_", "unitAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseTransactionPoint.class) {
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

    public long getCalculatedPoint() {
        return this.calculatedPoint_;
    }

    public long getPoint() {
        return this.point_;
    }

    public long getUnitAmount() {
        return this.unitAmount_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseTransactionPoint kifpoolOuterClass$ResponseTransactionPoint) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseTransactionPoint);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseTransactionPoint parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
