package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC13810gr3;
import ir.nasim.InterfaceC8128Uq3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolStruct$InvoiceRecord extends GeneratedMessageLite implements InterfaceC8128Uq3 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int APPROVAL_CODE_FIELD_NUMBER = 6;
    public static final int APP_FIELD_NUMBER = 3;
    public static final int CREDITDEBIT_FIELD_NUMBER = 5;
    public static final int DATE_FIELD_NUMBER = 4;
    private static final KifpoolStruct$InvoiceRecord DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_TYPE_FIELD_NUMBER = 2;
    public static final int TRX_REF_FIELD_NUMBER = 7;
    private long amount_;
    private long approvalCode_;
    private long creditDebit_;
    private long date_;
    private int transactionType_;
    private String app_ = "";
    private String trxRef_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8128Uq3 {
        private a() {
            super(KifpoolStruct$InvoiceRecord.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolStruct$InvoiceRecord kifpoolStruct$InvoiceRecord = new KifpoolStruct$InvoiceRecord();
        DEFAULT_INSTANCE = kifpoolStruct$InvoiceRecord;
        GeneratedMessageLite.registerDefaultInstance(KifpoolStruct$InvoiceRecord.class, kifpoolStruct$InvoiceRecord);
    }

    private KifpoolStruct$InvoiceRecord() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearApp() {
        this.app_ = getDefaultInstance().getApp();
    }

    private void clearApprovalCode() {
        this.approvalCode_ = 0L;
    }

    private void clearCreditDebit() {
        this.creditDebit_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearTransactionType() {
        this.transactionType_ = 0;
    }

    private void clearTrxRef() {
        this.trxRef_ = getDefaultInstance().getTrxRef();
    }

    public static KifpoolStruct$InvoiceRecord getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolStruct$InvoiceRecord parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setApp(String str) {
        str.getClass();
        this.app_ = str;
    }

    private void setAppBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.app_ = abstractC2383g.f0();
    }

    private void setApprovalCode(long j) {
        this.approvalCode_ = j;
    }

    private void setCreditDebit(long j) {
        this.creditDebit_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setTransactionType(EnumC13810gr3 enumC13810gr3) {
        this.transactionType_ = enumC13810gr3.getNumber();
    }

    private void setTransactionTypeValue(int i) {
        this.transactionType_ = i;
    }

    private void setTrxRef(String str) {
        str.getClass();
        this.trxRef_ = str;
    }

    private void setTrxRefBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trxRef_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1900v0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolStruct$InvoiceRecord();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003Ȉ\u0004\u0002\u0005\u0002\u0006\u0002\u0007Ȉ", new Object[]{"amount_", "transactionType_", "app_", "date_", "creditDebit_", "approvalCode_", "trxRef_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolStruct$InvoiceRecord.class) {
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

    public String getApp() {
        return this.app_;
    }

    public AbstractC2383g getAppBytes() {
        return AbstractC2383g.N(this.app_);
    }

    public long getApprovalCode() {
        return this.approvalCode_;
    }

    public long getCreditDebit() {
        return this.creditDebit_;
    }

    public long getDate() {
        return this.date_;
    }

    public EnumC13810gr3 getTransactionType() {
        EnumC13810gr3 enumC13810gr3J = EnumC13810gr3.j(this.transactionType_);
        return enumC13810gr3J == null ? EnumC13810gr3.UNRECOGNIZED : enumC13810gr3J;
    }

    public int getTransactionTypeValue() {
        return this.transactionType_;
    }

    public String getTrxRef() {
        return this.trxRef_;
    }

    public AbstractC2383g getTrxRefBytes() {
        return AbstractC2383g.N(this.trxRef_);
    }

    public static a newBuilder(KifpoolStruct$InvoiceRecord kifpoolStruct$InvoiceRecord) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolStruct$InvoiceRecord);
    }

    public static KifpoolStruct$InvoiceRecord parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(byte[] bArr) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(InputStream inputStream) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolStruct$InvoiceRecord parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolStruct$InvoiceRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
