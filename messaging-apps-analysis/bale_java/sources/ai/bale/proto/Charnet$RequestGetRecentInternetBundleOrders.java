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
public final class Charnet$RequestGetRecentInternetBundleOrders extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final Charnet$RequestGetRecentInternetBundleOrders DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int count_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestGetRecentInternetBundleOrders.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestGetRecentInternetBundleOrders charnet$RequestGetRecentInternetBundleOrders = new Charnet$RequestGetRecentInternetBundleOrders();
        DEFAULT_INSTANCE = charnet$RequestGetRecentInternetBundleOrders;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestGetRecentInternetBundleOrders.class, charnet$RequestGetRecentInternetBundleOrders);
    }

    private Charnet$RequestGetRecentInternetBundleOrders() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    public static Charnet$RequestGetRecentInternetBundleOrders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestGetRecentInternetBundleOrders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestGetRecentInternetBundleOrders.class) {
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

    public int getCount() {
        return this.count_;
    }

    public static a newBuilder(Charnet$RequestGetRecentInternetBundleOrders charnet$RequestGetRecentInternetBundleOrders) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestGetRecentInternetBundleOrders);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(byte[] bArr) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(InputStream inputStream) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestGetRecentInternetBundleOrders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestGetRecentInternetBundleOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
