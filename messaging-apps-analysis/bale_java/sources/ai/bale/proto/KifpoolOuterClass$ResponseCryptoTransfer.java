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
public final class KifpoolOuterClass$ResponseCryptoTransfer extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int APPROVAL_CODE_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 2;
    private static final KifpoolOuterClass$ResponseCryptoTransfer DEFAULT_INSTANCE;
    public static final int DST_TOKEN_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SRC_TOKEN_FIELD_NUMBER = 4;
    private long amount_;
    private long approvalCode_;
    private long date_;
    private String srcToken_ = "";
    private String dstToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseCryptoTransfer.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseCryptoTransfer kifpoolOuterClass$ResponseCryptoTransfer = new KifpoolOuterClass$ResponseCryptoTransfer();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseCryptoTransfer;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseCryptoTransfer.class, kifpoolOuterClass$ResponseCryptoTransfer);
    }

    private KifpoolOuterClass$ResponseCryptoTransfer() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearApprovalCode() {
        this.approvalCode_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearDstToken() {
        this.dstToken_ = getDefaultInstance().getDstToken();
    }

    private void clearSrcToken() {
        this.srcToken_ = getDefaultInstance().getSrcToken();
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setDstToken(String str) {
        str.getClass();
        this.dstToken_ = str;
    }

    private void setDstTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.dstToken_ = abstractC2383g.f0();
    }

    private void setSrcToken(String str) {
        str.getClass();
        this.srcToken_ = str;
    }

    private void setSrcTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.srcToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseCryptoTransfer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004Ȉ\u0005Ȉ", new Object[]{"amount_", "date_", "approvalCode_", "srcToken_", "dstToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseCryptoTransfer.class) {
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

    public long getDate() {
        return this.date_;
    }

    public String getDstToken() {
        return this.dstToken_;
    }

    public AbstractC2383g getDstTokenBytes() {
        return AbstractC2383g.N(this.dstToken_);
    }

    public String getSrcToken() {
        return this.srcToken_;
    }

    public AbstractC2383g getSrcTokenBytes() {
        return AbstractC2383g.N(this.srcToken_);
    }

    public static a newBuilder(KifpoolOuterClass$ResponseCryptoTransfer kifpoolOuterClass$ResponseCryptoTransfer) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseCryptoTransfer);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseCryptoTransfer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
