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
public final class LivekitCloudAgent$RollbackAgentRequest extends GeneratedMessageLite implements U64 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    private static final LivekitCloudAgent$RollbackAgentRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private String agentId_ = "";
    private String agentName_ = "";
    private String version_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$RollbackAgentRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$RollbackAgentRequest livekitCloudAgent$RollbackAgentRequest = new LivekitCloudAgent$RollbackAgentRequest();
        DEFAULT_INSTANCE = livekitCloudAgent$RollbackAgentRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$RollbackAgentRequest.class, livekitCloudAgent$RollbackAgentRequest);
    }

    private LivekitCloudAgent$RollbackAgentRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static LivekitCloudAgent$RollbackAgentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setAgentName(String str) {
        str.getClass();
        this.agentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.agentName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.version_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$RollbackAgentRequest();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"agentId_", "agentName_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$RollbackAgentRequest.class) {
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

    public String getAgentName() {
        return this.agentName_;
    }

    public AbstractC2383g getAgentNameBytes() {
        return AbstractC2383g.N(this.agentName_);
    }

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public static a newBuilder(LivekitCloudAgent$RollbackAgentRequest livekitCloudAgent$RollbackAgentRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$RollbackAgentRequest);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$RollbackAgentRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$RollbackAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
