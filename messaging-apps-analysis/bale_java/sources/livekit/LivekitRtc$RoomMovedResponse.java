package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$Room;

/* loaded from: classes8.dex */
public final class LivekitRtc$RoomMovedResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$RoomMovedResponse DEFAULT_INSTANCE;
    public static final int OTHER_PARTICIPANTS_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 3;
    public static final int ROOM_FIELD_NUMBER = 1;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private LivekitModels$ParticipantInfo participant_;
    private LivekitModels$Room room_;
    private String token_ = "";
    private B.j otherParticipants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$RoomMovedResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$RoomMovedResponse livekitRtc$RoomMovedResponse = new LivekitRtc$RoomMovedResponse();
        DEFAULT_INSTANCE = livekitRtc$RoomMovedResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$RoomMovedResponse.class, livekitRtc$RoomMovedResponse);
    }

    private LivekitRtc$RoomMovedResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOtherParticipants(Iterable<? extends LivekitModels$ParticipantInfo> iterable) {
        ensureOtherParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.otherParticipants_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOtherParticipants(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.add(livekitModels$ParticipantInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOtherParticipants() {
        this.otherParticipants_ = GeneratedMessageLite.emptyProtobufList();
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
    public void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    private void ensureOtherParticipantsIsMutable() {
        B.j jVar = this.otherParticipants_;
        if (jVar.u()) {
            return;
        }
        this.otherParticipants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$RoomMovedResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo2 = this.participant_;
        if (livekitModels$ParticipantInfo2 == null || livekitModels$ParticipantInfo2 == LivekitModels$ParticipantInfo.getDefaultInstance()) {
            this.participant_ = livekitModels$ParticipantInfo;
        } else {
            this.participant_ = (LivekitModels$ParticipantInfo) ((LivekitModels$ParticipantInfo.c) LivekitModels$ParticipantInfo.newBuilder(this.participant_).v(livekitModels$ParticipantInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        LivekitModels$Room livekitModels$Room2 = this.room_;
        if (livekitModels$Room2 == null || livekitModels$Room2 == LivekitModels$Room.getDefaultInstance()) {
            this.room_ = livekitModels$Room;
        } else {
            this.room_ = (LivekitModels$Room) ((LivekitModels$Room.a) LivekitModels$Room.newBuilder(this.room_).v(livekitModels$Room)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$RoomMovedResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOtherParticipants(int i) {
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtherParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.set(i, livekitModels$ParticipantInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        this.participant_ = livekitModels$ParticipantInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        this.room_ = livekitModels$Room;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$RoomMovedResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0002Ȉ\u0003\t\u0004\u001b", new Object[]{"room_", "token_", "participant_", "otherParticipants_", LivekitModels$ParticipantInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$RoomMovedResponse.class) {
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

    public LivekitModels$ParticipantInfo getOtherParticipants(int i) {
        return (LivekitModels$ParticipantInfo) this.otherParticipants_.get(i);
    }

    public int getOtherParticipantsCount() {
        return this.otherParticipants_.size();
    }

    public List<LivekitModels$ParticipantInfo> getOtherParticipantsList() {
        return this.otherParticipants_;
    }

    public p getOtherParticipantsOrBuilder(int i) {
        return (p) this.otherParticipants_.get(i);
    }

    public List<? extends p> getOtherParticipantsOrBuilderList() {
        return this.otherParticipants_;
    }

    public LivekitModels$ParticipantInfo getParticipant() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.participant_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasParticipant() {
        return this.participant_ != null;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public static a newBuilder(LivekitRtc$RoomMovedResponse livekitRtc$RoomMovedResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$RoomMovedResponse);
    }

    public static LivekitRtc$RoomMovedResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOtherParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.add(i, livekitModels$ParticipantInfo);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$RoomMovedResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$RoomMovedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
