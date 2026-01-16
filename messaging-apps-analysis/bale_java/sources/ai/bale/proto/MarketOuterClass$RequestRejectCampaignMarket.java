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
public final class MarketOuterClass$RequestRejectCampaignMarket extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestRejectCampaignMarket DEFAULT_INSTANCE;
    public static final int IS_PERMANENT_FIELD_NUMBER = 2;
    public static final int MARKET_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isPermanent_;
    private int marketId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestRejectCampaignMarket.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestRejectCampaignMarket marketOuterClass$RequestRejectCampaignMarket = new MarketOuterClass$RequestRejectCampaignMarket();
        DEFAULT_INSTANCE = marketOuterClass$RequestRejectCampaignMarket;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestRejectCampaignMarket.class, marketOuterClass$RequestRejectCampaignMarket);
    }

    private MarketOuterClass$RequestRejectCampaignMarket() {
    }

    private void clearIsPermanent() {
        this.isPermanent_ = false;
    }

    private void clearMarketId() {
        this.marketId_ = 0;
    }

    public static MarketOuterClass$RequestRejectCampaignMarket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsPermanent(boolean z) {
        this.isPermanent_ = z;
    }

    private void setMarketId(int i) {
        this.marketId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestRejectCampaignMarket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0007", new Object[]{"marketId_", "isPermanent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestRejectCampaignMarket.class) {
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

    public boolean getIsPermanent() {
        return this.isPermanent_;
    }

    public int getMarketId() {
        return this.marketId_;
    }

    public static a newBuilder(MarketOuterClass$RequestRejectCampaignMarket marketOuterClass$RequestRejectCampaignMarket) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestRejectCampaignMarket);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestRejectCampaignMarket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestRejectCampaignMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
