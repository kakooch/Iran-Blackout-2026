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
public final class LivekitCloudAgent$ListAgentSecretsResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitCloudAgent$ListAgentSecretsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SECRETS_FIELD_NUMBER = 1;
    private B.j secrets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$ListAgentSecretsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$ListAgentSecretsResponse livekitCloudAgent$ListAgentSecretsResponse = new LivekitCloudAgent$ListAgentSecretsResponse();
        DEFAULT_INSTANCE = livekitCloudAgent$ListAgentSecretsResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$ListAgentSecretsResponse.class, livekitCloudAgent$ListAgentSecretsResponse);
    }

    private LivekitCloudAgent$ListAgentSecretsResponse() {
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

    public static LivekitCloudAgent$ListAgentSecretsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new LivekitCloudAgent$ListAgentSecretsResponse();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"secrets_", LivekitCloudAgent$AgentSecret.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$ListAgentSecretsResponse.class) {
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

    public static a newBuilder(LivekitCloudAgent$ListAgentSecretsResponse livekitCloudAgent$ListAgentSecretsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$ListAgentSecretsResponse);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecrets(int i, LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        livekitCloudAgent$AgentSecret.getClass();
        ensureSecretsIsMutable();
        this.secrets_.add(i, livekitCloudAgent$AgentSecret);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$ListAgentSecretsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentSecretsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
