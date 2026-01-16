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
public final class LivekitAgentDispatch$CreateAgentDispatchRequest extends GeneratedMessageLite implements U64 {
    public static final int AGENT_NAME_FIELD_NUMBER = 1;
    private static final LivekitAgentDispatch$CreateAgentDispatchRequest DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 2;
    private String agentName_ = "";
    private String room_ = "";
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(b bVar) {
            this();
        }

        private a() {
            super(LivekitAgentDispatch$CreateAgentDispatchRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgentDispatch$CreateAgentDispatchRequest livekitAgentDispatch$CreateAgentDispatchRequest = new LivekitAgentDispatch$CreateAgentDispatchRequest();
        DEFAULT_INSTANCE = livekitAgentDispatch$CreateAgentDispatchRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgentDispatch$CreateAgentDispatchRequest.class, livekitAgentDispatch$CreateAgentDispatchRequest);
    }

    private LivekitAgentDispatch$CreateAgentDispatchRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentName(String str) {
        str.getClass();
        this.agentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.agentName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
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
        b bVar = null;
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgentDispatch$CreateAgentDispatchRequest();
            case 2:
                return new a(bVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"agentName_", "room_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgentDispatch$CreateAgentDispatchRequest.class) {
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

    public String getAgentName() {
        return this.agentName_;
    }

    public AbstractC2383g getAgentNameBytes() {
        return AbstractC2383g.N(this.agentName_);
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public static a newBuilder(LivekitAgentDispatch$CreateAgentDispatchRequest livekitAgentDispatch$CreateAgentDispatchRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgentDispatch$CreateAgentDispatchRequest);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(byte[] bArr) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgentDispatch$CreateAgentDispatchRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgentDispatch$CreateAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
