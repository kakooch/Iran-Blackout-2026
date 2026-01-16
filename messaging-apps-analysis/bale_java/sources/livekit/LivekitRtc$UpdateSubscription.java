package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$UpdateSubscription extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$UpdateSubscription DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_TRACKS_FIELD_NUMBER = 3;
    public static final int SUBSCRIBE_FIELD_NUMBER = 2;
    public static final int TRACK_SIDS_FIELD_NUMBER = 1;
    private boolean subscribe_;
    private B.j trackSids_ = GeneratedMessageLite.emptyProtobufList();
    private B.j participantTracks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(Iterable iterable) {
            q();
            ((LivekitRtc$UpdateSubscription) this.b).addAllParticipantTracks(iterable);
            return this;
        }

        public a B(Iterable iterable) {
            q();
            ((LivekitRtc$UpdateSubscription) this.b).addAllTrackSids(iterable);
            return this;
        }

        public a C(boolean z) {
            q();
            ((LivekitRtc$UpdateSubscription) this.b).setSubscribe(z);
            return this;
        }

        private a() {
            super(LivekitRtc$UpdateSubscription.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription = new LivekitRtc$UpdateSubscription();
        DEFAULT_INSTANCE = livekitRtc$UpdateSubscription;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$UpdateSubscription.class, livekitRtc$UpdateSubscription);
    }

    private LivekitRtc$UpdateSubscription() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParticipantTracks(Iterable<? extends LivekitModels$ParticipantTracks> iterable) {
        ensureParticipantTracksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.participantTracks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrackSids(Iterable<String> iterable) {
        ensureTrackSidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trackSids_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipantTracks(LivekitModels$ParticipantTracks livekitModels$ParticipantTracks) {
        livekitModels$ParticipantTracks.getClass();
        ensureParticipantTracksIsMutable();
        this.participantTracks_.add(livekitModels$ParticipantTracks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackSids(String str) {
        str.getClass();
        ensureTrackSidsIsMutable();
        this.trackSids_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackSidsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureTrackSidsIsMutable();
        this.trackSids_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantTracks() {
        this.participantTracks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscribe() {
        this.subscribe_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSids() {
        this.trackSids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureParticipantTracksIsMutable() {
        B.j jVar = this.participantTracks_;
        if (jVar.u()) {
            return;
        }
        this.participantTracks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTrackSidsIsMutable() {
        B.j jVar = this.trackSids_;
        if (jVar.u()) {
            return;
        }
        this.trackSids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$UpdateSubscription getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$UpdateSubscription parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParticipantTracks(int i) {
        ensureParticipantTracksIsMutable();
        this.participantTracks_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantTracks(int i, LivekitModels$ParticipantTracks livekitModels$ParticipantTracks) {
        livekitModels$ParticipantTracks.getClass();
        ensureParticipantTracksIsMutable();
        this.participantTracks_.set(i, livekitModels$ParticipantTracks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscribe(boolean z) {
        this.subscribe_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSids(int i, String str) {
        str.getClass();
        ensureTrackSidsIsMutable();
        this.trackSids_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$UpdateSubscription();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001Ț\u0002\u0007\u0003\u001b", new Object[]{"trackSids_", "subscribe_", "participantTracks_", LivekitModels$ParticipantTracks.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$UpdateSubscription.class) {
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

    public LivekitModels$ParticipantTracks getParticipantTracks(int i) {
        return (LivekitModels$ParticipantTracks) this.participantTracks_.get(i);
    }

    public int getParticipantTracksCount() {
        return this.participantTracks_.size();
    }

    public List<LivekitModels$ParticipantTracks> getParticipantTracksList() {
        return this.participantTracks_;
    }

    public TE3 getParticipantTracksOrBuilder(int i) {
        return (TE3) this.participantTracks_.get(i);
    }

    public List<? extends TE3> getParticipantTracksOrBuilderList() {
        return this.participantTracks_;
    }

    public boolean getSubscribe() {
        return this.subscribe_;
    }

    public String getTrackSids(int i) {
        return (String) this.trackSids_.get(i);
    }

    public AbstractC2383g getTrackSidsBytes(int i) {
        return AbstractC2383g.N((String) this.trackSids_.get(i));
    }

    public int getTrackSidsCount() {
        return this.trackSids_.size();
    }

    public List<String> getTrackSidsList() {
        return this.trackSids_;
    }

    public static a newBuilder(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$UpdateSubscription);
    }

    public static LivekitRtc$UpdateSubscription parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipantTracks(int i, LivekitModels$ParticipantTracks livekitModels$ParticipantTracks) {
        livekitModels$ParticipantTracks.getClass();
        ensureParticipantTracksIsMutable();
        this.participantTracks_.add(i, livekitModels$ParticipantTracks);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(byte[] bArr) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$UpdateSubscription parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$UpdateSubscription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
