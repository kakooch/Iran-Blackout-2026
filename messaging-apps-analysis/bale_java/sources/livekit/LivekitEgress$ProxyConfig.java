package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$ProxyConfig extends GeneratedMessageLite implements U64 {
    private static final LivekitEgress$ProxyConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 1;
    public static final int USERNAME_FIELD_NUMBER = 2;
    private String url_ = "";
    private String username_ = "";
    private String password_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$ProxyConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$ProxyConfig livekitEgress$ProxyConfig = new LivekitEgress$ProxyConfig();
        DEFAULT_INSTANCE = livekitEgress$ProxyConfig;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$ProxyConfig.class, livekitEgress$ProxyConfig);
    }

    private LivekitEgress$ProxyConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsername() {
        this.username_ = getDefaultInstance().getUsername();
    }

    public static LivekitEgress$ProxyConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$ProxyConfig parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ProxyConfig parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassword(String str) {
        str.getClass();
        this.password_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.password_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsername(String str) {
        str.getClass();
        this.username_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.username_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$ProxyConfig();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"url_", "username_", "password_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$ProxyConfig.class) {
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

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public String getUsername() {
        return this.username_;
    }

    public AbstractC2383g getUsernameBytes() {
        return AbstractC2383g.N(this.username_);
    }

    public static a newBuilder(LivekitEgress$ProxyConfig livekitEgress$ProxyConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$ProxyConfig);
    }

    public static LivekitEgress$ProxyConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ProxyConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$ProxyConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$ProxyConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$ProxyConfig parseFrom(byte[] bArr) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$ProxyConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$ProxyConfig parseFrom(InputStream inputStream) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ProxyConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ProxyConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$ProxyConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$ProxyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
