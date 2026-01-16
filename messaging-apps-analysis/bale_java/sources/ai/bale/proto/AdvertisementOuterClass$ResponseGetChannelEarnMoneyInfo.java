package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo extends GeneratedMessageLite implements U64 {
    public static final int AD_COUNT_FIELD_NUMBER = 3;
    public static final int AD_COUNT_UPDATE_DATE_FIELD_NUMBER = 4;
    public static final int CURRENT_MONTH_INCOME_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo DEFAULT_INSTANCE;
    public static final int NOT_PAID_INCOME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long adCountUpdateDate_;
    private long adCount_;
    private double currentMonthIncome_;
    private double notPaidIncome_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo advertisementOuterClass$ResponseGetChannelEarnMoneyInfo = new AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelEarnMoneyInfo;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.class, advertisementOuterClass$ResponseGetChannelEarnMoneyInfo);
    }

    private AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo() {
    }

    private void clearAdCount() {
        this.adCount_ = 0L;
    }

    private void clearAdCountUpdateDate() {
        this.adCountUpdateDate_ = 0L;
    }

    private void clearCurrentMonthIncome() {
        this.currentMonthIncome_ = 0.0d;
    }

    private void clearNotPaidIncome() {
        this.notPaidIncome_ = 0.0d;
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdCount(long j) {
        this.adCount_ = j;
    }

    private void setAdCountUpdateDate(long j) {
        this.adCountUpdateDate_ = j;
    }

    private void setCurrentMonthIncome(double d) {
        this.currentMonthIncome_ = d;
    }

    private void setNotPaidIncome(double d) {
        this.notPaidIncome_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0000\u0002\u0000\u0003\u0002\u0004\u0002", new Object[]{"currentMonthIncome_", "notPaidIncome_", "adCount_", "adCountUpdateDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.class) {
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

    public long getAdCount() {
        return this.adCount_;
    }

    public long getAdCountUpdateDate() {
        return this.adCountUpdateDate_;
    }

    public double getCurrentMonthIncome() {
        return this.currentMonthIncome_;
    }

    public double getNotPaidIncome() {
        return this.notPaidIncome_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo advertisementOuterClass$ResponseGetChannelEarnMoneyInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelEarnMoneyInfo);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
