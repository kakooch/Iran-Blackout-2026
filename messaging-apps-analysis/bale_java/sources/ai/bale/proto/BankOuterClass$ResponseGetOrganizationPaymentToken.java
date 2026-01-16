package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$ResponseGetOrganizationPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int BILL_HOLDER_NAME_FIELD_NUMBER = 2;
    private static final BankOuterClass$ResponseGetOrganizationPaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private double amount_;
    private String token_ = "";
    private String billHolderName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetOrganizationPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetOrganizationPaymentToken bankOuterClass$ResponseGetOrganizationPaymentToken = new BankOuterClass$ResponseGetOrganizationPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetOrganizationPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetOrganizationPaymentToken.class, bankOuterClass$ResponseGetOrganizationPaymentToken);
    }

    private BankOuterClass$ResponseGetOrganizationPaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0.0d;
    }

    private void clearBillHolderName() {
        this.billHolderName_ = getDefaultInstance().getBillHolderName();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(double d) {
        this.amount_ = d;
    }

    private void setBillHolderName(String str) {
        str.getClass();
        this.billHolderName_ = str;
    }

    private void setBillHolderNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.billHolderName_ = abstractC2383g.f0();
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetOrganizationPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0000", new Object[]{"token_", "billHolderName_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetOrganizationPaymentToken.class) {
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

    public double getAmount() {
        return this.amount_;
    }

    public String getBillHolderName() {
        return this.billHolderName_;
    }

    public AbstractC2383g getBillHolderNameBytes() {
        return AbstractC2383g.N(this.billHolderName_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(BankOuterClass$ResponseGetOrganizationPaymentToken bankOuterClass$ResponseGetOrganizationPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetOrganizationPaymentToken);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetOrganizationPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
