package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13451gF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$WebhookConfig extends GeneratedMessageLite implements InterfaceC13451gF3 {
    private static final LivekitModels$WebhookConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SIGNING_KEY_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    private String url_ = "";
    private String signingKey_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13451gF3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$WebhookConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$WebhookConfig livekitModels$WebhookConfig = new LivekitModels$WebhookConfig();
        DEFAULT_INSTANCE = livekitModels$WebhookConfig;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$WebhookConfig.class, livekitModels$WebhookConfig);
    }

    private LivekitModels$WebhookConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSigningKey() {
        this.signingKey_ = getDefaultInstance().getSigningKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static LivekitModels$WebhookConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$WebhookConfig parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$WebhookConfig parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSigningKey(String str) {
        str.getClass();
        this.signingKey_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSigningKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.signingKey_ = abstractC2383g.f0();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$WebhookConfig();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"url_", "signingKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$WebhookConfig.class) {
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

    public String getSigningKey() {
        return this.signingKey_;
    }

    public AbstractC2383g getSigningKeyBytes() {
        return AbstractC2383g.N(this.signingKey_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$WebhookConfig);
    }

    public static LivekitModels$WebhookConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$WebhookConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$WebhookConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$WebhookConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$WebhookConfig parseFrom(byte[] bArr) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$WebhookConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$WebhookConfig parseFrom(InputStream inputStream) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$WebhookConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$WebhookConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$WebhookConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$WebhookConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
