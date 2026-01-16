package livekit;

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
public final class LivekitRoom$MuteRoomTrackRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$MuteRoomTrackRequest DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    public static final int MUTED_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 1;
    public static final int TRACK_SID_FIELD_NUMBER = 3;
    private boolean muted_;
    private String room_ = "";
    private String identity_ = "";
    private String trackSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$MuteRoomTrackRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$MuteRoomTrackRequest livekitRoom$MuteRoomTrackRequest = new LivekitRoom$MuteRoomTrackRequest();
        DEFAULT_INSTANCE = livekitRoom$MuteRoomTrackRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$MuteRoomTrackRequest.class, livekitRoom$MuteRoomTrackRequest);
    }

    private LivekitRoom$MuteRoomTrackRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMuted() {
        this.muted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    public static LivekitRoom$MuteRoomTrackRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$MuteRoomTrackRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentity(String str) {
        str.getClass();
        this.identity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.identity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuted(boolean z) {
        this.muted_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSid(String str) {
        str.getClass();
        this.trackSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackSid_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$MuteRoomTrackRequest();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007", new Object[]{"room_", "identity_", "trackSid_", "muted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$MuteRoomTrackRequest.class) {
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

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
    }

    public boolean getMuted() {
        return this.muted_;
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static a newBuilder(LivekitRoom$MuteRoomTrackRequest livekitRoom$MuteRoomTrackRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$MuteRoomTrackRequest);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(byte[] bArr) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(InputStream inputStream) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$MuteRoomTrackRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$MuteRoomTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
