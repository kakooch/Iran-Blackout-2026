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
import livekit.LivekitRoom$RoomEgress;

/* loaded from: classes8.dex */
public final class LivekitRoom$RoomConfiguration extends GeneratedMessageLite implements U64 {
    public static final int AGENTS_FIELD_NUMBER = 10;
    private static final LivekitRoom$RoomConfiguration DEFAULT_INSTANCE;
    public static final int DEPARTURE_TIMEOUT_FIELD_NUMBER = 3;
    public static final int EGRESS_FIELD_NUMBER = 5;
    public static final int EMPTY_TIMEOUT_FIELD_NUMBER = 2;
    public static final int MAX_PARTICIPANTS_FIELD_NUMBER = 4;
    public static final int MAX_PLAYOUT_DELAY_FIELD_NUMBER = 8;
    public static final int MIN_PLAYOUT_DELAY_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SYNC_STREAMS_FIELD_NUMBER = 9;
    private int departureTimeout_;
    private LivekitRoom$RoomEgress egress_;
    private int emptyTimeout_;
    private int maxParticipants_;
    private int maxPlayoutDelay_;
    private int minPlayoutDelay_;
    private boolean syncStreams_;
    private String name_ = "";
    private B.j agents_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$RoomConfiguration.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$RoomConfiguration livekitRoom$RoomConfiguration = new LivekitRoom$RoomConfiguration();
        DEFAULT_INSTANCE = livekitRoom$RoomConfiguration;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$RoomConfiguration.class, livekitRoom$RoomConfiguration);
    }

    private LivekitRoom$RoomConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgents(LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureAgentsIsMutable();
        this.agents_.add(livekitAgentDispatch$RoomAgentDispatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAgents(Iterable<? extends LivekitAgentDispatch$RoomAgentDispatch> iterable) {
        ensureAgentsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.agents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgents() {
        this.agents_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDepartureTimeout() {
        this.departureTimeout_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgress() {
        this.egress_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEmptyTimeout() {
        this.emptyTimeout_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxParticipants() {
        this.maxParticipants_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxPlayoutDelay() {
        this.maxPlayoutDelay_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinPlayoutDelay() {
        this.minPlayoutDelay_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyncStreams() {
        this.syncStreams_ = false;
    }

    private void ensureAgentsIsMutable() {
        B.j jVar = this.agents_;
        if (jVar.u()) {
            return;
        }
        this.agents_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRoom$RoomConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEgress(LivekitRoom$RoomEgress livekitRoom$RoomEgress) {
        livekitRoom$RoomEgress.getClass();
        LivekitRoom$RoomEgress livekitRoom$RoomEgress2 = this.egress_;
        if (livekitRoom$RoomEgress2 == null || livekitRoom$RoomEgress2 == LivekitRoom$RoomEgress.getDefaultInstance()) {
            this.egress_ = livekitRoom$RoomEgress;
        } else {
            this.egress_ = (LivekitRoom$RoomEgress) ((LivekitRoom$RoomEgress.a) LivekitRoom$RoomEgress.newBuilder(this.egress_).v(livekitRoom$RoomEgress)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$RoomConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setAgents(int i, LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureAgentsIsMutable();
        this.agents_.set(i, livekitAgentDispatch$RoomAgentDispatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDepartureTimeout(int i) {
        this.departureTimeout_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgress(LivekitRoom$RoomEgress livekitRoom$RoomEgress) {
        livekitRoom$RoomEgress.getClass();
        this.egress_ = livekitRoom$RoomEgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEmptyTimeout(int i) {
        this.emptyTimeout_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxParticipants(int i) {
        this.maxParticipants_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxPlayoutDelay(int i) {
        this.maxPlayoutDelay_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinPlayoutDelay(int i) {
        this.minPlayoutDelay_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyncStreams(boolean z) {
        this.syncStreams_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$RoomConfiguration();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\n\t\u0000\u0001\u0000\u0001Ȉ\u0002\u000b\u0003\u000b\u0004\u000b\u0005\t\u0007\u000b\b\u000b\t\u0007\n\u001b", new Object[]{"name_", "emptyTimeout_", "departureTimeout_", "maxParticipants_", "egress_", "minPlayoutDelay_", "maxPlayoutDelay_", "syncStreams_", "agents_", LivekitAgentDispatch$RoomAgentDispatch.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$RoomConfiguration.class) {
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

    public LivekitAgentDispatch$RoomAgentDispatch getAgents(int i) {
        return (LivekitAgentDispatch$RoomAgentDispatch) this.agents_.get(i);
    }

    public int getAgentsCount() {
        return this.agents_.size();
    }

    public List<LivekitAgentDispatch$RoomAgentDispatch> getAgentsList() {
        return this.agents_;
    }

    public YD3 getAgentsOrBuilder(int i) {
        return (YD3) this.agents_.get(i);
    }

    public List<? extends YD3> getAgentsOrBuilderList() {
        return this.agents_;
    }

    public int getDepartureTimeout() {
        return this.departureTimeout_;
    }

    public LivekitRoom$RoomEgress getEgress() {
        LivekitRoom$RoomEgress livekitRoom$RoomEgress = this.egress_;
        return livekitRoom$RoomEgress == null ? LivekitRoom$RoomEgress.getDefaultInstance() : livekitRoom$RoomEgress;
    }

    public int getEmptyTimeout() {
        return this.emptyTimeout_;
    }

    public int getMaxParticipants() {
        return this.maxParticipants_;
    }

    public int getMaxPlayoutDelay() {
        return this.maxPlayoutDelay_;
    }

    public int getMinPlayoutDelay() {
        return this.minPlayoutDelay_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public boolean getSyncStreams() {
        return this.syncStreams_;
    }

    public boolean hasEgress() {
        return this.egress_ != null;
    }

    public static a newBuilder(LivekitRoom$RoomConfiguration livekitRoom$RoomConfiguration) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$RoomConfiguration);
    }

    public static LivekitRoom$RoomConfiguration parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgents(int i, LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureAgentsIsMutable();
        this.agents_.add(i, livekitAgentDispatch$RoomAgentDispatch);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(byte[] bArr) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(InputStream inputStream) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$RoomConfiguration parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$RoomConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
