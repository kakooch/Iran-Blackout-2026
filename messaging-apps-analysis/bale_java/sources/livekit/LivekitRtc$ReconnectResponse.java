package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16424lF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitModels$ClientConfiguration;
import livekit.LivekitModels$ServerInfo;

/* loaded from: classes8.dex */
public final class LivekitRtc$ReconnectResponse extends GeneratedMessageLite implements U64 {
    public static final int CLIENT_CONFIGURATION_FIELD_NUMBER = 2;
    private static final LivekitRtc$ReconnectResponse DEFAULT_INSTANCE;
    public static final int ICE_SERVERS_FIELD_NUMBER = 1;
    public static final int LAST_MESSAGE_SEQ_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int SERVER_INFO_FIELD_NUMBER = 3;
    private LivekitModels$ClientConfiguration clientConfiguration_;
    private B.j iceServers_ = GeneratedMessageLite.emptyProtobufList();
    private int lastMessageSeq_;
    private LivekitModels$ServerInfo serverInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$ReconnectResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$ReconnectResponse livekitRtc$ReconnectResponse = new LivekitRtc$ReconnectResponse();
        DEFAULT_INSTANCE = livekitRtc$ReconnectResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$ReconnectResponse.class, livekitRtc$ReconnectResponse);
    }

    private LivekitRtc$ReconnectResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIceServers(Iterable<? extends LivekitRtc$ICEServer> iterable) {
        ensureIceServersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.iceServers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIceServers(LivekitRtc$ICEServer livekitRtc$ICEServer) {
        livekitRtc$ICEServer.getClass();
        ensureIceServersIsMutable();
        this.iceServers_.add(livekitRtc$ICEServer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientConfiguration() {
        this.clientConfiguration_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIceServers() {
        this.iceServers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastMessageSeq() {
        this.lastMessageSeq_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerInfo() {
        this.serverInfo_ = null;
    }

    private void ensureIceServersIsMutable() {
        B.j jVar = this.iceServers_;
        if (jVar.u()) {
            return;
        }
        this.iceServers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$ReconnectResponse getDefaultInstance() {
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

    public static LivekitRtc$ReconnectResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeIceServers(int i) {
        ensureIceServersIsMutable();
        this.iceServers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientConfiguration(LivekitModels$ClientConfiguration livekitModels$ClientConfiguration) {
        livekitModels$ClientConfiguration.getClass();
        this.clientConfiguration_ = livekitModels$ClientConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIceServers(int i, LivekitRtc$ICEServer livekitRtc$ICEServer) {
        livekitRtc$ICEServer.getClass();
        ensureIceServersIsMutable();
        this.iceServers_.set(i, livekitRtc$ICEServer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastMessageSeq(int i) {
        this.lastMessageSeq_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerInfo(LivekitModels$ServerInfo livekitModels$ServerInfo) {
        livekitModels$ServerInfo.getClass();
        this.serverInfo_ = livekitModels$ServerInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$ReconnectResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001b\u0002\t\u0003\t\u0004\u000b", new Object[]{"iceServers_", LivekitRtc$ICEServer.class, "clientConfiguration_", "serverInfo_", "lastMessageSeq_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$ReconnectResponse.class) {
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

    public LivekitModels$ClientConfiguration getClientConfiguration() {
        LivekitModels$ClientConfiguration livekitModels$ClientConfiguration = this.clientConfiguration_;
        return livekitModels$ClientConfiguration == null ? LivekitModels$ClientConfiguration.getDefaultInstance() : livekitModels$ClientConfiguration;
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

    public int getLastMessageSeq() {
        return this.lastMessageSeq_;
    }

    public LivekitModels$ServerInfo getServerInfo() {
        LivekitModels$ServerInfo livekitModels$ServerInfo = this.serverInfo_;
        return livekitModels$ServerInfo == null ? LivekitModels$ServerInfo.getDefaultInstance() : livekitModels$ServerInfo;
    }

    public boolean hasClientConfiguration() {
        return this.clientConfiguration_ != null;
    }

    public boolean hasServerInfo() {
        return this.serverInfo_ != null;
    }

    public static a newBuilder(LivekitRtc$ReconnectResponse livekitRtc$ReconnectResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$ReconnectResponse);
    }

    public static LivekitRtc$ReconnectResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIceServers(int i, LivekitRtc$ICEServer livekitRtc$ICEServer) {
        livekitRtc$ICEServer.getClass();
        ensureIceServersIsMutable();
        this.iceServers_.add(i, livekitRtc$ICEServer);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$ReconnectResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$ReconnectResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
