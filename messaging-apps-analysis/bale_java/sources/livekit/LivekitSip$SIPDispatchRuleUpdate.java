package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.BF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import livekit.LivekitModels$ListUpdate;
import livekit.LivekitSip$SIPDispatchRule;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPDispatchRuleUpdate extends GeneratedMessageLite implements U64 {
    public static final int ATTRIBUTES_FIELD_NUMBER = 5;
    private static final LivekitSip$SIPDispatchRuleUpdate DEFAULT_INSTANCE;
    public static final int MEDIA_ENCRYPTION_FIELD_NUMBER = 6;
    public static final int METADATA_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RULE_FIELD_NUMBER = 2;
    public static final int TRUNK_IDS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int mediaEncryption_;
    private LivekitSip$SIPDispatchRule rule_;
    private LivekitModels$ListUpdate trunkIds_;
    private J attributes_ = J.e();
    private String name_ = "";
    private String metadata_ = "";

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
            super(LivekitSip$SIPDispatchRuleUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPDispatchRuleUpdate livekitSip$SIPDispatchRuleUpdate = new LivekitSip$SIPDispatchRuleUpdate();
        DEFAULT_INSTANCE = livekitSip$SIPDispatchRuleUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPDispatchRuleUpdate.class, livekitSip$SIPDispatchRuleUpdate);
    }

    private LivekitSip$SIPDispatchRuleUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaEncryption() {
        this.bitField0_ &= -5;
        this.mediaEncryption_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.bitField0_ &= -3;
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRule() {
        this.rule_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunkIds() {
        this.trunkIds_ = null;
    }

    public static LivekitSip$SIPDispatchRuleUpdate getDefaultInstance() {
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
    public void mergeRule(LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule) {
        livekitSip$SIPDispatchRule.getClass();
        LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule2 = this.rule_;
        if (livekitSip$SIPDispatchRule2 == null || livekitSip$SIPDispatchRule2 == LivekitSip$SIPDispatchRule.getDefaultInstance()) {
            this.rule_ = livekitSip$SIPDispatchRule;
        } else {
            this.rule_ = (LivekitSip$SIPDispatchRule) ((LivekitSip$SIPDispatchRule.a) LivekitSip$SIPDispatchRule.newBuilder(this.rule_).v(livekitSip$SIPDispatchRule)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrunkIds(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        LivekitModels$ListUpdate livekitModels$ListUpdate2 = this.trunkIds_;
        if (livekitModels$ListUpdate2 == null || livekitModels$ListUpdate2 == LivekitModels$ListUpdate.getDefaultInstance()) {
            this.trunkIds_ = livekitModels$ListUpdate;
        } else {
            this.trunkIds_ = (LivekitModels$ListUpdate) ((LivekitModels$ListUpdate.a) LivekitModels$ListUpdate.newBuilder(this.trunkIds_).v(livekitModels$ListUpdate)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryption(BF3 bf3) {
        this.mediaEncryption_ = bf3.getNumber();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryptionValue(int i) {
        this.bitField0_ |= 4;
        this.mediaEncryption_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRule(LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule) {
        livekitSip$SIPDispatchRule.getClass();
        this.rule_ = livekitSip$SIPDispatchRule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunkIds(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        this.trunkIds_ = livekitModels$ListUpdate;
    }

    public boolean containsAttributes(String str) {
        str.getClass();
        return internalGetAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPDispatchRuleUpdate();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0001\u0000\u0000\u0001\t\u0002\t\u0003ለ\u0000\u0004ለ\u0001\u00052\u0006ဌ\u0002", new Object[]{"bitField0_", "trunkIds_", "rule_", "name_", "metadata_", "attributes_", a.a, "mediaEncryption_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPDispatchRuleUpdate.class) {
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

    public int getAttributesCount() {
        return internalGetAttributes().size();
    }

    public Map<String, String> getAttributesMap() {
        return Collections.unmodifiableMap(internalGetAttributes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAttributesOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetAttributes = internalGetAttributes();
        return jInternalGetAttributes.containsKey(str) ? (String) jInternalGetAttributes.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAttributesOrThrow(String str) {
        str.getClass();
        J jInternalGetAttributes = internalGetAttributes();
        if (jInternalGetAttributes.containsKey(str)) {
            return (String) jInternalGetAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public BF3 getMediaEncryption() {
        BF3 bf3J = BF3.j(this.mediaEncryption_);
        return bf3J == null ? BF3.UNRECOGNIZED : bf3J;
    }

    public int getMediaEncryptionValue() {
        return this.mediaEncryption_;
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public LivekitSip$SIPDispatchRule getRule() {
        LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule = this.rule_;
        return livekitSip$SIPDispatchRule == null ? LivekitSip$SIPDispatchRule.getDefaultInstance() : livekitSip$SIPDispatchRule;
    }

    public LivekitModels$ListUpdate getTrunkIds() {
        LivekitModels$ListUpdate livekitModels$ListUpdate = this.trunkIds_;
        return livekitModels$ListUpdate == null ? LivekitModels$ListUpdate.getDefaultInstance() : livekitModels$ListUpdate;
    }

    public boolean hasMediaEncryption() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMetadata() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRule() {
        return this.rule_ != null;
    }

    public boolean hasTrunkIds() {
        return this.trunkIds_ != null;
    }

    public static b newBuilder(LivekitSip$SIPDispatchRuleUpdate livekitSip$SIPDispatchRuleUpdate) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPDispatchRuleUpdate);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(byte[] bArr) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPDispatchRuleUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
