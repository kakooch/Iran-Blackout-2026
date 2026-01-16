package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AI;
import ir.nasim.BI;
import ir.nasim.EnumC23065wI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Arbainexchange$RequestGetListOfArbaeenDeliveryStations extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 4;
    private static final Arbainexchange$RequestGetListOfArbaeenDeliveryStations DEFAULT_INSTANCE;
    public static final int DELIVERY_STATION_TYPE_FIELD_NUMBER = 1;
    public static final int EXITDATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SHOULD_RETURN_CAPACITY_FIELD_NUMBER = 5;
    private int bankType_;
    private int bitField0_;
    private int deliveryStationType_;
    private String exitDate_ = "";
    private int reason_;
    private BoolValue shouldReturnCapacity_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestGetListOfArbaeenDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestGetListOfArbaeenDeliveryStations arbainexchange$RequestGetListOfArbaeenDeliveryStations = new Arbainexchange$RequestGetListOfArbaeenDeliveryStations();
        DEFAULT_INSTANCE = arbainexchange$RequestGetListOfArbaeenDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestGetListOfArbaeenDeliveryStations.class, arbainexchange$RequestGetListOfArbaeenDeliveryStations);
    }

    private Arbainexchange$RequestGetListOfArbaeenDeliveryStations() {
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearDeliveryStationType() {
        this.deliveryStationType_ = 0;
    }

    private void clearExitDate() {
        this.exitDate_ = getDefaultInstance().getExitDate();
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    private void clearShouldReturnCapacity() {
        this.shouldReturnCapacity_ = null;
        this.bitField0_ &= -2;
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeShouldReturnCapacity(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.shouldReturnCapacity_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.shouldReturnCapacity_ = boolValue;
        } else {
            this.shouldReturnCapacity_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.shouldReturnCapacity_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankType(EnumC23065wI enumC23065wI) {
        this.bankType_ = enumC23065wI.getNumber();
    }

    private void setBankTypeValue(int i) {
        this.bankType_ = i;
    }

    private void setDeliveryStationType(AI ai2) {
        this.deliveryStationType_ = ai2.getNumber();
    }

    private void setDeliveryStationTypeValue(int i) {
        this.deliveryStationType_ = i;
    }

    private void setExitDate(String str) {
        str.getClass();
        this.exitDate_ = str;
    }

    private void setExitDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.exitDate_ = abstractC2383g.f0();
    }

    private void setReason(BI bi) {
        this.reason_ = bi.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    private void setShouldReturnCapacity(BoolValue boolValue) {
        boolValue.getClass();
        this.shouldReturnCapacity_ = boolValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestGetListOfArbaeenDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ\u0004\f\u0005ဉ\u0000", new Object[]{"bitField0_", "deliveryStationType_", "reason_", "exitDate_", "bankType_", "shouldReturnCapacity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestGetListOfArbaeenDeliveryStations.class) {
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

    public EnumC23065wI getBankType() {
        EnumC23065wI enumC23065wIJ = EnumC23065wI.j(this.bankType_);
        return enumC23065wIJ == null ? EnumC23065wI.UNRECOGNIZED : enumC23065wIJ;
    }

    public int getBankTypeValue() {
        return this.bankType_;
    }

    public AI getDeliveryStationType() {
        AI aiJ = AI.j(this.deliveryStationType_);
        return aiJ == null ? AI.UNRECOGNIZED : aiJ;
    }

    public int getDeliveryStationTypeValue() {
        return this.deliveryStationType_;
    }

    public String getExitDate() {
        return this.exitDate_;
    }

    public AbstractC2383g getExitDateBytes() {
        return AbstractC2383g.N(this.exitDate_);
    }

    public BI getReason() {
        BI biJ = BI.j(this.reason_);
        return biJ == null ? BI.UNRECOGNIZED : biJ;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public BoolValue getShouldReturnCapacity() {
        BoolValue boolValue = this.shouldReturnCapacity_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasShouldReturnCapacity() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Arbainexchange$RequestGetListOfArbaeenDeliveryStations arbainexchange$RequestGetListOfArbaeenDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestGetListOfArbaeenDeliveryStations);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestGetListOfArbaeenDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
