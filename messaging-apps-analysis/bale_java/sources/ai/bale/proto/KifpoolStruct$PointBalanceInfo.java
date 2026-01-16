package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9969ar3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolStruct$PointBalanceInfo extends GeneratedMessageLite implements InterfaceC9969ar3 {
    public static final int AVAILABLE_POINT_FIELD_NUMBER = 4;
    public static final int BURN_POINT_FIELD_NUMBER = 3;
    public static final int CURRENCY_FIELD_NUMBER = 5;
    public static final int CURRENCY_NAME_FIELD_NUMBER = 6;
    private static final KifpoolStruct$PointBalanceInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REDEEM_POINT_FIELD_NUMBER = 2;
    public static final int TOTAL_POINT_FIELD_NUMBER = 1;
    private long availablePoint_;
    private long burnPoint_;
    private String currencyName_ = "";
    private int currency_;
    private long redeemPoint_;
    private long totalPoint_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9969ar3 {
        private a() {
            super(KifpoolStruct$PointBalanceInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolStruct$PointBalanceInfo kifpoolStruct$PointBalanceInfo = new KifpoolStruct$PointBalanceInfo();
        DEFAULT_INSTANCE = kifpoolStruct$PointBalanceInfo;
        GeneratedMessageLite.registerDefaultInstance(KifpoolStruct$PointBalanceInfo.class, kifpoolStruct$PointBalanceInfo);
    }

    private KifpoolStruct$PointBalanceInfo() {
    }

    private void clearAvailablePoint() {
        this.availablePoint_ = 0L;
    }

    private void clearBurnPoint() {
        this.burnPoint_ = 0L;
    }

    private void clearCurrency() {
        this.currency_ = 0;
    }

    private void clearCurrencyName() {
        this.currencyName_ = getDefaultInstance().getCurrencyName();
    }

    private void clearRedeemPoint() {
        this.redeemPoint_ = 0L;
    }

    private void clearTotalPoint() {
        this.totalPoint_ = 0L;
    }

    public static KifpoolStruct$PointBalanceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolStruct$PointBalanceInfo parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvailablePoint(long j) {
        this.availablePoint_ = j;
    }

    private void setBurnPoint(long j) {
        this.burnPoint_ = j;
    }

    private void setCurrency(int i) {
        this.currency_ = i;
    }

    private void setCurrencyName(String str) {
        str.getClass();
        this.currencyName_ = str;
    }

    private void setCurrencyNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.currencyName_ = abstractC2383g.f0();
    }

    private void setRedeemPoint(long j) {
        this.redeemPoint_ = j;
    }

    private void setTotalPoint(long j) {
        this.totalPoint_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1900v0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolStruct$PointBalanceInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u0002\u0005\u0004\u0006Ȉ", new Object[]{"totalPoint_", "redeemPoint_", "burnPoint_", "availablePoint_", "currency_", "currencyName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolStruct$PointBalanceInfo.class) {
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

    public long getAvailablePoint() {
        return this.availablePoint_;
    }

    public long getBurnPoint() {
        return this.burnPoint_;
    }

    public int getCurrency() {
        return this.currency_;
    }

    public String getCurrencyName() {
        return this.currencyName_;
    }

    public AbstractC2383g getCurrencyNameBytes() {
        return AbstractC2383g.N(this.currencyName_);
    }

    public long getRedeemPoint() {
        return this.redeemPoint_;
    }

    public long getTotalPoint() {
        return this.totalPoint_;
    }

    public static a newBuilder(KifpoolStruct$PointBalanceInfo kifpoolStruct$PointBalanceInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolStruct$PointBalanceInfo);
    }

    public static KifpoolStruct$PointBalanceInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(byte[] bArr) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(InputStream inputStream) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolStruct$PointBalanceInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolStruct$PointBalanceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
