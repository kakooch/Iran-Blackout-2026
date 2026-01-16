package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.K04;
import ir.nasim.KW4;
import ir.nasim.R04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestDiscardCall extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestDiscardCall DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 4;
    private long callId_;
    private int duration_;
    private int reason_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestDiscardCall) this.b).setCallId(j);
            return this;
        }

        public a B(int i) {
            q();
            ((MeetOuterClass$RequestDiscardCall) this.b).setDuration(i);
            return this;
        }

        public a C(K04 k04) {
            q();
            ((MeetOuterClass$RequestDiscardCall) this.b).setReason(k04);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestDiscardCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestDiscardCall meetOuterClass$RequestDiscardCall = new MeetOuterClass$RequestDiscardCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestDiscardCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestDiscardCall.class, meetOuterClass$RequestDiscardCall);
    }

    private MeetOuterClass$RequestDiscardCall() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static MeetOuterClass$RequestDiscardCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestDiscardCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(int i) {
        this.duration_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(K04 k04) {
        this.reason_ = k04.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    private void setType(R04 r04) {
        this.type_ = r04.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestDiscardCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\f\u0004\f", new Object[]{"callId_", "duration_", "reason_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestDiscardCall.class) {
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

    public int getDuration() {
        return this.duration_;
    }

    public K04 getReason() {
        K04 k04J = K04.j(this.reason_);
        return k04J == null ? K04.UNRECOGNIZED : k04J;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public R04 getType() {
        R04 r04J = R04.j(this.type_);
        return r04J == null ? R04.UNRECOGNIZED : r04J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(MeetOuterClass$RequestDiscardCall meetOuterClass$RequestDiscardCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestDiscardCall);
    }

    public static MeetOuterClass$RequestDiscardCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestDiscardCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestDiscardCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
