package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.J04;
import ir.nasim.KW4;
import ir.nasim.P04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestSubmitCallFeedback extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    public static final int CLIENT_FIELD_NUMBER = 4;
    public static final int CLIENT_VERSION_FIELD_NUMBER = 5;
    private static final MeetOuterClass$RequestSubmitCallFeedback DEFAULT_INSTANCE;
    public static final int EXTRA_FIELDS_FIELD_NUMBER = 6;
    public static final int IS_STREAM_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int RATE_FIELD_NUMBER = 2;
    public static final int USER_OPINION_FIELD_NUMBER = 3;
    private int bitField0_;
    private long callId_;
    private CollectionsStruct$StringValue clientVersion_;
    private int client_;
    private com.google.protobuf.J extraFields_ = com.google.protobuf.J.e();
    private CollectionsStruct$BooleanValue isStream_;
    private int rate_;
    private CollectionsStruct$StringValue userOpinion_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Map map) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).getMutableExtraFieldsMap().putAll(map);
            return this;
        }

        public a B(long j) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).setCallId(j);
            return this;
        }

        public a C(J04 j04) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).setClient(j04);
            return this;
        }

        public a D(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).setClientVersion(collectionsStruct$StringValue);
            return this;
        }

        public a E(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).setIsStream(collectionsStruct$BooleanValue);
            return this;
        }

        public a F(int i) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).setRateValue(i);
            return this;
        }

        public a G(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((MeetOuterClass$RequestSubmitCallFeedback) this.b).setUserOpinion(collectionsStruct$StringValue);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestSubmitCallFeedback.DEFAULT_INSTANCE);
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
        MeetOuterClass$RequestSubmitCallFeedback meetOuterClass$RequestSubmitCallFeedback = new MeetOuterClass$RequestSubmitCallFeedback();
        DEFAULT_INSTANCE = meetOuterClass$RequestSubmitCallFeedback;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestSubmitCallFeedback.class, meetOuterClass$RequestSubmitCallFeedback);
    }

    private MeetOuterClass$RequestSubmitCallFeedback() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearClient() {
        this.client_ = 0;
    }

    private void clearClientVersion() {
        this.clientVersion_ = null;
        this.bitField0_ &= -3;
    }

    private void clearIsStream() {
        this.isStream_ = null;
        this.bitField0_ &= -5;
    }

    private void clearRate() {
        this.rate_ = 0;
    }

    private void clearUserOpinion() {
        this.userOpinion_ = null;
        this.bitField0_ &= -2;
    }

    public static MeetOuterClass$RequestSubmitCallFeedback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableExtraFieldsMap() {
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

    private void mergeIsStream(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isStream_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isStream_ = collectionsStruct$BooleanValue;
        } else {
            this.isStream_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isStream_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 4;
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

    public static MeetOuterClass$RequestSubmitCallFeedback parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClient(J04 j04) {
        this.client_ = j04.getNumber();
    }

    private void setClientValue(int i) {
        this.client_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientVersion(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.clientVersion_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsStream(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isStream_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 4;
    }

    private void setRate(P04 p04) {
        this.rate_ = p04.getNumber();
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
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestSubmitCallFeedback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001\u0002\u0002\f\u0003ဉ\u0000\u0004\f\u0005ဉ\u0001\u00062\u0007ဉ\u0002", new Object[]{"bitField0_", "callId_", "rate_", "userOpinion_", "client_", "clientVersion_", "extraFields_", b.a, "isStream_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestSubmitCallFeedback.class) {
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

    public long getCallId() {
        return this.callId_;
    }

    public J04 getClient() {
        J04 j04J = J04.j(this.client_);
        return j04J == null ? J04.UNRECOGNIZED : j04J;
    }

    public int getClientValue() {
        return this.client_;
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

    public CollectionsStruct$BooleanValue getIsStream() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isStream_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public P04 getRate() {
        P04 p04J = P04.j(this.rate_);
        return p04J == null ? P04.UNRECOGNIZED : p04J;
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

    public boolean hasIsStream() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasUserOpinion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestSubmitCallFeedback meetOuterClass$RequestSubmitCallFeedback) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestSubmitCallFeedback);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestSubmitCallFeedback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestSubmitCallFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
