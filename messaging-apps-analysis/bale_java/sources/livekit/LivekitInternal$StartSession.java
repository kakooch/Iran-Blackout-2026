package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.VE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ClientInfo;
import livekit.LivekitRoom$CreateRoomRequest;

/* loaded from: classes8.dex */
public final class LivekitInternal$StartSession extends GeneratedMessageLite implements U64 {
    public static final int ADAPTIVE_STREAM_FIELD_NUMBER = 15;
    public static final int AUTO_SUBSCRIBE_FIELD_NUMBER = 9;
    public static final int CLIENT_FIELD_NUMBER = 11;
    public static final int CONNECTION_ID_FIELD_NUMBER = 3;
    public static final int CREATE_ROOM_FIELD_NUMBER = 20;
    private static final LivekitInternal$StartSession DEFAULT_INSTANCE;
    public static final int DISABLE_ICE_LITE_FIELD_NUMBER = 19;
    public static final int GRANTS_JSON_FIELD_NUMBER = 14;
    public static final int HIDDEN_FIELD_NUMBER = 10;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 13;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_ID_FIELD_NUMBER = 16;
    public static final int RECONNECT_FIELD_NUMBER = 4;
    public static final int RECONNECT_REASON_FIELD_NUMBER = 17;
    public static final int RECORDER_FIELD_NUMBER = 12;
    public static final int ROOM_NAME_FIELD_NUMBER = 1;
    public static final int SUBSCRIBER_ALLOW_PAUSE_FIELD_NUMBER = 18;
    private boolean adaptiveStream_;
    private boolean autoSubscribe_;
    private int bitField0_;
    private LivekitModels$ClientInfo client_;
    private LivekitRoom$CreateRoomRequest createRoom_;
    private boolean disableIceLite_;
    private boolean hidden_;
    private int reconnectReason_;
    private boolean reconnect_;
    private boolean recorder_;
    private boolean subscriberAllowPause_;
    private String roomName_ = "";
    private String identity_ = "";
    private String connectionId_ = "";
    private String name_ = "";
    private String grantsJson_ = "";
    private String participantId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(m mVar) {
            this();
        }

        private a() {
            super(LivekitInternal$StartSession.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitInternal$StartSession livekitInternal$StartSession = new LivekitInternal$StartSession();
        DEFAULT_INSTANCE = livekitInternal$StartSession;
        GeneratedMessageLite.registerDefaultInstance(LivekitInternal$StartSession.class, livekitInternal$StartSession);
    }

    private LivekitInternal$StartSession() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdaptiveStream() {
        this.adaptiveStream_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAutoSubscribe() {
        this.autoSubscribe_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClient() {
        this.client_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionId() {
        this.connectionId_ = getDefaultInstance().getConnectionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreateRoom() {
        this.createRoom_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableIceLite() {
        this.disableIceLite_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGrantsJson() {
        this.grantsJson_ = getDefaultInstance().getGrantsJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHidden() {
        this.hidden_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantId() {
        this.participantId_ = getDefaultInstance().getParticipantId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReconnect() {
        this.reconnect_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReconnectReason() {
        this.reconnectReason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRecorder() {
        this.recorder_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriberAllowPause() {
        this.bitField0_ &= -2;
        this.subscriberAllowPause_ = false;
    }

    public static LivekitInternal$StartSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClient(LivekitModels$ClientInfo livekitModels$ClientInfo) {
        livekitModels$ClientInfo.getClass();
        LivekitModels$ClientInfo livekitModels$ClientInfo2 = this.client_;
        if (livekitModels$ClientInfo2 == null || livekitModels$ClientInfo2 == LivekitModels$ClientInfo.getDefaultInstance()) {
            this.client_ = livekitModels$ClientInfo;
        } else {
            this.client_ = (LivekitModels$ClientInfo) ((LivekitModels$ClientInfo.a) LivekitModels$ClientInfo.newBuilder(this.client_).v(livekitModels$ClientInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreateRoom(LivekitRoom$CreateRoomRequest livekitRoom$CreateRoomRequest) {
        livekitRoom$CreateRoomRequest.getClass();
        LivekitRoom$CreateRoomRequest livekitRoom$CreateRoomRequest2 = this.createRoom_;
        if (livekitRoom$CreateRoomRequest2 == null || livekitRoom$CreateRoomRequest2 == LivekitRoom$CreateRoomRequest.getDefaultInstance()) {
            this.createRoom_ = livekitRoom$CreateRoomRequest;
        } else {
            this.createRoom_ = (LivekitRoom$CreateRoomRequest) ((LivekitRoom$CreateRoomRequest.a) LivekitRoom$CreateRoomRequest.newBuilder(this.createRoom_).v(livekitRoom$CreateRoomRequest)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitInternal$StartSession parseDelimitedFrom(InputStream inputStream) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$StartSession parseFrom(ByteBuffer byteBuffer) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdaptiveStream(boolean z) {
        this.adaptiveStream_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoSubscribe(boolean z) {
        this.autoSubscribe_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClient(LivekitModels$ClientInfo livekitModels$ClientInfo) {
        livekitModels$ClientInfo.getClass();
        this.client_ = livekitModels$ClientInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionId(String str) {
        str.getClass();
        this.connectionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.connectionId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreateRoom(LivekitRoom$CreateRoomRequest livekitRoom$CreateRoomRequest) {
        livekitRoom$CreateRoomRequest.getClass();
        this.createRoom_ = livekitRoom$CreateRoomRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableIceLite(boolean z) {
        this.disableIceLite_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGrantsJson(String str) {
        str.getClass();
        this.grantsJson_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGrantsJsonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.grantsJson_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHidden(boolean z) {
        this.hidden_ = z;
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
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
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
    public void setReconnect(boolean z) {
        this.reconnect_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReconnectReason(VE3 ve3) {
        this.reconnectReason_ = ve3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReconnectReasonValue(int i) {
        this.reconnectReason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecorder(boolean z) {
        this.recorder_ = z;
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
    public void setSubscriberAllowPause(boolean z) {
        this.bitField0_ |= 1;
        this.subscriberAllowPause_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        m mVar = null;
        switch (m.a[gVar.ordinal()]) {
            case 1:
                return new LivekitInternal$StartSession();
            case 2:
                return new a(mVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0001\u0001\u0014\u0010\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007\t\u0007\n\u0007\u000b\t\f\u0007\rȈ\u000eȈ\u000f\u0007\u0010Ȉ\u0011\f\u0012ဇ\u0000\u0013\u0007\u0014\t", new Object[]{"bitField0_", "roomName_", "identity_", "connectionId_", "reconnect_", "autoSubscribe_", "hidden_", "client_", "recorder_", "name_", "grantsJson_", "adaptiveStream_", "participantId_", "reconnectReason_", "subscriberAllowPause_", "disableIceLite_", "createRoom_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitInternal$StartSession.class) {
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

    public boolean getAdaptiveStream() {
        return this.adaptiveStream_;
    }

    public boolean getAutoSubscribe() {
        return this.autoSubscribe_;
    }

    public LivekitModels$ClientInfo getClient() {
        LivekitModels$ClientInfo livekitModels$ClientInfo = this.client_;
        return livekitModels$ClientInfo == null ? LivekitModels$ClientInfo.getDefaultInstance() : livekitModels$ClientInfo;
    }

    public String getConnectionId() {
        return this.connectionId_;
    }

    public AbstractC2383g getConnectionIdBytes() {
        return AbstractC2383g.N(this.connectionId_);
    }

    public LivekitRoom$CreateRoomRequest getCreateRoom() {
        LivekitRoom$CreateRoomRequest livekitRoom$CreateRoomRequest = this.createRoom_;
        return livekitRoom$CreateRoomRequest == null ? LivekitRoom$CreateRoomRequest.getDefaultInstance() : livekitRoom$CreateRoomRequest;
    }

    public boolean getDisableIceLite() {
        return this.disableIceLite_;
    }

    public String getGrantsJson() {
        return this.grantsJson_;
    }

    public AbstractC2383g getGrantsJsonBytes() {
        return AbstractC2383g.N(this.grantsJson_);
    }

    public boolean getHidden() {
        return this.hidden_;
    }

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getParticipantId() {
        return this.participantId_;
    }

    public AbstractC2383g getParticipantIdBytes() {
        return AbstractC2383g.N(this.participantId_);
    }

    public boolean getReconnect() {
        return this.reconnect_;
    }

    public VE3 getReconnectReason() {
        VE3 ve3J = VE3.j(this.reconnectReason_);
        return ve3J == null ? VE3.UNRECOGNIZED : ve3J;
    }

    public int getReconnectReasonValue() {
        return this.reconnectReason_;
    }

    public boolean getRecorder() {
        return this.recorder_;
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public boolean getSubscriberAllowPause() {
        return this.subscriberAllowPause_;
    }

    public boolean hasClient() {
        return this.client_ != null;
    }

    public boolean hasCreateRoom() {
        return this.createRoom_ != null;
    }

    public boolean hasSubscriberAllowPause() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitInternal$StartSession livekitInternal$StartSession) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitInternal$StartSession);
    }

    public static LivekitInternal$StartSession parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$StartSession parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitInternal$StartSession parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitInternal$StartSession parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitInternal$StartSession parseFrom(byte[] bArr) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitInternal$StartSession parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitInternal$StartSession parseFrom(InputStream inputStream) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$StartSession parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$StartSession parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitInternal$StartSession parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitInternal$StartSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
