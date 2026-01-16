package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.VD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ParticipantPermission;

/* loaded from: classes8.dex */
public final class LivekitAgent$RegisterWorkerRequest extends GeneratedMessageLite implements U64 {
    public static final int AGENT_NAME_FIELD_NUMBER = 8;
    public static final int ALLOWED_PERMISSIONS_FIELD_NUMBER = 7;
    private static final LivekitAgent$RegisterWorkerRequest DEFAULT_INSTANCE;
    public static final int NAMESPACE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PING_INTERVAL_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 3;
    private LivekitModels$ParticipantPermission allowedPermissions_;
    private int bitField0_;
    private int pingInterval_;
    private int type_;
    private String agentName_ = "";
    private String version_ = "";
    private String namespace_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$RegisterWorkerRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$RegisterWorkerRequest livekitAgent$RegisterWorkerRequest = new LivekitAgent$RegisterWorkerRequest();
        DEFAULT_INSTANCE = livekitAgent$RegisterWorkerRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$RegisterWorkerRequest.class, livekitAgent$RegisterWorkerRequest);
    }

    private LivekitAgent$RegisterWorkerRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowedPermissions() {
        this.allowedPermissions_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNamespace() {
        this.bitField0_ &= -2;
        this.namespace_ = getDefaultInstance().getNamespace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPingInterval() {
        this.pingInterval_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static LivekitAgent$RegisterWorkerRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAllowedPermissions(LivekitModels$ParticipantPermission livekitModels$ParticipantPermission) {
        livekitModels$ParticipantPermission.getClass();
        LivekitModels$ParticipantPermission livekitModels$ParticipantPermission2 = this.allowedPermissions_;
        if (livekitModels$ParticipantPermission2 == null || livekitModels$ParticipantPermission2 == LivekitModels$ParticipantPermission.getDefaultInstance()) {
            this.allowedPermissions_ = livekitModels$ParticipantPermission;
        } else {
            this.allowedPermissions_ = (LivekitModels$ParticipantPermission) ((LivekitModels$ParticipantPermission.b) LivekitModels$ParticipantPermission.newBuilder(this.allowedPermissions_).v(livekitModels$ParticipantPermission)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$RegisterWorkerRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setAllowedPermissions(LivekitModels$ParticipantPermission livekitModels$ParticipantPermission) {
        livekitModels$ParticipantPermission.getClass();
        this.allowedPermissions_ = livekitModels$ParticipantPermission;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.namespace_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNamespaceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.namespace_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPingInterval(int i) {
        this.pingInterval_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(VD3 vd3) {
        this.type_ = vd3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.version_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$RegisterWorkerRequest();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\b\u0006\u0000\u0000\u0000\u0001\f\u0003Ȉ\u0005\u000b\u0006ለ\u0000\u0007\t\bȈ", new Object[]{"bitField0_", "type_", "version_", "pingInterval_", "namespace_", "allowedPermissions_", "agentName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$RegisterWorkerRequest.class) {
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

    public LivekitModels$ParticipantPermission getAllowedPermissions() {
        LivekitModels$ParticipantPermission livekitModels$ParticipantPermission = this.allowedPermissions_;
        return livekitModels$ParticipantPermission == null ? LivekitModels$ParticipantPermission.getDefaultInstance() : livekitModels$ParticipantPermission;
    }

    public String getNamespace() {
        return this.namespace_;
    }

    public AbstractC2383g getNamespaceBytes() {
        return AbstractC2383g.N(this.namespace_);
    }

    public int getPingInterval() {
        return this.pingInterval_;
    }

    public VD3 getType() {
        VD3 vd3J = VD3.j(this.type_);
        return vd3J == null ? VD3.UNRECOGNIZED : vd3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public boolean hasAllowedPermissions() {
        return this.allowedPermissions_ != null;
    }

    public boolean hasNamespace() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitAgent$RegisterWorkerRequest livekitAgent$RegisterWorkerRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$RegisterWorkerRequest);
    }

    public static LivekitAgent$RegisterWorkerRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(byte[] bArr) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(InputStream inputStream) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$RegisterWorkerRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
