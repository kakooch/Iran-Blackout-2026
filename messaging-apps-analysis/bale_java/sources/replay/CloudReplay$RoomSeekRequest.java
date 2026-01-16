package replay;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class CloudReplay$RoomSeekRequest extends GeneratedMessageLite implements U64 {
    private static final CloudReplay$RoomSeekRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PLAYBACK_ID_FIELD_NUMBER = 1;
    public static final int PTS_FIELD_NUMBER = 2;
    private String playbackId_ = "";
    private long pts_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(replay.a aVar) {
            this();
        }

        private a() {
            super(CloudReplay$RoomSeekRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        CloudReplay$RoomSeekRequest cloudReplay$RoomSeekRequest = new CloudReplay$RoomSeekRequest();
        DEFAULT_INSTANCE = cloudReplay$RoomSeekRequest;
        GeneratedMessageLite.registerDefaultInstance(CloudReplay$RoomSeekRequest.class, cloudReplay$RoomSeekRequest);
    }

    private CloudReplay$RoomSeekRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlaybackId() {
        this.playbackId_ = getDefaultInstance().getPlaybackId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPts() {
        this.pts_ = 0L;
    }

    public static CloudReplay$RoomSeekRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CloudReplay$RoomSeekRequest parseDelimitedFrom(InputStream inputStream) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(ByteBuffer byteBuffer) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackId(String str) {
        str.getClass();
        this.playbackId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.playbackId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPts(long j) {
        this.pts_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        replay.a aVar = null;
        switch (replay.a.a[gVar.ordinal()]) {
            case 1:
                return new CloudReplay$RoomSeekRequest();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", new Object[]{"playbackId_", "pts_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CloudReplay$RoomSeekRequest.class) {
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

    public String getPlaybackId() {
        return this.playbackId_;
    }

    public AbstractC2383g getPlaybackIdBytes() {
        return AbstractC2383g.N(this.playbackId_);
    }

    public long getPts() {
        return this.pts_;
    }

    public static a newBuilder(CloudReplay$RoomSeekRequest cloudReplay$RoomSeekRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(cloudReplay$RoomSeekRequest);
    }

    public static CloudReplay$RoomSeekRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(byte[] bArr) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(InputStream inputStream) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CloudReplay$RoomSeekRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CloudReplay$RoomSeekRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
