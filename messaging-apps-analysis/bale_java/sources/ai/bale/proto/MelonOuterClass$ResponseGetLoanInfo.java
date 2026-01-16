package ai.bale.proto;

import ai.bale.proto.MelonStruct$Loan;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MelonOuterClass$ResponseGetLoanInfo extends GeneratedMessageLite implements U64 {
    private static final MelonOuterClass$ResponseGetLoanInfo DEFAULT_INSTANCE;
    public static final int LOAN_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MelonStruct$Loan loan_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MelonOuterClass$ResponseGetLoanInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonOuterClass$ResponseGetLoanInfo melonOuterClass$ResponseGetLoanInfo = new MelonOuterClass$ResponseGetLoanInfo();
        DEFAULT_INSTANCE = melonOuterClass$ResponseGetLoanInfo;
        GeneratedMessageLite.registerDefaultInstance(MelonOuterClass$ResponseGetLoanInfo.class, melonOuterClass$ResponseGetLoanInfo);
    }

    private MelonOuterClass$ResponseGetLoanInfo() {
    }

    private void clearLoan() {
        this.loan_ = null;
        this.bitField0_ &= -2;
    }

    public static MelonOuterClass$ResponseGetLoanInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoan(MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        MelonStruct$Loan melonStruct$Loan2 = this.loan_;
        if (melonStruct$Loan2 == null || melonStruct$Loan2 == MelonStruct$Loan.getDefaultInstance()) {
            this.loan_ = melonStruct$Loan;
        } else {
            this.loan_ = (MelonStruct$Loan) ((MelonStruct$Loan.a) MelonStruct$Loan.newBuilder(this.loan_).v(melonStruct$Loan)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseDelimitedFrom(InputStream inputStream) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(ByteBuffer byteBuffer) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLoan(MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        this.loan_ = melonStruct$Loan;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I0.a[gVar.ordinal()]) {
            case 1:
                return new MelonOuterClass$ResponseGetLoanInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "loan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonOuterClass$ResponseGetLoanInfo.class) {
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

    public MelonStruct$Loan getLoan() {
        MelonStruct$Loan melonStruct$Loan = this.loan_;
        return melonStruct$Loan == null ? MelonStruct$Loan.getDefaultInstance() : melonStruct$Loan;
    }

    public boolean hasLoan() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MelonOuterClass$ResponseGetLoanInfo melonOuterClass$ResponseGetLoanInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonOuterClass$ResponseGetLoanInfo);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(byte[] bArr) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(InputStream inputStream) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonOuterClass$ResponseGetLoanInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
