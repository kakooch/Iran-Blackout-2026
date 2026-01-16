package ai.bale.proto;

import ai.bale.proto.EvexStruct$EvexStation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5139Ib2;
import ir.nasim.InterfaceC6074Mb2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexStruct$EvexHistoryItem extends GeneratedMessageLite implements InterfaceC6074Mb2 {
    public static final int BALE_ORDER_ID_FIELD_NUMBER = 7;
    public static final int BIRTH_DATE_FIELD_NUMBER = 10;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final EvexStruct$EvexHistoryItem DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 3;
    public static final int LAST_NAME_FIELD_NUMBER = 4;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PUYA_ORDER_ID_FIELD_NUMBER = 8;
    public static final int STATION_FIELD_NUMBER = 9;
    public static final int SUBMIT_TIME_FIELD_NUMBER = 6;
    private int bitField0_;
    private long currencyAmount_;
    private int currencyType_;
    private EvexStruct$EvexStation station_;
    private String firstName_ = "";
    private String lastName_ = "";
    private String nationalCode_ = "";
    private String submitTime_ = "";
    private String baleOrderId_ = "";
    private String puyaOrderId_ = "";
    private String birthDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6074Mb2 {
        private a() {
            super(EvexStruct$EvexHistoryItem.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexStruct$EvexHistoryItem evexStruct$EvexHistoryItem = new EvexStruct$EvexHistoryItem();
        DEFAULT_INSTANCE = evexStruct$EvexHistoryItem;
        GeneratedMessageLite.registerDefaultInstance(EvexStruct$EvexHistoryItem.class, evexStruct$EvexHistoryItem);
    }

    private EvexStruct$EvexHistoryItem() {
    }

    private void clearBaleOrderId() {
        this.baleOrderId_ = getDefaultInstance().getBaleOrderId();
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearCurrencyAmount() {
        this.currencyAmount_ = 0L;
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

    private void clearPuyaOrderId() {
        this.puyaOrderId_ = getDefaultInstance().getPuyaOrderId();
    }

    private void clearStation() {
        this.station_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSubmitTime() {
        this.submitTime_ = getDefaultInstance().getSubmitTime();
    }

    public static EvexStruct$EvexHistoryItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeStation(EvexStruct$EvexStation evexStruct$EvexStation) {
        evexStruct$EvexStation.getClass();
        EvexStruct$EvexStation evexStruct$EvexStation2 = this.station_;
        if (evexStruct$EvexStation2 == null || evexStruct$EvexStation2 == EvexStruct$EvexStation.getDefaultInstance()) {
            this.station_ = evexStruct$EvexStation;
        } else {
            this.station_ = (EvexStruct$EvexStation) ((EvexStruct$EvexStation.a) EvexStruct$EvexStation.newBuilder(this.station_).v(evexStruct$EvexStation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexStruct$EvexHistoryItem parseDelimitedFrom(InputStream inputStream) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(ByteBuffer byteBuffer) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBaleOrderId(String str) {
        str.getClass();
        this.baleOrderId_ = str;
    }

    private void setBaleOrderIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.baleOrderId_ = abstractC2383g.f0();
    }

    private void setBirthDate(String str) {
        str.getClass();
        this.birthDate_ = str;
    }

    private void setBirthDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.birthDate_ = abstractC2383g.f0();
    }

    private void setCurrencyAmount(long j) {
        this.currencyAmount_ = j;
    }

    private void setCurrencyType(EnumC5139Ib2 enumC5139Ib2) {
        this.currencyType_ = enumC5139Ib2.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
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

    private void setPuyaOrderId(String str) {
        str.getClass();
        this.puyaOrderId_ = str;
    }

    private void setPuyaOrderIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.puyaOrderId_ = abstractC2383g.f0();
    }

    private void setStation(EvexStruct$EvexStation evexStruct$EvexStation) {
        evexStruct$EvexStation.getClass();
        this.station_ = evexStruct$EvexStation;
        this.bitField0_ |= 1;
    }

    private void setSubmitTime(String str) {
        str.getClass();
        this.submitTime_ = str;
    }

    private void setSubmitTimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.submitTime_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T.a[gVar.ordinal()]) {
            case 1:
                return new EvexStruct$EvexHistoryItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tဉ\u0000\nȈ", new Object[]{"bitField0_", "currencyType_", "currencyAmount_", "firstName_", "lastName_", "nationalCode_", "submitTime_", "baleOrderId_", "puyaOrderId_", "station_", "birthDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexStruct$EvexHistoryItem.class) {
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

    public String getBaleOrderId() {
        return this.baleOrderId_;
    }

    public AbstractC2383g getBaleOrderIdBytes() {
        return AbstractC2383g.N(this.baleOrderId_);
    }

    public String getBirthDate() {
        return this.birthDate_;
    }

    public AbstractC2383g getBirthDateBytes() {
        return AbstractC2383g.N(this.birthDate_);
    }

    public long getCurrencyAmount() {
        return this.currencyAmount_;
    }

    public EnumC5139Ib2 getCurrencyType() {
        EnumC5139Ib2 enumC5139Ib2J = EnumC5139Ib2.j(this.currencyType_);
        return enumC5139Ib2J == null ? EnumC5139Ib2.UNRECOGNIZED : enumC5139Ib2J;
    }

    public int getCurrencyTypeValue() {
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

    public String getPuyaOrderId() {
        return this.puyaOrderId_;
    }

    public AbstractC2383g getPuyaOrderIdBytes() {
        return AbstractC2383g.N(this.puyaOrderId_);
    }

    public EvexStruct$EvexStation getStation() {
        EvexStruct$EvexStation evexStruct$EvexStation = this.station_;
        return evexStruct$EvexStation == null ? EvexStruct$EvexStation.getDefaultInstance() : evexStruct$EvexStation;
    }

    public String getSubmitTime() {
        return this.submitTime_;
    }

    public AbstractC2383g getSubmitTimeBytes() {
        return AbstractC2383g.N(this.submitTime_);
    }

    public boolean hasStation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(EvexStruct$EvexHistoryItem evexStruct$EvexHistoryItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexStruct$EvexHistoryItem);
    }

    public static EvexStruct$EvexHistoryItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(byte[] bArr) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(InputStream inputStream) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexStruct$EvexHistoryItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexStruct$EvexHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
