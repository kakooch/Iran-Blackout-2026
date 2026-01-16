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
public final class LlmAuth$ResponseGetAuthToken extends GeneratedMessageLite implements U64 {
    private static final LlmAuth$ResponseGetAuthToken DEFAULT_INSTANCE;
    public static final int EXPIRES_IN_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private long expiresIn_;
    private String token_ = "";
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LlmAuth$ResponseGetAuthToken.DEFAULT_INSTANCE);
        }
    }

    static {
        LlmAuth$ResponseGetAuthToken llmAuth$ResponseGetAuthToken = new LlmAuth$ResponseGetAuthToken();
        DEFAULT_INSTANCE = llmAuth$ResponseGetAuthToken;
        GeneratedMessageLite.registerDefaultInstance(LlmAuth$ResponseGetAuthToken.class, llmAuth$ResponseGetAuthToken);
    }

    private LlmAuth$ResponseGetAuthToken() {
    }

    private void clearExpiresIn() {
        this.expiresIn_ = 0L;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static LlmAuth$ResponseGetAuthToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LlmAuth$ResponseGetAuthToken parseDelimitedFrom(InputStream inputStream) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(ByteBuffer byteBuffer) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExpiresIn(long j) {
        this.expiresIn_ = j;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1912z0.a[gVar.ordinal()]) {
            case 1:
                return new LlmAuth$ResponseGetAuthToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002", new Object[]{"token_", "url_", "expiresIn_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LlmAuth$ResponseGetAuthToken.class) {
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

    public long getExpiresIn() {
        return this.expiresIn_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(LlmAuth$ResponseGetAuthToken llmAuth$ResponseGetAuthToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(llmAuth$ResponseGetAuthToken);
    }

    public static LlmAuth$ResponseGetAuthToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(AbstractC2383g abstractC2383g) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(byte[] bArr) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(InputStream inputStream) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(AbstractC2384h abstractC2384h) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LlmAuth$ResponseGetAuthToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LlmAuth$ResponseGetAuthToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
