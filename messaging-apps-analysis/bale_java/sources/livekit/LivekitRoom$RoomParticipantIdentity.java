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
public final class LivekitRoom$RoomParticipantIdentity extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$RoomParticipantIdentity DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 1;
    private String room_ = "";
    private String identity_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$RoomParticipantIdentity.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$RoomParticipantIdentity livekitRoom$RoomParticipantIdentity = new LivekitRoom$RoomParticipantIdentity();
        DEFAULT_INSTANCE = livekitRoom$RoomParticipantIdentity;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$RoomParticipantIdentity.class, livekitRoom$RoomParticipantIdentity);
    }

    private LivekitRoom$RoomParticipantIdentity() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    public static LivekitRoom$RoomParticipantIdentity getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$RoomParticipantIdentity parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new LivekitRoom$RoomParticipantIdentity();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"room_", "identity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$RoomParticipantIdentity.class) {
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

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public static a newBuilder(LivekitRoom$RoomParticipantIdentity livekitRoom$RoomParticipantIdentity) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$RoomParticipantIdentity);
    }

    public static LivekitRoom$RoomParticipantIdentity parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(byte[] bArr) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(InputStream inputStream) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$RoomParticipantIdentity parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$RoomParticipantIdentity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
