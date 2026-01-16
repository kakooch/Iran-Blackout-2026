package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.EnumC22446vF3;
import ir.nasim.EnumC23042wF3;
import ir.nasim.EnumC24222yF3;
import ir.nasim.KW4;
import ir.nasim.RE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import livekit.LivekitSip$SIPStatus;
import livekit.LivekitSip$SIPUri;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPCallInfo extends GeneratedMessageLite implements U64 {
    public static final int AUDIO_CODEC_FIELD_NUMBER = 20;
    public static final int CALL_DIRECTION_FIELD_NUMBER = 15;
    public static final int CALL_ID_FIELD_NUMBER = 1;
    public static final int CALL_STATUS_CODE_FIELD_NUMBER = 19;
    public static final int CALL_STATUS_FIELD_NUMBER = 8;
    public static final int CREATED_AT_FIELD_NUMBER = 9;
    public static final int CREATED_AT_NS_FIELD_NUMBER = 22;
    private static final LivekitSip$SIPCallInfo DEFAULT_INSTANCE;
    public static final int DISCONNECT_REASON_FIELD_NUMBER = 12;
    public static final int DISPATCH_RULE_ID_FIELD_NUMBER = 16;
    public static final int ENABLED_FEATURES_FIELD_NUMBER = 14;
    public static final int ENDED_AT_FIELD_NUMBER = 11;
    public static final int ENDED_AT_NS_FIELD_NUMBER = 24;
    public static final int ERROR_FIELD_NUMBER = 13;
    public static final int FROM_URI_FIELD_NUMBER = 6;
    public static final int MEDIA_ENCRYPTION_FIELD_NUMBER = 21;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_ATTRIBUTES_FIELD_NUMBER = 18;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 5;
    public static final int REGION_FIELD_NUMBER = 17;
    public static final int ROOM_ID_FIELD_NUMBER = 4;
    public static final int ROOM_NAME_FIELD_NUMBER = 3;
    public static final int STARTED_AT_FIELD_NUMBER = 10;
    public static final int STARTED_AT_NS_FIELD_NUMBER = 23;
    public static final int TO_URI_FIELD_NUMBER = 7;
    public static final int TRUNK_ID_FIELD_NUMBER = 2;
    private static final B.h.a enabledFeatures_converter_ = new a();
    private int callDirection_;
    private LivekitSip$SIPStatus callStatusCode_;
    private int callStatus_;
    private long createdAtNs_;
    private long createdAt_;
    private int disconnectReason_;
    private int enabledFeaturesMemoizedSerializedSize;
    private long endedAtNs_;
    private long endedAt_;
    private LivekitSip$SIPUri fromUri_;
    private long startedAtNs_;
    private long startedAt_;
    private LivekitSip$SIPUri toUri_;
    private J participantAttributes_ = J.e();
    private String callId_ = "";
    private String trunkId_ = "";
    private String dispatchRuleId_ = "";
    private String region_ = "";
    private String roomName_ = "";
    private String roomId_ = "";
    private String participantIdentity_ = "";
    private B.g enabledFeatures_ = GeneratedMessageLite.emptyIntList();
    private String error_ = "";
    private String audioCodec_ = "";
    private String mediaEncryption_ = "";

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24222yF3 a(Integer num) {
            EnumC24222yF3 enumC24222yF3J = EnumC24222yF3.j(num.intValue());
            return enumC24222yF3J == null ? EnumC24222yF3.UNRECOGNIZED : enumC24222yF3J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(t tVar) {
            this();
        }

        private b() {
            super(LivekitSip$SIPCallInfo.DEFAULT_INSTANCE);
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
        LivekitSip$SIPCallInfo livekitSip$SIPCallInfo = new LivekitSip$SIPCallInfo();
        DEFAULT_INSTANCE = livekitSip$SIPCallInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPCallInfo.class, livekitSip$SIPCallInfo);
    }

    private LivekitSip$SIPCallInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnabledFeatures(Iterable<? extends EnumC24222yF3> iterable) {
        ensureEnabledFeaturesIsMutable();
        Iterator<? extends EnumC24222yF3> it = iterable.iterator();
        while (it.hasNext()) {
            this.enabledFeatures_.b1(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnabledFeaturesValue(Iterable<Integer> iterable) {
        ensureEnabledFeaturesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.enabledFeatures_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnabledFeatures(EnumC24222yF3 enumC24222yF3) {
        enumC24222yF3.getClass();
        ensureEnabledFeaturesIsMutable();
        this.enabledFeatures_.b1(enumC24222yF3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnabledFeaturesValue(int i) {
        ensureEnabledFeaturesIsMutable();
        this.enabledFeatures_.b1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioCodec() {
        this.audioCodec_ = getDefaultInstance().getAudioCodec();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallDirection() {
        this.callDirection_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallId() {
        this.callId_ = getDefaultInstance().getCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallStatus() {
        this.callStatus_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallStatusCode() {
        this.callStatusCode_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAtNs() {
        this.createdAtNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisconnectReason() {
        this.disconnectReason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchRuleId() {
        this.dispatchRuleId_ = getDefaultInstance().getDispatchRuleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnabledFeatures() {
        this.enabledFeatures_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAtNs() {
        this.endedAtNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFromUri() {
        this.fromUri_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaEncryption() {
        this.mediaEncryption_ = getDefaultInstance().getMediaEncryption();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
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
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAtNs() {
        this.startedAtNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToUri() {
        this.toUri_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunkId() {
        this.trunkId_ = getDefaultInstance().getTrunkId();
    }

    private void ensureEnabledFeaturesIsMutable() {
        B.g gVar = this.enabledFeatures_;
        if (gVar.u()) {
            return;
        }
        this.enabledFeatures_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static LivekitSip$SIPCallInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableParticipantAttributesMap() {
        return internalGetMutableParticipantAttributes();
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
    public void mergeCallStatusCode(LivekitSip$SIPStatus livekitSip$SIPStatus) {
        livekitSip$SIPStatus.getClass();
        LivekitSip$SIPStatus livekitSip$SIPStatus2 = this.callStatusCode_;
        if (livekitSip$SIPStatus2 == null || livekitSip$SIPStatus2 == LivekitSip$SIPStatus.getDefaultInstance()) {
            this.callStatusCode_ = livekitSip$SIPStatus;
        } else {
            this.callStatusCode_ = (LivekitSip$SIPStatus) ((LivekitSip$SIPStatus.a) LivekitSip$SIPStatus.newBuilder(this.callStatusCode_).v(livekitSip$SIPStatus)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFromUri(LivekitSip$SIPUri livekitSip$SIPUri) {
        livekitSip$SIPUri.getClass();
        LivekitSip$SIPUri livekitSip$SIPUri2 = this.fromUri_;
        if (livekitSip$SIPUri2 == null || livekitSip$SIPUri2 == LivekitSip$SIPUri.getDefaultInstance()) {
            this.fromUri_ = livekitSip$SIPUri;
        } else {
            this.fromUri_ = (LivekitSip$SIPUri) ((LivekitSip$SIPUri.a) LivekitSip$SIPUri.newBuilder(this.fromUri_).v(livekitSip$SIPUri)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToUri(LivekitSip$SIPUri livekitSip$SIPUri) {
        livekitSip$SIPUri.getClass();
        LivekitSip$SIPUri livekitSip$SIPUri2 = this.toUri_;
        if (livekitSip$SIPUri2 == null || livekitSip$SIPUri2 == LivekitSip$SIPUri.getDefaultInstance()) {
            this.toUri_ = livekitSip$SIPUri;
        } else {
            this.toUri_ = (LivekitSip$SIPUri) ((LivekitSip$SIPUri.a) LivekitSip$SIPUri.newBuilder(this.toUri_).v(livekitSip$SIPUri)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPCallInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPCallInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioCodec(String str) {
        str.getClass();
        this.audioCodec_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioCodecBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.audioCodec_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallDirection(EnumC22446vF3 enumC22446vF3) {
        this.callDirection_ = enumC22446vF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallDirectionValue(int i) {
        this.callDirection_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(String str) {
        str.getClass();
        this.callId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallStatus(EnumC23042wF3 enumC23042wF3) {
        this.callStatus_ = enumC23042wF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallStatusCode(LivekitSip$SIPStatus livekitSip$SIPStatus) {
        livekitSip$SIPStatus.getClass();
        this.callStatusCode_ = livekitSip$SIPStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallStatusValue(int i) {
        this.callStatus_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAtNs(long j) {
        this.createdAtNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisconnectReason(RE3 re3) {
        this.disconnectReason_ = re3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisconnectReasonValue(int i) {
        this.disconnectReason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchRuleId(String str) {
        str.getClass();
        this.dispatchRuleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchRuleIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.dispatchRuleId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledFeatures(int i, EnumC24222yF3 enumC24222yF3) {
        enumC24222yF3.getClass();
        ensureEnabledFeaturesIsMutable();
        this.enabledFeatures_.U(i, enumC24222yF3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledFeaturesValue(int i, int i2) {
        ensureEnabledFeaturesIsMutable();
        this.enabledFeatures_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAtNs(long j) {
        this.endedAtNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFromUri(LivekitSip$SIPUri livekitSip$SIPUri) {
        livekitSip$SIPUri.getClass();
        this.fromUri_ = livekitSip$SIPUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryption(String str) {
        str.getClass();
        this.mediaEncryption_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mediaEncryption_ = abstractC2383g.f0();
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
    public void setRegion(String str) {
        str.getClass();
        this.region_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.region_ = abstractC2383g.f0();
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
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAtNs(long j) {
        this.startedAtNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToUri(LivekitSip$SIPUri livekitSip$SIPUri) {
        livekitSip$SIPUri.getClass();
        this.toUri_ = livekitSip$SIPUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunkId(String str) {
        str.getClass();
        this.trunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trunkId_ = abstractC2383g.f0();
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
                return new LivekitSip$SIPCallInfo();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0018\u0000\u0000\u0001\u0018\u0018\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\t\u0007\t\b\f\t\u0002\n\u0002\u000b\u0002\f\f\rȈ\u000e,\u000f\f\u0010Ȉ\u0011Ȉ\u00122\u0013\t\u0014Ȉ\u0015Ȉ\u0016\u0002\u0017\u0002\u0018\u0002", new Object[]{"callId_", "trunkId_", "roomName_", "roomId_", "participantIdentity_", "fromUri_", "toUri_", "callStatus_", "createdAt_", "startedAt_", "endedAt_", "disconnectReason_", "error_", "enabledFeatures_", "callDirection_", "dispatchRuleId_", "region_", "participantAttributes_", c.a, "callStatusCode_", "audioCodec_", "mediaEncryption_", "createdAtNs_", "startedAtNs_", "endedAtNs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPCallInfo.class) {
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

    public String getAudioCodec() {
        return this.audioCodec_;
    }

    public AbstractC2383g getAudioCodecBytes() {
        return AbstractC2383g.N(this.audioCodec_);
    }

    public EnumC22446vF3 getCallDirection() {
        EnumC22446vF3 enumC22446vF3J = EnumC22446vF3.j(this.callDirection_);
        return enumC22446vF3J == null ? EnumC22446vF3.UNRECOGNIZED : enumC22446vF3J;
    }

    public int getCallDirectionValue() {
        return this.callDirection_;
    }

    public String getCallId() {
        return this.callId_;
    }

    public AbstractC2383g getCallIdBytes() {
        return AbstractC2383g.N(this.callId_);
    }

    public EnumC23042wF3 getCallStatus() {
        EnumC23042wF3 enumC23042wF3J = EnumC23042wF3.j(this.callStatus_);
        return enumC23042wF3J == null ? EnumC23042wF3.UNRECOGNIZED : enumC23042wF3J;
    }

    public LivekitSip$SIPStatus getCallStatusCode() {
        LivekitSip$SIPStatus livekitSip$SIPStatus = this.callStatusCode_;
        return livekitSip$SIPStatus == null ? LivekitSip$SIPStatus.getDefaultInstance() : livekitSip$SIPStatus;
    }

    public int getCallStatusValue() {
        return this.callStatus_;
    }

    @Deprecated
    public long getCreatedAt() {
        return this.createdAt_;
    }

    public long getCreatedAtNs() {
        return this.createdAtNs_;
    }

    public RE3 getDisconnectReason() {
        RE3 re3J = RE3.j(this.disconnectReason_);
        return re3J == null ? RE3.UNRECOGNIZED : re3J;
    }

    public int getDisconnectReasonValue() {
        return this.disconnectReason_;
    }

    public String getDispatchRuleId() {
        return this.dispatchRuleId_;
    }

    public AbstractC2383g getDispatchRuleIdBytes() {
        return AbstractC2383g.N(this.dispatchRuleId_);
    }

    public EnumC24222yF3 getEnabledFeatures(int i) {
        EnumC24222yF3 enumC24222yF3J = EnumC24222yF3.j(this.enabledFeatures_.getInt(i));
        return enumC24222yF3J == null ? EnumC24222yF3.UNRECOGNIZED : enumC24222yF3J;
    }

    public int getEnabledFeaturesCount() {
        return this.enabledFeatures_.size();
    }

    public List<EnumC24222yF3> getEnabledFeaturesList() {
        return new B.h(this.enabledFeatures_, enabledFeatures_converter_);
    }

    public int getEnabledFeaturesValue(int i) {
        return this.enabledFeatures_.getInt(i);
    }

    public List<Integer> getEnabledFeaturesValueList() {
        return this.enabledFeatures_;
    }

    @Deprecated
    public long getEndedAt() {
        return this.endedAt_;
    }

    public long getEndedAtNs() {
        return this.endedAtNs_;
    }

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public LivekitSip$SIPUri getFromUri() {
        LivekitSip$SIPUri livekitSip$SIPUri = this.fromUri_;
        return livekitSip$SIPUri == null ? LivekitSip$SIPUri.getDefaultInstance() : livekitSip$SIPUri;
    }

    public String getMediaEncryption() {
        return this.mediaEncryption_;
    }

    public AbstractC2383g getMediaEncryptionBytes() {
        return AbstractC2383g.N(this.mediaEncryption_);
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

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
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

    @Deprecated
    public long getStartedAt() {
        return this.startedAt_;
    }

    public long getStartedAtNs() {
        return this.startedAtNs_;
    }

    public LivekitSip$SIPUri getToUri() {
        LivekitSip$SIPUri livekitSip$SIPUri = this.toUri_;
        return livekitSip$SIPUri == null ? LivekitSip$SIPUri.getDefaultInstance() : livekitSip$SIPUri;
    }

    public String getTrunkId() {
        return this.trunkId_;
    }

    public AbstractC2383g getTrunkIdBytes() {
        return AbstractC2383g.N(this.trunkId_);
    }

    public boolean hasCallStatusCode() {
        return this.callStatusCode_ != null;
    }

    public boolean hasFromUri() {
        return this.fromUri_ != null;
    }

    public boolean hasToUri() {
        return this.toUri_ != null;
    }

    public static b newBuilder(LivekitSip$SIPCallInfo livekitSip$SIPCallInfo) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPCallInfo);
    }

    public static LivekitSip$SIPCallInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPCallInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPCallInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPCallInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPCallInfo parseFrom(byte[] bArr) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPCallInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPCallInfo parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPCallInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPCallInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPCallInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPCallInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
