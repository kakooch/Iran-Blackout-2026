package ai.bale.proto;

import ai.bale.proto.ArbainexchangeStruct$ArbaeenStation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DI;
import ir.nasim.EnumC24839zI;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ArbainexchangeStruct$ArbaeenHistoryItem extends GeneratedMessageLite implements DI {
    public static final int BALE_ORDER_ID_FIELD_NUMBER = 7;
    public static final int BIRTH_DATE_FIELD_NUMBER = 10;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final ArbainexchangeStruct$ArbaeenHistoryItem DEFAULT_INSTANCE;
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
    private ArbainexchangeStruct$ArbaeenStation station_;
    private String firstName_ = "";
    private String lastName_ = "";
    private String nationalCode_ = "";
    private String submitTime_ = "";
    private String baleOrderId_ = "";
    private String puyaOrderId_ = "";
    private String birthDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements DI {
        private a() {
            super(ArbainexchangeStruct$ArbaeenHistoryItem.DEFAULT_INSTANCE);
        }
    }

    static {
        ArbainexchangeStruct$ArbaeenHistoryItem arbainexchangeStruct$ArbaeenHistoryItem = new ArbainexchangeStruct$ArbaeenHistoryItem();
        DEFAULT_INSTANCE = arbainexchangeStruct$ArbaeenHistoryItem;
        GeneratedMessageLite.registerDefaultInstance(ArbainexchangeStruct$ArbaeenHistoryItem.class, arbainexchangeStruct$ArbaeenHistoryItem);
    }

    private ArbainexchangeStruct$ArbaeenHistoryItem() {
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

    public static ArbainexchangeStruct$ArbaeenHistoryItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeStation(ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation) {
        arbainexchangeStruct$ArbaeenStation.getClass();
        ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation2 = this.station_;
        if (arbainexchangeStruct$ArbaeenStation2 == null || arbainexchangeStruct$ArbaeenStation2 == ArbainexchangeStruct$ArbaeenStation.getDefaultInstance()) {
            this.station_ = arbainexchangeStruct$ArbaeenStation;
        } else {
            this.station_ = (ArbainexchangeStruct$ArbaeenStation) ((ArbainexchangeStruct$ArbaeenStation.a) ArbainexchangeStruct$ArbaeenStation.newBuilder(this.station_).v(arbainexchangeStruct$ArbaeenStation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseDelimitedFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(ByteBuffer byteBuffer) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCurrencyType(EnumC24839zI enumC24839zI) {
        this.currencyType_ = enumC24839zI.getNumber();
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

    private void setStation(ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation) {
        arbainexchangeStruct$ArbaeenStation.getClass();
        this.station_ = arbainexchangeStruct$ArbaeenStation;
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
        switch (AbstractC1864j.a[gVar.ordinal()]) {
            case 1:
                return new ArbainexchangeStruct$ArbaeenHistoryItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tဉ\u0000\nȈ", new Object[]{"bitField0_", "currencyType_", "currencyAmount_", "firstName_", "lastName_", "nationalCode_", "submitTime_", "baleOrderId_", "puyaOrderId_", "station_", "birthDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ArbainexchangeStruct$ArbaeenHistoryItem.class) {
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

    public EnumC24839zI getCurrencyType() {
        EnumC24839zI enumC24839zIJ = EnumC24839zI.j(this.currencyType_);
        return enumC24839zIJ == null ? EnumC24839zI.UNRECOGNIZED : enumC24839zIJ;
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

    public ArbainexchangeStruct$ArbaeenStation getStation() {
        ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation = this.station_;
        return arbainexchangeStruct$ArbaeenStation == null ? ArbainexchangeStruct$ArbaeenStation.getDefaultInstance() : arbainexchangeStruct$ArbaeenStation;
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

    public static a newBuilder(ArbainexchangeStruct$ArbaeenHistoryItem arbainexchangeStruct$ArbaeenHistoryItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchangeStruct$ArbaeenHistoryItem);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(AbstractC2383g abstractC2383g) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(byte[] bArr) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(AbstractC2384h abstractC2384h) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ArbainexchangeStruct$ArbaeenHistoryItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
