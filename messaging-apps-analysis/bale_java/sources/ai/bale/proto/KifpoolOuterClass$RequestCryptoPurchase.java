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
public final class KifpoolOuterClass$RequestCryptoPurchase extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int BORNATRXID_FIELD_NUMBER = 6;
    private static final KifpoolOuterClass$RequestCryptoPurchase DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int DST_TOKEN_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SRC_TOKEN_FIELD_NUMBER = 2;
    public static final int TERMINAL_ID_FIELD_NUMBER = 5;
    private int amount_;
    private String srcToken_ = "";
    private String dstToken_ = "";
    private String description_ = "";
    private String terminalId_ = "";
    private String bornaTrxId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCryptoPurchase.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCryptoPurchase kifpoolOuterClass$RequestCryptoPurchase = new KifpoolOuterClass$RequestCryptoPurchase();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCryptoPurchase;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCryptoPurchase.class, kifpoolOuterClass$RequestCryptoPurchase);
    }

    private KifpoolOuterClass$RequestCryptoPurchase() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearBornaTrxId() {
        this.bornaTrxId_ = getDefaultInstance().getBornaTrxId();
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearDstToken() {
        this.dstToken_ = getDefaultInstance().getDstToken();
    }

    private void clearSrcToken() {
        this.srcToken_ = getDefaultInstance().getSrcToken();
    }

    private void clearTerminalId() {
        this.terminalId_ = getDefaultInstance().getTerminalId();
    }

    public static KifpoolOuterClass$RequestCryptoPurchase getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(int i) {
        this.amount_ = i;
    }

    private void setBornaTrxId(String str) {
        str.getClass();
        this.bornaTrxId_ = str;
    }

    private void setBornaTrxIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.bornaTrxId_ = abstractC2383g.f0();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
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

    private void setTerminalId(String str) {
        str.getClass();
        this.terminalId_ = str;
    }

    private void setTerminalIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.terminalId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestCryptoPurchase();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ", new Object[]{"amount_", "srcToken_", "dstToken_", "description_", "terminalId_", "bornaTrxId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCryptoPurchase.class) {
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

    public int getAmount() {
        return this.amount_;
    }

    public String getBornaTrxId() {
        return this.bornaTrxId_;
    }

    public AbstractC2383g getBornaTrxIdBytes() {
        return AbstractC2383g.N(this.bornaTrxId_);
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
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

    public String getTerminalId() {
        return this.terminalId_;
    }

    public AbstractC2383g getTerminalIdBytes() {
        return AbstractC2383g.N(this.terminalId_);
    }

    public static a newBuilder(KifpoolOuterClass$RequestCryptoPurchase kifpoolOuterClass$RequestCryptoPurchase) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCryptoPurchase);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCryptoPurchase parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoPurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
