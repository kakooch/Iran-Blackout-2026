package ai.bale.proto;

import ai.bale.proto.MeetStruct$GroupCall;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExGroupCallStarted extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExGroupCallStarted DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 2;
    public static final int EXT_FIELD_NUMBER = 3;
    public static final int GROUP_CALL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MeetStruct$GroupCall groupCall_;
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExGroupCallStarted.DEFAULT_INSTANCE);
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
        MessagingStruct$ServiceExGroupCallStarted messagingStruct$ServiceExGroupCallStarted = new MessagingStruct$ServiceExGroupCallStarted();
        DEFAULT_INSTANCE = messagingStruct$ServiceExGroupCallStarted;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExGroupCallStarted.class, messagingStruct$ServiceExGroupCallStarted);
    }

    private MessagingStruct$ServiceExGroupCallStarted() {
    }

    private void clearGroupCall() {
        this.groupCall_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ServiceExGroupCallStarted getDefaultInstance() {
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

    private void mergeGroupCall(MeetStruct$GroupCall meetStruct$GroupCall) {
        meetStruct$GroupCall.getClass();
        MeetStruct$GroupCall meetStruct$GroupCall2 = this.groupCall_;
        if (meetStruct$GroupCall2 == null || meetStruct$GroupCall2 == MeetStruct$GroupCall.getDefaultInstance()) {
            this.groupCall_ = meetStruct$GroupCall;
        } else {
            this.groupCall_ = (MeetStruct$GroupCall) ((MeetStruct$GroupCall.a) MeetStruct$GroupCall.newBuilder(this.groupCall_).v(meetStruct$GroupCall)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupCall(MeetStruct$GroupCall meetStruct$GroupCall) {
        meetStruct$GroupCall.getClass();
        this.groupCall_ = meetStruct$GroupCall;
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
                return new MessagingStruct$ServiceExGroupCallStarted();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0002\u0000\u0000\u0001ဉ\u0000\u00022\u00032", new Object[]{"bitField0_", "groupCall_", "extra_", c.a, "ext_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExGroupCallStarted.class) {
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

    public MeetStruct$GroupCall getGroupCall() {
        MeetStruct$GroupCall meetStruct$GroupCall = this.groupCall_;
        return meetStruct$GroupCall == null ? MeetStruct$GroupCall.getDefaultInstance() : meetStruct$GroupCall;
    }

    public boolean hasGroupCall() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ServiceExGroupCallStarted messagingStruct$ServiceExGroupCallStarted) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExGroupCallStarted);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExGroupCallStarted parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExGroupCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
