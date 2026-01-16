package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes8.dex */
public final class LivekitSip$TransferSIPParticipantRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$TransferSIPParticipantRequest DEFAULT_INSTANCE;
    public static final int HEADERS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 1;
    public static final int PLAY_DIALTONE_FIELD_NUMBER = 4;
    public static final int RINGING_TIMEOUT_FIELD_NUMBER = 6;
    public static final int ROOM_NAME_FIELD_NUMBER = 2;
    public static final int TRANSFER_TO_FIELD_NUMBER = 3;
    private boolean playDialtone_;
    private Duration ringingTimeout_;
    private J headers_ = J.e();
    private String participantIdentity_ = "";
    private String roomName_ = "";
    private String transferTo_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$TransferSIPParticipantRequest.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    static {
        LivekitSip$TransferSIPParticipantRequest livekitSip$TransferSIPParticipantRequest = new LivekitSip$TransferSIPParticipantRequest();
        DEFAULT_INSTANCE = livekitSip$TransferSIPParticipantRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$TransferSIPParticipantRequest.class, livekitSip$TransferSIPParticipantRequest);
    }

    private LivekitSip$TransferSIPParticipantRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayDialtone() {
        this.playDialtone_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRingingTimeout() {
        this.ringingTimeout_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferTo() {
        this.transferTo_ = getDefaultInstance().getTransferTo();
    }

    public static LivekitSip$TransferSIPParticipantRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableHeadersMap() {
        return internalGetMutableHeaders();
    }

    private J internalGetHeaders() {
        return this.headers_;
    }

    private J internalGetMutableHeaders() {
        if (!this.headers_.n()) {
            this.headers_ = this.headers_.s();
        }
        return this.headers_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRingingTimeout(Duration duration) {
        duration.getClass();
        Duration duration2 = this.ringingTimeout_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.ringingTimeout_ = duration;
        } else {
            this.ringingTimeout_ = (Duration) ((Duration.b) Duration.newBuilder(this.ringingTimeout_).v(duration)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$TransferSIPParticipantRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setPlayDialtone(boolean z) {
        this.playDialtone_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRingingTimeout(Duration duration) {
        duration.getClass();
        this.ringingTimeout_ = duration;
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
    public void setTransferTo(String str) {
        str.getClass();
        this.transferTo_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferToBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transferTo_ = abstractC2383g.f0();
    }

    public boolean containsHeaders(String str) {
        str.getClass();
        return internalGetHeaders().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$TransferSIPParticipantRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007\u00052\u0006\t", new Object[]{"participantIdentity_", "roomName_", "transferTo_", "playDialtone_", "headers_", b.a, "ringingTimeout_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$TransferSIPParticipantRequest.class) {
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

    @Deprecated
    public Map<String, String> getHeaders() {
        return getHeadersMap();
    }

    public int getHeadersCount() {
        return internalGetHeaders().size();
    }

    public Map<String, String> getHeadersMap() {
        return Collections.unmodifiableMap(internalGetHeaders());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getHeadersOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetHeaders = internalGetHeaders();
        return jInternalGetHeaders.containsKey(str) ? (String) jInternalGetHeaders.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getHeadersOrThrow(String str) {
        str.getClass();
        J jInternalGetHeaders = internalGetHeaders();
        if (jInternalGetHeaders.containsKey(str)) {
            return (String) jInternalGetHeaders.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public boolean getPlayDialtone() {
        return this.playDialtone_;
    }

    public Duration getRingingTimeout() {
        Duration duration = this.ringingTimeout_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public String getTransferTo() {
        return this.transferTo_;
    }

    public AbstractC2383g getTransferToBytes() {
        return AbstractC2383g.N(this.transferTo_);
    }

    public boolean hasRingingTimeout() {
        return this.ringingTimeout_ != null;
    }

    public static a newBuilder(LivekitSip$TransferSIPParticipantRequest livekitSip$TransferSIPParticipantRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$TransferSIPParticipantRequest);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(byte[] bArr) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$TransferSIPParticipantRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$TransferSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
