package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17634nI4;
import ir.nasim.EnumC18225oI4;
import ir.nasim.EnumC20607sI4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreOuterClass$RequestGetOmreCurrencyPrice extends GeneratedMessageLite implements U64 {
    public static final int COUNTRY_CODE_FIELD_NUMBER = 4;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final OmreOuterClass$RequestGetOmreCurrencyPrice DEFAULT_INSTANCE;
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
            super(OmreOuterClass$RequestGetOmreCurrencyPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$RequestGetOmreCurrencyPrice omreOuterClass$RequestGetOmreCurrencyPrice = new OmreOuterClass$RequestGetOmreCurrencyPrice();
        DEFAULT_INSTANCE = omreOuterClass$RequestGetOmreCurrencyPrice;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$RequestGetOmreCurrencyPrice.class, omreOuterClass$RequestGetOmreCurrencyPrice);
    }

    private OmreOuterClass$RequestGetOmreCurrencyPrice() {
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

    public static OmreOuterClass$RequestGetOmreCurrencyPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCurrencyType(EnumC17634nI4 enumC17634nI4) {
        this.currencyType_ = enumC17634nI4.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
    }

    private void setDeliveryStationType(EnumC18225oI4 enumC18225oI4) {
        this.deliveryStationType_ = enumC18225oI4.getNumber();
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

    private void setReason(EnumC20607sI4 enumC20607sI4) {
        this.reason_ = enumC20607sI4.getNumber();
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
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$RequestGetOmreCurrencyPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\f\u0004\u0004\u0005Ȉ\u0006Ȉ\u0007\f\bȈ", new Object[]{"currencyType_", "currencyAmount_", "reason_", "countryCode_", "exitDate_", "nationalCode_", "deliveryStationType_", "stationId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$RequestGetOmreCurrencyPrice.class) {
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

    public EnumC17634nI4 getCurrencyType() {
        EnumC17634nI4 enumC17634nI4J = EnumC17634nI4.j(this.currencyType_);
        return enumC17634nI4J == null ? EnumC17634nI4.UNRECOGNIZED : enumC17634nI4J;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
    }

    public EnumC18225oI4 getDeliveryStationType() {
        EnumC18225oI4 enumC18225oI4J = EnumC18225oI4.j(this.deliveryStationType_);
        return enumC18225oI4J == null ? EnumC18225oI4.UNRECOGNIZED : enumC18225oI4J;
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

    public EnumC20607sI4 getReason() {
        EnumC20607sI4 enumC20607sI4J = EnumC20607sI4.j(this.reason_);
        return enumC20607sI4J == null ? EnumC20607sI4.UNRECOGNIZED : enumC20607sI4J;
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

    public static a newBuilder(OmreOuterClass$RequestGetOmreCurrencyPrice omreOuterClass$RequestGetOmreCurrencyPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$RequestGetOmreCurrencyPrice);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(byte[] bArr) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$RequestGetOmreCurrencyPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
