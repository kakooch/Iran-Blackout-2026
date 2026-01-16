package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$ResponseBuyFastCharge extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseBuyFastCharge DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PIN_FIELD_NUMBER = 3;
    public static final int REFRENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int SERIAL_FIELD_NUMBER = 4;
    public static final int TRANSACTION_DATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue pin_;
    private String refrenceNumber_ = "";
    private StringValue serial_;
    private long transactionDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseBuyFastCharge.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseBuyFastCharge bankOuterClass$ResponseBuyFastCharge = new BankOuterClass$ResponseBuyFastCharge();
        DEFAULT_INSTANCE = bankOuterClass$ResponseBuyFastCharge;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseBuyFastCharge.class, bankOuterClass$ResponseBuyFastCharge);
    }

    private BankOuterClass$ResponseBuyFastCharge() {
    }

    private void clearPin() {
        this.pin_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRefrenceNumber() {
        this.refrenceNumber_ = getDefaultInstance().getRefrenceNumber();
    }

    private void clearSerial() {
        this.serial_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTransactionDate() {
        this.transactionDate_ = 0L;
    }

    public static BankOuterClass$ResponseBuyFastCharge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePin(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.pin_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.pin_ = stringValue;
        } else {
            this.pin_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.pin_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSerial(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.serial_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.serial_ = stringValue;
        } else {
            this.serial_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.serial_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseBuyFastCharge parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPin(StringValue stringValue) {
        stringValue.getClass();
        this.pin_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setRefrenceNumber(String str) {
        str.getClass();
        this.refrenceNumber_ = str;
    }

    private void setRefrenceNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.refrenceNumber_ = abstractC2383g.f0();
    }

    private void setSerial(StringValue stringValue) {
        stringValue.getClass();
        this.serial_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setTransactionDate(long j) {
        this.transactionDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseBuyFastCharge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "transactionDate_", "refrenceNumber_", "pin_", "serial_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseBuyFastCharge.class) {
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

    public StringValue getPin() {
        StringValue stringValue = this.pin_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getRefrenceNumber() {
        return this.refrenceNumber_;
    }

    public AbstractC2383g getRefrenceNumberBytes() {
        return AbstractC2383g.N(this.refrenceNumber_);
    }

    public StringValue getSerial() {
        StringValue stringValue = this.serial_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getTransactionDate() {
        return this.transactionDate_;
    }

    public boolean hasPin() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSerial() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(BankOuterClass$ResponseBuyFastCharge bankOuterClass$ResponseBuyFastCharge) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseBuyFastCharge);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseBuyFastCharge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
