package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5850Lc2;
import ir.nasim.EnumC6083Mc2;
import ir.nasim.EnumC6816Pc2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$RequestGetCurrencyPrice extends GeneratedMessageLite implements U64 {
    public static final int COUNTRY_CODE_FIELD_NUMBER = 4;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final ExchangeOuterClass$RequestGetCurrencyPrice DEFAULT_INSTANCE;
    public static final int DELIVERY_STATION_TYPE_FIELD_NUMBER = 7;
    public static final int EXIT_DATE_FIELD_NUMBER = 5;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int STATION_ID_FIELD_NUMBER = 8;
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
            super(ExchangeOuterClass$RequestGetCurrencyPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$RequestGetCurrencyPrice exchangeOuterClass$RequestGetCurrencyPrice = new ExchangeOuterClass$RequestGetCurrencyPrice();
        DEFAULT_INSTANCE = exchangeOuterClass$RequestGetCurrencyPrice;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$RequestGetCurrencyPrice.class, exchangeOuterClass$RequestGetCurrencyPrice);
    }

    private ExchangeOuterClass$RequestGetCurrencyPrice() {
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

    public static ExchangeOuterClass$RequestGetCurrencyPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCountryCode(int i) {
        this.countryCode_ = i;
    }

    private void setCurrencyAmount(int i) {
        this.currencyAmount_ = i;
    }

    private void setCurrencyType(EnumC6083Mc2 enumC6083Mc2) {
        this.currencyType_ = enumC6083Mc2.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
    }

    private void setDeliveryStationType(EnumC5850Lc2 enumC5850Lc2) {
        this.deliveryStationType_ = enumC5850Lc2.getNumber();
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

    private void setReason(EnumC6816Pc2 enumC6816Pc2) {
        this.reason_ = enumC6816Pc2.getNumber();
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
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$RequestGetCurrencyPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\f\u0004\u0004\u0005Ȉ\u0006Ȉ\u0007\f\bȈ", new Object[]{"currencyType_", "currencyAmount_", "reason_", "countryCode_", "exitDate_", "nationalCode_", "deliveryStationType_", "stationId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$RequestGetCurrencyPrice.class) {
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

    public int getCountryCode() {
        return this.countryCode_;
    }

    public int getCurrencyAmount() {
        return this.currencyAmount_;
    }

    public EnumC6083Mc2 getCurrencyType() {
        EnumC6083Mc2 enumC6083Mc2J = EnumC6083Mc2.j(this.currencyType_);
        return enumC6083Mc2J == null ? EnumC6083Mc2.UNRECOGNIZED : enumC6083Mc2J;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
    }

    public EnumC5850Lc2 getDeliveryStationType() {
        EnumC5850Lc2 enumC5850Lc2J = EnumC5850Lc2.j(this.deliveryStationType_);
        return enumC5850Lc2J == null ? EnumC5850Lc2.UNRECOGNIZED : enumC5850Lc2J;
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

    public EnumC6816Pc2 getReason() {
        EnumC6816Pc2 enumC6816Pc2J = EnumC6816Pc2.j(this.reason_);
        return enumC6816Pc2J == null ? EnumC6816Pc2.UNRECOGNIZED : enumC6816Pc2J;
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

    public static a newBuilder(ExchangeOuterClass$RequestGetCurrencyPrice exchangeOuterClass$RequestGetCurrencyPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$RequestGetCurrencyPrice);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$RequestGetCurrencyPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
