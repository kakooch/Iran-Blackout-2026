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
public final class BankOuterClass$RequestGetOrganizationPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final BankOuterClass$RequestGetOrganizationPaymentToken DEFAULT_INSTANCE;
    public static final int INVOICE_ID_FIELD_NUMBER = 2;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long amount_;
    private String organizationId_ = "";
    private String invoiceId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestGetOrganizationPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetOrganizationPaymentToken bankOuterClass$RequestGetOrganizationPaymentToken = new BankOuterClass$RequestGetOrganizationPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetOrganizationPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetOrganizationPaymentToken.class, bankOuterClass$RequestGetOrganizationPaymentToken);
    }

    private BankOuterClass$RequestGetOrganizationPaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearInvoiceId() {
        this.invoiceId_ = getDefaultInstance().getInvoiceId();
    }

    private void clearOrganizationId() {
        this.organizationId_ = getDefaultInstance().getOrganizationId();
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setInvoiceId(String str) {
        str.getClass();
        this.invoiceId_ = str;
    }

    private void setInvoiceIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.invoiceId_ = abstractC2383g.f0();
    }

    private void setOrganizationId(String str) {
        str.getClass();
        this.organizationId_ = str;
    }

    private void setOrganizationIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.organizationId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetOrganizationPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002", new Object[]{"organizationId_", "invoiceId_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetOrganizationPaymentToken.class) {
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

    public String getInvoiceId() {
        return this.invoiceId_;
    }

    public AbstractC2383g getInvoiceIdBytes() {
        return AbstractC2383g.N(this.invoiceId_);
    }

    public String getOrganizationId() {
        return this.organizationId_;
    }

    public AbstractC2383g getOrganizationIdBytes() {
        return AbstractC2383g.N(this.organizationId_);
    }

    public static a newBuilder(BankOuterClass$RequestGetOrganizationPaymentToken bankOuterClass$RequestGetOrganizationPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetOrganizationPaymentToken);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetOrganizationPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetOrganizationPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
