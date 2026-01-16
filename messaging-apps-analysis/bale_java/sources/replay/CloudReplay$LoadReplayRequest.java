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
public final class CloudReplay$LoadReplayRequest extends GeneratedMessageLite implements U64 {
    private static final CloudReplay$LoadReplayRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPLAY_ID_FIELD_NUMBER = 1;
    public static final int ROOM_NAME_FIELD_NUMBER = 2;
    public static final int STARTING_PTS_FIELD_NUMBER = 3;
    private String replayId_ = "";
    private String roomName_ = "";
    private long startingPts_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(replay.a aVar) {
            this();
        }

        private a() {
            super(CloudReplay$LoadReplayRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        CloudReplay$LoadReplayRequest cloudReplay$LoadReplayRequest = new CloudReplay$LoadReplayRequest();
        DEFAULT_INSTANCE = cloudReplay$LoadReplayRequest;
        GeneratedMessageLite.registerDefaultInstance(CloudReplay$LoadReplayRequest.class, cloudReplay$LoadReplayRequest);
    }

    private CloudReplay$LoadReplayRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplayId() {
        this.replayId_ = getDefaultInstance().getReplayId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartingPts() {
        this.startingPts_ = 0L;
    }

    public static CloudReplay$LoadReplayRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CloudReplay$LoadReplayRequest parseDelimitedFrom(InputStream inputStream) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(ByteBuffer byteBuffer) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplayId(String str) {
        str.getClass();
        this.replayId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplayIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.replayId_ = abstractC2383g.f0();
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
    public void setStartingPts(long j) {
        this.startingPts_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        replay.a aVar = null;
        switch (replay.a.a[gVar.ordinal()]) {
            case 1:
                return new CloudReplay$LoadReplayRequest();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002", new Object[]{"replayId_", "roomName_", "startingPts_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CloudReplay$LoadReplayRequest.class) {
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

    public String getReplayId() {
        return this.replayId_;
    }

    public AbstractC2383g getReplayIdBytes() {
        return AbstractC2383g.N(this.replayId_);
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public long getStartingPts() {
        return this.startingPts_;
    }

    public static a newBuilder(CloudReplay$LoadReplayRequest cloudReplay$LoadReplayRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(cloudReplay$LoadReplayRequest);
    }

    public static CloudReplay$LoadReplayRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(byte[] bArr) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(InputStream inputStream) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CloudReplay$LoadReplayRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CloudReplay$LoadReplayRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
