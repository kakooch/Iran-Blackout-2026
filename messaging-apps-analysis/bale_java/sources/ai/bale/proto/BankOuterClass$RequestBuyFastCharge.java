package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC10123b70;
import ir.nasim.KW4;
import ir.nasim.Q60;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$RequestBuyFastCharge extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int CHARGE_TYPE_FIELD_NUMBER = 4;
    private static final BankOuterClass$RequestBuyFastCharge DEFAULT_INSTANCE;
    public static final int OPERATOR_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 2;
    private long amount_;
    private int bitField0_;
    private int chargeType_;
    private int operator_;
    private StringValue phoneNumber_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((BankOuterClass$RequestBuyFastCharge) this.b).setAmount(j);
            return this;
        }

        public a B(Q60 q60) {
            q();
            ((BankOuterClass$RequestBuyFastCharge) this.b).setChargeType(q60);
            return this;
        }

        public a C(EnumC10123b70 enumC10123b70) {
            q();
            ((BankOuterClass$RequestBuyFastCharge) this.b).setOperator(enumC10123b70);
            return this;
        }

        public a D(StringValue stringValue) {
            q();
            ((BankOuterClass$RequestBuyFastCharge) this.b).setPhoneNumber(stringValue);
            return this;
        }

        private a() {
            super(BankOuterClass$RequestBuyFastCharge.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestBuyFastCharge bankOuterClass$RequestBuyFastCharge = new BankOuterClass$RequestBuyFastCharge();
        DEFAULT_INSTANCE = bankOuterClass$RequestBuyFastCharge;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestBuyFastCharge.class, bankOuterClass$RequestBuyFastCharge);
    }

    private BankOuterClass$RequestBuyFastCharge() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearChargeType() {
        this.chargeType_ = 0;
    }

    private void clearOperator() {
        this.operator_ = 0;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = null;
        this.bitField0_ &= -2;
    }

    public static BankOuterClass$RequestBuyFastCharge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePhoneNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.phoneNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.phoneNumber_ = stringValue;
        } else {
            this.phoneNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.phoneNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestBuyFastCharge parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(long j) {
        this.amount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChargeType(Q60 q60) {
        this.chargeType_ = q60.getNumber();
    }

    private void setChargeTypeValue(int i) {
        this.chargeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperator(EnumC10123b70 enumC10123b70) {
        this.operator_ = enumC10123b70.getNumber();
    }

    private void setOperatorValue(int i) {
        this.operator_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneNumber(StringValue stringValue) {
        stringValue.getClass();
        this.phoneNumber_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestBuyFastCharge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000\u0003\f\u0004\f", new Object[]{"bitField0_", "amount_", "phoneNumber_", "operator_", "chargeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestBuyFastCharge.class) {
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

    public Q60 getChargeType() {
        Q60 q60J = Q60.j(this.chargeType_);
        return q60J == null ? Q60.UNRECOGNIZED : q60J;
    }

    public int getChargeTypeValue() {
        return this.chargeType_;
    }

    public EnumC10123b70 getOperator() {
        EnumC10123b70 enumC10123b70J = EnumC10123b70.j(this.operator_);
        return enumC10123b70J == null ? EnumC10123b70.UNRECOGNIZED : enumC10123b70J;
    }

    public int getOperatorValue() {
        return this.operator_;
    }

    public StringValue getPhoneNumber() {
        StringValue stringValue = this.phoneNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasPhoneNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestBuyFastCharge bankOuterClass$RequestBuyFastCharge) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestBuyFastCharge);
    }

    public static BankOuterClass$RequestBuyFastCharge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestBuyFastCharge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestBuyFastCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
