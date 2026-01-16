package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23033wE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$SegmentsInfo extends GeneratedMessageLite implements InterfaceC23033wE3 {
    private static final LivekitEgress$SegmentsInfo DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 2;
    public static final int ENDED_AT_FIELD_NUMBER = 7;
    public static final int LIVE_PLAYLIST_LOCATION_FIELD_NUMBER = 9;
    public static final int LIVE_PLAYLIST_NAME_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int PLAYLIST_LOCATION_FIELD_NUMBER = 4;
    public static final int PLAYLIST_NAME_FIELD_NUMBER = 1;
    public static final int SEGMENT_COUNT_FIELD_NUMBER = 5;
    public static final int SIZE_FIELD_NUMBER = 3;
    public static final int STARTED_AT_FIELD_NUMBER = 6;
    private long duration_;
    private long endedAt_;
    private long segmentCount_;
    private long size_;
    private long startedAt_;
    private String playlistName_ = "";
    private String livePlaylistName_ = "";
    private String playlistLocation_ = "";
    private String livePlaylistLocation_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23033wE3 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$SegmentsInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo = new LivekitEgress$SegmentsInfo();
        DEFAULT_INSTANCE = livekitEgress$SegmentsInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$SegmentsInfo.class, livekitEgress$SegmentsInfo);
    }

    private LivekitEgress$SegmentsInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLivePlaylistLocation() {
        this.livePlaylistLocation_ = getDefaultInstance().getLivePlaylistLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLivePlaylistName() {
        this.livePlaylistName_ = getDefaultInstance().getLivePlaylistName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlaylistLocation() {
        this.playlistLocation_ = getDefaultInstance().getPlaylistLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlaylistName() {
        this.playlistName_ = getDefaultInstance().getPlaylistName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegmentCount() {
        this.segmentCount_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    public static LivekitEgress$SegmentsInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$SegmentsInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(long j) {
        this.duration_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLivePlaylistLocation(String str) {
        str.getClass();
        this.livePlaylistLocation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLivePlaylistLocationBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.livePlaylistLocation_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLivePlaylistName(String str) {
        str.getClass();
        this.livePlaylistName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLivePlaylistNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.livePlaylistName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistLocation(String str) {
        str.getClass();
        this.playlistLocation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistLocationBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.playlistLocation_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistName(String str) {
        str.getClass();
        this.playlistName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.playlistName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegmentCount(long j) {
        this.segmentCount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(long j) {
        this.size_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$SegmentsInfo();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007\u0002\bȈ\tȈ", new Object[]{"playlistName_", "duration_", "size_", "playlistLocation_", "segmentCount_", "startedAt_", "endedAt_", "livePlaylistName_", "livePlaylistLocation_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$SegmentsInfo.class) {
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

    public long getDuration() {
        return this.duration_;
    }

    public long getEndedAt() {
        return this.endedAt_;
    }

    public String getLivePlaylistLocation() {
        return this.livePlaylistLocation_;
    }

    public AbstractC2383g getLivePlaylistLocationBytes() {
        return AbstractC2383g.N(this.livePlaylistLocation_);
    }

    public String getLivePlaylistName() {
        return this.livePlaylistName_;
    }

    public AbstractC2383g getLivePlaylistNameBytes() {
        return AbstractC2383g.N(this.livePlaylistName_);
    }

    public String getPlaylistLocation() {
        return this.playlistLocation_;
    }

    public AbstractC2383g getPlaylistLocationBytes() {
        return AbstractC2383g.N(this.playlistLocation_);
    }

    public String getPlaylistName() {
        return this.playlistName_;
    }

    public AbstractC2383g getPlaylistNameBytes() {
        return AbstractC2383g.N(this.playlistName_);
    }

    public long getSegmentCount() {
        return this.segmentCount_;
    }

    public long getSize() {
        return this.size_;
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public static a newBuilder(LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$SegmentsInfo);
    }

    public static LivekitEgress$SegmentsInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(byte[] bArr) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(InputStream inputStream) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$SegmentsInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$SegmentsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
