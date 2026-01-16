package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16424lF3;
import ir.nasim.KW4;
import ir.nasim.PE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitModels$ClientConfiguration;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$Room;
import livekit.LivekitModels$ServerInfo;

/* loaded from: classes8.dex */
public final class LivekitRtc$JoinResponse extends GeneratedMessageLite implements U64 {
    public static final int ALTERNATIVE_URL_FIELD_NUMBER = 7;
    public static final int CLIENT_CONFIGURATION_FIELD_NUMBER = 8;
    private static final LivekitRtc$JoinResponse DEFAULT_INSTANCE;
    public static final int ENABLED_PUBLISH_CODECS_FIELD_NUMBER = 14;
    public static final int FAST_PUBLISH_FIELD_NUMBER = 15;
    public static final int ICE_SERVERS_FIELD_NUMBER = 5;
    public static final int OTHER_PARTICIPANTS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 2;
    public static final int PING_INTERVAL_FIELD_NUMBER = 11;
    public static final int PING_TIMEOUT_FIELD_NUMBER = 10;
    public static final int ROOM_FIELD_NUMBER = 1;
    public static final int SERVER_INFO_FIELD_NUMBER = 12;
    public static final int SERVER_REGION_FIELD_NUMBER = 9;
    public static final int SERVER_VERSION_FIELD_NUMBER = 4;
    public static final int SIF_TRAILER_FIELD_NUMBER = 13;
    public static final int SUBSCRIBER_PRIMARY_FIELD_NUMBER = 6;
    private LivekitModels$ClientConfiguration clientConfiguration_;
    private boolean fastPublish_;
    private LivekitModels$ParticipantInfo participant_;
    private int pingInterval_;
    private int pingTimeout_;
    private LivekitModels$Room room_;
    private LivekitModels$ServerInfo serverInfo_;
    private boolean subscriberPrimary_;
    private B.j otherParticipants_ = GeneratedMessageLite.emptyProtobufList();
    private String serverVersion_ = "";
    private B.j iceServers_ = GeneratedMessageLite.emptyProtobufList();
    private String alternativeUrl_ = "";
    private String serverRegion_ = "";
    private AbstractC2383g sifTrailer_ = AbstractC2383g.b;
    private B.j enabledPublishCodecs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$JoinResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$JoinResponse livekitRtc$JoinResponse = new LivekitRtc$JoinResponse();
        DEFAULT_INSTANCE = livekitRtc$JoinResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$JoinResponse.class, livekitRtc$JoinResponse);
    }

    private LivekitRtc$JoinResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnabledPublishCodecs(Iterable<? extends LivekitModels$Codec> iterable) {
        ensureEnabledPublishCodecsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.enabledPublishCodecs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIceServers(Iterable<? extends LivekitRtc$ICEServer> iterable) {
        ensureIceServersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.iceServers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOtherParticipants(Iterable<? extends LivekitModels$ParticipantInfo> iterable) {
        ensureOtherParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.otherParticipants_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnabledPublishCodecs(LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureEnabledPublishCodecsIsMutable();
        this.enabledPublishCodecs_.add(livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIceServers(LivekitRtc$ICEServer livekitRtc$ICEServer) {
        livekitRtc$ICEServer.getClass();
        ensureIceServersIsMutable();
        this.iceServers_.add(livekitRtc$ICEServer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOtherParticipants(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.add(livekitModels$ParticipantInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlternativeUrl() {
        this.alternativeUrl_ = getDefaultInstance().getAlternativeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientConfiguration() {
        this.clientConfiguration_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnabledPublishCodecs() {
        this.enabledPublishCodecs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFastPublish() {
        this.fastPublish_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIceServers() {
        this.iceServers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOtherParticipants() {
        this.otherParticipants_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipant() {
        this.participant_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPingInterval() {
        this.pingInterval_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPingTimeout() {
        this.pingTimeout_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerInfo() {
        this.serverInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerRegion() {
        this.serverRegion_ = getDefaultInstance().getServerRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerVersion() {
        this.serverVersion_ = getDefaultInstance().getServerVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSifTrailer() {
        this.sifTrailer_ = getDefaultInstance().getSifTrailer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriberPrimary() {
        this.subscriberPrimary_ = false;
    }

    private void ensureEnabledPublishCodecsIsMutable() {
        B.j jVar = this.enabledPublishCodecs_;
        if (jVar.u()) {
            return;
        }
        this.enabledPublishCodecs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureIceServersIsMutable() {
        B.j jVar = this.iceServers_;
        if (jVar.u()) {
            return;
        }
        this.iceServers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureOtherParticipantsIsMutable() {
        B.j jVar = this.otherParticipants_;
        if (jVar.u()) {
            return;
        }
        this.otherParticipants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$JoinResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientConfiguration(LivekitModels$ClientConfiguration livekitModels$ClientConfiguration) {
        livekitModels$ClientConfiguration.getClass();
        LivekitModels$ClientConfiguration livekitModels$ClientConfiguration2 = this.clientConfiguration_;
        if (livekitModels$ClientConfiguration2 == null || livekitModels$ClientConfiguration2 == LivekitModels$ClientConfiguration.getDefaultInstance()) {
            this.clientConfiguration_ = livekitModels$ClientConfiguration;
        } else {
            this.clientConfiguration_ = (LivekitModels$ClientConfiguration) ((LivekitModels$ClientConfiguration.a) LivekitModels$ClientConfiguration.newBuilder(this.clientConfiguration_).v(livekitModels$ClientConfiguration)).j();
        }
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
    public void mergeServerInfo(LivekitModels$ServerInfo livekitModels$ServerInfo) {
        livekitModels$ServerInfo.getClass();
        LivekitModels$ServerInfo livekitModels$ServerInfo2 = this.serverInfo_;
        if (livekitModels$ServerInfo2 == null || livekitModels$ServerInfo2 == LivekitModels$ServerInfo.getDefaultInstance()) {
            this.serverInfo_ = livekitModels$ServerInfo;
        } else {
            this.serverInfo_ = (LivekitModels$ServerInfo) ((LivekitModels$ServerInfo.a) LivekitModels$ServerInfo.newBuilder(this.serverInfo_).v(livekitModels$ServerInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$JoinResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$JoinResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnabledPublishCodecs(int i) {
        ensureEnabledPublishCodecsIsMutable();
        this.enabledPublishCodecs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeIceServers(int i) {
        ensureIceServersIsMutable();
        this.iceServers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOtherParticipants(int i) {
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlternativeUrl(String str) {
        str.getClass();
        this.alternativeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlternativeUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.alternativeUrl_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientConfiguration(LivekitModels$ClientConfiguration livekitModels$ClientConfiguration) {
        livekitModels$ClientConfiguration.getClass();
        this.clientConfiguration_ = livekitModels$ClientConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledPublishCodecs(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureEnabledPublishCodecsIsMutable();
        this.enabledPublishCodecs_.set(i, livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFastPublish(boolean z) {
        this.fastPublish_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIceServers(int i, LivekitRtc$ICEServer livekitRtc$ICEServer) {
        livekitRtc$ICEServer.getClass();
        ensureIceServersIsMutable();
        this.iceServers_.set(i, livekitRtc$ICEServer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtherParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.set(i, livekitModels$ParticipantInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        this.participant_ = livekitModels$ParticipantInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPingInterval(int i) {
        this.pingInterval_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPingTimeout(int i) {
        this.pingTimeout_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        this.room_ = livekitModels$Room;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerInfo(LivekitModels$ServerInfo livekitModels$ServerInfo) {
        livekitModels$ServerInfo.getClass();
        this.serverInfo_ = livekitModels$ServerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerRegion(String str) {
        str.getClass();
        this.serverRegion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serverRegion_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerVersion(String str) {
        str.getClass();
        this.serverVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serverVersion_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSifTrailer(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.sifTrailer_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscriberPrimary(boolean z) {
        this.subscriberPrimary_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$JoinResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0003\u0000\u0001\t\u0002\t\u0003\u001b\u0004Ȉ\u0005\u001b\u0006\u0007\u0007Ȉ\b\t\tȈ\n\u0004\u000b\u0004\f\t\r\n\u000e\u001b\u000f\u0007", new Object[]{"room_", "participant_", "otherParticipants_", LivekitModels$ParticipantInfo.class, "serverVersion_", "iceServers_", LivekitRtc$ICEServer.class, "subscriberPrimary_", "alternativeUrl_", "clientConfiguration_", "serverRegion_", "pingTimeout_", "pingInterval_", "serverInfo_", "sifTrailer_", "enabledPublishCodecs_", LivekitModels$Codec.class, "fastPublish_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$JoinResponse.class) {
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

    public String getAlternativeUrl() {
        return this.alternativeUrl_;
    }

    public AbstractC2383g getAlternativeUrlBytes() {
        return AbstractC2383g.N(this.alternativeUrl_);
    }

    public LivekitModels$ClientConfiguration getClientConfiguration() {
        LivekitModels$ClientConfiguration livekitModels$ClientConfiguration = this.clientConfiguration_;
        return livekitModels$ClientConfiguration == null ? LivekitModels$ClientConfiguration.getDefaultInstance() : livekitModels$ClientConfiguration;
    }

    public LivekitModels$Codec getEnabledPublishCodecs(int i) {
        return (LivekitModels$Codec) this.enabledPublishCodecs_.get(i);
    }

    public int getEnabledPublishCodecsCount() {
        return this.enabledPublishCodecs_.size();
    }

    public List<LivekitModels$Codec> getEnabledPublishCodecsList() {
        return this.enabledPublishCodecs_;
    }

    public PE3 getEnabledPublishCodecsOrBuilder(int i) {
        return (PE3) this.enabledPublishCodecs_.get(i);
    }

    public List<? extends PE3> getEnabledPublishCodecsOrBuilderList() {
        return this.enabledPublishCodecs_;
    }

    public boolean getFastPublish() {
        return this.fastPublish_;
    }

    public LivekitRtc$ICEServer getIceServers(int i) {
        return (LivekitRtc$ICEServer) this.iceServers_.get(i);
    }

    public int getIceServersCount() {
        return this.iceServers_.size();
    }

    public List<LivekitRtc$ICEServer> getIceServersList() {
        return this.iceServers_;
    }

    public InterfaceC16424lF3 getIceServersOrBuilder(int i) {
        return (InterfaceC16424lF3) this.iceServers_.get(i);
    }

    public List<? extends InterfaceC16424lF3> getIceServersOrBuilderList() {
        return this.iceServers_;
    }

    public LivekitModels$ParticipantInfo getOtherParticipants(int i) {
        return (LivekitModels$ParticipantInfo) this.otherParticipants_.get(i);
    }

    public int getOtherParticipantsCount() {
        return this.otherParticipants_.size();
    }

    public List<LivekitModels$ParticipantInfo> getOtherParticipantsList() {
        return this.otherParticipants_;
    }

    public p getOtherParticipantsOrBuilder(int i) {
        return (p) this.otherParticipants_.get(i);
    }

    public List<? extends p> getOtherParticipantsOrBuilderList() {
        return this.otherParticipants_;
    }

    public LivekitModels$ParticipantInfo getParticipant() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.participant_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public int getPingInterval() {
        return this.pingInterval_;
    }

    public int getPingTimeout() {
        return this.pingTimeout_;
    }

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public LivekitModels$ServerInfo getServerInfo() {
        LivekitModels$ServerInfo livekitModels$ServerInfo = this.serverInfo_;
        return livekitModels$ServerInfo == null ? LivekitModels$ServerInfo.getDefaultInstance() : livekitModels$ServerInfo;
    }

    public String getServerRegion() {
        return this.serverRegion_;
    }

    public AbstractC2383g getServerRegionBytes() {
        return AbstractC2383g.N(this.serverRegion_);
    }

    public String getServerVersion() {
        return this.serverVersion_;
    }

    public AbstractC2383g getServerVersionBytes() {
        return AbstractC2383g.N(this.serverVersion_);
    }

    public AbstractC2383g getSifTrailer() {
        return this.sifTrailer_;
    }

    public boolean getSubscriberPrimary() {
        return this.subscriberPrimary_;
    }

    public boolean hasClientConfiguration() {
        return this.clientConfiguration_ != null;
    }

    public boolean hasParticipant() {
        return this.participant_ != null;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public boolean hasServerInfo() {
        return this.serverInfo_ != null;
    }

    public static a newBuilder(LivekitRtc$JoinResponse livekitRtc$JoinResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$JoinResponse);
    }

    public static LivekitRtc$JoinResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$JoinResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$JoinResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnabledPublishCodecs(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureEnabledPublishCodecsIsMutable();
        this.enabledPublishCodecs_.add(i, livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIceServers(int i, LivekitRtc$ICEServer livekitRtc$ICEServer) {
        livekitRtc$ICEServer.getClass();
        ensureIceServersIsMutable();
        this.iceServers_.add(i, livekitRtc$ICEServer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOtherParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureOtherParticipantsIsMutable();
        this.otherParticipants_.add(i, livekitModels$ParticipantInfo);
    }

    public static LivekitRtc$JoinResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$JoinResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$JoinResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$JoinResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$JoinResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$JoinResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$JoinResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$JoinResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
