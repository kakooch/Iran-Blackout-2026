package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.XD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAgentDispatch$AgentDispatchState;

/* loaded from: classes8.dex */
public final class LivekitAgentDispatch$AgentDispatch extends GeneratedMessageLite implements XD3 {
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    private static final LivekitAgentDispatch$AgentDispatch DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 5;
    private LivekitAgentDispatch$AgentDispatchState state_;
    private String id_ = "";
    private String agentName_ = "";
    private String room_ = "";
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements XD3 {
        /* synthetic */ a(b bVar) {
            this();
        }

        private a() {
            super(LivekitAgentDispatch$AgentDispatch.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgentDispatch$AgentDispatch livekitAgentDispatch$AgentDispatch = new LivekitAgentDispatch$AgentDispatch();
        DEFAULT_INSTANCE = livekitAgentDispatch$AgentDispatch;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgentDispatch$AgentDispatch.class, livekitAgentDispatch$AgentDispatch);
    }

    private LivekitAgentDispatch$AgentDispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = null;
    }

    public static LivekitAgentDispatch$AgentDispatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeState(LivekitAgentDispatch$AgentDispatchState livekitAgentDispatch$AgentDispatchState) {
        livekitAgentDispatch$AgentDispatchState.getClass();
        LivekitAgentDispatch$AgentDispatchState livekitAgentDispatch$AgentDispatchState2 = this.state_;
        if (livekitAgentDispatch$AgentDispatchState2 == null || livekitAgentDispatch$AgentDispatchState2 == LivekitAgentDispatch$AgentDispatchState.getDefaultInstance()) {
            this.state_ = livekitAgentDispatch$AgentDispatchState;
        } else {
            this.state_ = (LivekitAgentDispatch$AgentDispatchState) ((LivekitAgentDispatch$AgentDispatchState.a) LivekitAgentDispatch$AgentDispatchState.newBuilder(this.state_).v(livekitAgentDispatch$AgentDispatchState)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgentDispatch$AgentDispatch parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(LivekitAgentDispatch$AgentDispatchState livekitAgentDispatch$AgentDispatchState) {
        livekitAgentDispatch$AgentDispatchState.getClass();
        this.state_ = livekitAgentDispatch$AgentDispatchState;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        b bVar = null;
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgentDispatch$AgentDispatch();
            case 2:
                return new a(bVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\t", new Object[]{"id_", "agentName_", "room_", "metadata_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgentDispatch$AgentDispatch.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
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

    public LivekitAgentDispatch$AgentDispatchState getState() {
        LivekitAgentDispatch$AgentDispatchState livekitAgentDispatch$AgentDispatchState = this.state_;
        return livekitAgentDispatch$AgentDispatchState == null ? LivekitAgentDispatch$AgentDispatchState.getDefaultInstance() : livekitAgentDispatch$AgentDispatchState;
    }

    public boolean hasState() {
        return this.state_ != null;
    }

    public static a newBuilder(LivekitAgentDispatch$AgentDispatch livekitAgentDispatch$AgentDispatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgentDispatch$AgentDispatch);
    }

    public static LivekitAgentDispatch$AgentDispatch parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(byte[] bArr) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(InputStream inputStream) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgentDispatch$AgentDispatch parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgentDispatch$AgentDispatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
