package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.RT3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestSubmitMarketFeedback extends GeneratedMessageLite implements U64 {
    public static final int CLIENT_VERSION_FIELD_NUMBER = 3;
    private static final MarketOuterClass$RequestSubmitMarketFeedback DEFAULT_INSTANCE;
    public static final int EXTRA_FIELDS_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int RATE_FIELD_NUMBER = 1;
    public static final int USER_OPINION_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$StringValue clientVersion_;
    private com.google.protobuf.J extraFields_ = com.google.protobuf.J.e();
    private int rate_;
    private CollectionsStruct$StringValue userOpinion_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((MarketOuterClass$RequestSubmitMarketFeedback) this.b).setClientVersion(collectionsStruct$StringValue);
            return this;
        }

        public a B(RT3 rt3) {
            q();
            ((MarketOuterClass$RequestSubmitMarketFeedback) this.b).setRate(rt3);
            return this;
        }

        public a C(int i) {
            q();
            ((MarketOuterClass$RequestSubmitMarketFeedback) this.b).setRateValue(i);
            return this;
        }

        public a D(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((MarketOuterClass$RequestSubmitMarketFeedback) this.b).setUserOpinion(collectionsStruct$StringValue);
            return this;
        }

        private a() {
            super(MarketOuterClass$RequestSubmitMarketFeedback.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a;

        static {
            r0.b bVar = r0.b.k;
            a = com.google.protobuf.I.d(bVar, "", bVar, "");
        }
    }

    static {
        MarketOuterClass$RequestSubmitMarketFeedback marketOuterClass$RequestSubmitMarketFeedback = new MarketOuterClass$RequestSubmitMarketFeedback();
        DEFAULT_INSTANCE = marketOuterClass$RequestSubmitMarketFeedback;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestSubmitMarketFeedback.class, marketOuterClass$RequestSubmitMarketFeedback);
    }

    private MarketOuterClass$RequestSubmitMarketFeedback() {
    }

    private void clearClientVersion() {
        this.clientVersion_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRate() {
        this.rate_ = 0;
    }

    private void clearUserOpinion() {
        this.userOpinion_ = null;
        this.bitField0_ &= -2;
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, String> getMutableExtraFieldsMap() {
        return internalGetMutableExtraFields();
    }

    private com.google.protobuf.J internalGetExtraFields() {
        return this.extraFields_;
    }

    private com.google.protobuf.J internalGetMutableExtraFields() {
        if (!this.extraFields_.n()) {
            this.extraFields_ = this.extraFields_.s();
        }
        return this.extraFields_;
    }

    private void mergeClientVersion(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.clientVersion_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.clientVersion_ = collectionsStruct$StringValue;
        } else {
            this.clientVersion_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.clientVersion_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUserOpinion(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.userOpinion_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.userOpinion_ = collectionsStruct$StringValue;
        } else {
            this.userOpinion_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.userOpinion_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientVersion(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.clientVersion_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRate(RT3 rt3) {
        this.rate_ = rt3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRateValue(int i) {
        this.rate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserOpinion(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.userOpinion_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    public boolean containsExtraFields(String str) {
        str.getClass();
        return internalGetExtraFields().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestSubmitMarketFeedback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0001\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001\u00042", new Object[]{"bitField0_", "rate_", "userOpinion_", "clientVersion_", "extraFields_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestSubmitMarketFeedback.class) {
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

    public CollectionsStruct$StringValue getClientVersion() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.clientVersion_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    @Deprecated
    public Map<String, String> getExtraFields() {
        return getExtraFieldsMap();
    }

    public int getExtraFieldsCount() {
        return internalGetExtraFields().size();
    }

    public Map<String, String> getExtraFieldsMap() {
        return Collections.unmodifiableMap(internalGetExtraFields());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getExtraFieldsOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtraFields = internalGetExtraFields();
        return jInternalGetExtraFields.containsKey(str) ? (String) jInternalGetExtraFields.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getExtraFieldsOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtraFields = internalGetExtraFields();
        if (jInternalGetExtraFields.containsKey(str)) {
            return (String) jInternalGetExtraFields.get(str);
        }
        throw new IllegalArgumentException();
    }

    public RT3 getRate() {
        RT3 rt3J = RT3.j(this.rate_);
        return rt3J == null ? RT3.UNRECOGNIZED : rt3J;
    }

    public int getRateValue() {
        return this.rate_;
    }

    public CollectionsStruct$StringValue getUserOpinion() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.userOpinion_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasClientVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUserOpinion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$RequestSubmitMarketFeedback marketOuterClass$RequestSubmitMarketFeedback) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestSubmitMarketFeedback);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestSubmitMarketFeedback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestSubmitMarketFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
