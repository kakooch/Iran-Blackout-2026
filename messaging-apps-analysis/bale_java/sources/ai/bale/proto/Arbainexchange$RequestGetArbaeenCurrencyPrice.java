package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AI;
import ir.nasim.BI;
import ir.nasim.EnumC23065wI;
import ir.nasim.EnumC24839zI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Arbainexchange$RequestGetArbaeenCurrencyPrice extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 9;
    public static final int COUNTRY_CODE_FIELD_NUMBER = 4;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final Arbainexchange$RequestGetArbaeenCurrencyPrice DEFAULT_INSTANCE;
    public static final int DELIVERY_STATION_TYPE_FIELD_NUMBER = 7;
    public static final int EXIT_DATE_FIELD_NUMBER = 5;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int STATION_ID_FIELD_NUMBER = 8;
    private int bankType_;
    private int countryCode_;
    private int currencyAmount_;
    private int currencyType_;
    private int deliveryStationType_;
    private int reason_;
    private String exitDate_ = "";
    private String nationalCode_ = "";
    private String stationId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestGetArbaeenCurrencyPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestGetArbaeenCurrencyPrice arbainexchange$RequestGetArbaeenCurrencyPrice = new Arbainexchange$RequestGetArbaeenCurrencyPrice();
        DEFAULT_INSTANCE = arbainexchange$RequestGetArbaeenCurrencyPrice;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestGetArbaeenCurrencyPrice.class, arbainexchange$RequestGetArbaeenCurrencyPrice);
    }

    private Arbainexchange$RequestGetArbaeenCurrencyPrice() {
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearCountryCode() {
        this.countryCode_ = 0;
    }

    private void clearCurrencyAmount() {
        this.currencyAmount_ = 0;
    }

    private void clearCurrencyType() {
        this.currencyType_ = 0;
    }

    private void clearDeliveryStationType() {
        this.deliveryStationType_ = 0;
    }

    private void clearExitDate() {
        this.exitDate_ = getDefaultInstance().getExitDate();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    private void clearStationId() {
        this.stationId_ = getDefaultInstance().getStationId();
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCountryCode(int i) {
        this.countryCode_ = i;
    }

    private void setCurrencyAmount(int i) {
        this.currencyAmount_ = i;
    }

    private void setCurrencyType(EnumC24839zI enumC24839zI) {
        this.currencyType_ = enumC24839zI.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
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

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setReason(BI bi) {
        this.reason_ = bi.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    private void setStationId(String str) {
        str.getClass();
        this.stationId_ = str;
    }

    private void setStationIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stationId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestGetArbaeenCurrencyPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\f\u0004\u0004\u0005Ȉ\u0006Ȉ\u0007\f\bȈ\t\f", new Object[]{"currencyType_", "currencyAmount_", "reason_", "countryCode_", "exitDate_", "nationalCode_", "deliveryStationType_", "stationId_", "bankType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestGetArbaeenCurrencyPrice.class) {
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

    public int getCountryCode() {
        return this.countryCode_;
    }

    public int getCurrencyAmount() {
        return this.currencyAmount_;
    }

    public EnumC24839zI getCurrencyType() {
        EnumC24839zI enumC24839zIJ = EnumC24839zI.j(this.currencyType_);
        return enumC24839zIJ == null ? EnumC24839zI.UNRECOGNIZED : enumC24839zIJ;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
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

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public BI getReason() {
        BI biJ = BI.j(this.reason_);
        return biJ == null ? BI.UNRECOGNIZED : biJ;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public String getStationId() {
        return this.stationId_;
    }

    public AbstractC2383g getStationIdBytes() {
        return AbstractC2383g.N(this.stationId_);
    }

    public static a newBuilder(Arbainexchange$RequestGetArbaeenCurrencyPrice arbainexchange$RequestGetArbaeenCurrencyPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestGetArbaeenCurrencyPrice);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestGetArbaeenCurrencyPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
