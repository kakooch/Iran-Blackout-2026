package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4422Fb2;
import ir.nasim.EnumC5139Ib2;
import ir.nasim.EnumC5373Jb2;
import ir.nasim.EnumC5607Kb2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexOuterClass$RequestGetEvexCurrencyPrice extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 9;
    public static final int COUNTRY_CODE_FIELD_NUMBER = 4;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final EvexOuterClass$RequestGetEvexCurrencyPrice DEFAULT_INSTANCE;
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
            super(EvexOuterClass$RequestGetEvexCurrencyPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$RequestGetEvexCurrencyPrice evexOuterClass$RequestGetEvexCurrencyPrice = new EvexOuterClass$RequestGetEvexCurrencyPrice();
        DEFAULT_INSTANCE = evexOuterClass$RequestGetEvexCurrencyPrice;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$RequestGetEvexCurrencyPrice.class, evexOuterClass$RequestGetEvexCurrencyPrice);
    }

    private EvexOuterClass$RequestGetEvexCurrencyPrice() {
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

    public static EvexOuterClass$RequestGetEvexCurrencyPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankType(EnumC4422Fb2 enumC4422Fb2) {
        this.bankType_ = enumC4422Fb2.getNumber();
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

    private void setCurrencyType(EnumC5139Ib2 enumC5139Ib2) {
        this.currencyType_ = enumC5139Ib2.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
    }

    private void setDeliveryStationType(EnumC5373Jb2 enumC5373Jb2) {
        this.deliveryStationType_ = enumC5373Jb2.getNumber();
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

    private void setReason(EnumC5607Kb2 enumC5607Kb2) {
        this.reason_ = enumC5607Kb2.getNumber();
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
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$RequestGetEvexCurrencyPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\f\u0004\u0004\u0005Ȉ\u0006Ȉ\u0007\f\bȈ\t\f", new Object[]{"currencyType_", "currencyAmount_", "reason_", "countryCode_", "exitDate_", "nationalCode_", "deliveryStationType_", "stationId_", "bankType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$RequestGetEvexCurrencyPrice.class) {
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

    public EnumC4422Fb2 getBankType() {
        EnumC4422Fb2 enumC4422Fb2J = EnumC4422Fb2.j(this.bankType_);
        return enumC4422Fb2J == null ? EnumC4422Fb2.UNRECOGNIZED : enumC4422Fb2J;
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

    public EnumC5139Ib2 getCurrencyType() {
        EnumC5139Ib2 enumC5139Ib2J = EnumC5139Ib2.j(this.currencyType_);
        return enumC5139Ib2J == null ? EnumC5139Ib2.UNRECOGNIZED : enumC5139Ib2J;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
    }

    public EnumC5373Jb2 getDeliveryStationType() {
        EnumC5373Jb2 enumC5373Jb2J = EnumC5373Jb2.j(this.deliveryStationType_);
        return enumC5373Jb2J == null ? EnumC5373Jb2.UNRECOGNIZED : enumC5373Jb2J;
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

    public EnumC5607Kb2 getReason() {
        EnumC5607Kb2 enumC5607Kb2J = EnumC5607Kb2.j(this.reason_);
        return enumC5607Kb2J == null ? EnumC5607Kb2.UNRECOGNIZED : enumC5607Kb2J;
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

    public static a newBuilder(EvexOuterClass$RequestGetEvexCurrencyPrice evexOuterClass$RequestGetEvexCurrencyPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$RequestGetEvexCurrencyPrice);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(byte[] bArr) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$RequestGetEvexCurrencyPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
