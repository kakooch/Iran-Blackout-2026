package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15824kE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$ListAgentVersionsResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitCloudAgent$ListAgentVersionsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSIONS_FIELD_NUMBER = 1;
    private B.j versions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$ListAgentVersionsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$ListAgentVersionsResponse livekitCloudAgent$ListAgentVersionsResponse = new LivekitCloudAgent$ListAgentVersionsResponse();
        DEFAULT_INSTANCE = livekitCloudAgent$ListAgentVersionsResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$ListAgentVersionsResponse.class, livekitCloudAgent$ListAgentVersionsResponse);
    }

    private LivekitCloudAgent$ListAgentVersionsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVersions(Iterable<? extends LivekitCloudAgent$AgentVersion> iterable) {
        ensureVersionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.versions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVersions(LivekitCloudAgent$AgentVersion livekitCloudAgent$AgentVersion) {
        livekitCloudAgent$AgentVersion.getClass();
        ensureVersionsIsMutable();
        this.versions_.add(livekitCloudAgent$AgentVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersions() {
        this.versions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVersionsIsMutable() {
        B.j jVar = this.versions_;
        if (jVar.u()) {
            return;
        }
        this.versions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVersions(int i) {
        ensureVersionsIsMutable();
        this.versions_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersions(int i, LivekitCloudAgent$AgentVersion livekitCloudAgent$AgentVersion) {
        livekitCloudAgent$AgentVersion.getClass();
        ensureVersionsIsMutable();
        this.versions_.set(i, livekitCloudAgent$AgentVersion);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$ListAgentVersionsResponse();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"versions_", LivekitCloudAgent$AgentVersion.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$ListAgentVersionsResponse.class) {
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

    public LivekitCloudAgent$AgentVersion getVersions(int i) {
        return (LivekitCloudAgent$AgentVersion) this.versions_.get(i);
    }

    public int getVersionsCount() {
        return this.versions_.size();
    }

    public List<LivekitCloudAgent$AgentVersion> getVersionsList() {
        return this.versions_;
    }

    public InterfaceC15824kE3 getVersionsOrBuilder(int i) {
        return (InterfaceC15824kE3) this.versions_.get(i);
    }

    public List<? extends InterfaceC15824kE3> getVersionsOrBuilderList() {
        return this.versions_;
    }

    public static a newBuilder(LivekitCloudAgent$ListAgentVersionsResponse livekitCloudAgent$ListAgentVersionsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$ListAgentVersionsResponse);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVersions(int i, LivekitCloudAgent$AgentVersion livekitCloudAgent$AgentVersion) {
        livekitCloudAgent$AgentVersion.getClass();
        ensureVersionsIsMutable();
        this.versions_.add(i, livekitCloudAgent$AgentVersion);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$ListAgentVersionsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$ListAgentVersionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
