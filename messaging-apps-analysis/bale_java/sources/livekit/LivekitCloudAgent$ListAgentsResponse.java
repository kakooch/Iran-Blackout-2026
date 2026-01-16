package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14635iE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$ListAgentsResponse extends GeneratedMessageLite implements U64 {
    public static final int AGENTS_FIELD_NUMBER = 1;
    private static final LivekitCloudAgent$ListAgentsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j agents_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$ListAgentsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$ListAgentsResponse livekitCloudAgent$ListAgentsResponse = new LivekitCloudAgent$ListAgentsResponse();
        DEFAULT_INSTANCE = livekitCloudAgent$ListAgentsResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$ListAgentsResponse.class, livekitCloudAgent$ListAgentsResponse);
    }

    private LivekitCloudAgent$ListAgentsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgents(LivekitCloudAgent$AgentInfo livekitCloudAgent$AgentInfo) {
        livekitCloudAgent$AgentInfo.getClass();
        ensureAgentsIsMutable();
        this.agents_.add(livekitCloudAgent$AgentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAgents(Iterable<? extends LivekitCloudAgent$AgentInfo> iterable) {
        ensureAgentsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.agents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgents() {
        this.agents_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAgentsIsMutable() {
        B.j jVar = this.agents_;
        if (jVar.u()) {
            return;
        }
        this.agents_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitCloudAgent$ListAgentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$ListAgentsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAgents(int i) {
        ensureAgentsIsMutable();
        this.agents_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgents(int i, LivekitCloudAgent$AgentInfo livekitCloudAgent$AgentInfo) {
        livekitCloudAgent$AgentInfo.getClass();
        ensureAgentsIsMutable();
        this.agents_.set(i, livekitCloudAgent$AgentInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$ListAgentsResponse();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"agents_", LivekitCloudAgent$AgentInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$ListAgentsResponse.class) {
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

    public LivekitCloudAgent$AgentInfo getAgents(int i) {
        return (LivekitCloudAgent$AgentInfo) this.agents_.get(i);
    }

    public int getAgentsCount() {
        return this.agents_.size();
    }

    public List<LivekitCloudAgent$AgentInfo> getAgentsList() {
        return this.agents_;
    }

    public InterfaceC14635iE3 getAgentsOrBuilder(int i) {
        return (InterfaceC14635iE3) this.agents_.get(i);
    }

    public List<? extends InterfaceC14635iE3> getAgentsOrBuilderList() {
        return this.agents_;
    }

    public static a newBuilder(LivekitCloudAgent$ListAgentsResponse livekitCloudAgent$ListAgentsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$ListAgentsResponse);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgents(int i, LivekitCloudAgent$AgentInfo livekitCloudAgent$AgentInfo) {
        livekitCloudAgent$AgentInfo.getClass();
        ensureAgentsIsMutable();
        this.agents_.add(i, livekitCloudAgent$AgentInfo);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$ListAgentsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
