package ai.bale.proto;

import ai.bale.proto.BillStruct$BillParameters;
import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5164Ie0;
import ir.nasim.EnumC5398Je0;
import ir.nasim.InterfaceC4696Ge0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BillStruct$Bill extends GeneratedMessageLite implements InterfaceC4696Ge0 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int BILL_ID_FIELD_NUMBER = 4;
    public static final int BILL_PARAMETERS_FIELD_NUMBER = 2;
    public static final int BILL_TYPE_FIELD_NUMBER = 1;
    private static final BillStruct$Bill DEFAULT_INSTANCE;
    public static final int EXPIRE_DATE_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PAY_DATE_FIELD_NUMBER = 8;
    public static final int PAY_ID_FIELD_NUMBER = 5;
    public static final int TERM_TYPE_FIELD_NUMBER = 6;
    private long amount_;
    private BillStruct$BillParameters billParameters_;
    private int billType_;
    private int bitField0_;
    private long expireDate_;
    private CollectionsStruct$Int64Value payDate_;
    private int termType_;
    private String billId_ = "";
    private String payId_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4696Ge0 {
        private a() {
            super(BillStruct$Bill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillStruct$Bill billStruct$Bill = new BillStruct$Bill();
        DEFAULT_INSTANCE = billStruct$Bill;
        GeneratedMessageLite.registerDefaultInstance(BillStruct$Bill.class, billStruct$Bill);
    }

    private BillStruct$Bill() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearBillId() {
        this.billId_ = getDefaultInstance().getBillId();
    }

    private void clearBillParameters() {
        this.billParameters_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBillType() {
        this.billType_ = 0;
    }

    private void clearExpireDate() {
        this.expireDate_ = 0L;
    }

    private void clearPayDate() {
        this.payDate_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPayId() {
        this.payId_ = getDefaultInstance().getPayId();
    }

    private void clearTermType() {
        this.termType_ = 0;
    }

    public static BillStruct$Bill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBillParameters(BillStruct$BillParameters billStruct$BillParameters) {
        billStruct$BillParameters.getClass();
        BillStruct$BillParameters billStruct$BillParameters2 = this.billParameters_;
        if (billStruct$BillParameters2 == null || billStruct$BillParameters2 == BillStruct$BillParameters.getDefaultInstance()) {
            this.billParameters_ = billStruct$BillParameters;
        } else {
            this.billParameters_ = (BillStruct$BillParameters) ((BillStruct$BillParameters.a) BillStruct$BillParameters.newBuilder(this.billParameters_).v(billStruct$BillParameters)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePayDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.payDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.payDate_ = collectionsStruct$Int64Value;
        } else {
            this.payDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.payDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillStruct$Bill parseDelimitedFrom(InputStream inputStream) {
        return (BillStruct$Bill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillStruct$Bill parseFrom(ByteBuffer byteBuffer) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setBillId(String str) {
        str.getClass();
        this.billId_ = str;
    }

    private void setBillIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.billId_ = abstractC2383g.f0();
    }

    private void setBillParameters(BillStruct$BillParameters billStruct$BillParameters) {
        billStruct$BillParameters.getClass();
        this.billParameters_ = billStruct$BillParameters;
        this.bitField0_ |= 1;
    }

    private void setBillType(EnumC5398Je0 enumC5398Je0) {
        this.billType_ = enumC5398Je0.getNumber();
    }

    private void setBillTypeValue(int i) {
        this.billType_ = i;
    }

    private void setExpireDate(long j) {
        this.expireDate_ = j;
    }

    private void setPayDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.payDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setPayId(String str) {
        str.getClass();
        this.payId_ = str;
    }

    private void setPayIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.payId_ = abstractC2383g.f0();
    }

    private void setTermType(EnumC5164Ie0 enumC5164Ie0) {
        this.termType_ = enumC5164Ie0.getNumber();
    }

    private void setTermTypeValue(int i) {
        this.termType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1890s.a[gVar.ordinal()]) {
            case 1:
                return new BillStruct$Bill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003\u0002\u0004Ȉ\u0005Ȉ\u0006\f\u0007\u0002\bဉ\u0001", new Object[]{"bitField0_", "billType_", "billParameters_", "amount_", "billId_", "payId_", "termType_", "expireDate_", "payDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillStruct$Bill.class) {
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

    public String getBillId() {
        return this.billId_;
    }

    public AbstractC2383g getBillIdBytes() {
        return AbstractC2383g.N(this.billId_);
    }

    public BillStruct$BillParameters getBillParameters() {
        BillStruct$BillParameters billStruct$BillParameters = this.billParameters_;
        return billStruct$BillParameters == null ? BillStruct$BillParameters.getDefaultInstance() : billStruct$BillParameters;
    }

    public EnumC5398Je0 getBillType() {
        EnumC5398Je0 enumC5398Je0J = EnumC5398Je0.j(this.billType_);
        return enumC5398Je0J == null ? EnumC5398Je0.UNRECOGNIZED : enumC5398Je0J;
    }

    public int getBillTypeValue() {
        return this.billType_;
    }

    public long getExpireDate() {
        return this.expireDate_;
    }

    public CollectionsStruct$Int64Value getPayDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.payDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public String getPayId() {
        return this.payId_;
    }

    public AbstractC2383g getPayIdBytes() {
        return AbstractC2383g.N(this.payId_);
    }

    public EnumC5164Ie0 getTermType() {
        EnumC5164Ie0 enumC5164Ie0J = EnumC5164Ie0.j(this.termType_);
        return enumC5164Ie0J == null ? EnumC5164Ie0.UNRECOGNIZED : enumC5164Ie0J;
    }

    public int getTermTypeValue() {
        return this.termType_;
    }

    public boolean hasBillParameters() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPayDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(BillStruct$Bill billStruct$Bill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billStruct$Bill);
    }

    public static BillStruct$Bill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillStruct$Bill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillStruct$Bill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillStruct$Bill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillStruct$Bill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillStruct$Bill parseFrom(byte[] bArr) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillStruct$Bill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillStruct$Bill parseFrom(InputStream inputStream) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillStruct$Bill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillStruct$Bill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillStruct$Bill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillStruct$Bill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
