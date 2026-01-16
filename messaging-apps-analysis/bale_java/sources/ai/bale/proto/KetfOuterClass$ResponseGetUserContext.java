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
public final class KetfOuterClass$ResponseGetUserContext extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final KetfOuterClass$ResponseGetUserContext DEFAULT_INSTANCE;
    public static final int NONCE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SIGN_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int botUserId_;
    private String nonce_ = "";
    private String sign_ = "";
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetUserContext.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetUserContext ketfOuterClass$ResponseGetUserContext = new KetfOuterClass$ResponseGetUserContext();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetUserContext;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetUserContext.class, ketfOuterClass$ResponseGetUserContext);
    }

    private KetfOuterClass$ResponseGetUserContext() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearNonce() {
        this.nonce_ = getDefaultInstance().getNonce();
    }

    private void clearSign() {
        this.sign_ = getDefaultInstance().getSign();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static KetfOuterClass$ResponseGetUserContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetUserContext parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    private void setNonce(String str) {
        str.getClass();
        this.nonce_ = str;
    }

    private void setNonceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nonce_ = abstractC2383g.f0();
    }

    private void setSign(String str) {
        str.getClass();
        this.sign_ = str;
    }

    private void setSignBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sign_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetUserContext();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ\u0004Ȉ", new Object[]{"botUserId_", "userId_", "nonce_", "sign_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetUserContext.class) {
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

    public int getBotUserId() {
        return this.botUserId_;
    }

    public String getNonce() {
        return this.nonce_;
    }

    public AbstractC2383g getNonceBytes() {
        return AbstractC2383g.N(this.nonce_);
    }

    public String getSign() {
        return this.sign_;
    }

    public AbstractC2383g getSignBytes() {
        return AbstractC2383g.N(this.sign_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetUserContext ketfOuterClass$ResponseGetUserContext) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetUserContext);
    }

    public static KetfOuterClass$ResponseGetUserContext parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetUserContext parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetUserContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
