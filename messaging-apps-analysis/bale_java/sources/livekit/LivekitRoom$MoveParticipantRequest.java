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
public final class LivekitRoom$MoveParticipantRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$MoveParticipantRequest DEFAULT_INSTANCE;
    public static final int DESTINATION_ROOM_FIELD_NUMBER = 3;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 1;
    private String room_ = "";
    private String identity_ = "";
    private String destinationRoom_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$MoveParticipantRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$MoveParticipantRequest livekitRoom$MoveParticipantRequest = new LivekitRoom$MoveParticipantRequest();
        DEFAULT_INSTANCE = livekitRoom$MoveParticipantRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$MoveParticipantRequest.class, livekitRoom$MoveParticipantRequest);
    }

    private LivekitRoom$MoveParticipantRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationRoom() {
        this.destinationRoom_ = getDefaultInstance().getDestinationRoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    public static LivekitRoom$MoveParticipantRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$MoveParticipantRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationRoom(String str) {
        str.getClass();
        this.destinationRoom_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.destinationRoom_ = abstractC2383g.f0();
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
                return new LivekitRoom$MoveParticipantRequest();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"room_", "identity_", "destinationRoom_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$MoveParticipantRequest.class) {
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

    public String getDestinationRoom() {
        return this.destinationRoom_;
    }

    public AbstractC2383g getDestinationRoomBytes() {
        return AbstractC2383g.N(this.destinationRoom_);
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

    public static a newBuilder(LivekitRoom$MoveParticipantRequest livekitRoom$MoveParticipantRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$MoveParticipantRequest);
    }

    public static LivekitRoom$MoveParticipantRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(byte[] bArr) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(InputStream inputStream) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$MoveParticipantRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
