package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.N38;
import ir.nasim.S38;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletStruct$WalletInvoice extends GeneratedMessageLite implements S38 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int CURRENCY_FIELD_NUMBER = 2;
    public static final int DATE_TIME_FIELD_NUMBER = 4;
    private static final WalletStruct$WalletInvoice DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SOURCE_WALLET_ID_FIELD_NUMBER = 5;
    public static final int TARGET_WALLET_ID_FIELD_NUMBER = 6;
    private long amount_;
    private int bitField0_;
    private int currency_;
    private long dateTime_;
    private StringValue description_;
    private StringValue sourceWalletId_;
    private StringValue targetWalletId_;

    public static final class a extends GeneratedMessageLite.b implements S38 {
        private a() {
            super(WalletStruct$WalletInvoice.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletStruct$WalletInvoice walletStruct$WalletInvoice = new WalletStruct$WalletInvoice();
        DEFAULT_INSTANCE = walletStruct$WalletInvoice;
        GeneratedMessageLite.registerDefaultInstance(WalletStruct$WalletInvoice.class, walletStruct$WalletInvoice);
    }

    private WalletStruct$WalletInvoice() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCurrency() {
        this.currency_ = 0;
    }

    private void clearDateTime() {
        this.dateTime_ = 0L;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSourceWalletId() {
        this.sourceWalletId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTargetWalletId() {
        this.targetWalletId_ = null;
        this.bitField0_ &= -5;
    }

    public static WalletStruct$WalletInvoice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSourceWalletId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.sourceWalletId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.sourceWalletId_ = stringValue;
        } else {
            this.sourceWalletId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.sourceWalletId_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeTargetWalletId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.targetWalletId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.targetWalletId_ = stringValue;
        } else {
            this.targetWalletId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.targetWalletId_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletStruct$WalletInvoice parseDelimitedFrom(InputStream inputStream) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$WalletInvoice parseFrom(ByteBuffer byteBuffer) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCurrency(N38 n38) {
        this.currency_ = n38.getNumber();
    }

    private void setCurrencyValue(int i) {
        this.currency_ = i;
    }

    private void setDateTime(long j) {
        this.dateTime_ = j;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setSourceWalletId(StringValue stringValue) {
        stringValue.getClass();
        this.sourceWalletId_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setTargetWalletId(StringValue stringValue) {
        stringValue.getClass();
        this.targetWalletId_ = stringValue;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (v2.a[gVar.ordinal()]) {
            case 1:
                return new WalletStruct$WalletInvoice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003ဉ\u0000\u0004\u0002\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"bitField0_", "amount_", "currency_", "description_", "dateTime_", "sourceWalletId_", "targetWalletId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletStruct$WalletInvoice.class) {
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

    public N38 getCurrency() {
        N38 n38J = N38.j(this.currency_);
        return n38J == null ? N38.UNRECOGNIZED : n38J;
    }

    public int getCurrencyValue() {
        return this.currency_;
    }

    public long getDateTime() {
        return this.dateTime_;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getSourceWalletId() {
        StringValue stringValue = this.sourceWalletId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getTargetWalletId() {
        StringValue stringValue = this.targetWalletId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSourceWalletId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTargetWalletId() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(WalletStruct$WalletInvoice walletStruct$WalletInvoice) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletStruct$WalletInvoice);
    }

    public static WalletStruct$WalletInvoice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$WalletInvoice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletStruct$WalletInvoice parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletStruct$WalletInvoice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletStruct$WalletInvoice parseFrom(byte[] bArr) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletStruct$WalletInvoice parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletStruct$WalletInvoice parseFrom(InputStream inputStream) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$WalletInvoice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$WalletInvoice parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletStruct$WalletInvoice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletStruct$WalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
