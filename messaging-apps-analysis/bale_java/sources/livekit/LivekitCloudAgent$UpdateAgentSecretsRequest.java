package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15233jE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$UpdateAgentSecretsRequest extends GeneratedMessageLite implements U64 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    private static final LivekitCloudAgent$UpdateAgentSecretsRequest DEFAULT_INSTANCE;
    public static final int OVERWRITE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SECRETS_FIELD_NUMBER = 4;
    private boolean overwrite_;
    private String agentId_ = "";
    private String agentName_ = "";
    private B.j secrets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$UpdateAgentSecretsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$UpdateAgentSecretsRequest livekitCloudAgent$UpdateAgentSecretsRequest = new LivekitCloudAgent$UpdateAgentSecretsRequest();
        DEFAULT_INSTANCE = livekitCloudAgent$UpdateAgentSecretsRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$UpdateAgentSecretsRequest.class, livekitCloudAgent$UpdateAgentSecretsRequest);
    }

    private LivekitCloudAgent$UpdateAgentSecretsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSecrets(Iterable<? extends LivekitCloudAgent$AgentSecret> iterable) {
        ensureSecretsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.secrets_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecrets(LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        livekitCloudAgent$AgentSecret.getClass();
        ensureSecretsIsMutable();
        this.secrets_.add(livekitCloudAgent$AgentSecret);
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
    public void clearOverwrite() {
        this.overwrite_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecrets() {
        this.secrets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSecretsIsMutable() {
        B.j jVar = this.secrets_;
        if (jVar.u()) {
            return;
        }
        this.secrets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSecrets(int i) {
        ensureSecretsIsMutable();
        this.secrets_.remove(i);
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
    public void setOverwrite(boolean z) {
        this.overwrite_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecrets(int i, LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        livekitCloudAgent$AgentSecret.getClass();
        ensureSecretsIsMutable();
        this.secrets_.set(i, livekitCloudAgent$AgentSecret);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$UpdateAgentSecretsRequest();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u001b", new Object[]{"agentId_", "agentName_", "overwrite_", "secrets_", LivekitCloudAgent$AgentSecret.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$UpdateAgentSecretsRequest.class) {
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

    public boolean getOverwrite() {
        return this.overwrite_;
    }

    public LivekitCloudAgent$AgentSecret getSecrets(int i) {
        return (LivekitCloudAgent$AgentSecret) this.secrets_.get(i);
    }

    public int getSecretsCount() {
        return this.secrets_.size();
    }

    public List<LivekitCloudAgent$AgentSecret> getSecretsList() {
        return this.secrets_;
    }

    public InterfaceC15233jE3 getSecretsOrBuilder(int i) {
        return (InterfaceC15233jE3) this.secrets_.get(i);
    }

    public List<? extends InterfaceC15233jE3> getSecretsOrBuilderList() {
        return this.secrets_;
    }

    public static a newBuilder(LivekitCloudAgent$UpdateAgentSecretsRequest livekitCloudAgent$UpdateAgentSecretsRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$UpdateAgentSecretsRequest);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecrets(int i, LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        livekitCloudAgent$AgentSecret.getClass();
        ensureSecretsIsMutable();
        this.secrets_.add(i, livekitCloudAgent$AgentSecret);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$UpdateAgentSecretsRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentSecretsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
