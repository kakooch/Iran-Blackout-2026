package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.XD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAgentDispatch$ListAgentDispatchResponse extends GeneratedMessageLite implements U64 {
    public static final int AGENT_DISPATCHES_FIELD_NUMBER = 1;
    private static final LivekitAgentDispatch$ListAgentDispatchResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j agentDispatches_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(b bVar) {
            this();
        }

        private a() {
            super(LivekitAgentDispatch$ListAgentDispatchResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgentDispatch$ListAgentDispatchResponse livekitAgentDispatch$ListAgentDispatchResponse = new LivekitAgentDispatch$ListAgentDispatchResponse();
        DEFAULT_INSTANCE = livekitAgentDispatch$ListAgentDispatchResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgentDispatch$ListAgentDispatchResponse.class, livekitAgentDispatch$ListAgentDispatchResponse);
    }

    private LivekitAgentDispatch$ListAgentDispatchResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgentDispatches(LivekitAgentDispatch$AgentDispatch livekitAgentDispatch$AgentDispatch) {
        livekitAgentDispatch$AgentDispatch.getClass();
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.add(livekitAgentDispatch$AgentDispatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAgentDispatches(Iterable<? extends LivekitAgentDispatch$AgentDispatch> iterable) {
        ensureAgentDispatchesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.agentDispatches_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentDispatches() {
        this.agentDispatches_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAgentDispatchesIsMutable() {
        B.j jVar = this.agentDispatches_;
        if (jVar.u()) {
            return;
        }
        this.agentDispatches_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAgentDispatches(int i) {
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentDispatches(int i, LivekitAgentDispatch$AgentDispatch livekitAgentDispatch$AgentDispatch) {
        livekitAgentDispatch$AgentDispatch.getClass();
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.set(i, livekitAgentDispatch$AgentDispatch);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        b bVar = null;
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgentDispatch$ListAgentDispatchResponse();
            case 2:
                return new a(bVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"agentDispatches_", LivekitAgentDispatch$AgentDispatch.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgentDispatch$ListAgentDispatchResponse.class) {
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

    public LivekitAgentDispatch$AgentDispatch getAgentDispatches(int i) {
        return (LivekitAgentDispatch$AgentDispatch) this.agentDispatches_.get(i);
    }

    public int getAgentDispatchesCount() {
        return this.agentDispatches_.size();
    }

    public List<LivekitAgentDispatch$AgentDispatch> getAgentDispatchesList() {
        return this.agentDispatches_;
    }

    public XD3 getAgentDispatchesOrBuilder(int i) {
        return (XD3) this.agentDispatches_.get(i);
    }

    public List<? extends XD3> getAgentDispatchesOrBuilderList() {
        return this.agentDispatches_;
    }

    public static a newBuilder(LivekitAgentDispatch$ListAgentDispatchResponse livekitAgentDispatch$ListAgentDispatchResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgentDispatch$ListAgentDispatchResponse);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgentDispatches(int i, LivekitAgentDispatch$AgentDispatch livekitAgentDispatch$AgentDispatch) {
        livekitAgentDispatch$AgentDispatch.getClass();
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.add(i, livekitAgentDispatch$AgentDispatch);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(byte[] bArr) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgentDispatch$ListAgentDispatchResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgentDispatch$ListAgentDispatchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
