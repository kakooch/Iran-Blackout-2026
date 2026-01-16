package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestGetCategories extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 1;
    private static final MarketOuterClass$RequestGetCategories DEFAULT_INSTANCE;
    public static final int INCLUDE_SAMPLE_MARKETS_FIELD_NUMBER = 3;
    public static final int LEVEL_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private int categoryId_;
    private CollectionsStruct$BooleanValue includeSampleMarkets_;
    private CollectionsStruct$Int32Value level_;
    private CollectionsStruct$Int32Value version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MarketOuterClass$RequestGetCategories) this.b).setCategoryId(i);
            return this;
        }

        public a B(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
            q();
            ((MarketOuterClass$RequestGetCategories) this.b).setIncludeSampleMarkets(collectionsStruct$BooleanValue);
            return this;
        }

        public a C(CollectionsStruct$Int32Value.a aVar) {
            q();
            ((MarketOuterClass$RequestGetCategories) this.b).setLevel((CollectionsStruct$Int32Value) aVar.a());
            return this;
        }

        public a D(CollectionsStruct$Int32Value.a aVar) {
            q();
            ((MarketOuterClass$RequestGetCategories) this.b).setVersion((CollectionsStruct$Int32Value) aVar.a());
            return this;
        }

        private a() {
            super(MarketOuterClass$RequestGetCategories.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetCategories marketOuterClass$RequestGetCategories = new MarketOuterClass$RequestGetCategories();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetCategories;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetCategories.class, marketOuterClass$RequestGetCategories);
    }

    private MarketOuterClass$RequestGetCategories() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearIncludeSampleMarkets() {
        this.includeSampleMarkets_ = null;
        this.bitField0_ &= -3;
    }

    private void clearLevel() {
        this.level_ = null;
        this.bitField0_ &= -2;
    }

    private void clearVersion() {
        this.version_ = null;
        this.bitField0_ &= -5;
    }

    public static MarketOuterClass$RequestGetCategories getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIncludeSampleMarkets(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.includeSampleMarkets_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.includeSampleMarkets_ = collectionsStruct$BooleanValue;
        } else {
            this.includeSampleMarkets_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.includeSampleMarkets_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeLevel(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.level_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.level_ = collectionsStruct$Int32Value;
        } else {
            this.level_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.level_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeVersion(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.version_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.version_ = collectionsStruct$Int32Value;
        } else {
            this.version_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.version_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetCategories parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeSampleMarkets(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.includeSampleMarkets_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLevel(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.level_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.version_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetCategories();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "categoryId_", "level_", "includeSampleMarkets_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetCategories.class) {
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

    public CollectionsStruct$BooleanValue getIncludeSampleMarkets() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.includeSampleMarkets_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public CollectionsStruct$Int32Value getLevel() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.level_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public CollectionsStruct$Int32Value getVersion() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.version_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public boolean hasIncludeSampleMarkets() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLevel() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(MarketOuterClass$RequestGetCategories marketOuterClass$RequestGetCategories) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetCategories);
    }

    public static MarketOuterClass$RequestGetCategories parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetCategories parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
