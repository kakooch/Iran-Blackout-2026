package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestPurchase extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int COUPON_ID_FIELD_NUMBER = 6;
    private static final KifpoolOuterClass$RequestPurchase DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int DST_TOKEN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SRC_TOKEN_FIELD_NUMBER = 3;
    public static final int STAN_FIELD_NUMBER = 8;
    public static final int TERMINALNO_FIELD_NUMBER = 7;
    public static final int USE_CREDIT_FIELD_NUMBER = 5;
    private long amount_;
    private int bitField0_;
    private Int32Value couponId_;
    private Int64Value stan_;
    private StringValue terminalNo_;
    private CollectionsStruct$BooleanValue useCredit_;
    private String dstToken_ = "";
    private String srcToken_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestPurchase.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestPurchase kifpoolOuterClass$RequestPurchase = new KifpoolOuterClass$RequestPurchase();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestPurchase;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestPurchase.class, kifpoolOuterClass$RequestPurchase);
    }

    private KifpoolOuterClass$RequestPurchase() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCouponId() {
        this.couponId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearDstToken() {
        this.dstToken_ = getDefaultInstance().getDstToken();
    }

    private void clearSrcToken() {
        this.srcToken_ = getDefaultInstance().getSrcToken();
    }

    private void clearStan() {
        this.stan_ = null;
        this.bitField0_ &= -9;
    }

    private void clearTerminalNo() {
        this.terminalNo_ = null;
        this.bitField0_ &= -5;
    }

    private void clearUseCredit() {
        this.useCredit_ = null;
        this.bitField0_ &= -2;
    }

    public static KifpoolOuterClass$RequestPurchase getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCouponId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.couponId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.couponId_ = int32Value;
        } else {
            this.couponId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.couponId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStan(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.stan_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.stan_ = int64Value;
        } else {
            this.stan_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.stan_).v(int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeTerminalNo(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.terminalNo_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.terminalNo_ = stringValue;
        } else {
            this.terminalNo_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.terminalNo_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeUseCredit(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.useCredit_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.useCredit_ = collectionsStruct$BooleanValue;
        } else {
            this.useCredit_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.useCredit_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestPurchase parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCouponId(Int32Value int32Value) {
        int32Value.getClass();
        this.couponId_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setDstToken(String str) {
        str.getClass();
        this.dstToken_ = str;
    }

    private void setDstTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.dstToken_ = abstractC2383g.f0();
    }

    private void setSrcToken(String str) {
        str.getClass();
        this.srcToken_ = str;
    }

    private void setSrcTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.srcToken_ = abstractC2383g.f0();
    }

    private void setStan(Int64Value int64Value) {
        int64Value.getClass();
        this.stan_ = int64Value;
        this.bitField0_ |= 8;
    }

    private void setTerminalNo(StringValue stringValue) {
        stringValue.getClass();
        this.terminalNo_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setUseCredit(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.useCredit_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestPurchase();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003", new Object[]{"bitField0_", "amount_", "dstToken_", "srcToken_", "description_", "useCredit_", "couponId_", "terminalNo_", "stan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestPurchase.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public Int32Value getCouponId() {
        Int32Value int32Value = this.couponId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getDstToken() {
        return this.dstToken_;
    }

    public AbstractC2383g getDstTokenBytes() {
        return AbstractC2383g.N(this.dstToken_);
    }

    public String getSrcToken() {
        return this.srcToken_;
    }

    public AbstractC2383g getSrcTokenBytes() {
        return AbstractC2383g.N(this.srcToken_);
    }

    public Int64Value getStan() {
        Int64Value int64Value = this.stan_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public StringValue getTerminalNo() {
        StringValue stringValue = this.terminalNo_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Deprecated
    public CollectionsStruct$BooleanValue getUseCredit() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.useCredit_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public boolean hasCouponId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStan() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTerminalNo() {
        return (this.bitField0_ & 4) != 0;
    }

    @Deprecated
    public boolean hasUseCredit() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestPurchase kifpoolOuterClass$RequestPurchase) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestPurchase);
    }

    public static KifpoolOuterClass$RequestPurchase parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestPurchase parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
