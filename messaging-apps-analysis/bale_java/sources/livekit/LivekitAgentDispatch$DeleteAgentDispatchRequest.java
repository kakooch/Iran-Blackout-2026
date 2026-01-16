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
public final class LivekitAgentDispatch$DeleteAgentDispatchRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitAgentDispatch$DeleteAgentDispatchRequest DEFAULT_INSTANCE;
    public static final int DISPATCH_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 2;
    private String dispatchId_ = "";
    private String room_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(b bVar) {
            this();
        }

        private a() {
            super(LivekitAgentDispatch$DeleteAgentDispatchRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgentDispatch$DeleteAgentDispatchRequest livekitAgentDispatch$DeleteAgentDispatchRequest = new LivekitAgentDispatch$DeleteAgentDispatchRequest();
        DEFAULT_INSTANCE = livekitAgentDispatch$DeleteAgentDispatchRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgentDispatch$DeleteAgentDispatchRequest.class, livekitAgentDispatch$DeleteAgentDispatchRequest);
    }

    private LivekitAgentDispatch$DeleteAgentDispatchRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchId() {
        this.dispatchId_ = getDefaultInstance().getDispatchId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchId(String str) {
        str.getClass();
        this.dispatchId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.dispatchId_ = abstractC2383g.f0();
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
                return new LivekitAgentDispatch$DeleteAgentDispatchRequest();
            case 2:
                return new a(bVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"dispatchId_", "room_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgentDispatch$DeleteAgentDispatchRequest.class) {
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

    public String getDispatchId() {
        return this.dispatchId_;
    }

    public AbstractC2383g getDispatchIdBytes() {
        return AbstractC2383g.N(this.dispatchId_);
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public static a newBuilder(LivekitAgentDispatch$DeleteAgentDispatchRequest livekitAgentDispatch$DeleteAgentDispatchRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgentDispatch$DeleteAgentDispatchRequest);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(byte[] bArr) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgentDispatch$DeleteAgentDispatchRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgentDispatch$DeleteAgentDispatchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
