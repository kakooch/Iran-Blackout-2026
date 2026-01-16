package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.YD3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAgentDispatch$RoomAgentDispatch extends GeneratedMessageLite implements YD3 {
    public static final int AGENT_NAME_FIELD_NUMBER = 1;
    private static final LivekitAgentDispatch$RoomAgentDispatch DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String agentName_ = "";
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements YD3 {
        /* synthetic */ a(b bVar) {
            this();
        }

        private a() {
            super(LivekitAgentDispatch$RoomAgentDispatch.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch = new LivekitAgentDispatch$RoomAgentDispatch();
        DEFAULT_INSTANCE = livekitAgentDispatch$RoomAgentDispatch;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgentDispatch$RoomAgentDispatch.class, livekitAgentDispatch$RoomAgentDispatch);
    }

    private LivekitAgentDispatch$RoomAgentDispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    public static LivekitAgentDispatch$RoomAgentDispatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        b bVar = null;
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgentDispatch$RoomAgentDispatch();
            case 2:
                return new a(bVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"agentName_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgentDispatch$RoomAgentDispatch.class) {
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

    public static a newBuilder(LivekitAgentDispatch$RoomAgentDispatch livekitAgentDispatch$RoomAgentDispatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgentDispatch$RoomAgentDispatch);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(byte[] bArr) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgentDispatch$RoomAgentDispatch parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgentDispatch$RoomAgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
