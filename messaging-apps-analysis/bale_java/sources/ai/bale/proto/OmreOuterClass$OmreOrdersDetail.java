package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PH4;
import ir.nasim.QH4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreOuterClass$OmreOrdersDetail extends GeneratedMessageLite implements PH4 {
    public static final int AMOUNT_PAYED_FIELD_NUMBER = 7;
    public static final int CREATED_AT_FIELD_NUMBER = 16;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 4;
    public static final int CURRENCY_IN_RIAL_FIELD_NUMBER = 6;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 5;
    private static final OmreOuterClass$OmreOrdersDetail DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    public static final int LAST_NAME_FIELD_NUMBER = 2;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 3;
    public static final int ORDER_ID_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 17;
    public static final int PUYA_SALE_ID_FIELD_NUMBER = 14;
    public static final int PUYA_TRACKING_CODE_FIELD_NUMBER = 13;
    public static final int SANA_TRACKING_CODE_FIELD_NUMBER = 18;
    public static final int STATION_ID_FIELD_NUMBER = 10;
    public static final int STATION_NAME_FIELD_NUMBER = 9;
    public static final int STATUS_FIELD_NUMBER = 15;
    public static final int TRAVELING_DATE_FIELD_NUMBER = 12;
    public static final int USER_ID_FIELD_NUMBER = 11;
    private long amountPayed_;
    private long currencyAmount_;
    private long currencyInRial_;
    private int currencyType_;
    private long orderId_;
    private int status_;
    private int userId_;
    private String firstName_ = "";
    private String lastName_ = "";
    private String nationalCode_ = "";
    private String stationName_ = "";
    private String stationId_ = "";
    private String travelingDate_ = "";
    private String puyaTrackingCode_ = "";
    private String puyaSaleId_ = "";
    private String createdAt_ = "";
    private String phoneNumber_ = "";
    private String sanaTrackingCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements PH4 {
        private a() {
            super(OmreOuterClass$OmreOrdersDetail.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$OmreOrdersDetail omreOuterClass$OmreOrdersDetail = new OmreOuterClass$OmreOrdersDetail();
        DEFAULT_INSTANCE = omreOuterClass$OmreOrdersDetail;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$OmreOrdersDetail.class, omreOuterClass$OmreOrdersDetail);
    }

    private OmreOuterClass$OmreOrdersDetail() {
    }

    private void clearAmountPayed() {
        this.amountPayed_ = 0L;
    }

    private void clearCreatedAt() {
        this.createdAt_ = getDefaultInstance().getCreatedAt();
    }

    private void clearCurrencyAmount() {
        this.currencyAmount_ = 0L;
    }

    private void clearCurrencyInRial() {
        this.currencyInRial_ = 0L;
    }

    private void clearCurrencyType() {
        this.currencyType_ = 0;
    }

    private void clearFirstName() {
        this.firstName_ = getDefaultInstance().getFirstName();
    }

    private void clearLastName() {
        this.lastName_ = getDefaultInstance().getLastName();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearOrderId() {
        this.orderId_ = 0L;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearPuyaSaleId() {
        this.puyaSaleId_ = getDefaultInstance().getPuyaSaleId();
    }

    private void clearPuyaTrackingCode() {
        this.puyaTrackingCode_ = getDefaultInstance().getPuyaTrackingCode();
    }

    private void clearSanaTrackingCode() {
        this.sanaTrackingCode_ = getDefaultInstance().getSanaTrackingCode();
    }

    private void clearStationId() {
        this.stationId_ = getDefaultInstance().getStationId();
    }

    private void clearStationName() {
        this.stationName_ = getDefaultInstance().getStationName();
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTravelingDate() {
        this.travelingDate_ = getDefaultInstance().getTravelingDate();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static OmreOuterClass$OmreOrdersDetail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$OmreOrdersDetail parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmountPayed(long j) {
        this.amountPayed_ = j;
    }

    private void setCreatedAt(String str) {
        str.getClass();
        this.createdAt_ = str;
    }

    private void setCreatedAtBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.createdAt_ = abstractC2383g.f0();
    }

    private void setCurrencyAmount(long j) {
        this.currencyAmount_ = j;
    }

    private void setCurrencyInRial(long j) {
        this.currencyInRial_ = j;
    }

    private void setCurrencyType(int i) {
        this.currencyType_ = i;
    }

    private void setFirstName(String str) {
        str.getClass();
        this.firstName_ = str;
    }

    private void setFirstNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.firstName_ = abstractC2383g.f0();
    }

    private void setLastName(String str) {
        str.getClass();
        this.lastName_ = str;
    }

    private void setLastNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.lastName_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setOrderId(long j) {
        this.orderId_ = j;
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    private void setPuyaSaleId(String str) {
        str.getClass();
        this.puyaSaleId_ = str;
    }

    private void setPuyaSaleIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.puyaSaleId_ = abstractC2383g.f0();
    }

    private void setPuyaTrackingCode(String str) {
        str.getClass();
        this.puyaTrackingCode_ = str;
    }

    private void setPuyaTrackingCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.puyaTrackingCode_ = abstractC2383g.f0();
    }

    private void setSanaTrackingCode(String str) {
        str.getClass();
        this.sanaTrackingCode_ = str;
    }

    private void setSanaTrackingCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sanaTrackingCode_ = abstractC2383g.f0();
    }

    private void setStationId(String str) {
        str.getClass();
        this.stationId_ = str;
    }

    private void setStationIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stationId_ = abstractC2383g.f0();
    }

    private void setStationName(String str) {
        str.getClass();
        this.stationName_ = str;
    }

    private void setStationNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stationName_ = abstractC2383g.f0();
    }

    private void setStatus(QH4 qh4) {
        this.status_ = qh4.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setTravelingDate(String str) {
        str.getClass();
        this.travelingDate_ = str;
    }

    private void setTravelingDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.travelingDate_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$OmreOrdersDetail();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0012\u0000\u0000\u0001\u0012\u0012\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005\u0004\u0006\u0002\u0007\u0002\b\u0002\tȈ\nȈ\u000b\u0004\fȈ\rȈ\u000eȈ\u000f\f\u0010Ȉ\u0011Ȉ\u0012Ȉ", new Object[]{"firstName_", "lastName_", "nationalCode_", "currencyAmount_", "currencyType_", "currencyInRial_", "amountPayed_", "orderId_", "stationName_", "stationId_", "userId_", "travelingDate_", "puyaTrackingCode_", "puyaSaleId_", "status_", "createdAt_", "phoneNumber_", "sanaTrackingCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$OmreOrdersDetail.class) {
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

    public long getAmountPayed() {
        return this.amountPayed_;
    }

    public String getCreatedAt() {
        return this.createdAt_;
    }

    public AbstractC2383g getCreatedAtBytes() {
        return AbstractC2383g.N(this.createdAt_);
    }

    public long getCurrencyAmount() {
        return this.currencyAmount_;
    }

    public long getCurrencyInRial() {
        return this.currencyInRial_;
    }

    public int getCurrencyType() {
        return this.currencyType_;
    }

    public String getFirstName() {
        return this.firstName_;
    }

    public AbstractC2383g getFirstNameBytes() {
        return AbstractC2383g.N(this.firstName_);
    }

    public String getLastName() {
        return this.lastName_;
    }

    public AbstractC2383g getLastNameBytes() {
        return AbstractC2383g.N(this.lastName_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public long getOrderId() {
        return this.orderId_;
    }

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public String getPuyaSaleId() {
        return this.puyaSaleId_;
    }

    public AbstractC2383g getPuyaSaleIdBytes() {
        return AbstractC2383g.N(this.puyaSaleId_);
    }

    public String getPuyaTrackingCode() {
        return this.puyaTrackingCode_;
    }

    public AbstractC2383g getPuyaTrackingCodeBytes() {
        return AbstractC2383g.N(this.puyaTrackingCode_);
    }

    public String getSanaTrackingCode() {
        return this.sanaTrackingCode_;
    }

    public AbstractC2383g getSanaTrackingCodeBytes() {
        return AbstractC2383g.N(this.sanaTrackingCode_);
    }

    public String getStationId() {
        return this.stationId_;
    }

    public AbstractC2383g getStationIdBytes() {
        return AbstractC2383g.N(this.stationId_);
    }

    public String getStationName() {
        return this.stationName_;
    }

    public AbstractC2383g getStationNameBytes() {
        return AbstractC2383g.N(this.stationName_);
    }

    public QH4 getStatus() {
        QH4 qh4J = QH4.j(this.status_);
        return qh4J == null ? QH4.UNRECOGNIZED : qh4J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public String getTravelingDate() {
        return this.travelingDate_;
    }

    public AbstractC2383g getTravelingDateBytes() {
        return AbstractC2383g.N(this.travelingDate_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(OmreOuterClass$OmreOrdersDetail omreOuterClass$OmreOrdersDetail) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$OmreOrdersDetail);
    }

    public static OmreOuterClass$OmreOrdersDetail parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(byte[] bArr) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(InputStream inputStream) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$OmreOrdersDetail parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$OmreOrdersDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
