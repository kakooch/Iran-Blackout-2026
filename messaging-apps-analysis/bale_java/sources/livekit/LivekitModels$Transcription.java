package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10817cF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitModels$Transcription extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$Transcription DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEGMENTS_FIELD_NUMBER = 4;
    public static final int TRACK_ID_FIELD_NUMBER = 3;
    public static final int TRANSCRIBED_PARTICIPANT_IDENTITY_FIELD_NUMBER = 2;
    private String transcribedParticipantIdentity_ = "";
    private String trackId_ = "";
    private B.j segments_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$Transcription.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$Transcription livekitModels$Transcription = new LivekitModels$Transcription();
        DEFAULT_INSTANCE = livekitModels$Transcription;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$Transcription.class, livekitModels$Transcription);
    }

    private LivekitModels$Transcription() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSegments(Iterable<? extends LivekitModels$TranscriptionSegment> iterable) {
        ensureSegmentsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.segments_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegments(LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment) {
        livekitModels$TranscriptionSegment.getClass();
        ensureSegmentsIsMutable();
        this.segments_.add(livekitModels$TranscriptionSegment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegments() {
        this.segments_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTranscribedParticipantIdentity() {
        this.transcribedParticipantIdentity_ = getDefaultInstance().getTranscribedParticipantIdentity();
    }

    private void ensureSegmentsIsMutable() {
        B.j jVar = this.segments_;
        if (jVar.u()) {
            return;
        }
        this.segments_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$Transcription getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$Transcription parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Transcription parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSegments(int i) {
        ensureSegmentsIsMutable();
        this.segments_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegments(int i, LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment) {
        livekitModels$TranscriptionSegment.getClass();
        ensureSegmentsIsMutable();
        this.segments_.set(i, livekitModels$TranscriptionSegment);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranscribedParticipantIdentity(String str) {
        str.getClass();
        this.transcribedParticipantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranscribedParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transcribedParticipantIdentity_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$Transcription();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0002\u0004\u0003\u0000\u0001\u0000\u0002Ȉ\u0003Ȉ\u0004\u001b", new Object[]{"transcribedParticipantIdentity_", "trackId_", "segments_", LivekitModels$TranscriptionSegment.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$Transcription.class) {
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

    public LivekitModels$TranscriptionSegment getSegments(int i) {
        return (LivekitModels$TranscriptionSegment) this.segments_.get(i);
    }

    public int getSegmentsCount() {
        return this.segments_.size();
    }

    public List<LivekitModels$TranscriptionSegment> getSegmentsList() {
        return this.segments_;
    }

    public InterfaceC10817cF3 getSegmentsOrBuilder(int i) {
        return (InterfaceC10817cF3) this.segments_.get(i);
    }

    public List<? extends InterfaceC10817cF3> getSegmentsOrBuilderList() {
        return this.segments_;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public String getTranscribedParticipantIdentity() {
        return this.transcribedParticipantIdentity_;
    }

    public AbstractC2383g getTranscribedParticipantIdentityBytes() {
        return AbstractC2383g.N(this.transcribedParticipantIdentity_);
    }

    public static a newBuilder(LivekitModels$Transcription livekitModels$Transcription) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$Transcription);
    }

    public static LivekitModels$Transcription parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Transcription parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$Transcription parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegments(int i, LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment) {
        livekitModels$TranscriptionSegment.getClass();
        ensureSegmentsIsMutable();
        this.segments_.add(i, livekitModels$TranscriptionSegment);
    }

    public static LivekitModels$Transcription parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$Transcription parseFrom(byte[] bArr) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$Transcription parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$Transcription parseFrom(InputStream inputStream) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Transcription parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Transcription parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$Transcription parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$Transcription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
