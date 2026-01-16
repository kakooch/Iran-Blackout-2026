package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestSetMarketBanners extends GeneratedMessageLite implements U64 {
    public static final int BANNERS_FIELD_NUMBER = 1;
    private static final MarketOuterClass$RequestSetMarketBanners DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j banners_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestSetMarketBanners.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestSetMarketBanners marketOuterClass$RequestSetMarketBanners = new MarketOuterClass$RequestSetMarketBanners();
        DEFAULT_INSTANCE = marketOuterClass$RequestSetMarketBanners;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestSetMarketBanners.class, marketOuterClass$RequestSetMarketBanners);
    }

    private MarketOuterClass$RequestSetMarketBanners() {
    }

    private void addAllBanners(Iterable<? extends MarketStruct$MarketBanner> iterable) {
        ensureBannersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.banners_);
    }

    private void addBanners(MarketStruct$MarketBanner marketStruct$MarketBanner) {
        marketStruct$MarketBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(marketStruct$MarketBanner);
    }

    private void clearBanners() {
        this.banners_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBannersIsMutable() {
        B.j jVar = this.banners_;
        if (jVar.u()) {
            return;
        }
        this.banners_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$RequestSetMarketBanners getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestSetMarketBanners parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBanners(int i) {
        ensureBannersIsMutable();
        this.banners_.remove(i);
    }

    private void setBanners(int i, MarketStruct$MarketBanner marketStruct$MarketBanner) {
        marketStruct$MarketBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.set(i, marketStruct$MarketBanner);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestSetMarketBanners();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"banners_", MarketStruct$MarketBanner.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestSetMarketBanners.class) {
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

    public MarketStruct$MarketBanner getBanners(int i) {
        return (MarketStruct$MarketBanner) this.banners_.get(i);
    }

    public int getBannersCount() {
        return this.banners_.size();
    }

    public List<MarketStruct$MarketBanner> getBannersList() {
        return this.banners_;
    }

    public AT3 getBannersOrBuilder(int i) {
        return (AT3) this.banners_.get(i);
    }

    public List<? extends AT3> getBannersOrBuilderList() {
        return this.banners_;
    }

    public static a newBuilder(MarketOuterClass$RequestSetMarketBanners marketOuterClass$RequestSetMarketBanners) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestSetMarketBanners);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBanners(int i, MarketStruct$MarketBanner marketStruct$MarketBanner) {
        marketStruct$MarketBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(i, marketStruct$MarketBanner);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestSetMarketBanners parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestSetMarketBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
