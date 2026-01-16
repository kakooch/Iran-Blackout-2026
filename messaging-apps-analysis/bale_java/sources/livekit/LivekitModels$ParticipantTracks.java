package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitModels$ParticipantTracks extends GeneratedMessageLite implements TE3 {
    private static final LivekitModels$ParticipantTracks DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 1;
    public static final int TRACK_SIDS_FIELD_NUMBER = 2;
    private String participantSid_ = "";
    private B.j trackSids_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements TE3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitModels$ParticipantTracks) this.b).addTrackSids(str);
            return this;
        }

        public int B() {
            return ((LivekitModels$ParticipantTracks) this.b).getTrackSidsCount();
        }

        public a C(String str) {
            q();
            ((LivekitModels$ParticipantTracks) this.b).setParticipantSid(str);
            return this;
        }

        private a() {
            super(LivekitModels$ParticipantTracks.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$ParticipantTracks livekitModels$ParticipantTracks = new LivekitModels$ParticipantTracks();
        DEFAULT_INSTANCE = livekitModels$ParticipantTracks;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ParticipantTracks.class, livekitModels$ParticipantTracks);
    }

    private LivekitModels$ParticipantTracks() {
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

    public static LivekitModels$ParticipantTracks getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ParticipantTracks parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ParticipantTracks parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ParticipantTracks();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"participantSid_", "trackSids_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ParticipantTracks.class) {
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

    public static a newBuilder(LivekitModels$ParticipantTracks livekitModels$ParticipantTracks) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$ParticipantTracks);
    }

    public static LivekitModels$ParticipantTracks parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ParticipantTracks parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ParticipantTracks parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ParticipantTracks parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ParticipantTracks parseFrom(byte[] bArr) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ParticipantTracks parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ParticipantTracks parseFrom(InputStream inputStream) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ParticipantTracks parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ParticipantTracks parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ParticipantTracks parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ParticipantTracks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
