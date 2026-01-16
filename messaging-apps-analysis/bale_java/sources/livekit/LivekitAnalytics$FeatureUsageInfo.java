package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13442gE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$FeatureUsageInfo extends GeneratedMessageLite implements U64 {
    private static final LivekitAnalytics$FeatureUsageInfo DEFAULT_INSTANCE;
    public static final int FEATURE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 5;
    public static final int PARTICIPANT_ID_FIELD_NUMBER = 6;
    public static final int PROJECT_ID_FIELD_NUMBER = 2;
    public static final int ROOM_ID_FIELD_NUMBER = 4;
    public static final int ROOM_NAME_FIELD_NUMBER = 3;
    public static final int TIME_RANGES_FIELD_NUMBER = 8;
    public static final int TRACK_ID_FIELD_NUMBER = 7;
    private int feature_;
    private String projectId_ = "";
    private String roomName_ = "";
    private String roomId_ = "";
    private String participantIdentity_ = "";
    private String participantId_ = "";
    private String trackId_ = "";
    private B.j timeRanges_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$FeatureUsageInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        KRISP_NOISE_CANCELLATION(0),
        KRISP_BACKGROUND_VOICE_CANCELLATION(1),
        UNRECOGNIZED(-1);

        private static final B.d e = new a();
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

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return KRISP_NOISE_CANCELLATION;
            }
            if (i != 1) {
                return null;
            }
            return KRISP_BACKGROUND_VOICE_CANCELLATION;
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
        LivekitAnalytics$FeatureUsageInfo livekitAnalytics$FeatureUsageInfo = new LivekitAnalytics$FeatureUsageInfo();
        DEFAULT_INSTANCE = livekitAnalytics$FeatureUsageInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$FeatureUsageInfo.class, livekitAnalytics$FeatureUsageInfo);
    }

    private LivekitAnalytics$FeatureUsageInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTimeRanges(Iterable<? extends LivekitAnalytics$TimeRange> iterable) {
        ensureTimeRangesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.timeRanges_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTimeRanges(LivekitAnalytics$TimeRange livekitAnalytics$TimeRange) {
        livekitAnalytics$TimeRange.getClass();
        ensureTimeRangesIsMutable();
        this.timeRanges_.add(livekitAnalytics$TimeRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFeature() {
        this.feature_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantId() {
        this.participantId_ = getDefaultInstance().getParticipantId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectId() {
        this.projectId_ = getDefaultInstance().getProjectId();
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
    public void clearTimeRanges() {
        this.timeRanges_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    private void ensureTimeRangesIsMutable() {
        B.j jVar = this.timeRanges_;
        if (jVar.u()) {
            return;
        }
        this.timeRanges_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$FeatureUsageInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$FeatureUsageInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTimeRanges(int i) {
        ensureTimeRangesIsMutable();
        this.timeRanges_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeature(b bVar) {
        this.feature_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeatureValue(int i) {
        this.feature_ = i;
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
    public void setParticipantIdentity(String str) {
        str.getClass();
        this.participantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantIdentity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectId(String str) {
        str.getClass();
        this.projectId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.projectId_ = abstractC2383g.f0();
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
    public void setTimeRanges(int i, LivekitAnalytics$TimeRange livekitAnalytics$TimeRange) {
        livekitAnalytics$TimeRange.getClass();
        ensureTimeRangesIsMutable();
        this.timeRanges_.set(i, livekitAnalytics$TimeRange);
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
                return new LivekitAnalytics$FeatureUsageInfo();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u001b", new Object[]{"feature_", "projectId_", "roomName_", "roomId_", "participantIdentity_", "participantId_", "trackId_", "timeRanges_", LivekitAnalytics$TimeRange.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$FeatureUsageInfo.class) {
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

    public b getFeature() {
        b bVarJ = b.j(this.feature_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getFeatureValue() {
        return this.feature_;
    }

    public String getParticipantId() {
        return this.participantId_;
    }

    public AbstractC2383g getParticipantIdBytes() {
        return AbstractC2383g.N(this.participantId_);
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getProjectId() {
        return this.projectId_;
    }

    public AbstractC2383g getProjectIdBytes() {
        return AbstractC2383g.N(this.projectId_);
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

    public LivekitAnalytics$TimeRange getTimeRanges(int i) {
        return (LivekitAnalytics$TimeRange) this.timeRanges_.get(i);
    }

    public int getTimeRangesCount() {
        return this.timeRanges_.size();
    }

    public List<LivekitAnalytics$TimeRange> getTimeRangesList() {
        return this.timeRanges_;
    }

    public InterfaceC13442gE3 getTimeRangesOrBuilder(int i) {
        return (InterfaceC13442gE3) this.timeRanges_.get(i);
    }

    public List<? extends InterfaceC13442gE3> getTimeRangesOrBuilderList() {
        return this.timeRanges_;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public static a newBuilder(LivekitAnalytics$FeatureUsageInfo livekitAnalytics$FeatureUsageInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$FeatureUsageInfo);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTimeRanges(int i, LivekitAnalytics$TimeRange livekitAnalytics$TimeRange) {
        livekitAnalytics$TimeRange.getClass();
        ensureTimeRangesIsMutable();
        this.timeRanges_.add(i, livekitAnalytics$TimeRange);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(byte[] bArr) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$FeatureUsageInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$FeatureUsageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
