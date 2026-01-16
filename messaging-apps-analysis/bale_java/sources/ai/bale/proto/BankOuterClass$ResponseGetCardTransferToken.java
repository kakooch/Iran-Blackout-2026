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
public final class BankOuterClass$ResponseGetCardTransferToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseGetCardTransferToken DEFAULT_INSTANCE;
    public static final int DEST_CARD_NO_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_END_POINT_FIELD_NUMBER = 1;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private int bitField0_;
    private StringValue destCardNo_;
    private String requestEndPoint_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetCardTransferToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetCardTransferToken bankOuterClass$ResponseGetCardTransferToken = new BankOuterClass$ResponseGetCardTransferToken();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetCardTransferToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetCardTransferToken.class, bankOuterClass$ResponseGetCardTransferToken);
    }

    private BankOuterClass$ResponseGetCardTransferToken() {
    }

    private void clearDestCardNo() {
        this.destCardNo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRequestEndPoint() {
        this.requestEndPoint_ = getDefaultInstance().getRequestEndPoint();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BankOuterClass$ResponseGetCardTransferToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDestCardNo(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.destCardNo_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.destCardNo_ = stringValue;
        } else {
            this.destCardNo_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.destCardNo_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDestCardNo(StringValue stringValue) {
        stringValue.getClass();
        this.destCardNo_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setRequestEndPoint(String str) {
        str.getClass();
        this.requestEndPoint_ = str;
    }

    private void setRequestEndPointBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requestEndPoint_ = abstractC2383g.f0();
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
                return new BankOuterClass$ResponseGetCardTransferToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "requestEndPoint_", "token_", "destCardNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetCardTransferToken.class) {
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

    public StringValue getDestCardNo() {
        StringValue stringValue = this.destCardNo_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getRequestEndPoint() {
        return this.requestEndPoint_;
    }

    public AbstractC2383g getRequestEndPointBytes() {
        return AbstractC2383g.N(this.requestEndPoint_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasDestCardNo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$ResponseGetCardTransferToken bankOuterClass$ResponseGetCardTransferToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetCardTransferToken);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetCardTransferToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
