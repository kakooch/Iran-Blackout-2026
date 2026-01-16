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
public final class LivekitEgress$AliOSSUpload extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_KEY_FIELD_NUMBER = 1;
    public static final int BUCKET_FIELD_NUMBER = 5;
    private static final LivekitEgress$AliOSSUpload DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int SECRET_FIELD_NUMBER = 2;
    private String accessKey_ = "";
    private String secret_ = "";
    private String region_ = "";
    private String endpoint_ = "";
    private String bucket_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$AliOSSUpload.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload = new LivekitEgress$AliOSSUpload();
        DEFAULT_INSTANCE = livekitEgress$AliOSSUpload;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$AliOSSUpload.class, livekitEgress$AliOSSUpload);
    }

    private LivekitEgress$AliOSSUpload() {
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
    public void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecret() {
        this.secret_ = getDefaultInstance().getSecret();
    }

    public static LivekitEgress$AliOSSUpload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$AliOSSUpload parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$AliOSSUpload();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"accessKey_", "secret_", "region_", "endpoint_", "bucket_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$AliOSSUpload.class) {
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

    public String getEndpoint() {
        return this.endpoint_;
    }

    public AbstractC2383g getEndpointBytes() {
        return AbstractC2383g.N(this.endpoint_);
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

    public static a newBuilder(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$AliOSSUpload);
    }

    public static LivekitEgress$AliOSSUpload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(byte[] bArr) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(InputStream inputStream) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$AliOSSUpload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$AliOSSUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
