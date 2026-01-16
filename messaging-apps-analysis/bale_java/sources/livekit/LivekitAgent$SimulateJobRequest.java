package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.VD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$Room;

/* loaded from: classes8.dex */
public final class LivekitAgent$SimulateJobRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$SimulateJobRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 3;
    public static final int ROOM_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private LivekitModels$ParticipantInfo participant_;
    private LivekitModels$Room room_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$SimulateJobRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$SimulateJobRequest livekitAgent$SimulateJobRequest = new LivekitAgent$SimulateJobRequest();
        DEFAULT_INSTANCE = livekitAgent$SimulateJobRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$SimulateJobRequest.class, livekitAgent$SimulateJobRequest);
    }

    private LivekitAgent$SimulateJobRequest() {
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
    public void clearType() {
        this.type_ = 0;
    }

    public static LivekitAgent$SimulateJobRequest getDefaultInstance() {
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

    public static LivekitAgent$SimulateJobRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setType(VD3 vd3) {
        this.type_ = vd3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$SimulateJobRequest();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"type_", "room_", "participant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$SimulateJobRequest.class) {
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

    public LivekitModels$ParticipantInfo getParticipant() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.participant_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public VD3 getType() {
        VD3 vd3J = VD3.j(this.type_);
        return vd3J == null ? VD3.UNRECOGNIZED : vd3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasParticipant() {
        return this.participant_ != null;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public static a newBuilder(LivekitAgent$SimulateJobRequest livekitAgent$SimulateJobRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$SimulateJobRequest);
    }

    public static LivekitAgent$SimulateJobRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(byte[] bArr) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(InputStream inputStream) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$SimulateJobRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$SimulateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
