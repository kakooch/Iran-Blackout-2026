package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestAcceptMarketJoinRequest extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 4;
    private static final MarketOuterClass$RequestAcceptMarketJoinRequest DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 3;
    public static final int MARKET_PEER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 2;
    private int categoryId_;
    private String displayName_ = "";
    private int marketPeerId_;
    private int requestId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestAcceptMarketJoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestAcceptMarketJoinRequest marketOuterClass$RequestAcceptMarketJoinRequest = new MarketOuterClass$RequestAcceptMarketJoinRequest();
        DEFAULT_INSTANCE = marketOuterClass$RequestAcceptMarketJoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestAcceptMarketJoinRequest.class, marketOuterClass$RequestAcceptMarketJoinRequest);
    }

    private MarketOuterClass$RequestAcceptMarketJoinRequest() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    private void clearMarketPeerId() {
        this.marketPeerId_ = 0;
    }

    private void clearRequestId() {
        this.requestId_ = 0;
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    private void setDisplayNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.displayName_ = abstractC2383g.f0();
    }

    private void setMarketPeerId(int i) {
        this.marketPeerId_ = i;
    }

    private void setRequestId(int i) {
        this.requestId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestAcceptMarketJoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ\u0004\u0004", new Object[]{"marketPeerId_", "requestId_", "displayName_", "categoryId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestAcceptMarketJoinRequest.class) {
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

    public String getDisplayName() {
        return this.displayName_;
    }

    public AbstractC2383g getDisplayNameBytes() {
        return AbstractC2383g.N(this.displayName_);
    }

    public int getMarketPeerId() {
        return this.marketPeerId_;
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public static a newBuilder(MarketOuterClass$RequestAcceptMarketJoinRequest marketOuterClass$RequestAcceptMarketJoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestAcceptMarketJoinRequest);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestAcceptMarketJoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestAcceptMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
