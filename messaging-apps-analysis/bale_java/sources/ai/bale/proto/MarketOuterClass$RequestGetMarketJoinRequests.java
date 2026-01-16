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
public final class MarketOuterClass$RequestGetMarketJoinRequests extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestGetMarketJoinRequests DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetMarketJoinRequests.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetMarketJoinRequests marketOuterClass$RequestGetMarketJoinRequests = new MarketOuterClass$RequestGetMarketJoinRequests();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetMarketJoinRequests;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetMarketJoinRequests.class, marketOuterClass$RequestGetMarketJoinRequests);
    }

    private MarketOuterClass$RequestGetMarketJoinRequests() {
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetMarketJoinRequests();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetMarketJoinRequests.class) {
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

    public static a newBuilder(MarketOuterClass$RequestGetMarketJoinRequests marketOuterClass$RequestGetMarketJoinRequests) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetMarketJoinRequests);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetMarketJoinRequests parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
