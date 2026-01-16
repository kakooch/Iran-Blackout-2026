package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC14033hE3;
import ir.nasim.InterfaceC14635iE3;
import ir.nasim.InterfaceC15233jE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$AgentInfo extends GeneratedMessageLite implements InterfaceC14635iE3 {
    public static final int AGENT_DEPLOYMENTS_FIELD_NUMBER = 4;
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    private static final LivekitCloudAgent$AgentInfo DEFAULT_INSTANCE;
    public static final int DEPLOYED_AT_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int SECRETS_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 3;
    private Timestamp deployedAt_;
    private String agentId_ = "";
    private String agentName_ = "";
    private String version_ = "";
    private B.j agentDeployments_ = GeneratedMessageLite.emptyProtobufList();
    private B.j secrets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14635iE3 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$AgentInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$AgentInfo livekitCloudAgent$AgentInfo = new LivekitCloudAgent$AgentInfo();
        DEFAULT_INSTANCE = livekitCloudAgent$AgentInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$AgentInfo.class, livekitCloudAgent$AgentInfo);
    }

    private LivekitCloudAgent$AgentInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgentDeployments(LivekitCloudAgent$AgentDeployment livekitCloudAgent$AgentDeployment) {
        livekitCloudAgent$AgentDeployment.getClass();
        ensureAgentDeploymentsIsMutable();
        this.agentDeployments_.add(livekitCloudAgent$AgentDeployment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAgentDeployments(Iterable<? extends LivekitCloudAgent$AgentDeployment> iterable) {
        ensureAgentDeploymentsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.agentDeployments_);
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
    public void clearAgentDeployments() {
        this.agentDeployments_ = GeneratedMessageLite.emptyProtobufList();
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
    public void clearDeployedAt() {
        this.deployedAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecrets() {
        this.secrets_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    private void ensureAgentDeploymentsIsMutable() {
        B.j jVar = this.agentDeployments_;
        if (jVar.u()) {
            return;
        }
        this.agentDeployments_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSecretsIsMutable() {
        B.j jVar = this.secrets_;
        if (jVar.u()) {
            return;
        }
        this.secrets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitCloudAgent$AgentInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDeployedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.deployedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.deployedAt_ = timestamp;
        } else {
            this.deployedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.deployedAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$AgentInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAgentDeployments(int i) {
        ensureAgentDeploymentsIsMutable();
        this.agentDeployments_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSecrets(int i) {
        ensureSecretsIsMutable();
        this.secrets_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentDeployments(int i, LivekitCloudAgent$AgentDeployment livekitCloudAgent$AgentDeployment) {
        livekitCloudAgent$AgentDeployment.getClass();
        ensureAgentDeploymentsIsMutable();
        this.agentDeployments_.set(i, livekitCloudAgent$AgentDeployment);
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
    public void setDeployedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.deployedAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecrets(int i, LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        livekitCloudAgent$AgentSecret.getClass();
        ensureSecretsIsMutable();
        this.secrets_.set(i, livekitCloudAgent$AgentSecret);
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
                return new LivekitCloudAgent$AgentInfo();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005\u001b\u0006\t", new Object[]{"agentId_", "agentName_", "version_", "agentDeployments_", LivekitCloudAgent$AgentDeployment.class, "secrets_", LivekitCloudAgent$AgentSecret.class, "deployedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$AgentInfo.class) {
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

    public LivekitCloudAgent$AgentDeployment getAgentDeployments(int i) {
        return (LivekitCloudAgent$AgentDeployment) this.agentDeployments_.get(i);
    }

    public int getAgentDeploymentsCount() {
        return this.agentDeployments_.size();
    }

    public List<LivekitCloudAgent$AgentDeployment> getAgentDeploymentsList() {
        return this.agentDeployments_;
    }

    public InterfaceC14033hE3 getAgentDeploymentsOrBuilder(int i) {
        return (InterfaceC14033hE3) this.agentDeployments_.get(i);
    }

    public List<? extends InterfaceC14033hE3> getAgentDeploymentsOrBuilderList() {
        return this.agentDeployments_;
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

    public Timestamp getDeployedAt() {
        Timestamp timestamp = this.deployedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
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

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public boolean hasDeployedAt() {
        return this.deployedAt_ != null;
    }

    public static a newBuilder(LivekitCloudAgent$AgentInfo livekitCloudAgent$AgentInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$AgentInfo);
    }

    public static LivekitCloudAgent$AgentInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgentDeployments(int i, LivekitCloudAgent$AgentDeployment livekitCloudAgent$AgentDeployment) {
        livekitCloudAgent$AgentDeployment.getClass();
        ensureAgentDeploymentsIsMutable();
        this.agentDeployments_.add(i, livekitCloudAgent$AgentDeployment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecrets(int i, LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        livekitCloudAgent$AgentSecret.getClass();
        ensureSecretsIsMutable();
        this.secrets_.add(i, livekitCloudAgent$AgentSecret);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$AgentInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
