package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10336bU3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestSetOnboardingData extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_IDS_FIELD_NUMBER = 1;
    private static final MarketOuterClass$RequestSetOnboardingData DEFAULT_INSTANCE;
    public static final int GENDER_FIELD_NUMBER = 2;
    public static final int IS_SKIPPED_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int categoryIdsMemoizedSerializedSize = -1;
    private B.g categoryIds_ = GeneratedMessageLite.emptyIntList();
    private int gender_;
    private BoolValue isSkipped_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MarketOuterClass$RequestSetOnboardingData) this.b).addCategoryIds(i);
            return this;
        }

        public a B(EnumC10336bU3 enumC10336bU3) {
            q();
            ((MarketOuterClass$RequestSetOnboardingData) this.b).setGender(enumC10336bU3);
            return this;
        }

        public a C(BoolValue boolValue) {
            q();
            ((MarketOuterClass$RequestSetOnboardingData) this.b).setIsSkipped(boolValue);
            return this;
        }

        private a() {
            super(MarketOuterClass$RequestSetOnboardingData.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestSetOnboardingData marketOuterClass$RequestSetOnboardingData = new MarketOuterClass$RequestSetOnboardingData();
        DEFAULT_INSTANCE = marketOuterClass$RequestSetOnboardingData;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestSetOnboardingData.class, marketOuterClass$RequestSetOnboardingData);
    }

    private MarketOuterClass$RequestSetOnboardingData() {
    }

    private void addAllCategoryIds(Iterable<? extends Integer> iterable) {
        ensureCategoryIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categoryIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCategoryIds(int i) {
        ensureCategoryIdsIsMutable();
        this.categoryIds_.b1(i);
    }

    private void clearCategoryIds() {
        this.categoryIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearGender() {
        this.gender_ = 0;
    }

    private void clearIsSkipped() {
        this.isSkipped_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCategoryIdsIsMutable() {
        B.g gVar = this.categoryIds_;
        if (gVar.u()) {
            return;
        }
        this.categoryIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MarketOuterClass$RequestSetOnboardingData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsSkipped(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isSkipped_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isSkipped_ = boolValue;
        } else {
            this.isSkipped_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isSkipped_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestSetOnboardingData parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryIds(int i, int i2) {
        ensureCategoryIdsIsMutable();
        this.categoryIds_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGender(EnumC10336bU3 enumC10336bU3) {
        this.gender_ = enumC10336bU3.getNumber();
    }

    private void setGenderValue(int i) {
        this.gender_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsSkipped(BoolValue boolValue) {
        boolValue.getClass();
        this.isSkipped_ = boolValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestSetOnboardingData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001'\u0002\f\u0003ဉ\u0000", new Object[]{"bitField0_", "categoryIds_", "gender_", "isSkipped_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestSetOnboardingData.class) {
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

    public int getCategoryIds(int i) {
        return this.categoryIds_.getInt(i);
    }

    public int getCategoryIdsCount() {
        return this.categoryIds_.size();
    }

    public List<Integer> getCategoryIdsList() {
        return this.categoryIds_;
    }

    public EnumC10336bU3 getGender() {
        EnumC10336bU3 enumC10336bU3J = EnumC10336bU3.j(this.gender_);
        return enumC10336bU3J == null ? EnumC10336bU3.UNRECOGNIZED : enumC10336bU3J;
    }

    public int getGenderValue() {
        return this.gender_;
    }

    public BoolValue getIsSkipped() {
        BoolValue boolValue = this.isSkipped_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasIsSkipped() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$RequestSetOnboardingData marketOuterClass$RequestSetOnboardingData) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestSetOnboardingData);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestSetOnboardingData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestSetOnboardingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
