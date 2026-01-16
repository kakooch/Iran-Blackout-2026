package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketMenu;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AT3;
import ir.nasim.CT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketPanel extends GeneratedMessageLite implements U64 {
    public static final int BANNER_FIELD_NUMBER = 1;
    private static final MarketStruct$MarketPanel DEFAULT_INSTANCE;
    public static final int MENU_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int ROWS_FIELD_NUMBER = 3;
    private int bitField0_;
    private MarketStruct$MarketMenu menu_;
    private B.j banner_ = GeneratedMessageLite.emptyProtobufList();
    private B.j rows_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketStruct$MarketPanel.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketPanel marketStruct$MarketPanel = new MarketStruct$MarketPanel();
        DEFAULT_INSTANCE = marketStruct$MarketPanel;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketPanel.class, marketStruct$MarketPanel);
    }

    private MarketStruct$MarketPanel() {
    }

    private void addAllBanner(Iterable<? extends MarketStruct$MarketBanner> iterable) {
        ensureBannerIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.banner_);
    }

    private void addAllRows(Iterable<? extends MarketStruct$MarketCategory> iterable) {
        ensureRowsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rows_);
    }

    private void addBanner(MarketStruct$MarketBanner marketStruct$MarketBanner) {
        marketStruct$MarketBanner.getClass();
        ensureBannerIsMutable();
        this.banner_.add(marketStruct$MarketBanner);
    }

    private void addRows(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        ensureRowsIsMutable();
        this.rows_.add(marketStruct$MarketCategory);
    }

    private void clearBanner() {
        this.banner_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMenu() {
        this.menu_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRows() {
        this.rows_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBannerIsMutable() {
        B.j jVar = this.banner_;
        if (jVar.u()) {
            return;
        }
        this.banner_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRowsIsMutable() {
        B.j jVar = this.rows_;
        if (jVar.u()) {
            return;
        }
        this.rows_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketStruct$MarketPanel getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMenu(MarketStruct$MarketMenu marketStruct$MarketMenu) {
        marketStruct$MarketMenu.getClass();
        MarketStruct$MarketMenu marketStruct$MarketMenu2 = this.menu_;
        if (marketStruct$MarketMenu2 == null || marketStruct$MarketMenu2 == MarketStruct$MarketMenu.getDefaultInstance()) {
            this.menu_ = marketStruct$MarketMenu;
        } else {
            this.menu_ = (MarketStruct$MarketMenu) ((MarketStruct$MarketMenu.a) MarketStruct$MarketMenu.newBuilder(this.menu_).v(marketStruct$MarketMenu)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketPanel parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketPanel parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBanner(int i) {
        ensureBannerIsMutable();
        this.banner_.remove(i);
    }

    private void removeRows(int i) {
        ensureRowsIsMutable();
        this.rows_.remove(i);
    }

    private void setBanner(int i, MarketStruct$MarketBanner marketStruct$MarketBanner) {
        marketStruct$MarketBanner.getClass();
        ensureBannerIsMutable();
        this.banner_.set(i, marketStruct$MarketBanner);
    }

    private void setMenu(MarketStruct$MarketMenu marketStruct$MarketMenu) {
        marketStruct$MarketMenu.getClass();
        this.menu_ = marketStruct$MarketMenu;
        this.bitField0_ |= 1;
    }

    private void setRows(int i, MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        ensureRowsIsMutable();
        this.rows_.set(i, marketStruct$MarketCategory);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketPanel();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002ဉ\u0000\u0003\u001b", new Object[]{"bitField0_", "banner_", MarketStruct$MarketBanner.class, "menu_", "rows_", MarketStruct$MarketCategory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketPanel.class) {
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

    public MarketStruct$MarketBanner getBanner(int i) {
        return (MarketStruct$MarketBanner) this.banner_.get(i);
    }

    public int getBannerCount() {
        return this.banner_.size();
    }

    public List<MarketStruct$MarketBanner> getBannerList() {
        return this.banner_;
    }

    public AT3 getBannerOrBuilder(int i) {
        return (AT3) this.banner_.get(i);
    }

    public List<? extends AT3> getBannerOrBuilderList() {
        return this.banner_;
    }

    public MarketStruct$MarketMenu getMenu() {
        MarketStruct$MarketMenu marketStruct$MarketMenu = this.menu_;
        return marketStruct$MarketMenu == null ? MarketStruct$MarketMenu.getDefaultInstance() : marketStruct$MarketMenu;
    }

    public MarketStruct$MarketCategory getRows(int i) {
        return (MarketStruct$MarketCategory) this.rows_.get(i);
    }

    public int getRowsCount() {
        return this.rows_.size();
    }

    public List<MarketStruct$MarketCategory> getRowsList() {
        return this.rows_;
    }

    public CT3 getRowsOrBuilder(int i) {
        return (CT3) this.rows_.get(i);
    }

    public List<? extends CT3> getRowsOrBuilderList() {
        return this.rows_;
    }

    public boolean hasMenu() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketStruct$MarketPanel marketStruct$MarketPanel) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketPanel);
    }

    public static MarketStruct$MarketPanel parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketPanel parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketPanel parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBanner(int i, MarketStruct$MarketBanner marketStruct$MarketBanner) {
        marketStruct$MarketBanner.getClass();
        ensureBannerIsMutable();
        this.banner_.add(i, marketStruct$MarketBanner);
    }

    private void addRows(int i, MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        ensureRowsIsMutable();
        this.rows_.add(i, marketStruct$MarketCategory);
    }

    public static MarketStruct$MarketPanel parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketPanel parseFrom(byte[] bArr) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketPanel parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketPanel parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketPanel parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketPanel parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketPanel parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketPanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
