package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestUpdateMarketInfo extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestUpdateMarketInfo DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int IS_ACTIVE_FIELD_NUMBER = 5;
    public static final int IS_BANNED_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    public static final int PRIMARY_CATEGORY_ID_FIELD_NUMBER = 3;
    private int bitField0_;
    private StringValue displayName_;
    private BoolValue isActive_;
    private BoolValue isBanned_;
    private int peerId_;
    private Int32Value primaryCategoryId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestUpdateMarketInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestUpdateMarketInfo marketOuterClass$RequestUpdateMarketInfo = new MarketOuterClass$RequestUpdateMarketInfo();
        DEFAULT_INSTANCE = marketOuterClass$RequestUpdateMarketInfo;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestUpdateMarketInfo.class, marketOuterClass$RequestUpdateMarketInfo);
    }

    private MarketOuterClass$RequestUpdateMarketInfo() {
    }

    private void clearDisplayName() {
        this.displayName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsActive() {
        this.isActive_ = null;
        this.bitField0_ &= -9;
    }

    private void clearIsBanned() {
        this.isBanned_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPeerId() {
        this.peerId_ = 0;
    }

    private void clearPrimaryCategoryId() {
        this.primaryCategoryId_ = null;
        this.bitField0_ &= -3;
    }

    public static MarketOuterClass$RequestUpdateMarketInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDisplayName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.displayName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.displayName_ = stringValue;
        } else {
            this.displayName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.displayName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeIsActive(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isActive_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isActive_ = boolValue;
        } else {
            this.isActive_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isActive_).v(boolValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeIsBanned(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isBanned_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isBanned_ = boolValue;
        } else {
            this.isBanned_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isBanned_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergePrimaryCategoryId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.primaryCategoryId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.primaryCategoryId_ = int32Value;
        } else {
            this.primaryCategoryId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.primaryCategoryId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDisplayName(StringValue stringValue) {
        stringValue.getClass();
        this.displayName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setIsActive(BoolValue boolValue) {
        boolValue.getClass();
        this.isActive_ = boolValue;
        this.bitField0_ |= 8;
    }

    private void setIsBanned(BoolValue boolValue) {
        boolValue.getClass();
        this.isBanned_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setPeerId(int i) {
        this.peerId_ = i;
    }

    private void setPrimaryCategoryId(Int32Value int32Value) {
        int32Value.getClass();
        this.primaryCategoryId_ = int32Value;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestUpdateMarketInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003", new Object[]{"bitField0_", "peerId_", "displayName_", "primaryCategoryId_", "isBanned_", "isActive_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestUpdateMarketInfo.class) {
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

    public StringValue getDisplayName() {
        StringValue stringValue = this.displayName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public BoolValue getIsActive() {
        BoolValue boolValue = this.isActive_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsBanned() {
        BoolValue boolValue = this.isBanned_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public int getPeerId() {
        return this.peerId_;
    }

    public Int32Value getPrimaryCategoryId() {
        Int32Value int32Value = this.primaryCategoryId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasDisplayName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIsActive() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasIsBanned() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPrimaryCategoryId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MarketOuterClass$RequestUpdateMarketInfo marketOuterClass$RequestUpdateMarketInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestUpdateMarketInfo);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestUpdateMarketInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestUpdateMarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
