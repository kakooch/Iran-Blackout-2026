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
public final class LivekitCloudAgent$DeployAgentResponse extends GeneratedMessageLite implements U64 {
    public static final int AGENT_ID_FIELD_NUMBER = 3;
    private static final LivekitCloudAgent$DeployAgentResponse DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PRESIGNED_URL_FIELD_NUMBER = 4;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private boolean success_;
    private String message_ = "";
    private String agentId_ = "";
    private String presignedUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$DeployAgentResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$DeployAgentResponse livekitCloudAgent$DeployAgentResponse = new LivekitCloudAgent$DeployAgentResponse();
        DEFAULT_INSTANCE = livekitCloudAgent$DeployAgentResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$DeployAgentResponse.class, livekitCloudAgent$DeployAgentResponse);
    }

    private LivekitCloudAgent$DeployAgentResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPresignedUrl() {
        this.presignedUrl_ = getDefaultInstance().getPresignedUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static LivekitCloudAgent$DeployAgentResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$DeployAgentResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentId(String str) {
        str.getClass();
        this.agentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.agentId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresignedUrl(String str) {
        str.getClass();
        this.presignedUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresignedUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.presignedUrl_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z) {
        this.success_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$DeployAgentResponse();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"success_", "message_", "agentId_", "presignedUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$DeployAgentResponse.class) {
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

    public String getAgentId() {
        return this.agentId_;
    }

    public AbstractC2383g getAgentIdBytes() {
        return AbstractC2383g.N(this.agentId_);
    }

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public String getPresignedUrl() {
        return this.presignedUrl_;
    }

    public AbstractC2383g getPresignedUrlBytes() {
        return AbstractC2383g.N(this.presignedUrl_);
    }

    public boolean getSuccess() {
        return this.success_;
    }

    public static a newBuilder(LivekitCloudAgent$DeployAgentResponse livekitCloudAgent$DeployAgentResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$DeployAgentResponse);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$DeployAgentResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$DeployAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
