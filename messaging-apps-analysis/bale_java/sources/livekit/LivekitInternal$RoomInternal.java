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
import livekit.LivekitEgress$AutoParticipantEgress;
import livekit.LivekitEgress$AutoTrackEgress;
import livekit.LivekitModels$PlayoutDelay;

/* loaded from: classes8.dex */
public final class LivekitInternal$RoomInternal extends GeneratedMessageLite implements U64 {
    public static final int AGENT_DISPATCHES_FIELD_NUMBER = 5;
    private static final LivekitInternal$RoomInternal DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_EGRESS_FIELD_NUMBER = 2;
    public static final int PLAYOUT_DELAY_FIELD_NUMBER = 3;
    public static final int REPLAY_ENABLED_FIELD_NUMBER = 6;
    public static final int SYNC_STREAMS_FIELD_NUMBER = 4;
    public static final int TRACK_EGRESS_FIELD_NUMBER = 1;
    private B.j agentDispatches_ = GeneratedMessageLite.emptyProtobufList();
    private LivekitEgress$AutoParticipantEgress participantEgress_;
    private LivekitModels$PlayoutDelay playoutDelay_;
    private boolean replayEnabled_;
    private boolean syncStreams_;
    private LivekitEgress$AutoTrackEgress trackEgress_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(m mVar) {
            this();
        }

        private a() {
            super(LivekitInternal$RoomInternal.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitInternal$RoomInternal livekitInternal$RoomInternal = new LivekitInternal$RoomInternal();
        DEFAULT_INSTANCE = livekitInternal$RoomInternal;
        GeneratedMessageLite.registerDefaultInstance(LivekitInternal$RoomInternal.class, livekitInternal$RoomInternal);
    }

    private LivekitInternal$RoomInternal() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgentDispatches(LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.add(livekitAgentDispatch$RoomAgentDispatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAgentDispatches(Iterable<? extends LivekitAgentDispatch$RoomAgentDispatch> iterable) {
        ensureAgentDispatchesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.agentDispatches_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentDispatches() {
        this.agentDispatches_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantEgress() {
        this.participantEgress_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayoutDelay() {
        this.playoutDelay_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplayEnabled() {
        this.replayEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyncStreams() {
        this.syncStreams_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackEgress() {
        this.trackEgress_ = null;
    }

    private void ensureAgentDispatchesIsMutable() {
        B.j jVar = this.agentDispatches_;
        if (jVar.u()) {
            return;
        }
        this.agentDispatches_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitInternal$RoomInternal getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParticipantEgress(LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress) {
        livekitEgress$AutoParticipantEgress.getClass();
        LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress2 = this.participantEgress_;
        if (livekitEgress$AutoParticipantEgress2 == null || livekitEgress$AutoParticipantEgress2 == LivekitEgress$AutoParticipantEgress.getDefaultInstance()) {
            this.participantEgress_ = livekitEgress$AutoParticipantEgress;
        } else {
            this.participantEgress_ = (LivekitEgress$AutoParticipantEgress) ((LivekitEgress$AutoParticipantEgress.a) LivekitEgress$AutoParticipantEgress.newBuilder(this.participantEgress_).v(livekitEgress$AutoParticipantEgress)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePlayoutDelay(LivekitModels$PlayoutDelay livekitModels$PlayoutDelay) {
        livekitModels$PlayoutDelay.getClass();
        LivekitModels$PlayoutDelay livekitModels$PlayoutDelay2 = this.playoutDelay_;
        if (livekitModels$PlayoutDelay2 == null || livekitModels$PlayoutDelay2 == LivekitModels$PlayoutDelay.getDefaultInstance()) {
            this.playoutDelay_ = livekitModels$PlayoutDelay;
        } else {
            this.playoutDelay_ = (LivekitModels$PlayoutDelay) ((LivekitModels$PlayoutDelay.a) LivekitModels$PlayoutDelay.newBuilder(this.playoutDelay_).v(livekitModels$PlayoutDelay)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrackEgress(LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress) {
        livekitEgress$AutoTrackEgress.getClass();
        LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress2 = this.trackEgress_;
        if (livekitEgress$AutoTrackEgress2 == null || livekitEgress$AutoTrackEgress2 == LivekitEgress$AutoTrackEgress.getDefaultInstance()) {
            this.trackEgress_ = livekitEgress$AutoTrackEgress;
        } else {
            this.trackEgress_ = (LivekitEgress$AutoTrackEgress) ((LivekitEgress$AutoTrackEgress.a) LivekitEgress$AutoTrackEgress.newBuilder(this.trackEgress_).v(livekitEgress$AutoTrackEgress)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitInternal$RoomInternal parseDelimitedFrom(InputStream inputStream) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$RoomInternal parseFrom(ByteBuffer byteBuffer) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setAgentDispatches(int i, LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.set(i, livekitAgentDispatch$RoomAgentDispatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantEgress(LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress) {
        livekitEgress$AutoParticipantEgress.getClass();
        this.participantEgress_ = livekitEgress$AutoParticipantEgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayoutDelay(LivekitModels$PlayoutDelay livekitModels$PlayoutDelay) {
        livekitModels$PlayoutDelay.getClass();
        this.playoutDelay_ = livekitModels$PlayoutDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplayEnabled(boolean z) {
        this.replayEnabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyncStreams(boolean z) {
        this.syncStreams_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackEgress(LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress) {
        livekitEgress$AutoTrackEgress.getClass();
        this.trackEgress_ = livekitEgress$AutoTrackEgress;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        m mVar = null;
        switch (m.a[gVar.ordinal()]) {
            case 1:
                return new LivekitInternal$RoomInternal();
            case 2:
                return new a(mVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\t\u0002\t\u0003\t\u0004\u0007\u0005\u001b\u0006\u0007", new Object[]{"trackEgress_", "participantEgress_", "playoutDelay_", "syncStreams_", "agentDispatches_", LivekitAgentDispatch$RoomAgentDispatch.class, "replayEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitInternal$RoomInternal.class) {
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

    public LivekitAgentDispatch$RoomAgentDispatch getAgentDispatches(int i) {
        return (LivekitAgentDispatch$RoomAgentDispatch) this.agentDispatches_.get(i);
    }

    public int getAgentDispatchesCount() {
        return this.agentDispatches_.size();
    }

    public List<LivekitAgentDispatch$RoomAgentDispatch> getAgentDispatchesList() {
        return this.agentDispatches_;
    }

    public YD3 getAgentDispatchesOrBuilder(int i) {
        return (YD3) this.agentDispatches_.get(i);
    }

    public List<? extends YD3> getAgentDispatchesOrBuilderList() {
        return this.agentDispatches_;
    }

    public LivekitEgress$AutoParticipantEgress getParticipantEgress() {
        LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress = this.participantEgress_;
        return livekitEgress$AutoParticipantEgress == null ? LivekitEgress$AutoParticipantEgress.getDefaultInstance() : livekitEgress$AutoParticipantEgress;
    }

    public LivekitModels$PlayoutDelay getPlayoutDelay() {
        LivekitModels$PlayoutDelay livekitModels$PlayoutDelay = this.playoutDelay_;
        return livekitModels$PlayoutDelay == null ? LivekitModels$PlayoutDelay.getDefaultInstance() : livekitModels$PlayoutDelay;
    }

    public boolean getReplayEnabled() {
        return this.replayEnabled_;
    }

    public boolean getSyncStreams() {
        return this.syncStreams_;
    }

    public LivekitEgress$AutoTrackEgress getTrackEgress() {
        LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress = this.trackEgress_;
        return livekitEgress$AutoTrackEgress == null ? LivekitEgress$AutoTrackEgress.getDefaultInstance() : livekitEgress$AutoTrackEgress;
    }

    public boolean hasParticipantEgress() {
        return this.participantEgress_ != null;
    }

    public boolean hasPlayoutDelay() {
        return this.playoutDelay_ != null;
    }

    public boolean hasTrackEgress() {
        return this.trackEgress_ != null;
    }

    public static a newBuilder(LivekitInternal$RoomInternal livekitInternal$RoomInternal) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitInternal$RoomInternal);
    }

    public static LivekitInternal$RoomInternal parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$RoomInternal parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitInternal$RoomInternal parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAgentDispatches(int i, LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        livekitAgentDispatch$RoomAgentDispatch.getClass();
        ensureAgentDispatchesIsMutable();
        this.agentDispatches_.add(i, livekitAgentDispatch$RoomAgentDispatch);
    }

    public static LivekitInternal$RoomInternal parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitInternal$RoomInternal parseFrom(byte[] bArr) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitInternal$RoomInternal parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitInternal$RoomInternal parseFrom(InputStream inputStream) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$RoomInternal parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$RoomInternal parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitInternal$RoomInternal parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitInternal$RoomInternal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
