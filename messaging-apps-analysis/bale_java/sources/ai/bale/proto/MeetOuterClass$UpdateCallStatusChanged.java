package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.Q04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateCallStatusChanged extends GeneratedMessageLite implements U64 {
    public static final int CALLSTATUS_FIELD_NUMBER = 2;
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdateCallStatusChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long callId_;
    private int callStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallStatusChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallStatusChanged meetOuterClass$UpdateCallStatusChanged = new MeetOuterClass$UpdateCallStatusChanged();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallStatusChanged;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallStatusChanged.class, meetOuterClass$UpdateCallStatusChanged);
    }

    private MeetOuterClass$UpdateCallStatusChanged() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearCallStatus() {
        this.callStatus_ = 0;
    }

    public static MeetOuterClass$UpdateCallStatusChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setCallStatus(Q04 q04) {
        this.callStatus_ = q04.getNumber();
    }

    private void setCallStatusValue(int i) {
        this.callStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallStatusChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\f", new Object[]{"callId_", "callStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallStatusChanged.class) {
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

    public Q04 getCallStatus() {
        Q04 q04J = Q04.j(this.callStatus_);
        return q04J == null ? Q04.UNRECOGNIZED : q04J;
    }

    public int getCallStatusValue() {
        return this.callStatus_;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallStatusChanged meetOuterClass$UpdateCallStatusChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallStatusChanged);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallStatusChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallStatusChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
