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
public final class PremiumStruct$QuotaExceededInfo extends GeneratedMessageLite implements U64 {
    private static final PremiumStruct$QuotaExceededInfo DEFAULT_INSTANCE;
    public static final int EXPIRATION_TIME_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PURCHASE_TIME_FIELD_NUMBER = 4;
    public static final int QUOTA_FIELD_NUMBER = 2;
    public static final int RESET_PERIOD_FIELD_NUMBER = 3;
    public static final int USED_FIELD_NUMBER = 1;
    private long expirationTime_;
    private long purchaseTime_;
    private long quota_;
    private long resetPeriod_;
    private long used_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumStruct$QuotaExceededInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$QuotaExceededInfo premiumStruct$QuotaExceededInfo = new PremiumStruct$QuotaExceededInfo();
        DEFAULT_INSTANCE = premiumStruct$QuotaExceededInfo;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$QuotaExceededInfo.class, premiumStruct$QuotaExceededInfo);
    }

    private PremiumStruct$QuotaExceededInfo() {
    }

    private void clearExpirationTime() {
        this.expirationTime_ = 0L;
    }

    private void clearPurchaseTime() {
        this.purchaseTime_ = 0L;
    }

    private void clearQuota() {
        this.quota_ = 0L;
    }

    private void clearResetPeriod() {
        this.resetPeriod_ = 0L;
    }

    private void clearUsed() {
        this.used_ = 0L;
    }

    public static PremiumStruct$QuotaExceededInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$QuotaExceededInfo parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExpirationTime(long j) {
        this.expirationTime_ = j;
    }

    private void setPurchaseTime(long j) {
        this.purchaseTime_ = j;
    }

    private void setQuota(long j) {
        this.quota_ = j;
    }

    private void setResetPeriod(long j) {
        this.resetPeriod_ = j;
    }

    private void setUsed(long j) {
        this.used_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$QuotaExceededInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u0002\u0005\u0002", new Object[]{"used_", "quota_", "resetPeriod_", "purchaseTime_", "expirationTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$QuotaExceededInfo.class) {
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

    public long getExpirationTime() {
        return this.expirationTime_;
    }

    public long getPurchaseTime() {
        return this.purchaseTime_;
    }

    public long getQuota() {
        return this.quota_;
    }

    public long getResetPeriod() {
        return this.resetPeriod_;
    }

    public long getUsed() {
        return this.used_;
    }

    public static a newBuilder(PremiumStruct$QuotaExceededInfo premiumStruct$QuotaExceededInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$QuotaExceededInfo);
    }

    public static PremiumStruct$QuotaExceededInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(byte[] bArr) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(InputStream inputStream) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$QuotaExceededInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$QuotaExceededInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
