package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.L04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateCallEvent extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdateCallEvent DEFAULT_INSTANCE;
    public static final int EXTRA_DATA_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TRIGGERER_IDENTITY_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 3;
    private long callId_;
    private com.google.protobuf.J extraData_ = com.google.protobuf.J.e();
    private String triggererIdentity_ = "";
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallEvent.DEFAULT_INSTANCE);
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
        MeetOuterClass$UpdateCallEvent meetOuterClass$UpdateCallEvent = new MeetOuterClass$UpdateCallEvent();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallEvent;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallEvent.class, meetOuterClass$UpdateCallEvent);
    }

    private MeetOuterClass$UpdateCallEvent() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearTriggererIdentity() {
        this.triggererIdentity_ = getDefaultInstance().getTriggererIdentity();
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static MeetOuterClass$UpdateCallEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, String> getMutableExtraDataMap() {
        return internalGetMutableExtraData();
    }

    private com.google.protobuf.J internalGetExtraData() {
        return this.extraData_;
    }

    private com.google.protobuf.J internalGetMutableExtraData() {
        if (!this.extraData_.n()) {
            this.extraData_ = this.extraData_.s();
        }
        return this.extraData_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallEvent parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setTriggererIdentity(String str) {
        str.getClass();
        this.triggererIdentity_ = str;
    }

    private void setTriggererIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.triggererIdentity_ = abstractC2383g.f0();
    }

    private void setType(L04 l04) {
        this.type_ = l04.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    public boolean containsExtraData(String str) {
        str.getClass();
        return internalGetExtraData().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallEvent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\f\u00042", new Object[]{"callId_", "triggererIdentity_", "type_", "extraData_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallEvent.class) {
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

    @Deprecated
    public Map<String, String> getExtraData() {
        return getExtraDataMap();
    }

    public int getExtraDataCount() {
        return internalGetExtraData().size();
    }

    public Map<String, String> getExtraDataMap() {
        return Collections.unmodifiableMap(internalGetExtraData());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getExtraDataOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtraData = internalGetExtraData();
        return jInternalGetExtraData.containsKey(str) ? (String) jInternalGetExtraData.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getExtraDataOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtraData = internalGetExtraData();
        if (jInternalGetExtraData.containsKey(str)) {
            return (String) jInternalGetExtraData.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getTriggererIdentity() {
        return this.triggererIdentity_;
    }

    public AbstractC2383g getTriggererIdentityBytes() {
        return AbstractC2383g.N(this.triggererIdentity_);
    }

    public L04 getType() {
        L04 l04J = L04.j(this.type_);
        return l04J == null ? L04.UNRECOGNIZED : l04J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallEvent meetOuterClass$UpdateCallEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallEvent);
    }

    public static MeetOuterClass$UpdateCallEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
