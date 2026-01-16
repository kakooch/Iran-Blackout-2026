package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6083Mc2;
import ir.nasim.InterfaceC6577Oc2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ExchangeStruct$ExchangeHistoryItem extends GeneratedMessageLite implements InterfaceC6577Oc2 {
    public static final int BALE_ORDER_ID_FIELD_NUMBER = 7;
    public static final int CURRENCY_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final ExchangeStruct$ExchangeHistoryItem DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 3;
    public static final int LAST_NAME_FIELD_NUMBER = 4;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 5;
    public static final int ORDER_ID_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int PUYA_ORDER_ID_FIELD_NUMBER = 8;
    public static final int SUBMIT_TIME_FIELD_NUMBER = 6;
    private long currencyAmount_;
    private int currencyType_;
    private int orderId_;
    private String firstName_ = "";
    private String lastName_ = "";
    private String nationalCode_ = "";
    private String submitTime_ = "";
    private String baleOrderId_ = "";
    private String puyaOrderId_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6577Oc2 {
        private a() {
            super(ExchangeStruct$ExchangeHistoryItem.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeStruct$ExchangeHistoryItem exchangeStruct$ExchangeHistoryItem = new ExchangeStruct$ExchangeHistoryItem();
        DEFAULT_INSTANCE = exchangeStruct$ExchangeHistoryItem;
        GeneratedMessageLite.registerDefaultInstance(ExchangeStruct$ExchangeHistoryItem.class, exchangeStruct$ExchangeHistoryItem);
    }

    private ExchangeStruct$ExchangeHistoryItem() {
    }

    private void clearBaleOrderId() {
        this.baleOrderId_ = getDefaultInstance().getBaleOrderId();
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

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    private void clearPuyaOrderId() {
        this.puyaOrderId_ = getDefaultInstance().getPuyaOrderId();
    }

    private void clearSubmitTime() {
        this.submitTime_ = getDefaultInstance().getSubmitTime();
    }

    public static ExchangeStruct$ExchangeHistoryItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeStruct$ExchangeHistoryItem parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCurrencyAmount(long j) {
        this.currencyAmount_ = j;
    }

    private void setCurrencyType(EnumC6083Mc2 enumC6083Mc2) {
        this.currencyType_ = enumC6083Mc2.getNumber();
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

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    private void setPuyaOrderId(String str) {
        str.getClass();
        this.puyaOrderId_ = str;
    }

    private void setPuyaOrderIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.puyaOrderId_ = abstractC2383g.f0();
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
        switch (V.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeStruct$ExchangeHistoryItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\t\u0004", new Object[]{"currencyType_", "currencyAmount_", "firstName_", "lastName_", "nationalCode_", "submitTime_", "baleOrderId_", "puyaOrderId_", "orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeStruct$ExchangeHistoryItem.class) {
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

    public long getCurrencyAmount() {
        return this.currencyAmount_;
    }

    public EnumC6083Mc2 getCurrencyType() {
        EnumC6083Mc2 enumC6083Mc2J = EnumC6083Mc2.j(this.currencyType_);
        return enumC6083Mc2J == null ? EnumC6083Mc2.UNRECOGNIZED : enumC6083Mc2J;
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

    public int getOrderId() {
        return this.orderId_;
    }

    public String getPuyaOrderId() {
        return this.puyaOrderId_;
    }

    public AbstractC2383g getPuyaOrderIdBytes() {
        return AbstractC2383g.N(this.puyaOrderId_);
    }

    public String getSubmitTime() {
        return this.submitTime_;
    }

    public AbstractC2383g getSubmitTimeBytes() {
        return AbstractC2383g.N(this.submitTime_);
    }

    public static a newBuilder(ExchangeStruct$ExchangeHistoryItem exchangeStruct$ExchangeHistoryItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeStruct$ExchangeHistoryItem);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(byte[] bArr) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(InputStream inputStream) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeStruct$ExchangeHistoryItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeStruct$ExchangeHistoryItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
