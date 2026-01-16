package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$TrackInfo;

/* loaded from: classes8.dex */
public final class LivekitRoom$MuteRoomTrackResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$MuteRoomTrackResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_FIELD_NUMBER = 1;
    private LivekitModels$TrackInfo track_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$MuteRoomTrackResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$MuteRoomTrackResponse livekitRoom$MuteRoomTrackResponse = new LivekitRoom$MuteRoomTrackResponse();
        DEFAULT_INSTANCE = livekitRoom$MuteRoomTrackResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$MuteRoomTrackResponse.class, livekitRoom$MuteRoomTrackResponse);
    }

    private LivekitRoom$MuteRoomTrackResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrack() {
        this.track_ = null;
    }

    public static LivekitRoom$MuteRoomTrackResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        LivekitModels$TrackInfo livekitModels$TrackInfo2 = this.track_;
        if (livekitModels$TrackInfo2 == null || livekitModels$TrackInfo2 == LivekitModels$TrackInfo.getDefaultInstance()) {
            this.track_ = livekitModels$TrackInfo;
        } else {
            this.track_ = (LivekitModels$TrackInfo) ((LivekitModels$TrackInfo.b) LivekitModels$TrackInfo.newBuilder(this.track_).v(livekitModels$TrackInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$MuteRoomTrackResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        this.track_ = livekitModels$TrackInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$MuteRoomTrackResponse();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"track_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$MuteRoomTrackResponse.class) {
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

    public LivekitModels$TrackInfo getTrack() {
        LivekitModels$TrackInfo livekitModels$TrackInfo = this.track_;
        return livekitModels$TrackInfo == null ? LivekitModels$TrackInfo.getDefaultInstance() : livekitModels$TrackInfo;
    }

    public boolean hasTrack() {
        return this.track_ != null;
    }

    public static a newBuilder(LivekitRoom$MuteRoomTrackResponse livekitRoom$MuteRoomTrackResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$MuteRoomTrackResponse);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(byte[] bArr) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(InputStream inputStream) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$MuteRoomTrackResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
