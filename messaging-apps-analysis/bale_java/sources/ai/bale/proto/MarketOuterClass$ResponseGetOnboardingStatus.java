package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10336bU3;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.UT3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetOnboardingStatus extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_IDS_FIELD_NUMBER = 2;
    private static final MarketOuterClass$ResponseGetOnboardingStatus DEFAULT_INSTANCE;
    public static final int GENDER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int categoryIdsMemoizedSerializedSize = -1;
    private B.g categoryIds_ = GeneratedMessageLite.emptyIntList();
    private int gender_;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetOnboardingStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetOnboardingStatus marketOuterClass$ResponseGetOnboardingStatus = new MarketOuterClass$ResponseGetOnboardingStatus();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetOnboardingStatus;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetOnboardingStatus.class, marketOuterClass$ResponseGetOnboardingStatus);
    }

    private MarketOuterClass$ResponseGetOnboardingStatus() {
    }

    private void addAllCategoryIds(Iterable<? extends Integer> iterable) {
        ensureCategoryIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categoryIds_);
    }

    private void addCategoryIds(int i) {
        ensureCategoryIdsIsMutable();
        this.categoryIds_.b1(i);
    }

    private void clearCategoryIds() {
        this.categoryIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearGender() {
        this.gender_ = 0;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void ensureCategoryIdsIsMutable() {
        B.g gVar = this.categoryIds_;
        if (gVar.u()) {
            return;
        }
        this.categoryIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryIds(int i, int i2) {
        ensureCategoryIdsIsMutable();
        this.categoryIds_.U(i, i2);
    }

    private void setGender(EnumC10336bU3 enumC10336bU3) {
        this.gender_ = enumC10336bU3.getNumber();
    }

    private void setGenderValue(int i) {
        this.gender_ = i;
    }

    private void setStatus(UT3 ut3) {
        this.status_ = ut3.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetOnboardingStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002'\u0003\f", new Object[]{"status_", "categoryIds_", "gender_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetOnboardingStatus.class) {
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

    public UT3 getStatus() {
        UT3 ut3J = UT3.j(this.status_);
        return ut3J == null ? UT3.UNRECOGNIZED : ut3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetOnboardingStatus marketOuterClass$ResponseGetOnboardingStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetOnboardingStatus);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetOnboardingStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
