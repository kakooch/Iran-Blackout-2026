package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TD3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAgentDispatch$AgentDispatchState extends GeneratedMessageLite implements U64 {
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final LivekitAgentDispatch$AgentDispatchState DEFAULT_INSTANCE;
    public static final int DELETED_AT_FIELD_NUMBER = 3;
    public static final int JOBS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long createdAt_;
    private long deletedAt_;
    private B.j jobs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(b bVar) {
            this();
        }

        private a() {
            super(LivekitAgentDispatch$AgentDispatchState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgentDispatch$AgentDispatchState livekitAgentDispatch$AgentDispatchState = new LivekitAgentDispatch$AgentDispatchState();
        DEFAULT_INSTANCE = livekitAgentDispatch$AgentDispatchState;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgentDispatch$AgentDispatchState.class, livekitAgentDispatch$AgentDispatchState);
    }

    private LivekitAgentDispatch$AgentDispatchState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllJobs(Iterable<? extends LivekitAgent$Job> iterable) {
        ensureJobsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.jobs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addJobs(LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        ensureJobsIsMutable();
        this.jobs_.add(livekitAgent$Job);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeletedAt() {
        this.deletedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJobs() {
        this.jobs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureJobsIsMutable() {
        B.j jVar = this.jobs_;
        if (jVar.u()) {
            return;
        }
        this.jobs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAgentDispatch$AgentDispatchState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgentDispatch$AgentDispatchState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeJobs(int i) {
        ensureJobsIsMutable();
        this.jobs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeletedAt(long j) {
        this.deletedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobs(int i, LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        ensureJobsIsMutable();
        this.jobs_.set(i, livekitAgent$Job);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        b bVar = null;
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgentDispatch$AgentDispatchState();
            case 2:
                return new a(bVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002\u0002\u0003\u0002", new Object[]{"jobs_", LivekitAgent$Job.class, "createdAt_", "deletedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgentDispatch$AgentDispatchState.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public long getDeletedAt() {
        return this.deletedAt_;
    }

    public LivekitAgent$Job getJobs(int i) {
        return (LivekitAgent$Job) this.jobs_.get(i);
    }

    public int getJobsCount() {
        return this.jobs_.size();
    }

    public List<LivekitAgent$Job> getJobsList() {
        return this.jobs_;
    }

    public TD3 getJobsOrBuilder(int i) {
        return (TD3) this.jobs_.get(i);
    }

    public List<? extends TD3> getJobsOrBuilderList() {
        return this.jobs_;
    }

    public static a newBuilder(LivekitAgentDispatch$AgentDispatchState livekitAgentDispatch$AgentDispatchState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgentDispatch$AgentDispatchState);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addJobs(int i, LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        ensureJobsIsMutable();
        this.jobs_.add(i, livekitAgent$Job);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(byte[] bArr) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgentDispatch$AgentDispatchState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatchState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
