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
public final class KifpoolOuterClass$RequestTransactionPoint extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final KifpoolOuterClass$RequestTransactionPoint DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTIONID_FIELD_NUMBER = 1;
    private long amount_;
    private int transactionID_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestTransactionPoint.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestTransactionPoint kifpoolOuterClass$RequestTransactionPoint = new KifpoolOuterClass$RequestTransactionPoint();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestTransactionPoint;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestTransactionPoint.class, kifpoolOuterClass$RequestTransactionPoint);
    }

    private KifpoolOuterClass$RequestTransactionPoint() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearTransactionID() {
        this.transactionID_ = 0;
    }

    public static KifpoolOuterClass$RequestTransactionPoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setTransactionID(int i) {
        this.transactionID_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestTransactionPoint();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"transactionID_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestTransactionPoint.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public int getTransactionID() {
        return this.transactionID_;
    }

    public static a newBuilder(KifpoolOuterClass$RequestTransactionPoint kifpoolOuterClass$RequestTransactionPoint) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestTransactionPoint);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestTransactionPoint parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransactionPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
