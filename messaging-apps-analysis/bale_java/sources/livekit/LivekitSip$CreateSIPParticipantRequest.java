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
import ir.nasim.BF3;
import ir.nasim.EnumC24816zF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import livekit.LivekitSip$SIPOutboundConfig;

/* loaded from: classes8.dex */
public final class LivekitSip$CreateSIPParticipantRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$CreateSIPParticipantRequest DEFAULT_INSTANCE;
    public static final int DTMF_FIELD_NUMBER = 5;
    public static final int HEADERS_FIELD_NUMBER = 16;
    public static final int HIDE_PHONE_NUMBER_FIELD_NUMBER = 10;
    public static final int INCLUDE_HEADERS_FIELD_NUMBER = 17;
    public static final int KRISP_ENABLED_FIELD_NUMBER = 14;
    public static final int MAX_CALL_DURATION_FIELD_NUMBER = 12;
    public static final int MEDIA_ENCRYPTION_FIELD_NUMBER = 18;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_ATTRIBUTES_FIELD_NUMBER = 9;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 4;
    public static final int PARTICIPANT_METADATA_FIELD_NUMBER = 8;
    public static final int PARTICIPANT_NAME_FIELD_NUMBER = 7;
    public static final int PLAY_DIALTONE_FIELD_NUMBER = 13;
    public static final int PLAY_RINGTONE_FIELD_NUMBER = 6;
    public static final int RINGING_TIMEOUT_FIELD_NUMBER = 11;
    public static final int ROOM_NAME_FIELD_NUMBER = 3;
    public static final int SIP_CALL_TO_FIELD_NUMBER = 2;
    public static final int SIP_NUMBER_FIELD_NUMBER = 15;
    public static final int SIP_TRUNK_ID_FIELD_NUMBER = 1;
    public static final int TRUNK_FIELD_NUMBER = 20;
    public static final int WAIT_UNTIL_ANSWERED_FIELD_NUMBER = 19;
    private boolean hidePhoneNumber_;
    private int includeHeaders_;
    private boolean krispEnabled_;
    private Duration maxCallDuration_;
    private int mediaEncryption_;
    private boolean playDialtone_;
    private boolean playRingtone_;
    private Duration ringingTimeout_;
    private LivekitSip$SIPOutboundConfig trunk_;
    private boolean waitUntilAnswered_;
    private J participantAttributes_ = J.e();
    private J headers_ = J.e();
    private String sipTrunkId_ = "";
    private String sipCallTo_ = "";
    private String sipNumber_ = "";
    private String roomName_ = "";
    private String participantIdentity_ = "";
    private String participantName_ = "";
    private String participantMetadata_ = "";
    private String dtmf_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$CreateSIPParticipantRequest.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    private static final class c {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    static {
        LivekitSip$CreateSIPParticipantRequest livekitSip$CreateSIPParticipantRequest = new LivekitSip$CreateSIPParticipantRequest();
        DEFAULT_INSTANCE = livekitSip$CreateSIPParticipantRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$CreateSIPParticipantRequest.class, livekitSip$CreateSIPParticipantRequest);
    }

    private LivekitSip$CreateSIPParticipantRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDtmf() {
        this.dtmf_ = getDefaultInstance().getDtmf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHidePhoneNumber() {
        this.hidePhoneNumber_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIncludeHeaders() {
        this.includeHeaders_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKrispEnabled() {
        this.krispEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxCallDuration() {
        this.maxCallDuration_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaEncryption() {
        this.mediaEncryption_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantMetadata() {
        this.participantMetadata_ = getDefaultInstance().getParticipantMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantName() {
        this.participantName_ = getDefaultInstance().getParticipantName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayDialtone() {
        this.playDialtone_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayRingtone() {
        this.playRingtone_ = false;
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
    public void clearSipCallTo() {
        this.sipCallTo_ = getDefaultInstance().getSipCallTo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipNumber() {
        this.sipNumber_ = getDefaultInstance().getSipNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTrunkId() {
        this.sipTrunkId_ = getDefaultInstance().getSipTrunkId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunk() {
        this.trunk_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWaitUntilAnswered() {
        this.waitUntilAnswered_ = false;
    }

    public static LivekitSip$CreateSIPParticipantRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableHeadersMap() {
        return internalGetMutableHeaders();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableParticipantAttributesMap() {
        return internalGetMutableParticipantAttributes();
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

    private J internalGetMutableParticipantAttributes() {
        if (!this.participantAttributes_.n()) {
            this.participantAttributes_ = this.participantAttributes_.s();
        }
        return this.participantAttributes_;
    }

    private J internalGetParticipantAttributes() {
        return this.participantAttributes_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMaxCallDuration(Duration duration) {
        duration.getClass();
        Duration duration2 = this.maxCallDuration_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.maxCallDuration_ = duration;
        } else {
            this.maxCallDuration_ = (Duration) ((Duration.b) Duration.newBuilder(this.maxCallDuration_).v(duration)).j();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrunk(LivekitSip$SIPOutboundConfig livekitSip$SIPOutboundConfig) {
        livekitSip$SIPOutboundConfig.getClass();
        LivekitSip$SIPOutboundConfig livekitSip$SIPOutboundConfig2 = this.trunk_;
        if (livekitSip$SIPOutboundConfig2 == null || livekitSip$SIPOutboundConfig2 == LivekitSip$SIPOutboundConfig.getDefaultInstance()) {
            this.trunk_ = livekitSip$SIPOutboundConfig;
        } else {
            this.trunk_ = (LivekitSip$SIPOutboundConfig) ((LivekitSip$SIPOutboundConfig.b) LivekitSip$SIPOutboundConfig.newBuilder(this.trunk_).v(livekitSip$SIPOutboundConfig)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$CreateSIPParticipantRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDtmf(String str) {
        str.getClass();
        this.dtmf_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDtmfBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.dtmf_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHidePhoneNumber(boolean z) {
        this.hidePhoneNumber_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeHeaders(EnumC24816zF3 enumC24816zF3) {
        this.includeHeaders_ = enumC24816zF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeHeadersValue(int i) {
        this.includeHeaders_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKrispEnabled(boolean z) {
        this.krispEnabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxCallDuration(Duration duration) {
        duration.getClass();
        this.maxCallDuration_ = duration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryption(BF3 bf3) {
        this.mediaEncryption_ = bf3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryptionValue(int i) {
        this.mediaEncryption_ = i;
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
    public void setParticipantMetadata(String str) {
        str.getClass();
        this.participantMetadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantMetadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantName(String str) {
        str.getClass();
        this.participantName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayDialtone(boolean z) {
        this.playDialtone_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayRingtone(boolean z) {
        this.playRingtone_ = z;
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
    public void setSipCallTo(String str) {
        str.getClass();
        this.sipCallTo_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipCallToBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipCallTo_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipNumber(String str) {
        str.getClass();
        this.sipNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipNumber_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkId(String str) {
        str.getClass();
        this.sipTrunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipTrunkId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunk(LivekitSip$SIPOutboundConfig livekitSip$SIPOutboundConfig) {
        livekitSip$SIPOutboundConfig.getClass();
        this.trunk_ = livekitSip$SIPOutboundConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWaitUntilAnswered(boolean z) {
        this.waitUntilAnswered_ = z;
    }

    public boolean containsHeaders(String str) {
        str.getClass();
        return internalGetHeaders().containsKey(str);
    }

    public boolean containsParticipantAttributes(String str) {
        str.getClass();
        return internalGetParticipantAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$CreateSIPParticipantRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0014\u0000\u0000\u0001\u0014\u0014\u0002\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0007\u0007Ȉ\bȈ\t2\n\u0007\u000b\t\f\t\r\u0007\u000e\u0007\u000fȈ\u00102\u0011\f\u0012\f\u0013\u0007\u0014\t", new Object[]{"sipTrunkId_", "sipCallTo_", "roomName_", "participantIdentity_", "dtmf_", "playRingtone_", "participantName_", "participantMetadata_", "participantAttributes_", c.a, "hidePhoneNumber_", "ringingTimeout_", "maxCallDuration_", "playDialtone_", "krispEnabled_", "sipNumber_", "headers_", b.a, "includeHeaders_", "mediaEncryption_", "waitUntilAnswered_", "trunk_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$CreateSIPParticipantRequest.class) {
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

    public String getDtmf() {
        return this.dtmf_;
    }

    public AbstractC2383g getDtmfBytes() {
        return AbstractC2383g.N(this.dtmf_);
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

    public boolean getHidePhoneNumber() {
        return this.hidePhoneNumber_;
    }

    public EnumC24816zF3 getIncludeHeaders() {
        EnumC24816zF3 enumC24816zF3J = EnumC24816zF3.j(this.includeHeaders_);
        return enumC24816zF3J == null ? EnumC24816zF3.UNRECOGNIZED : enumC24816zF3J;
    }

    public int getIncludeHeadersValue() {
        return this.includeHeaders_;
    }

    public boolean getKrispEnabled() {
        return this.krispEnabled_;
    }

    public Duration getMaxCallDuration() {
        Duration duration = this.maxCallDuration_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public BF3 getMediaEncryption() {
        BF3 bf3J = BF3.j(this.mediaEncryption_);
        return bf3J == null ? BF3.UNRECOGNIZED : bf3J;
    }

    public int getMediaEncryptionValue() {
        return this.mediaEncryption_;
    }

    @Deprecated
    public Map<String, String> getParticipantAttributes() {
        return getParticipantAttributesMap();
    }

    public int getParticipantAttributesCount() {
        return internalGetParticipantAttributes().size();
    }

    public Map<String, String> getParticipantAttributesMap() {
        return Collections.unmodifiableMap(internalGetParticipantAttributes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getParticipantAttributesOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetParticipantAttributes = internalGetParticipantAttributes();
        return jInternalGetParticipantAttributes.containsKey(str) ? (String) jInternalGetParticipantAttributes.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getParticipantAttributesOrThrow(String str) {
        str.getClass();
        J jInternalGetParticipantAttributes = internalGetParticipantAttributes();
        if (jInternalGetParticipantAttributes.containsKey(str)) {
            return (String) jInternalGetParticipantAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getParticipantMetadata() {
        return this.participantMetadata_;
    }

    public AbstractC2383g getParticipantMetadataBytes() {
        return AbstractC2383g.N(this.participantMetadata_);
    }

    public String getParticipantName() {
        return this.participantName_;
    }

    public AbstractC2383g getParticipantNameBytes() {
        return AbstractC2383g.N(this.participantName_);
    }

    public boolean getPlayDialtone() {
        return this.playDialtone_;
    }

    @Deprecated
    public boolean getPlayRingtone() {
        return this.playRingtone_;
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

    public String getSipCallTo() {
        return this.sipCallTo_;
    }

    public AbstractC2383g getSipCallToBytes() {
        return AbstractC2383g.N(this.sipCallTo_);
    }

    public String getSipNumber() {
        return this.sipNumber_;
    }

    public AbstractC2383g getSipNumberBytes() {
        return AbstractC2383g.N(this.sipNumber_);
    }

    public String getSipTrunkId() {
        return this.sipTrunkId_;
    }

    public AbstractC2383g getSipTrunkIdBytes() {
        return AbstractC2383g.N(this.sipTrunkId_);
    }

    public LivekitSip$SIPOutboundConfig getTrunk() {
        LivekitSip$SIPOutboundConfig livekitSip$SIPOutboundConfig = this.trunk_;
        return livekitSip$SIPOutboundConfig == null ? LivekitSip$SIPOutboundConfig.getDefaultInstance() : livekitSip$SIPOutboundConfig;
    }

    public boolean getWaitUntilAnswered() {
        return this.waitUntilAnswered_;
    }

    public boolean hasMaxCallDuration() {
        return this.maxCallDuration_ != null;
    }

    public boolean hasRingingTimeout() {
        return this.ringingTimeout_ != null;
    }

    public boolean hasTrunk() {
        return this.trunk_ != null;
    }

    public static a newBuilder(LivekitSip$CreateSIPParticipantRequest livekitSip$CreateSIPParticipantRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$CreateSIPParticipantRequest);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(byte[] bArr) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$CreateSIPParticipantRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$CreateSIPParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
