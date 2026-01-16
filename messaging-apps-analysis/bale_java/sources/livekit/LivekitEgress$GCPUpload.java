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
import livekit.LivekitEgress$ProxyConfig;

/* loaded from: classes8.dex */
public final class LivekitEgress$GCPUpload extends GeneratedMessageLite implements U64 {
    public static final int BUCKET_FIELD_NUMBER = 2;
    public static final int CREDENTIALS_FIELD_NUMBER = 1;
    private static final LivekitEgress$GCPUpload DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PROXY_FIELD_NUMBER = 3;
    private LivekitEgress$ProxyConfig proxy_;
    private String credentials_ = "";
    private String bucket_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$GCPUpload.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$GCPUpload livekitEgress$GCPUpload = new LivekitEgress$GCPUpload();
        DEFAULT_INSTANCE = livekitEgress$GCPUpload;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$GCPUpload.class, livekitEgress$GCPUpload);
    }

    private LivekitEgress$GCPUpload() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBucket() {
        this.bucket_ = getDefaultInstance().getBucket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCredentials() {
        this.credentials_ = getDefaultInstance().getCredentials();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProxy() {
        this.proxy_ = null;
    }

    public static LivekitEgress$GCPUpload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeProxy(LivekitEgress$ProxyConfig livekitEgress$ProxyConfig) {
        livekitEgress$ProxyConfig.getClass();
        LivekitEgress$ProxyConfig livekitEgress$ProxyConfig2 = this.proxy_;
        if (livekitEgress$ProxyConfig2 == null || livekitEgress$ProxyConfig2 == LivekitEgress$ProxyConfig.getDefaultInstance()) {
            this.proxy_ = livekitEgress$ProxyConfig;
        } else {
            this.proxy_ = (LivekitEgress$ProxyConfig) ((LivekitEgress$ProxyConfig.a) LivekitEgress$ProxyConfig.newBuilder(this.proxy_).v(livekitEgress$ProxyConfig)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$GCPUpload parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$GCPUpload parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucket(String str) {
        str.getClass();
        this.bucket_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucketBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.bucket_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCredentials(String str) {
        str.getClass();
        this.credentials_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCredentialsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.credentials_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProxy(LivekitEgress$ProxyConfig livekitEgress$ProxyConfig) {
        livekitEgress$ProxyConfig.getClass();
        this.proxy_ = livekitEgress$ProxyConfig;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$GCPUpload();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\t", new Object[]{"credentials_", "bucket_", "proxy_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$GCPUpload.class) {
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

    public String getBucket() {
        return this.bucket_;
    }

    public AbstractC2383g getBucketBytes() {
        return AbstractC2383g.N(this.bucket_);
    }

    public String getCredentials() {
        return this.credentials_;
    }

    public AbstractC2383g getCredentialsBytes() {
        return AbstractC2383g.N(this.credentials_);
    }

    public LivekitEgress$ProxyConfig getProxy() {
        LivekitEgress$ProxyConfig livekitEgress$ProxyConfig = this.proxy_;
        return livekitEgress$ProxyConfig == null ? LivekitEgress$ProxyConfig.getDefaultInstance() : livekitEgress$ProxyConfig;
    }

    public boolean hasProxy() {
        return this.proxy_ != null;
    }

    public static a newBuilder(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$GCPUpload);
    }

    public static LivekitEgress$GCPUpload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$GCPUpload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$GCPUpload parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$GCPUpload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$GCPUpload parseFrom(byte[] bArr) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$GCPUpload parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$GCPUpload parseFrom(InputStream inputStream) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$GCPUpload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$GCPUpload parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$GCPUpload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$GCPUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
