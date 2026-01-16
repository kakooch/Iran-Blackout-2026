package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.WT3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestSetPopularSearches extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestSetPopularSearches DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestSetPopularSearches.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestSetPopularSearches marketOuterClass$RequestSetPopularSearches = new MarketOuterClass$RequestSetPopularSearches();
        DEFAULT_INSTANCE = marketOuterClass$RequestSetPopularSearches;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestSetPopularSearches.class, marketOuterClass$RequestSetPopularSearches);
    }

    private MarketOuterClass$RequestSetPopularSearches() {
    }

    private void addAllItems(Iterable<? extends MarketStruct$PopularSearchItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(MarketStruct$PopularSearchItem marketStruct$PopularSearchItem) {
        marketStruct$PopularSearchItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(marketStruct$PopularSearchItem);
    }

    private void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$RequestSetPopularSearches getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestSetPopularSearches parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setItems(int i, MarketStruct$PopularSearchItem marketStruct$PopularSearchItem) {
        marketStruct$PopularSearchItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, marketStruct$PopularSearchItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestSetPopularSearches();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", MarketStruct$PopularSearchItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestSetPopularSearches.class) {
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

    public MarketStruct$PopularSearchItem getItems(int i) {
        return (MarketStruct$PopularSearchItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<MarketStruct$PopularSearchItem> getItemsList() {
        return this.items_;
    }

    public WT3 getItemsOrBuilder(int i) {
        return (WT3) this.items_.get(i);
    }

    public List<? extends WT3> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(MarketOuterClass$RequestSetPopularSearches marketOuterClass$RequestSetPopularSearches) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestSetPopularSearches);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, MarketStruct$PopularSearchItem marketStruct$PopularSearchItem) {
        marketStruct$PopularSearchItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, marketStruct$PopularSearchItem);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestSetPopularSearches parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestSetPopularSearches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
