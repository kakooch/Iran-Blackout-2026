package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.P38;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletStruct$Limitation extends GeneratedMessageLite implements P38 {
    private static final WalletStruct$Limitation DEFAULT_INSTANCE;
    public static final int HIGH_CEILING_PRICE_FIELD_NUMBER = 1;
    public static final int LIMITATION_PERIOD_FIELD_NUMBER = 3;
    public static final int LIMITATION_PRIORITY_FIELD_NUMBER = 4;
    public static final int LIMITATION_TYPE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 5;
    public static final int VALUE_FIELD_NUMBER = 6;
    private int bitField0_;
    private CollectionsStruct$Int64Value highCeilingPrice_;
    private StringValue limitationPeriod_;
    private StringValue limitationPriority_;
    private StringValue limitationType_;
    private StringValue status_;
    private CollectionsStruct$Int64Value value_;

    public static final class a extends GeneratedMessageLite.b implements P38 {
        private a() {
            super(WalletStruct$Limitation.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletStruct$Limitation walletStruct$Limitation = new WalletStruct$Limitation();
        DEFAULT_INSTANCE = walletStruct$Limitation;
        GeneratedMessageLite.registerDefaultInstance(WalletStruct$Limitation.class, walletStruct$Limitation);
    }

    private WalletStruct$Limitation() {
    }

    private void clearHighCeilingPrice() {
        this.highCeilingPrice_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLimitationPeriod() {
        this.limitationPeriod_ = null;
        this.bitField0_ &= -5;
    }

    private void clearLimitationPriority() {
        this.limitationPriority_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLimitationType() {
        this.limitationType_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStatus() {
        this.status_ = null;
        this.bitField0_ &= -17;
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -33;
    }

    public static WalletStruct$Limitation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeHighCeilingPrice(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.highCeilingPrice_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.highCeilingPrice_ = collectionsStruct$Int64Value;
        } else {
            this.highCeilingPrice_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.highCeilingPrice_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLimitationPeriod(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.limitationPeriod_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.limitationPeriod_ = stringValue;
        } else {
            this.limitationPeriod_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.limitationPeriod_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeLimitationPriority(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.limitationPriority_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.limitationPriority_ = stringValue;
        } else {
            this.limitationPriority_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.limitationPriority_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLimitationType(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.limitationType_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.limitationType_ = stringValue;
        } else {
            this.limitationType_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.limitationType_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStatus(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.status_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.status_ = stringValue;
        } else {
            this.status_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.status_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeValue(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.value_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.value_ = collectionsStruct$Int64Value;
        } else {
            this.value_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.value_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 32;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletStruct$Limitation parseDelimitedFrom(InputStream inputStream) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$Limitation parseFrom(ByteBuffer byteBuffer) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHighCeilingPrice(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.highCeilingPrice_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setLimitationPeriod(StringValue stringValue) {
        stringValue.getClass();
        this.limitationPeriod_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setLimitationPriority(StringValue stringValue) {
        stringValue.getClass();
        this.limitationPriority_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setLimitationType(StringValue stringValue) {
        stringValue.getClass();
        this.limitationType_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setStatus(StringValue stringValue) {
        stringValue.getClass();
        this.status_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setValue(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.value_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 32;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (v2.a[gVar.ordinal()]) {
            case 1:
                return new WalletStruct$Limitation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"bitField0_", "highCeilingPrice_", "limitationType_", "limitationPeriod_", "limitationPriority_", "status_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletStruct$Limitation.class) {
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

    public CollectionsStruct$Int64Value getHighCeilingPrice() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.highCeilingPrice_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public StringValue getLimitationPeriod() {
        StringValue stringValue = this.limitationPeriod_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLimitationPriority() {
        StringValue stringValue = this.limitationPriority_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLimitationType() {
        StringValue stringValue = this.limitationType_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getStatus() {
        StringValue stringValue = this.status_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public CollectionsStruct$Int64Value getValue() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.value_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasHighCeilingPrice() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLimitationPeriod() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLimitationPriority() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLimitationType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStatus() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 32) != 0;
    }

    public static a newBuilder(WalletStruct$Limitation walletStruct$Limitation) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletStruct$Limitation);
    }

    public static WalletStruct$Limitation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$Limitation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletStruct$Limitation parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletStruct$Limitation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletStruct$Limitation parseFrom(byte[] bArr) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletStruct$Limitation parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletStruct$Limitation parseFrom(InputStream inputStream) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$Limitation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$Limitation parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletStruct$Limitation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletStruct$Limitation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
