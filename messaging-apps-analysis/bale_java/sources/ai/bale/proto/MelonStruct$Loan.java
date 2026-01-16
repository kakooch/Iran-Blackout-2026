package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.N14;
import ir.nasim.O14;
import ir.nasim.P14;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MelonStruct$Loan extends GeneratedMessageLite implements N14 {
    public static final int CONTRACT_ID_FIELD_NUMBER = 1;
    private static final MelonStruct$Loan DEFAULT_INSTANCE;
    public static final int DUE_DATE_FIELD_NUMBER = 7;
    public static final int INSTALLMENT_AMOUNT_FIELD_NUMBER = 2;
    public static final int INSTALLMENT_COUNT_FIELD_NUMBER = 6;
    public static final int LOAN_AMOUNT_FIELD_NUMBER = 5;
    public static final int LOAN_STATUS_FIELD_NUMBER = 3;
    public static final int LOAN_TYPE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PAY_COUNT_FIELD_NUMBER = 8;
    public static final int TOTAL_PAYABLE_AMOUNT_FIELD_NUMBER = 9;
    private long dueDate_;
    private int installmentCount_;
    private int loanStatus_;
    private int loanType_;
    private int payCount_;
    private String contractId_ = "";
    private String installmentAmount_ = "";
    private String loanAmount_ = "";
    private String totalPayableAmount_ = "";

    public static final class a extends GeneratedMessageLite.b implements N14 {
        private a() {
            super(MelonStruct$Loan.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonStruct$Loan melonStruct$Loan = new MelonStruct$Loan();
        DEFAULT_INSTANCE = melonStruct$Loan;
        GeneratedMessageLite.registerDefaultInstance(MelonStruct$Loan.class, melonStruct$Loan);
    }

    private MelonStruct$Loan() {
    }

    private void clearContractId() {
        this.contractId_ = getDefaultInstance().getContractId();
    }

    private void clearDueDate() {
        this.dueDate_ = 0L;
    }

    private void clearInstallmentAmount() {
        this.installmentAmount_ = getDefaultInstance().getInstallmentAmount();
    }

    private void clearInstallmentCount() {
        this.installmentCount_ = 0;
    }

    private void clearLoanAmount() {
        this.loanAmount_ = getDefaultInstance().getLoanAmount();
    }

    private void clearLoanStatus() {
        this.loanStatus_ = 0;
    }

    private void clearLoanType() {
        this.loanType_ = 0;
    }

    private void clearPayCount() {
        this.payCount_ = 0;
    }

    private void clearTotalPayableAmount() {
        this.totalPayableAmount_ = getDefaultInstance().getTotalPayableAmount();
    }

    public static MelonStruct$Loan getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonStruct$Loan parseDelimitedFrom(InputStream inputStream) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonStruct$Loan parseFrom(ByteBuffer byteBuffer) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContractId(String str) {
        str.getClass();
        this.contractId_ = str;
    }

    private void setContractIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.contractId_ = abstractC2383g.f0();
    }

    private void setDueDate(long j) {
        this.dueDate_ = j;
    }

    private void setInstallmentAmount(String str) {
        str.getClass();
        this.installmentAmount_ = str;
    }

    private void setInstallmentAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.installmentAmount_ = abstractC2383g.f0();
    }

    private void setInstallmentCount(int i) {
        this.installmentCount_ = i;
    }

    private void setLoanAmount(String str) {
        str.getClass();
        this.loanAmount_ = str;
    }

    private void setLoanAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.loanAmount_ = abstractC2383g.f0();
    }

    private void setLoanStatus(O14 o14) {
        this.loanStatus_ = o14.getNumber();
    }

    private void setLoanStatusValue(int i) {
        this.loanStatus_ = i;
    }

    private void setLoanType(P14 p14) {
        this.loanType_ = p14.getNumber();
    }

    private void setLoanTypeValue(int i) {
        this.loanType_ = i;
    }

    private void setPayCount(int i) {
        this.payCount_ = i;
    }

    private void setTotalPayableAmount(String str) {
        str.getClass();
        this.totalPayableAmount_ = str;
    }

    private void setTotalPayableAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.totalPayableAmount_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J0.a[gVar.ordinal()]) {
            case 1:
                return new MelonStruct$Loan();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f\u0005Ȉ\u0006\u0004\u0007\u0002\b\u0004\tȈ", new Object[]{"contractId_", "installmentAmount_", "loanStatus_", "loanType_", "loanAmount_", "installmentCount_", "dueDate_", "payCount_", "totalPayableAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonStruct$Loan.class) {
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

    public String getContractId() {
        return this.contractId_;
    }

    public AbstractC2383g getContractIdBytes() {
        return AbstractC2383g.N(this.contractId_);
    }

    public long getDueDate() {
        return this.dueDate_;
    }

    public String getInstallmentAmount() {
        return this.installmentAmount_;
    }

    public AbstractC2383g getInstallmentAmountBytes() {
        return AbstractC2383g.N(this.installmentAmount_);
    }

    public int getInstallmentCount() {
        return this.installmentCount_;
    }

    public String getLoanAmount() {
        return this.loanAmount_;
    }

    public AbstractC2383g getLoanAmountBytes() {
        return AbstractC2383g.N(this.loanAmount_);
    }

    public O14 getLoanStatus() {
        O14 o14J = O14.j(this.loanStatus_);
        return o14J == null ? O14.UNRECOGNIZED : o14J;
    }

    public int getLoanStatusValue() {
        return this.loanStatus_;
    }

    public P14 getLoanType() {
        P14 p14J = P14.j(this.loanType_);
        return p14J == null ? P14.UNRECOGNIZED : p14J;
    }

    public int getLoanTypeValue() {
        return this.loanType_;
    }

    public int getPayCount() {
        return this.payCount_;
    }

    public String getTotalPayableAmount() {
        return this.totalPayableAmount_;
    }

    public AbstractC2383g getTotalPayableAmountBytes() {
        return AbstractC2383g.N(this.totalPayableAmount_);
    }

    public static a newBuilder(MelonStruct$Loan melonStruct$Loan) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonStruct$Loan);
    }

    public static MelonStruct$Loan parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonStruct$Loan parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonStruct$Loan parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MelonStruct$Loan parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonStruct$Loan parseFrom(byte[] bArr) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonStruct$Loan parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonStruct$Loan parseFrom(InputStream inputStream) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonStruct$Loan parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonStruct$Loan parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonStruct$Loan parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonStruct$Loan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
