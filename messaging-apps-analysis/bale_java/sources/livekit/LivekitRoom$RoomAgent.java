package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.YD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRoom$RoomAgent extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$RoomAgent DEFAULT_INSTANCE;
    public static final int DISPATCHES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j dispatches_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$RoomAgent.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$RoomAgent livekitRoom$RoomAgent = new LivekitRoom$RoomAgent();
        DEFAULT_INSTANCE = livekitRoom$RoomAgent;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$RoomAgent.class, livekitRoom$RoomAgent);
    }

    private LivekitRoom$RoomAgent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDispatches(Iterable<? extends LivekitAgentDispatch$RoomAgentDispatch> iterable) {
        ensureDispatchesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dispatches_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDispatches(LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureDispatchesIsMutable();
        this.dispatches_.add(livekitAgentDispatch$RoomAgentDispatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatches() {
        this.dispatches_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDispatchesIsMutable() {
        B.j jVar = this.dispatches_;
        if (jVar.u()) {
            return;
        }
        this.dispatches_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRoom$RoomAgent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$RoomAgent parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomAgent parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDispatches(int i) {
        ensureDispatchesIsMutable();
        this.dispatches_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatches(int i, LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureDispatchesIsMutable();
        this.dispatches_.set(i, livekitAgentDispatch$RoomAgentDispatch);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$RoomAgent();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"dispatches_", LivekitAgentDispatch$RoomAgentDispatch.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$RoomAgent.class) {
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

    public LivekitAgentDispatch$RoomAgentDispatch getDispatches(int i) {
        return (LivekitAgentDispatch$RoomAgentDispatch) this.dispatches_.get(i);
    }

    public int getDispatchesCount() {
        return this.dispatches_.size();
    }

    public List<LivekitAgentDispatch$RoomAgentDispatch> getDispatchesList() {
        return this.dispatches_;
    }

    public YD3 getDispatchesOrBuilder(int i) {
        return (YD3) this.dispatches_.get(i);
    }

    public List<? extends YD3> getDispatchesOrBuilderList() {
        return this.dispatches_;
    }

    public static a newBuilder(LivekitRoom$RoomAgent livekitRoom$RoomAgent) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$RoomAgent);
    }

    public static LivekitRoom$RoomAgent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomAgent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$RoomAgent parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDispatches(int i, LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureDispatchesIsMutable();
        this.dispatches_.add(i, livekitAgentDispatch$RoomAgentDispatch);
    }

    public static LivekitRoom$RoomAgent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$RoomAgent parseFrom(byte[] bArr) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$RoomAgent parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$RoomAgent parseFrom(InputStream inputStream) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomAgent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomAgent parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$RoomAgent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$RoomAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
