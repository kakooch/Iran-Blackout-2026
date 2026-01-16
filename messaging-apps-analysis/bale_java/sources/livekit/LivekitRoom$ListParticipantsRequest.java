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
public final class LivekitRoom$ListParticipantsRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$ListParticipantsRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 1;
    private String room_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$ListParticipantsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$ListParticipantsRequest livekitRoom$ListParticipantsRequest = new LivekitRoom$ListParticipantsRequest();
        DEFAULT_INSTANCE = livekitRoom$ListParticipantsRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$ListParticipantsRequest.class, livekitRoom$ListParticipantsRequest);
    }

    private LivekitRoom$ListParticipantsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    public static LivekitRoom$ListParticipantsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$ListParticipantsRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$ListParticipantsRequest();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"room_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$ListParticipantsRequest.class) {
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

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public static a newBuilder(LivekitRoom$ListParticipantsRequest livekitRoom$ListParticipantsRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$ListParticipantsRequest);
    }

    public static LivekitRoom$ListParticipantsRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(byte[] bArr) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(InputStream inputStream) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$ListParticipantsRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
