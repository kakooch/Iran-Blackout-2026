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
public final class LivekitModels$RpcRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$RpcRequest DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int METHOD_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 3;
    public static final int RESPONSE_TIMEOUT_MS_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 5;
    private String id_ = "";
    private String method_ = "";
    private String payload_ = "";
    private int responseTimeoutMs_;
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$RpcRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$RpcRequest livekitModels$RpcRequest = new LivekitModels$RpcRequest();
        DEFAULT_INSTANCE = livekitModels$RpcRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RpcRequest.class, livekitModels$RpcRequest);
    }

    private LivekitModels$RpcRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMethod() {
        this.method_ = getDefaultInstance().getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPayload() {
        this.payload_ = getDefaultInstance().getPayload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseTimeoutMs() {
        this.responseTimeoutMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static LivekitModels$RpcRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RpcRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethod(String str) {
        str.getClass();
        this.method_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethodBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.method_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPayload(String str) {
        str.getClass();
        this.payload_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPayloadBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.payload_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTimeoutMs(int i) {
        this.responseTimeoutMs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RpcRequest();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u000b\u0005\u000b", new Object[]{"id_", "method_", "payload_", "responseTimeoutMs_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RpcRequest.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getMethod() {
        return this.method_;
    }

    public AbstractC2383g getMethodBytes() {
        return AbstractC2383g.N(this.method_);
    }

    public String getPayload() {
        return this.payload_;
    }

    public AbstractC2383g getPayloadBytes() {
        return AbstractC2383g.N(this.payload_);
    }

    public int getResponseTimeoutMs() {
        return this.responseTimeoutMs_;
    }

    public int getVersion() {
        return this.version_;
    }

    public static a newBuilder(LivekitModels$RpcRequest livekitModels$RpcRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RpcRequest);
    }

    public static LivekitModels$RpcRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RpcRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RpcRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RpcRequest parseFrom(byte[] bArr) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RpcRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RpcRequest parseFrom(InputStream inputStream) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RpcRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RpcRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
