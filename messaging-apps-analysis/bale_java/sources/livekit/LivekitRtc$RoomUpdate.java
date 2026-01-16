package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$Room;

/* loaded from: classes8.dex */
public final class LivekitRtc$RoomUpdate extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$RoomUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 1;
    private LivekitModels$Room room_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$RoomUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$RoomUpdate livekitRtc$RoomUpdate = new LivekitRtc$RoomUpdate();
        DEFAULT_INSTANCE = livekitRtc$RoomUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$RoomUpdate.class, livekitRtc$RoomUpdate);
    }

    private LivekitRtc$RoomUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = null;
    }

    public static LivekitRtc$RoomUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static LivekitRtc$RoomUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RoomUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        this.room_ = livekitModels$Room;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$RoomUpdate();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"room_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$RoomUpdate.class) {
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

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public static a newBuilder(LivekitRtc$RoomUpdate livekitRtc$RoomUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$RoomUpdate);
    }

    public static LivekitRtc$RoomUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RoomUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$RoomUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$RoomUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$RoomUpdate parseFrom(byte[] bArr) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$RoomUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$RoomUpdate parseFrom(InputStream inputStream) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RoomUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RoomUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$RoomUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$RoomUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
