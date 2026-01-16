package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21182tF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$TrackPermission extends GeneratedMessageLite implements InterfaceC21182tF3 {
    public static final int ALL_TRACKS_FIELD_NUMBER = 2;
    private static final LivekitRtc$TrackPermission DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 4;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 1;
    public static final int TRACK_SIDS_FIELD_NUMBER = 3;
    private boolean allTracks_;
    private String participantSid_ = "";
    private B.j trackSids_ = GeneratedMessageLite.emptyProtobufList();
    private String participantIdentity_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21182tF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$TrackPermission.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$TrackPermission livekitRtc$TrackPermission = new LivekitRtc$TrackPermission();
        DEFAULT_INSTANCE = livekitRtc$TrackPermission;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$TrackPermission.class, livekitRtc$TrackPermission);
    }

    private LivekitRtc$TrackPermission() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrackSids(Iterable<String> iterable) {
        ensureTrackSidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trackSids_);
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
    public void clearAllTracks() {
        this.allTracks_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSid() {
        this.participantSid_ = getDefaultInstance().getParticipantSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSids() {
        this.trackSids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTrackSidsIsMutable() {
        B.j jVar = this.trackSids_;
        if (jVar.u()) {
            return;
        }
        this.trackSids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$TrackPermission getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$TrackPermission parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrackPermission parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllTracks(boolean z) {
        this.allTracks_ = z;
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
    public void setParticipantSid(String str) {
        str.getClass();
        this.participantSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantSid_ = abstractC2383g.f0();
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
                return new LivekitRtc$TrackPermission();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u0007\u0003Ț\u0004Ȉ", new Object[]{"participantSid_", "allTracks_", "trackSids_", "participantIdentity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$TrackPermission.class) {
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

    public boolean getAllTracks() {
        return this.allTracks_;
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getParticipantSid() {
        return this.participantSid_;
    }

    public AbstractC2383g getParticipantSidBytes() {
        return AbstractC2383g.N(this.participantSid_);
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

    public static a newBuilder(LivekitRtc$TrackPermission livekitRtc$TrackPermission) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$TrackPermission);
    }

    public static LivekitRtc$TrackPermission parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrackPermission parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$TrackPermission parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$TrackPermission parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$TrackPermission parseFrom(byte[] bArr) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$TrackPermission parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$TrackPermission parseFrom(InputStream inputStream) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrackPermission parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrackPermission parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$TrackPermission parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$TrackPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
