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
public final class MarketOuterClass$RequestGetTags extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 1;
    private static final MarketOuterClass$RequestGetTags DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int categoryId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetTags.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetTags marketOuterClass$RequestGetTags = new MarketOuterClass$RequestGetTags();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetTags;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetTags.class, marketOuterClass$RequestGetTags);
    }

    private MarketOuterClass$RequestGetTags() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    public static MarketOuterClass$RequestGetTags getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetTags parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetTags();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"categoryId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetTags.class) {
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

    public int getCategoryId() {
        return this.categoryId_;
    }

    public static a newBuilder(MarketOuterClass$RequestGetTags marketOuterClass$RequestGetTags) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetTags);
    }

    public static MarketOuterClass$RequestGetTags parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetTags parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
