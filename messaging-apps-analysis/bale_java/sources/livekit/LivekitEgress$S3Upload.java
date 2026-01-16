package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import livekit.LivekitEgress$ProxyConfig;

/* loaded from: classes8.dex */
public final class LivekitEgress$S3Upload extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_KEY_FIELD_NUMBER = 1;
    public static final int BUCKET_FIELD_NUMBER = 5;
    public static final int CONTENT_DISPOSITION_FIELD_NUMBER = 9;
    private static final LivekitEgress$S3Upload DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 4;
    public static final int FORCE_PATH_STYLE_FIELD_NUMBER = 6;
    public static final int METADATA_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PROXY_FIELD_NUMBER = 10;
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int SECRET_FIELD_NUMBER = 2;
    public static final int SESSION_TOKEN_FIELD_NUMBER = 11;
    public static final int TAGGING_FIELD_NUMBER = 8;
    private boolean forcePathStyle_;
    private LivekitEgress$ProxyConfig proxy_;
    private J metadata_ = J.e();
    private String accessKey_ = "";
    private String secret_ = "";
    private String sessionToken_ = "";
    private String region_ = "";
    private String endpoint_ = "";
    private String bucket_ = "";
    private String tagging_ = "";
    private String contentDisposition_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$S3Upload.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    static {
        LivekitEgress$S3Upload livekitEgress$S3Upload = new LivekitEgress$S3Upload();
        DEFAULT_INSTANCE = livekitEgress$S3Upload;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$S3Upload.class, livekitEgress$S3Upload);
    }

    private LivekitEgress$S3Upload() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccessKey() {
        this.accessKey_ = getDefaultInstance().getAccessKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBucket() {
        this.bucket_ = getDefaultInstance().getBucket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContentDisposition() {
        this.contentDisposition_ = getDefaultInstance().getContentDisposition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearForcePathStyle() {
        this.forcePathStyle_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProxy() {
        this.proxy_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecret() {
        this.secret_ = getDefaultInstance().getSecret();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionToken() {
        this.sessionToken_ = getDefaultInstance().getSessionToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTagging() {
        this.tagging_ = getDefaultInstance().getTagging();
    }

    public static LivekitEgress$S3Upload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    private J internalGetMetadata() {
        return this.metadata_;
    }

    private J internalGetMutableMetadata() {
        if (!this.metadata_.n()) {
            this.metadata_ = this.metadata_.s();
        }
        return this.metadata_;
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

    public static LivekitEgress$S3Upload parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$S3Upload parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessKey(String str) {
        str.getClass();
        this.accessKey_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accessKey_ = abstractC2383g.f0();
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
    public void setContentDisposition(String str) {
        str.getClass();
        this.contentDisposition_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentDispositionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.contentDisposition_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndpoint(String str) {
        str.getClass();
        this.endpoint_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndpointBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.endpoint_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForcePathStyle(boolean z) {
        this.forcePathStyle_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProxy(LivekitEgress$ProxyConfig livekitEgress$ProxyConfig) {
        livekitEgress$ProxyConfig.getClass();
        this.proxy_ = livekitEgress$ProxyConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(String str) {
        str.getClass();
        this.region_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.region_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecret(String str) {
        str.getClass();
        this.secret_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecretBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.secret_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionToken(String str) {
        str.getClass();
        this.sessionToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sessionToken_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTagging(String str) {
        str.getClass();
        this.tagging_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaggingBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.tagging_ = abstractC2383g.f0();
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$S3Upload();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0007\u00072\bȈ\tȈ\n\t\u000bȈ", new Object[]{"accessKey_", "secret_", "region_", "endpoint_", "bucket_", "forcePathStyle_", "metadata_", b.a, "tagging_", "contentDisposition_", "proxy_", "sessionToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$S3Upload.class) {
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

    public String getAccessKey() {
        return this.accessKey_;
    }

    public AbstractC2383g getAccessKeyBytes() {
        return AbstractC2383g.N(this.accessKey_);
    }

    public String getBucket() {
        return this.bucket_;
    }

    public AbstractC2383g getBucketBytes() {
        return AbstractC2383g.N(this.bucket_);
    }

    public String getContentDisposition() {
        return this.contentDisposition_;
    }

    public AbstractC2383g getContentDispositionBytes() {
        return AbstractC2383g.N(this.contentDisposition_);
    }

    public String getEndpoint() {
        return this.endpoint_;
    }

    public AbstractC2383g getEndpointBytes() {
        return AbstractC2383g.N(this.endpoint_);
    }

    public boolean getForcePathStyle() {
        return this.forcePathStyle_;
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetMetadata = internalGetMetadata();
        return jInternalGetMetadata.containsKey(str) ? (String) jInternalGetMetadata.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getMetadataOrThrow(String str) {
        str.getClass();
        J jInternalGetMetadata = internalGetMetadata();
        if (jInternalGetMetadata.containsKey(str)) {
            return (String) jInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    public LivekitEgress$ProxyConfig getProxy() {
        LivekitEgress$ProxyConfig livekitEgress$ProxyConfig = this.proxy_;
        return livekitEgress$ProxyConfig == null ? LivekitEgress$ProxyConfig.getDefaultInstance() : livekitEgress$ProxyConfig;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public String getSecret() {
        return this.secret_;
    }

    public AbstractC2383g getSecretBytes() {
        return AbstractC2383g.N(this.secret_);
    }

    public String getSessionToken() {
        return this.sessionToken_;
    }

    public AbstractC2383g getSessionTokenBytes() {
        return AbstractC2383g.N(this.sessionToken_);
    }

    public String getTagging() {
        return this.tagging_;
    }

    public AbstractC2383g getTaggingBytes() {
        return AbstractC2383g.N(this.tagging_);
    }

    public boolean hasProxy() {
        return this.proxy_ != null;
    }

    public static a newBuilder(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$S3Upload);
    }

    public static LivekitEgress$S3Upload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$S3Upload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$S3Upload parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$S3Upload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$S3Upload parseFrom(byte[] bArr) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$S3Upload parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$S3Upload parseFrom(InputStream inputStream) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$S3Upload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$S3Upload parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$S3Upload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$S3Upload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
