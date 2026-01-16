package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.EnumC12824fE3;
import ir.nasim.InterfaceC10808cE3;
import ir.nasim.InterfaceC11572dE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsStat extends GeneratedMessageLite implements InterfaceC10808cE3 {
    public static final int ANALYTICS_KEY_FIELD_NUMBER = 1;
    private static final LivekitAnalytics$AnalyticsStat DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 14;
    public static final int KIND_FIELD_NUMBER = 2;
    public static final int MEDIAN_SCORE_FIELD_NUMBER = 13;
    public static final int MIME_FIELD_NUMBER = 11;
    public static final int MIN_SCORE_FIELD_NUMBER = 12;
    public static final int NODE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_ID_FIELD_NUMBER = 7;
    public static final int ROOM_ID_FIELD_NUMBER = 5;
    public static final int ROOM_NAME_FIELD_NUMBER = 6;
    public static final int SCORE_FIELD_NUMBER = 9;
    public static final int STREAMS_FIELD_NUMBER = 10;
    public static final int TIME_STAMP_FIELD_NUMBER = 3;
    public static final int TRACK_ID_FIELD_NUMBER = 8;
    private int kind_;
    private float medianScore_;
    private float minScore_;
    private float score_;
    private Timestamp timeStamp_;
    private String id_ = "";
    private String analyticsKey_ = "";
    private String node_ = "";
    private String roomId_ = "";
    private String roomName_ = "";
    private String participantId_ = "";
    private String trackId_ = "";
    private B.j streams_ = GeneratedMessageLite.emptyProtobufList();
    private String mime_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC10808cE3 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsStat.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsStat livekitAnalytics$AnalyticsStat = new LivekitAnalytics$AnalyticsStat();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsStat;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsStat.class, livekitAnalytics$AnalyticsStat);
    }

    private LivekitAnalytics$AnalyticsStat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStreams(Iterable<? extends LivekitAnalytics$AnalyticsStream> iterable) {
        ensureStreamsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.streams_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreams(LivekitAnalytics$AnalyticsStream livekitAnalytics$AnalyticsStream) {
        livekitAnalytics$AnalyticsStream.getClass();
        ensureStreamsIsMutable();
        this.streams_.add(livekitAnalytics$AnalyticsStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnalyticsKey() {
        this.analyticsKey_ = getDefaultInstance().getAnalyticsKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMedianScore() {
        this.medianScore_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMime() {
        this.mime_ = getDefaultInstance().getMime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinScore() {
        this.minScore_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNode() {
        this.node_ = getDefaultInstance().getNode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantId() {
        this.participantId_ = getDefaultInstance().getParticipantId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomId() {
        this.roomId_ = getDefaultInstance().getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScore() {
        this.score_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreams() {
        this.streams_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeStamp() {
        this.timeStamp_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    private void ensureStreamsIsMutable() {
        B.j jVar = this.streams_;
        if (jVar.u()) {
            return;
        }
        this.streams_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$AnalyticsStat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTimeStamp(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.timeStamp_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.timeStamp_ = timestamp;
        } else {
            this.timeStamp_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.timeStamp_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsStat parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStreams(int i) {
        ensureStreamsIsMutable();
        this.streams_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnalyticsKey(String str) {
        str.getClass();
        this.analyticsKey_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnalyticsKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.analyticsKey_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(EnumC12824fE3 enumC12824fE3) {
        this.kind_ = enumC12824fE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMedianScore(float f) {
        this.medianScore_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMime(String str) {
        str.getClass();
        this.mime_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mime_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinScore(float f) {
        this.minScore_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNode(String str) {
        str.getClass();
        this.node_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.node_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantId(String str) {
        str.getClass();
        this.participantId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantId_ = abstractC2383g.f0();
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
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScore(float f) {
        this.score_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreams(int i, LivekitAnalytics$AnalyticsStream livekitAnalytics$AnalyticsStream) {
        livekitAnalytics$AnalyticsStream.getClass();
        ensureStreamsIsMutable();
        this.streams_.set(i, livekitAnalytics$AnalyticsStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeStamp(Timestamp timestamp) {
        timestamp.getClass();
        this.timeStamp_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackId(String str) {
        str.getClass();
        this.trackId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsStat();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0000\u0001\u000e\u000e\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\t\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\t\u0001\n\u001b\u000bȈ\f\u0001\r\u0001\u000eȈ", new Object[]{"analyticsKey_", "kind_", "timeStamp_", "node_", "roomId_", "roomName_", "participantId_", "trackId_", "score_", "streams_", LivekitAnalytics$AnalyticsStream.class, "mime_", "minScore_", "medianScore_", "id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsStat.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getAnalyticsKey() {
        return this.analyticsKey_;
    }

    public AbstractC2383g getAnalyticsKeyBytes() {
        return AbstractC2383g.N(this.analyticsKey_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public EnumC12824fE3 getKind() {
        EnumC12824fE3 enumC12824fE3J = EnumC12824fE3.j(this.kind_);
        return enumC12824fE3J == null ? EnumC12824fE3.UNRECOGNIZED : enumC12824fE3J;
    }

    public int getKindValue() {
        return this.kind_;
    }

    public float getMedianScore() {
        return this.medianScore_;
    }

    public String getMime() {
        return this.mime_;
    }

    public AbstractC2383g getMimeBytes() {
        return AbstractC2383g.N(this.mime_);
    }

    public float getMinScore() {
        return this.minScore_;
    }

    public String getNode() {
        return this.node_;
    }

    public AbstractC2383g getNodeBytes() {
        return AbstractC2383g.N(this.node_);
    }

    public String getParticipantId() {
        return this.participantId_;
    }

    public AbstractC2383g getParticipantIdBytes() {
        return AbstractC2383g.N(this.participantId_);
    }

    public String getRoomId() {
        return this.roomId_;
    }

    public AbstractC2383g getRoomIdBytes() {
        return AbstractC2383g.N(this.roomId_);
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public float getScore() {
        return this.score_;
    }

    public LivekitAnalytics$AnalyticsStream getStreams(int i) {
        return (LivekitAnalytics$AnalyticsStream) this.streams_.get(i);
    }

    public int getStreamsCount() {
        return this.streams_.size();
    }

    public List<LivekitAnalytics$AnalyticsStream> getStreamsList() {
        return this.streams_;
    }

    public InterfaceC11572dE3 getStreamsOrBuilder(int i) {
        return (InterfaceC11572dE3) this.streams_.get(i);
    }

    public List<? extends InterfaceC11572dE3> getStreamsOrBuilderList() {
        return this.streams_;
    }

    public Timestamp getTimeStamp() {
        Timestamp timestamp = this.timeStamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public boolean hasTimeStamp() {
        return this.timeStamp_ != null;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsStat livekitAnalytics$AnalyticsStat) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsStat);
    }

    public static LivekitAnalytics$AnalyticsStat parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreams(int i, LivekitAnalytics$AnalyticsStream livekitAnalytics$AnalyticsStream) {
        livekitAnalytics$AnalyticsStream.getClass();
        ensureStreamsIsMutable();
        this.streams_.add(i, livekitAnalytics$AnalyticsStream);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsStat parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
