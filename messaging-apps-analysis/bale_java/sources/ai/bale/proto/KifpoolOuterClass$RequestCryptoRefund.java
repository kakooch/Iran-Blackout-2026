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
public final class KifpoolOuterClass$RequestCryptoRefund extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int APPROVAL_CODE_FIELD_NUMBER = 3;
    private static final KifpoolOuterClass$RequestCryptoRefund DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    public static final int TRX_REF_SRC_FIELD_NUMBER = 4;
    private long amount_;
    private long approvalCode_;
    private String token_ = "";
    private String trxRefSrc_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCryptoRefund.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCryptoRefund kifpoolOuterClass$RequestCryptoRefund = new KifpoolOuterClass$RequestCryptoRefund();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCryptoRefund;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCryptoRefund.class, kifpoolOuterClass$RequestCryptoRefund);
    }

    private KifpoolOuterClass$RequestCryptoRefund() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearApprovalCode() {
        this.approvalCode_ = 0L;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    private void clearTrxRefSrc() {
        this.trxRefSrc_ = getDefaultInstance().getTrxRefSrc();
    }

    public static KifpoolOuterClass$RequestCryptoRefund getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setApprovalCode(long j) {
        this.approvalCode_ = j;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    private void setTrxRefSrc(String str) {
        str.getClass();
        this.trxRefSrc_ = str;
    }

    private void setTrxRefSrcBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trxRefSrc_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestCryptoRefund();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004Ȉ", new Object[]{"token_", "amount_", "approvalCode_", "trxRefSrc_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCryptoRefund.class) {
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

    public long getApprovalCode() {
        return this.approvalCode_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public String getTrxRefSrc() {
        return this.trxRefSrc_;
    }

    public AbstractC2383g getTrxRefSrcBytes() {
        return AbstractC2383g.N(this.trxRefSrc_);
    }

    public static a newBuilder(KifpoolOuterClass$RequestCryptoRefund kifpoolOuterClass$RequestCryptoRefund) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCryptoRefund);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCryptoRefund parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoRefund) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
