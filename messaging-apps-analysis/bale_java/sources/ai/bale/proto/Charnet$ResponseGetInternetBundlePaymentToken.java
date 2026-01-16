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
public final class Charnet$ResponseGetInternetBundlePaymentToken extends GeneratedMessageLite implements U64 {
    private static final Charnet$ResponseGetInternetBundlePaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$ResponseGetInternetBundlePaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$ResponseGetInternetBundlePaymentToken charnet$ResponseGetInternetBundlePaymentToken = new Charnet$ResponseGetInternetBundlePaymentToken();
        DEFAULT_INSTANCE = charnet$ResponseGetInternetBundlePaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Charnet$ResponseGetInternetBundlePaymentToken.class, charnet$ResponseGetInternetBundlePaymentToken);
    }

    private Charnet$ResponseGetInternetBundlePaymentToken() {
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$ResponseGetInternetBundlePaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$ResponseGetInternetBundlePaymentToken.class) {
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

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(Charnet$ResponseGetInternetBundlePaymentToken charnet$ResponseGetInternetBundlePaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$ResponseGetInternetBundlePaymentToken);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(byte[] bArr) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(InputStream inputStream) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$ResponseGetInternetBundlePaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
