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
public final class MarketOuterClass$RequestRejectMarketJoinRequest extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestRejectMarketJoinRequest DEFAULT_INSTANCE;
    public static final int MARKET_PEER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REJECT_CAUSE_FIELD_NUMBER = 2;
    public static final int REQUEST_ID_FIELD_NUMBER = 3;
    private int marketPeerId_;
    private int rejectCause_;
    private int requestId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestRejectMarketJoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestRejectMarketJoinRequest marketOuterClass$RequestRejectMarketJoinRequest = new MarketOuterClass$RequestRejectMarketJoinRequest();
        DEFAULT_INSTANCE = marketOuterClass$RequestRejectMarketJoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestRejectMarketJoinRequest.class, marketOuterClass$RequestRejectMarketJoinRequest);
    }

    private MarketOuterClass$RequestRejectMarketJoinRequest() {
    }

    private void clearMarketPeerId() {
        this.marketPeerId_ = 0;
    }

    private void clearRejectCause() {
        this.rejectCause_ = 0;
    }

    private void clearRequestId() {
        this.requestId_ = 0;
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMarketPeerId(int i) {
        this.marketPeerId_ = i;
    }

    private void setRejectCause(int i) {
        this.rejectCause_ = i;
    }

    private void setRequestId(int i) {
        this.requestId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestRejectMarketJoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"marketPeerId_", "rejectCause_", "requestId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestRejectMarketJoinRequest.class) {
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

    public int getMarketPeerId() {
        return this.marketPeerId_;
    }

    public int getRejectCause() {
        return this.rejectCause_;
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public static a newBuilder(MarketOuterClass$RequestRejectMarketJoinRequest marketOuterClass$RequestRejectMarketJoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestRejectMarketJoinRequest);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestRejectMarketJoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
