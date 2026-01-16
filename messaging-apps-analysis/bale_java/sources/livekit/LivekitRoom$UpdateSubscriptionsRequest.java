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
public final class LivekitRoom$UpdateSubscriptionsRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$UpdateSubscriptionsRequest DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_TRACKS_FIELD_NUMBER = 5;
    public static final int ROOM_FIELD_NUMBER = 1;
    public static final int SUBSCRIBE_FIELD_NUMBER = 4;
    public static final int TRACK_SIDS_FIELD_NUMBER = 3;
    private boolean subscribe_;
    private String room_ = "";
    private String identity_ = "";
    private B.j trackSids_ = GeneratedMessageLite.emptyProtobufList();
    private B.j participantTracks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$UpdateSubscriptionsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$UpdateSubscriptionsRequest livekitRoom$UpdateSubscriptionsRequest = new LivekitRoom$UpdateSubscriptionsRequest();
        DEFAULT_INSTANCE = livekitRoom$UpdateSubscriptionsRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$UpdateSubscriptionsRequest.class, livekitRoom$UpdateSubscriptionsRequest);
    }

    private LivekitRoom$UpdateSubscriptionsRequest() {
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
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantTracks() {
        this.participantTracks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
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

    public static LivekitRoom$UpdateSubscriptionsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setIdentity(String str) {
        str.getClass();
        this.identity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.identity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantTracks(int i, LivekitModels$ParticipantTracks livekitModels$ParticipantTracks) {
        livekitModels$ParticipantTracks.getClass();
        ensureParticipantTracksIsMutable();
        this.participantTracks_.set(i, livekitModels$ParticipantTracks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
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
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$UpdateSubscriptionsRequest();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ț\u0004\u0007\u0005\u001b", new Object[]{"room_", "identity_", "trackSids_", "subscribe_", "participantTracks_", LivekitModels$ParticipantTracks.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$UpdateSubscriptionsRequest.class) {
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

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
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

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
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

    public static a newBuilder(LivekitRoom$UpdateSubscriptionsRequest livekitRoom$UpdateSubscriptionsRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$UpdateSubscriptionsRequest);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipantTracks(int i, LivekitModels$ParticipantTracks livekitModels$ParticipantTracks) {
        livekitModels$ParticipantTracks.getClass();
        ensureParticipantTracksIsMutable();
        this.participantTracks_.add(i, livekitModels$ParticipantTracks);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(byte[] bArr) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(InputStream inputStream) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$UpdateSubscriptionsRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$UpdateSubscriptionsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
