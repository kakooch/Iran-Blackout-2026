package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitIngress$InputAudioState;
import livekit.LivekitIngress$InputVideoState;

/* loaded from: classes8.dex */
public final class LivekitIngress$IngressState extends GeneratedMessageLite implements U64 {
    public static final int AUDIO_FIELD_NUMBER = 4;
    private static final LivekitIngress$IngressState DEFAULT_INSTANCE;
    public static final int ENDED_AT_FIELD_NUMBER = 8;
    public static final int ERROR_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RESOURCE_ID_FIELD_NUMBER = 9;
    public static final int ROOM_ID_FIELD_NUMBER = 5;
    public static final int STARTED_AT_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int TRACKS_FIELD_NUMBER = 6;
    public static final int UPDATED_AT_FIELD_NUMBER = 10;
    public static final int VIDEO_FIELD_NUMBER = 3;
    private LivekitIngress$InputAudioState audio_;
    private long endedAt_;
    private long startedAt_;
    private int status_;
    private long updatedAt_;
    private LivekitIngress$InputVideoState video_;
    private String error_ = "";
    private String roomId_ = "";
    private String resourceId_ = "";
    private B.j tracks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$IngressState.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        ENDPOINT_INACTIVE(0),
        ENDPOINT_BUFFERING(1),
        ENDPOINT_PUBLISHING(2),
        ENDPOINT_ERROR(3),
        ENDPOINT_COMPLETE(4),
        UNRECOGNIZED(-1);

        private static final B.d h = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i2) {
            this.a = i2;
        }

        public static b j(int i2) {
            if (i2 == 0) {
                return ENDPOINT_INACTIVE;
            }
            if (i2 == 1) {
                return ENDPOINT_BUFFERING;
            }
            if (i2 == 2) {
                return ENDPOINT_PUBLISHING;
            }
            if (i2 == 3) {
                return ENDPOINT_ERROR;
            }
            if (i2 != 4) {
                return null;
            }
            return ENDPOINT_COMPLETE;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitIngress$IngressState livekitIngress$IngressState = new LivekitIngress$IngressState();
        DEFAULT_INSTANCE = livekitIngress$IngressState;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$IngressState.class, livekitIngress$IngressState);
    }

    private LivekitIngress$IngressState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTracks(Iterable<? extends LivekitModels$TrackInfo> iterable) {
        ensureTracksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tracks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTracks(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        ensureTracksIsMutable();
        this.tracks_.add(livekitModels$TrackInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudio() {
        this.audio_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResourceId() {
        this.resourceId_ = getDefaultInstance().getResourceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomId() {
        this.roomId_ = getDefaultInstance().getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTracks() {
        this.tracks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideo() {
        this.video_ = null;
    }

    private void ensureTracksIsMutable() {
        B.j jVar = this.tracks_;
        if (jVar.u()) {
            return;
        }
        this.tracks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitIngress$IngressState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAudio(LivekitIngress$InputAudioState livekitIngress$InputAudioState) {
        livekitIngress$InputAudioState.getClass();
        LivekitIngress$InputAudioState livekitIngress$InputAudioState2 = this.audio_;
        if (livekitIngress$InputAudioState2 == null || livekitIngress$InputAudioState2 == LivekitIngress$InputAudioState.getDefaultInstance()) {
            this.audio_ = livekitIngress$InputAudioState;
        } else {
            this.audio_ = (LivekitIngress$InputAudioState) ((LivekitIngress$InputAudioState.a) LivekitIngress$InputAudioState.newBuilder(this.audio_).v(livekitIngress$InputAudioState)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVideo(LivekitIngress$InputVideoState livekitIngress$InputVideoState) {
        livekitIngress$InputVideoState.getClass();
        LivekitIngress$InputVideoState livekitIngress$InputVideoState2 = this.video_;
        if (livekitIngress$InputVideoState2 == null || livekitIngress$InputVideoState2 == LivekitIngress$InputVideoState.getDefaultInstance()) {
            this.video_ = livekitIngress$InputVideoState;
        } else {
            this.video_ = (LivekitIngress$InputVideoState) ((LivekitIngress$InputVideoState.a) LivekitIngress$InputVideoState.newBuilder(this.video_).v(livekitIngress$InputVideoState)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$IngressState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTracks(int i) {
        ensureTracksIsMutable();
        this.tracks_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudio(LivekitIngress$InputAudioState livekitIngress$InputAudioState) {
        livekitIngress$InputAudioState.getClass();
        this.audio_ = livekitIngress$InputAudioState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceId(String str) {
        str.getClass();
        this.resourceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.resourceId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomId(String str) {
        str.getClass();
        this.roomId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(b bVar) {
        this.status_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTracks(int i, LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        ensureTracksIsMutable();
        this.tracks_.set(i, livekitModels$TrackInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdatedAt(long j) {
        this.updatedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideo(LivekitIngress$InputVideoState livekitIngress$InputVideoState) {
        livekitIngress$InputVideoState.getClass();
        this.video_ = livekitIngress$InputVideoState;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$IngressState();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003\t\u0004\t\u0005Ȉ\u0006\u001b\u0007\u0002\b\u0002\tȈ\n\u0002", new Object[]{"status_", "error_", "video_", "audio_", "roomId_", "tracks_", LivekitModels$TrackInfo.class, "startedAt_", "endedAt_", "resourceId_", "updatedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$IngressState.class) {
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

    public LivekitIngress$InputAudioState getAudio() {
        LivekitIngress$InputAudioState livekitIngress$InputAudioState = this.audio_;
        return livekitIngress$InputAudioState == null ? LivekitIngress$InputAudioState.getDefaultInstance() : livekitIngress$InputAudioState;
    }

    public long getEndedAt() {
        return this.endedAt_;
    }

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public String getResourceId() {
        return this.resourceId_;
    }

    public AbstractC2383g getResourceIdBytes() {
        return AbstractC2383g.N(this.resourceId_);
    }

    public String getRoomId() {
        return this.roomId_;
    }

    public AbstractC2383g getRoomIdBytes() {
        return AbstractC2383g.N(this.roomId_);
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public b getStatus() {
        b bVarJ = b.j(this.status_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public LivekitModels$TrackInfo getTracks(int i) {
        return (LivekitModels$TrackInfo) this.tracks_.get(i);
    }

    public int getTracksCount() {
        return this.tracks_.size();
    }

    public List<LivekitModels$TrackInfo> getTracksList() {
        return this.tracks_;
    }

    public q getTracksOrBuilder(int i) {
        return (q) this.tracks_.get(i);
    }

    public List<? extends q> getTracksOrBuilderList() {
        return this.tracks_;
    }

    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    public LivekitIngress$InputVideoState getVideo() {
        LivekitIngress$InputVideoState livekitIngress$InputVideoState = this.video_;
        return livekitIngress$InputVideoState == null ? LivekitIngress$InputVideoState.getDefaultInstance() : livekitIngress$InputVideoState;
    }

    public boolean hasAudio() {
        return this.audio_ != null;
    }

    public boolean hasVideo() {
        return this.video_ != null;
    }

    public static a newBuilder(LivekitIngress$IngressState livekitIngress$IngressState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$IngressState);
    }

    public static LivekitIngress$IngressState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$IngressState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTracks(int i, LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        ensureTracksIsMutable();
        this.tracks_.add(i, livekitModels$TrackInfo);
    }

    public static LivekitIngress$IngressState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$IngressState parseFrom(byte[] bArr) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$IngressState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$IngressState parseFrom(InputStream inputStream) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$IngressState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$IngressState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
