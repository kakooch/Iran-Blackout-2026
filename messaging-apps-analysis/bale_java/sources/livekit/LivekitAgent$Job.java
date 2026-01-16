package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TD3;
import ir.nasim.VD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAgent$JobState;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$Room;

/* loaded from: classes8.dex */
public final class LivekitAgent$Job extends GeneratedMessageLite implements TD3 {
    public static final int AGENT_NAME_FIELD_NUMBER = 7;
    private static final LivekitAgent$Job DEFAULT_INSTANCE;
    public static final int DISPATCH_ID_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 6;
    public static final int NAMESPACE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 4;
    public static final int ROOM_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private LivekitModels$ParticipantInfo participant_;
    private LivekitModels$Room room_;
    private LivekitAgent$JobState state_;
    private int type_;
    private String id_ = "";
    private String dispatchId_ = "";
    private String namespace_ = "";
    private String metadata_ = "";
    private String agentName_ = "";

    public static final class a extends GeneratedMessageLite.b implements TD3 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$Job.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$Job livekitAgent$Job = new LivekitAgent$Job();
        DEFAULT_INSTANCE = livekitAgent$Job;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$Job.class, livekitAgent$Job);
    }

    private LivekitAgent$Job() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchId() {
        this.dispatchId_ = getDefaultInstance().getDispatchId();
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
    public void clearNamespace() {
        this.namespace_ = getDefaultInstance().getNamespace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipant() {
        this.participant_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    public static LivekitAgent$Job getDefaultInstance() {
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
        this.bitField0_ |= 1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeState(LivekitAgent$JobState livekitAgent$JobState) {
        livekitAgent$JobState.getClass();
        LivekitAgent$JobState livekitAgent$JobState2 = this.state_;
        if (livekitAgent$JobState2 == null || livekitAgent$JobState2 == LivekitAgent$JobState.getDefaultInstance()) {
            this.state_ = livekitAgent$JobState;
        } else {
            this.state_ = (LivekitAgent$JobState) ((LivekitAgent$JobState.a) LivekitAgent$JobState.newBuilder(this.state_).v(livekitAgent$JobState)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$Job parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$Job parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setNamespace(String str) {
        str.getClass();
        this.namespace_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNamespaceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.namespace_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        this.participant_ = livekitModels$ParticipantInfo;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        this.room_ = livekitModels$Room;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(LivekitAgent$JobState livekitAgent$JobState) {
        livekitAgent$JobState.getClass();
        this.state_ = livekitAgent$JobState;
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
                return new LivekitAgent$Job();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\t\u0004ဉ\u0000\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\t\tȈ", new Object[]{"bitField0_", "id_", "type_", "room_", "participant_", "namespace_", "metadata_", "agentName_", "state_", "dispatchId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$Job.class) {
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

    public String getDispatchId() {
        return this.dispatchId_;
    }

    public AbstractC2383g getDispatchIdBytes() {
        return AbstractC2383g.N(this.dispatchId_);
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

    @Deprecated
    public String getNamespace() {
        return this.namespace_;
    }

    @Deprecated
    public AbstractC2383g getNamespaceBytes() {
        return AbstractC2383g.N(this.namespace_);
    }

    public LivekitModels$ParticipantInfo getParticipant() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.participant_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public LivekitAgent$JobState getState() {
        LivekitAgent$JobState livekitAgent$JobState = this.state_;
        return livekitAgent$JobState == null ? LivekitAgent$JobState.getDefaultInstance() : livekitAgent$JobState;
    }

    public VD3 getType() {
        VD3 vd3J = VD3.j(this.type_);
        return vd3J == null ? VD3.UNRECOGNIZED : vd3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasParticipant() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public boolean hasState() {
        return this.state_ != null;
    }

    public static a newBuilder(LivekitAgent$Job livekitAgent$Job) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$Job);
    }

    public static LivekitAgent$Job parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$Job parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$Job parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$Job parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$Job parseFrom(byte[] bArr) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$Job parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$Job parseFrom(InputStream inputStream) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$Job parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$Job parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$Job parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$Job) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
