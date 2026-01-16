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
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import livekit.LivekitRoom$RoomConfiguration;
import livekit.LivekitSip$SIPDispatchRule;
import livekit.LivekitSip$SIPDispatchRuleInfo;

/* loaded from: classes8.dex */
public final class LivekitSip$CreateSIPDispatchRuleRequest extends GeneratedMessageLite implements U64 {
    public static final int ATTRIBUTES_FIELD_NUMBER = 7;
    private static final LivekitSip$CreateSIPDispatchRuleRequest DEFAULT_INSTANCE;
    public static final int DISPATCH_RULE_FIELD_NUMBER = 10;
    public static final int HIDE_PHONE_NUMBER_FIELD_NUMBER = 3;
    public static final int INBOUND_NUMBERS_FIELD_NUMBER = 6;
    public static final int METADATA_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_CONFIG_FIELD_NUMBER = 9;
    public static final int ROOM_PRESET_FIELD_NUMBER = 8;
    public static final int RULE_FIELD_NUMBER = 1;
    public static final int TRUNK_IDS_FIELD_NUMBER = 2;
    private LivekitSip$SIPDispatchRuleInfo dispatchRule_;
    private boolean hidePhoneNumber_;
    private LivekitRoom$RoomConfiguration roomConfig_;
    private LivekitSip$SIPDispatchRule rule_;
    private J attributes_ = J.e();
    private B.j trunkIds_ = GeneratedMessageLite.emptyProtobufList();
    private B.j inboundNumbers_ = GeneratedMessageLite.emptyProtobufList();
    private String name_ = "";
    private String metadata_ = "";
    private String roomPreset_ = "";

    private static final class a {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(t tVar) {
            this();
        }

        private b() {
            super(LivekitSip$CreateSIPDispatchRuleRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$CreateSIPDispatchRuleRequest livekitSip$CreateSIPDispatchRuleRequest = new LivekitSip$CreateSIPDispatchRuleRequest();
        DEFAULT_INSTANCE = livekitSip$CreateSIPDispatchRuleRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$CreateSIPDispatchRuleRequest.class, livekitSip$CreateSIPDispatchRuleRequest);
    }

    private LivekitSip$CreateSIPDispatchRuleRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllInboundNumbers(Iterable<String> iterable) {
        ensureInboundNumbersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.inboundNumbers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrunkIds(Iterable<String> iterable) {
        ensureTrunkIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trunkIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundNumbers(String str) {
        str.getClass();
        ensureInboundNumbersIsMutable();
        this.inboundNumbers_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundNumbersBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureInboundNumbersIsMutable();
        this.inboundNumbers_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrunkIds(String str) {
        str.getClass();
        ensureTrunkIdsIsMutable();
        this.trunkIds_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrunkIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureTrunkIdsIsMutable();
        this.trunkIds_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchRule() {
        this.dispatchRule_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHidePhoneNumber() {
        this.hidePhoneNumber_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInboundNumbers() {
        this.inboundNumbers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomConfig() {
        this.roomConfig_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomPreset() {
        this.roomPreset_ = getDefaultInstance().getRoomPreset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRule() {
        this.rule_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunkIds() {
        this.trunkIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureInboundNumbersIsMutable() {
        B.j jVar = this.inboundNumbers_;
        if (jVar.u()) {
            return;
        }
        this.inboundNumbers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTrunkIdsIsMutable() {
        B.j jVar = this.trunkIds_;
        if (jVar.u()) {
            return;
        }
        this.trunkIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableAttributesMap() {
        return internalGetMutableAttributes();
    }

    private J internalGetAttributes() {
        return this.attributes_;
    }

    private J internalGetMutableAttributes() {
        if (!this.attributes_.n()) {
            this.attributes_ = this.attributes_.s();
        }
        return this.attributes_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDispatchRule(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo2 = this.dispatchRule_;
        if (livekitSip$SIPDispatchRuleInfo2 == null || livekitSip$SIPDispatchRuleInfo2 == LivekitSip$SIPDispatchRuleInfo.getDefaultInstance()) {
            this.dispatchRule_ = livekitSip$SIPDispatchRuleInfo;
        } else {
            this.dispatchRule_ = (LivekitSip$SIPDispatchRuleInfo) ((LivekitSip$SIPDispatchRuleInfo.b) LivekitSip$SIPDispatchRuleInfo.newBuilder(this.dispatchRule_).v(livekitSip$SIPDispatchRuleInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoomConfig(LivekitRoom$RoomConfiguration livekitRoom$RoomConfiguration) {
        livekitRoom$RoomConfiguration.getClass();
        LivekitRoom$RoomConfiguration livekitRoom$RoomConfiguration2 = this.roomConfig_;
        if (livekitRoom$RoomConfiguration2 == null || livekitRoom$RoomConfiguration2 == LivekitRoom$RoomConfiguration.getDefaultInstance()) {
            this.roomConfig_ = livekitRoom$RoomConfiguration;
        } else {
            this.roomConfig_ = (LivekitRoom$RoomConfiguration) ((LivekitRoom$RoomConfiguration.a) LivekitRoom$RoomConfiguration.newBuilder(this.roomConfig_).v(livekitRoom$RoomConfiguration)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRule(LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule) {
        livekitSip$SIPDispatchRule.getClass();
        LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule2 = this.rule_;
        if (livekitSip$SIPDispatchRule2 == null || livekitSip$SIPDispatchRule2 == LivekitSip$SIPDispatchRule.getDefaultInstance()) {
            this.rule_ = livekitSip$SIPDispatchRule;
        } else {
            this.rule_ = (LivekitSip$SIPDispatchRule) ((LivekitSip$SIPDispatchRule.a) LivekitSip$SIPDispatchRule.newBuilder(this.rule_).v(livekitSip$SIPDispatchRule)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchRule(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        this.dispatchRule_ = livekitSip$SIPDispatchRuleInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHidePhoneNumber(boolean z) {
        this.hidePhoneNumber_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundNumbers(int i, String str) {
        str.getClass();
        ensureInboundNumbersIsMutable();
        this.inboundNumbers_.set(i, str);
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
    public void setRoomConfig(LivekitRoom$RoomConfiguration livekitRoom$RoomConfiguration) {
        livekitRoom$RoomConfiguration.getClass();
        this.roomConfig_ = livekitRoom$RoomConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomPreset(String str) {
        str.getClass();
        this.roomPreset_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomPresetBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomPreset_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRule(LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule) {
        livekitSip$SIPDispatchRule.getClass();
        this.rule_ = livekitSip$SIPDispatchRule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunkIds(int i, String str) {
        str.getClass();
        ensureTrunkIdsIsMutable();
        this.trunkIds_.set(i, str);
    }

    @Deprecated
    public boolean containsAttributes(String str) {
        str.getClass();
        return internalGetAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$CreateSIPDispatchRuleRequest();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0002\u0000\u0001\t\u0002Ț\u0003\u0007\u0004Ȉ\u0005Ȉ\u0006Ț\u00072\bȈ\t\t\n\t", new Object[]{"rule_", "trunkIds_", "hidePhoneNumber_", "name_", "metadata_", "inboundNumbers_", "attributes_", a.a, "roomPreset_", "roomConfig_", "dispatchRule_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$CreateSIPDispatchRuleRequest.class) {
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
    public Map<String, String> getAttributes() {
        return getAttributesMap();
    }

    @Deprecated
    public int getAttributesCount() {
        return internalGetAttributes().size();
    }

    @Deprecated
    public Map<String, String> getAttributesMap() {
        return Collections.unmodifiableMap(internalGetAttributes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getAttributesOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetAttributes = internalGetAttributes();
        return jInternalGetAttributes.containsKey(str) ? (String) jInternalGetAttributes.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getAttributesOrThrow(String str) {
        str.getClass();
        J jInternalGetAttributes = internalGetAttributes();
        if (jInternalGetAttributes.containsKey(str)) {
            return (String) jInternalGetAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public LivekitSip$SIPDispatchRuleInfo getDispatchRule() {
        LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo = this.dispatchRule_;
        return livekitSip$SIPDispatchRuleInfo == null ? LivekitSip$SIPDispatchRuleInfo.getDefaultInstance() : livekitSip$SIPDispatchRuleInfo;
    }

    @Deprecated
    public boolean getHidePhoneNumber() {
        return this.hidePhoneNumber_;
    }

    @Deprecated
    public String getInboundNumbers(int i) {
        return (String) this.inboundNumbers_.get(i);
    }

    @Deprecated
    public AbstractC2383g getInboundNumbersBytes(int i) {
        return AbstractC2383g.N((String) this.inboundNumbers_.get(i));
    }

    @Deprecated
    public int getInboundNumbersCount() {
        return this.inboundNumbers_.size();
    }

    @Deprecated
    public List<String> getInboundNumbersList() {
        return this.inboundNumbers_;
    }

    @Deprecated
    public String getMetadata() {
        return this.metadata_;
    }

    @Deprecated
    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    @Deprecated
    public String getName() {
        return this.name_;
    }

    @Deprecated
    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    @Deprecated
    public LivekitRoom$RoomConfiguration getRoomConfig() {
        LivekitRoom$RoomConfiguration livekitRoom$RoomConfiguration = this.roomConfig_;
        return livekitRoom$RoomConfiguration == null ? LivekitRoom$RoomConfiguration.getDefaultInstance() : livekitRoom$RoomConfiguration;
    }

    @Deprecated
    public String getRoomPreset() {
        return this.roomPreset_;
    }

    @Deprecated
    public AbstractC2383g getRoomPresetBytes() {
        return AbstractC2383g.N(this.roomPreset_);
    }

    @Deprecated
    public LivekitSip$SIPDispatchRule getRule() {
        LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule = this.rule_;
        return livekitSip$SIPDispatchRule == null ? LivekitSip$SIPDispatchRule.getDefaultInstance() : livekitSip$SIPDispatchRule;
    }

    @Deprecated
    public String getTrunkIds(int i) {
        return (String) this.trunkIds_.get(i);
    }

    @Deprecated
    public AbstractC2383g getTrunkIdsBytes(int i) {
        return AbstractC2383g.N((String) this.trunkIds_.get(i));
    }

    @Deprecated
    public int getTrunkIdsCount() {
        return this.trunkIds_.size();
    }

    @Deprecated
    public List<String> getTrunkIdsList() {
        return this.trunkIds_;
    }

    public boolean hasDispatchRule() {
        return this.dispatchRule_ != null;
    }

    @Deprecated
    public boolean hasRoomConfig() {
        return this.roomConfig_ != null;
    }

    @Deprecated
    public boolean hasRule() {
        return this.rule_ != null;
    }

    public static b newBuilder(LivekitSip$CreateSIPDispatchRuleRequest livekitSip$CreateSIPDispatchRuleRequest) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$CreateSIPDispatchRuleRequest);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(byte[] bArr) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$CreateSIPDispatchRuleRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$CreateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
