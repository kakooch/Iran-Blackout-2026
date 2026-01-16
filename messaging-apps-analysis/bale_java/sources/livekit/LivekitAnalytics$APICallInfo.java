package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAnalytics$APICallRequest;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$APICallInfo extends GeneratedMessageLite implements U64 {
    private static final LivekitAnalytics$APICallInfo DEFAULT_INSTANCE;
    public static final int DURATION_NS_FIELD_NUMBER = 15;
    public static final int METHOD_FIELD_NUMBER = 4;
    public static final int NODE_ID_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 11;
    public static final int PARTICIPANT_ID_FIELD_NUMBER = 12;
    public static final int PROJECT_ID_FIELD_NUMBER = 1;
    public static final int REQUEST_FIELD_NUMBER = 2;
    public static final int ROOM_ID_FIELD_NUMBER = 10;
    public static final int ROOM_NAME_FIELD_NUMBER = 9;
    public static final int SERVICE_FIELD_NUMBER = 3;
    public static final int STARTED_AT_FIELD_NUMBER = 14;
    public static final int STATUS_FIELD_NUMBER = 6;
    public static final int TRACK_ID_FIELD_NUMBER = 13;
    public static final int TWIRP_ERROR_CODE_FIELD_NUMBER = 7;
    public static final int TWIRP_ERROR_MESSAGE_FIELD_NUMBER = 8;
    private long durationNs_;
    private LivekitAnalytics$APICallRequest request_;
    private Timestamp startedAt_;
    private int status_;
    private String projectId_ = "";
    private String service_ = "";
    private String method_ = "";
    private String nodeId_ = "";
    private String twirpErrorCode_ = "";
    private String twirpErrorMessage_ = "";
    private String roomName_ = "";
    private String roomId_ = "";
    private String participantIdentity_ = "";
    private String participantId_ = "";
    private String trackId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$APICallInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$APICallInfo livekitAnalytics$APICallInfo = new LivekitAnalytics$APICallInfo();
        DEFAULT_INSTANCE = livekitAnalytics$APICallInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$APICallInfo.class, livekitAnalytics$APICallInfo);
    }

    private LivekitAnalytics$APICallInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationNs() {
        this.durationNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMethod() {
        this.method_ = getDefaultInstance().getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNodeId() {
        this.nodeId_ = getDefaultInstance().getNodeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantId() {
        this.participantId_ = getDefaultInstance().getParticipantId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectId() {
        this.projectId_ = getDefaultInstance().getProjectId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.request_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomId() {
        this.roomId_ = getDefaultInstance().getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearService() {
        this.service_ = getDefaultInstance().getService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTwirpErrorCode() {
        this.twirpErrorCode_ = getDefaultInstance().getTwirpErrorCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTwirpErrorMessage() {
        this.twirpErrorMessage_ = getDefaultInstance().getTwirpErrorMessage();
    }

    public static LivekitAnalytics$APICallInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequest(LivekitAnalytics$APICallRequest livekitAnalytics$APICallRequest) {
        livekitAnalytics$APICallRequest.getClass();
        LivekitAnalytics$APICallRequest livekitAnalytics$APICallRequest2 = this.request_;
        if (livekitAnalytics$APICallRequest2 == null || livekitAnalytics$APICallRequest2 == LivekitAnalytics$APICallRequest.getDefaultInstance()) {
            this.request_ = livekitAnalytics$APICallRequest;
        } else {
            this.request_ = (LivekitAnalytics$APICallRequest) ((LivekitAnalytics$APICallRequest.a) LivekitAnalytics$APICallRequest.newBuilder(this.request_).v(livekitAnalytics$APICallRequest)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStartedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.startedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.startedAt_ = timestamp;
        } else {
            this.startedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.startedAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$APICallInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationNs(long j) {
        this.durationNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethod(String str) {
        str.getClass();
        this.method_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethodBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.method_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeId(String str) {
        str.getClass();
        this.nodeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nodeId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantId(String str) {
        str.getClass();
        this.participantId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentity(String str) {
        str.getClass();
        this.participantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantIdentity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectId(String str) {
        str.getClass();
        this.projectId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.projectId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequest(LivekitAnalytics$APICallRequest livekitAnalytics$APICallRequest) {
        livekitAnalytics$APICallRequest.getClass();
        this.request_ = livekitAnalytics$APICallRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomId(String str) {
        str.getClass();
        this.roomId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setService(String str) {
        str.getClass();
        this.service_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.service_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.startedAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackId(String str) {
        str.getClass();
        this.trackId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTwirpErrorCode(String str) {
        str.getClass();
        this.twirpErrorCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTwirpErrorCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.twirpErrorCode_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTwirpErrorMessage(String str) {
        str.getClass();
        this.twirpErrorMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTwirpErrorMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.twirpErrorMessage_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$APICallInfo();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\t\u000f\u0002", new Object[]{"projectId_", "request_", "service_", "method_", "nodeId_", "status_", "twirpErrorCode_", "twirpErrorMessage_", "roomName_", "roomId_", "participantIdentity_", "participantId_", "trackId_", "startedAt_", "durationNs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$APICallInfo.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getDurationNs() {
        return this.durationNs_;
    }

    public String getMethod() {
        return this.method_;
    }

    public AbstractC2383g getMethodBytes() {
        return AbstractC2383g.N(this.method_);
    }

    public String getNodeId() {
        return this.nodeId_;
    }

    public AbstractC2383g getNodeIdBytes() {
        return AbstractC2383g.N(this.nodeId_);
    }

    public String getParticipantId() {
        return this.participantId_;
    }

    public AbstractC2383g getParticipantIdBytes() {
        return AbstractC2383g.N(this.participantId_);
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getProjectId() {
        return this.projectId_;
    }

    public AbstractC2383g getProjectIdBytes() {
        return AbstractC2383g.N(this.projectId_);
    }

    public LivekitAnalytics$APICallRequest getRequest() {
        LivekitAnalytics$APICallRequest livekitAnalytics$APICallRequest = this.request_;
        return livekitAnalytics$APICallRequest == null ? LivekitAnalytics$APICallRequest.getDefaultInstance() : livekitAnalytics$APICallRequest;
    }

    public String getRoomId() {
        return this.roomId_;
    }

    public AbstractC2383g getRoomIdBytes() {
        return AbstractC2383g.N(this.roomId_);
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public String getService() {
        return this.service_;
    }

    public AbstractC2383g getServiceBytes() {
        return AbstractC2383g.N(this.service_);
    }

    public Timestamp getStartedAt() {
        Timestamp timestamp = this.startedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public int getStatus() {
        return this.status_;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public String getTwirpErrorCode() {
        return this.twirpErrorCode_;
    }

    public AbstractC2383g getTwirpErrorCodeBytes() {
        return AbstractC2383g.N(this.twirpErrorCode_);
    }

    public String getTwirpErrorMessage() {
        return this.twirpErrorMessage_;
    }

    public AbstractC2383g getTwirpErrorMessageBytes() {
        return AbstractC2383g.N(this.twirpErrorMessage_);
    }

    public boolean hasRequest() {
        return this.request_ != null;
    }

    public boolean hasStartedAt() {
        return this.startedAt_ != null;
    }

    public static a newBuilder(LivekitAnalytics$APICallInfo livekitAnalytics$APICallInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$APICallInfo);
    }

    public static LivekitAnalytics$APICallInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(byte[] bArr) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$APICallInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$APICallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
