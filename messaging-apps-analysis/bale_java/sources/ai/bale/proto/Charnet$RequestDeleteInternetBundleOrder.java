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
public final class Charnet$RequestDeleteInternetBundleOrder extends GeneratedMessageLite implements U64 {
    private static final Charnet$RequestDeleteInternetBundleOrder DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestDeleteInternetBundleOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestDeleteInternetBundleOrder charnet$RequestDeleteInternetBundleOrder = new Charnet$RequestDeleteInternetBundleOrder();
        DEFAULT_INSTANCE = charnet$RequestDeleteInternetBundleOrder;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestDeleteInternetBundleOrder.class, charnet$RequestDeleteInternetBundleOrder);
    }

    private Charnet$RequestDeleteInternetBundleOrder() {
    }

    private void clearOrderId() {
        this.orderId_ = 0L;
    }

    public static Charnet$RequestDeleteInternetBundleOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderId(long j) {
        this.orderId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestDeleteInternetBundleOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestDeleteInternetBundleOrder.class) {
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

    public long getOrderId() {
        return this.orderId_;
    }

    public static a newBuilder(Charnet$RequestDeleteInternetBundleOrder charnet$RequestDeleteInternetBundleOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestDeleteInternetBundleOrder);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(byte[] bArr) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(InputStream inputStream) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestDeleteInternetBundleOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestDeleteInternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
