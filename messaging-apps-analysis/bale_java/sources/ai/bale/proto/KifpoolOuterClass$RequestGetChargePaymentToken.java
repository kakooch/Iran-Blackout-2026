package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7187Qq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestGetChargePaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int CALLBACKTYPE_FIELD_NUMBER = 3;
    private static final KifpoolOuterClass$RequestGetChargePaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private long amount_;
    private int callbackType_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestGetChargePaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestGetChargePaymentToken kifpoolOuterClass$RequestGetChargePaymentToken = new KifpoolOuterClass$RequestGetChargePaymentToken();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestGetChargePaymentToken;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestGetChargePaymentToken.class, kifpoolOuterClass$RequestGetChargePaymentToken);
    }

    private KifpoolOuterClass$RequestGetChargePaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCallbackType() {
        this.callbackType_ = 0;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCallbackType(EnumC7187Qq3 enumC7187Qq3) {
        this.callbackType_ = enumC7187Qq3.getNumber();
    }

    private void setCallbackTypeValue(int i) {
        this.callbackType_ = i;
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
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestGetChargePaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\f", new Object[]{"token_", "amount_", "callbackType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestGetChargePaymentToken.class) {
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

    public EnumC7187Qq3 getCallbackType() {
        EnumC7187Qq3 enumC7187Qq3J = EnumC7187Qq3.j(this.callbackType_);
        return enumC7187Qq3J == null ? EnumC7187Qq3.UNRECOGNIZED : enumC7187Qq3J;
    }

    public int getCallbackTypeValue() {
        return this.callbackType_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(KifpoolOuterClass$RequestGetChargePaymentToken kifpoolOuterClass$RequestGetChargePaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestGetChargePaymentToken);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestGetChargePaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
