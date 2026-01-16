package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestCryptoTransfer extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final KifpoolOuterClass$RequestCryptoTransfer DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int DST_PHONE_NO_FIELD_NUMBER = 5;
    public static final int DST_TOKEN_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SRC_TOKEN_FIELD_NUMBER = 2;
    private long amount_;
    private int bitField0_;
    private StringValue description_;
    private StringValue dstPhoneNo_;
    private String srcToken_ = "";
    private String dstToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCryptoTransfer.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCryptoTransfer kifpoolOuterClass$RequestCryptoTransfer = new KifpoolOuterClass$RequestCryptoTransfer();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCryptoTransfer;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCryptoTransfer.class, kifpoolOuterClass$RequestCryptoTransfer);
    }

    private KifpoolOuterClass$RequestCryptoTransfer() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDstPhoneNo() {
        this.dstPhoneNo_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDstToken() {
        this.dstToken_ = getDefaultInstance().getDstToken();
    }

    private void clearSrcToken() {
        this.srcToken_ = getDefaultInstance().getSrcToken();
    }

    public static KifpoolOuterClass$RequestCryptoTransfer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeDstPhoneNo(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.dstPhoneNo_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.dstPhoneNo_ = stringValue;
        } else {
            this.dstPhoneNo_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.dstPhoneNo_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setDstPhoneNo(StringValue stringValue) {
        stringValue.getClass();
        this.dstPhoneNo_ = stringValue;
        this.bitField0_ |= 2;
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
                return new KifpoolOuterClass$RequestCryptoTransfer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005ဉ\u0001", new Object[]{"bitField0_", "amount_", "srcToken_", "dstToken_", "description_", "dstPhoneNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCryptoTransfer.class) {
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

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getDstPhoneNo() {
        StringValue stringValue = this.dstPhoneNo_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
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

    public boolean hasDescription() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDstPhoneNo() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestCryptoTransfer kifpoolOuterClass$RequestCryptoTransfer) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCryptoTransfer);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCryptoTransfer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
