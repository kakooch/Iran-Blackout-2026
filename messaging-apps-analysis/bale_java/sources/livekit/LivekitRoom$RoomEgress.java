package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitEgress$AutoParticipantEgress;
import livekit.LivekitEgress$AutoTrackEgress;
import livekit.LivekitEgress$RoomCompositeEgressRequest;

/* loaded from: classes8.dex */
public final class LivekitRoom$RoomEgress extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$RoomEgress DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 3;
    public static final int ROOM_FIELD_NUMBER = 1;
    public static final int TRACKS_FIELD_NUMBER = 2;
    private LivekitEgress$AutoParticipantEgress participant_;
    private LivekitEgress$RoomCompositeEgressRequest room_;
    private LivekitEgress$AutoTrackEgress tracks_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$RoomEgress.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$RoomEgress livekitRoom$RoomEgress = new LivekitRoom$RoomEgress();
        DEFAULT_INSTANCE = livekitRoom$RoomEgress;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$RoomEgress.class, livekitRoom$RoomEgress);
    }

    private LivekitRoom$RoomEgress() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipant() {
        this.participant_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTracks() {
        this.tracks_ = null;
    }

    public static LivekitRoom$RoomEgress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParticipant(LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress) {
        livekitEgress$AutoParticipantEgress.getClass();
        LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress2 = this.participant_;
        if (livekitEgress$AutoParticipantEgress2 == null || livekitEgress$AutoParticipantEgress2 == LivekitEgress$AutoParticipantEgress.getDefaultInstance()) {
            this.participant_ = livekitEgress$AutoParticipantEgress;
        } else {
            this.participant_ = (LivekitEgress$AutoParticipantEgress) ((LivekitEgress$AutoParticipantEgress.a) LivekitEgress$AutoParticipantEgress.newBuilder(this.participant_).v(livekitEgress$AutoParticipantEgress)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoom(LivekitEgress$RoomCompositeEgressRequest livekitEgress$RoomCompositeEgressRequest) {
        livekitEgress$RoomCompositeEgressRequest.getClass();
        LivekitEgress$RoomCompositeEgressRequest livekitEgress$RoomCompositeEgressRequest2 = this.room_;
        if (livekitEgress$RoomCompositeEgressRequest2 == null || livekitEgress$RoomCompositeEgressRequest2 == LivekitEgress$RoomCompositeEgressRequest.getDefaultInstance()) {
            this.room_ = livekitEgress$RoomCompositeEgressRequest;
        } else {
            this.room_ = (LivekitEgress$RoomCompositeEgressRequest) ((LivekitEgress$RoomCompositeEgressRequest.a) LivekitEgress$RoomCompositeEgressRequest.newBuilder(this.room_).v(livekitEgress$RoomCompositeEgressRequest)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTracks(LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress) {
        livekitEgress$AutoTrackEgress.getClass();
        LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress2 = this.tracks_;
        if (livekitEgress$AutoTrackEgress2 == null || livekitEgress$AutoTrackEgress2 == LivekitEgress$AutoTrackEgress.getDefaultInstance()) {
            this.tracks_ = livekitEgress$AutoTrackEgress;
        } else {
            this.tracks_ = (LivekitEgress$AutoTrackEgress) ((LivekitEgress$AutoTrackEgress.a) LivekitEgress$AutoTrackEgress.newBuilder(this.tracks_).v(livekitEgress$AutoTrackEgress)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$RoomEgress parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomEgress parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress) {
        livekitEgress$AutoParticipantEgress.getClass();
        this.participant_ = livekitEgress$AutoParticipantEgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitEgress$RoomCompositeEgressRequest livekitEgress$RoomCompositeEgressRequest) {
        livekitEgress$RoomCompositeEgressRequest.getClass();
        this.room_ = livekitEgress$RoomCompositeEgressRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTracks(LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress) {
        livekitEgress$AutoTrackEgress.getClass();
        this.tracks_ = livekitEgress$AutoTrackEgress;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$RoomEgress();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t", new Object[]{"room_", "tracks_", "participant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$RoomEgress.class) {
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

    public LivekitEgress$AutoParticipantEgress getParticipant() {
        LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress = this.participant_;
        return livekitEgress$AutoParticipantEgress == null ? LivekitEgress$AutoParticipantEgress.getDefaultInstance() : livekitEgress$AutoParticipantEgress;
    }

    public LivekitEgress$RoomCompositeEgressRequest getRoom() {
        LivekitEgress$RoomCompositeEgressRequest livekitEgress$RoomCompositeEgressRequest = this.room_;
        return livekitEgress$RoomCompositeEgressRequest == null ? LivekitEgress$RoomCompositeEgressRequest.getDefaultInstance() : livekitEgress$RoomCompositeEgressRequest;
    }

    public LivekitEgress$AutoTrackEgress getTracks() {
        LivekitEgress$AutoTrackEgress livekitEgress$AutoTrackEgress = this.tracks_;
        return livekitEgress$AutoTrackEgress == null ? LivekitEgress$AutoTrackEgress.getDefaultInstance() : livekitEgress$AutoTrackEgress;
    }

    public boolean hasParticipant() {
        return this.participant_ != null;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public boolean hasTracks() {
        return this.tracks_ != null;
    }

    public static a newBuilder(LivekitRoom$RoomEgress livekitRoom$RoomEgress) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$RoomEgress);
    }

    public static LivekitRoom$RoomEgress parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomEgress parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$RoomEgress parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$RoomEgress parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$RoomEgress parseFrom(byte[] bArr) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$RoomEgress parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$RoomEgress parseFrom(InputStream inputStream) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomEgress parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomEgress parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$RoomEgress parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$RoomEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
