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

/* loaded from: classes8.dex */
public final class LivekitAnalytics$WebhookInfo extends GeneratedMessageLite implements U64 {
    public static final int CREATED_AT_FIELD_NUMBER = 11;
    private static final LivekitAnalytics$WebhookInfo DEFAULT_INSTANCE;
    public static final int EGRESS_ID_FIELD_NUMBER = 9;
    public static final int EVENT_FIELD_NUMBER = 2;
    public static final int EVENT_ID_FIELD_NUMBER = 1;
    public static final int INGRESS_ID_FIELD_NUMBER = 10;
    public static final int IS_DROPPED_FIELD_NUMBER = 18;
    public static final int NUM_DROPPED_FIELD_NUMBER = 17;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 6;
    public static final int PARTICIPANT_ID_FIELD_NUMBER = 7;
    public static final int PROJECT_ID_FIELD_NUMBER = 3;
    public static final int QUEUED_AT_FIELD_NUMBER = 12;
    public static final int QUEUE_DURATION_NS_FIELD_NUMBER = 13;
    public static final int ROOM_ID_FIELD_NUMBER = 5;
    public static final int ROOM_NAME_FIELD_NUMBER = 4;
    public static final int SEND_DURATION_NS_FIELD_NUMBER = 15;
    public static final int SEND_ERROR_FIELD_NUMBER = 22;
    public static final int SENT_AT_FIELD_NUMBER = 14;
    public static final int SERVICE_ERROR_CODE_FIELD_NUMBER = 20;
    public static final int SERVICE_ERROR_FIELD_NUMBER = 21;
    public static final int SERVICE_STATUS_FIELD_NUMBER = 19;
    public static final int TRACK_ID_FIELD_NUMBER = 8;
    public static final int URL_FIELD_NUMBER = 16;
    private Timestamp createdAt_;
    private boolean isDropped_;
    private int numDropped_;
    private long queueDurationNs_;
    private Timestamp queuedAt_;
    private long sendDurationNs_;
    private Timestamp sentAt_;
    private int serviceErrorCode_;
    private String eventId_ = "";
    private String event_ = "";
    private String projectId_ = "";
    private String roomName_ = "";
    private String roomId_ = "";
    private String participantIdentity_ = "";
    private String participantId_ = "";
    private String trackId_ = "";
    private String egressId_ = "";
    private String ingressId_ = "";
    private String url_ = "";
    private String serviceStatus_ = "";
    private String serviceError_ = "";
    private String sendError_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$WebhookInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$WebhookInfo livekitAnalytics$WebhookInfo = new LivekitAnalytics$WebhookInfo();
        DEFAULT_INSTANCE = livekitAnalytics$WebhookInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$WebhookInfo.class, livekitAnalytics$WebhookInfo);
    }

    private LivekitAnalytics$WebhookInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressId() {
        this.egressId_ = getDefaultInstance().getEgressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvent() {
        this.event_ = getDefaultInstance().getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIngressId() {
        this.ingressId_ = getDefaultInstance().getIngressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsDropped() {
        this.isDropped_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumDropped() {
        this.numDropped_ = 0;
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
    public void clearQueueDurationNs() {
        this.queueDurationNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQueuedAt() {
        this.queuedAt_ = null;
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
    public void clearSendDurationNs() {
        this.sendDurationNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSendError() {
        this.sendError_ = getDefaultInstance().getSendError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSentAt() {
        this.sentAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceError() {
        this.serviceError_ = getDefaultInstance().getServiceError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceErrorCode() {
        this.serviceErrorCode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceStatus() {
        this.serviceStatus_ = getDefaultInstance().getServiceStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static LivekitAnalytics$WebhookInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.createdAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.createdAt_ = timestamp;
        } else {
            this.createdAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.createdAt_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQueuedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.queuedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.queuedAt_ = timestamp;
        } else {
            this.queuedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.queuedAt_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSentAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.sentAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.sentAt_ = timestamp;
        } else {
            this.sentAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.sentAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$WebhookInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.createdAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressId(String str) {
        str.getClass();
        this.egressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.egressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEvent(String str) {
        str.getClass();
        this.event_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.event_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventId(String str) {
        str.getClass();
        this.eventId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.eventId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressId(String str) {
        str.getClass();
        this.ingressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ingressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsDropped(boolean z) {
        this.isDropped_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumDropped(int i) {
        this.numDropped_ = i;
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
    public void setQueueDurationNs(long j) {
        this.queueDurationNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQueuedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.queuedAt_ = timestamp;
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
    public void setSendDurationNs(long j) {
        this.sendDurationNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendError(String str) {
        str.getClass();
        this.sendError_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sendError_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSentAt(Timestamp timestamp) {
        timestamp.getClass();
        this.sentAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceError(String str) {
        str.getClass();
        this.serviceError_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceError_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceErrorCode(int i) {
        this.serviceErrorCode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceStatus(String str) {
        str.getClass();
        this.serviceStatus_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceStatusBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceStatus_ = abstractC2383g.f0();
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
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$WebhookInfo();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0016\u0000\u0000\u0001\u0016\u0016\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000b\t\f\t\r\u0002\u000e\t\u000f\u0002\u0010Ȉ\u0011\u0004\u0012\u0007\u0013Ȉ\u0014\u0004\u0015Ȉ\u0016Ȉ", new Object[]{"eventId_", "event_", "projectId_", "roomName_", "roomId_", "participantIdentity_", "participantId_", "trackId_", "egressId_", "ingressId_", "createdAt_", "queuedAt_", "queueDurationNs_", "sentAt_", "sendDurationNs_", "url_", "numDropped_", "isDropped_", "serviceStatus_", "serviceErrorCode_", "serviceError_", "sendError_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$WebhookInfo.class) {
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

    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getEgressId() {
        return this.egressId_;
    }

    public AbstractC2383g getEgressIdBytes() {
        return AbstractC2383g.N(this.egressId_);
    }

    public String getEvent() {
        return this.event_;
    }

    public AbstractC2383g getEventBytes() {
        return AbstractC2383g.N(this.event_);
    }

    public String getEventId() {
        return this.eventId_;
    }

    public AbstractC2383g getEventIdBytes() {
        return AbstractC2383g.N(this.eventId_);
    }

    public String getIngressId() {
        return this.ingressId_;
    }

    public AbstractC2383g getIngressIdBytes() {
        return AbstractC2383g.N(this.ingressId_);
    }

    public boolean getIsDropped() {
        return this.isDropped_;
    }

    public int getNumDropped() {
        return this.numDropped_;
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

    public long getQueueDurationNs() {
        return this.queueDurationNs_;
    }

    public Timestamp getQueuedAt() {
        Timestamp timestamp = this.queuedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
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

    public long getSendDurationNs() {
        return this.sendDurationNs_;
    }

    public String getSendError() {
        return this.sendError_;
    }

    public AbstractC2383g getSendErrorBytes() {
        return AbstractC2383g.N(this.sendError_);
    }

    public Timestamp getSentAt() {
        Timestamp timestamp = this.sentAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getServiceError() {
        return this.serviceError_;
    }

    public AbstractC2383g getServiceErrorBytes() {
        return AbstractC2383g.N(this.serviceError_);
    }

    public int getServiceErrorCode() {
        return this.serviceErrorCode_;
    }

    public String getServiceStatus() {
        return this.serviceStatus_;
    }

    public AbstractC2383g getServiceStatusBytes() {
        return AbstractC2383g.N(this.serviceStatus_);
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasCreatedAt() {
        return this.createdAt_ != null;
    }

    public boolean hasQueuedAt() {
        return this.queuedAt_ != null;
    }

    public boolean hasSentAt() {
        return this.sentAt_ != null;
    }

    public static a newBuilder(LivekitAnalytics$WebhookInfo livekitAnalytics$WebhookInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$WebhookInfo);
    }

    public static LivekitAnalytics$WebhookInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(byte[] bArr) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$WebhookInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$WebhookInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
