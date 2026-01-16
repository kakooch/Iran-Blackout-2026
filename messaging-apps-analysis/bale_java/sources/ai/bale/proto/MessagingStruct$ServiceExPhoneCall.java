package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MeetStruct$Call;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.K04;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExPhoneCall extends GeneratedMessageLite implements U64 {
    public static final int CALL_FIELD_NUMBER = 8;
    private static final MessagingStruct$ServiceExPhoneCall DEFAULT_INSTANCE;
    public static final int DISCARD_REASON_FIELD_NUMBER = 3;
    public static final int DURATION_FIELD_NUMBER = 1;
    public static final int EXTRA_FIELD_NUMBER = 6;
    public static final int EXT_FIELD_NUMBER = 7;
    public static final int IS_VIDEO_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int START_DATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private MeetStruct$Call call_;
    private int discardReason_;
    private int duration_;
    private BoolValue isVideo_;
    private CollectionsStruct$Int64Value startDate_;
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExPhoneCall.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    private static final class c {
        static final com.google.protobuf.I a;

        static {
            r0.b bVar = r0.b.k;
            a = com.google.protobuf.I.d(bVar, "", bVar, "");
        }
    }

    static {
        MessagingStruct$ServiceExPhoneCall messagingStruct$ServiceExPhoneCall = new MessagingStruct$ServiceExPhoneCall();
        DEFAULT_INSTANCE = messagingStruct$ServiceExPhoneCall;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExPhoneCall.class, messagingStruct$ServiceExPhoneCall);
    }

    private MessagingStruct$ServiceExPhoneCall() {
    }

    private void clearCall() {
        this.call_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDiscardReason() {
        this.discardReason_ = 0;
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearIsVideo() {
        this.isVideo_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStartDate() {
        this.startDate_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ServiceExPhoneCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private Map<String, String> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetExtra() {
        return this.extra_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExtra() {
        if (!this.extra_.n()) {
            this.extra_ = this.extra_.s();
        }
        return this.extra_;
    }

    private void mergeCall(MeetStruct$Call meetStruct$Call) {
        meetStruct$Call.getClass();
        MeetStruct$Call meetStruct$Call2 = this.call_;
        if (meetStruct$Call2 == null || meetStruct$Call2 == MeetStruct$Call.getDefaultInstance()) {
            this.call_ = meetStruct$Call;
        } else {
            this.call_ = (MeetStruct$Call) ((MeetStruct$Call.a) MeetStruct$Call.newBuilder(this.call_).v(meetStruct$Call)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeIsVideo(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isVideo_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isVideo_ = boolValue;
        } else {
            this.isVideo_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isVideo_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStartDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.startDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.startDate_ = collectionsStruct$Int64Value;
        } else {
            this.startDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.startDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExPhoneCall parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCall(MeetStruct$Call meetStruct$Call) {
        meetStruct$Call.getClass();
        this.call_ = meetStruct$Call;
        this.bitField0_ |= 4;
    }

    private void setDiscardReason(K04 k04) {
        this.discardReason_ = k04.getNumber();
    }

    private void setDiscardReasonValue(int i) {
        this.discardReason_ = i;
    }

    private void setDuration(int i) {
        this.duration_ = i;
    }

    private void setIsVideo(BoolValue boolValue) {
        boolValue.getClass();
        this.isVideo_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setStartDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.startDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Deprecated
    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExPhoneCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\b\u0007\u0002\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\f\u0005ဉ\u0001\u00062\u00072\bဉ\u0002", new Object[]{"bitField0_", "duration_", "startDate_", "discardReason_", "isVideo_", "extra_", c.a, "ext_", b.a, "call_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExPhoneCall.class) {
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

    public MeetStruct$Call getCall() {
        MeetStruct$Call meetStruct$Call = this.call_;
        return meetStruct$Call == null ? MeetStruct$Call.getDefaultInstance() : meetStruct$Call;
    }

    public K04 getDiscardReason() {
        K04 k04J = K04.j(this.discardReason_);
        return k04J == null ? K04.UNRECOGNIZED : k04J;
    }

    public int getDiscardReasonValue() {
        return this.discardReason_;
    }

    public int getDuration() {
        return this.duration_;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExt() {
        return getExtMap();
    }

    public int getExtCount() {
        return internalGetExt().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtMap() {
        return Collections.unmodifiableMap(internalGetExt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        return jInternalGetExt.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExt.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        if (jInternalGetExt.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExt.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    @Deprecated
    public int getExtraCount() {
        return internalGetExtra().size();
    }

    @Deprecated
    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        return jInternalGetExtra.containsKey(str) ? (String) jInternalGetExtra.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getExtraOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        if (jInternalGetExtra.containsKey(str)) {
            return (String) jInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    public BoolValue getIsVideo() {
        BoolValue boolValue = this.isVideo_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public CollectionsStruct$Int64Value getStartDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.startDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasCall() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIsVideo() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ServiceExPhoneCall messagingStruct$ServiceExPhoneCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExPhoneCall);
    }

    public static MessagingStruct$ServiceExPhoneCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExPhoneCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExPhoneCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
