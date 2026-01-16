package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateCallJoinRequestAnswered extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 2;
    private static final MeetOuterClass$UpdateCallJoinRequestAnswered DEFAULT_INSTANCE;
    public static final int IS_ALLOWED_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long callId_;
    private boolean isAllowed_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallJoinRequestAnswered.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallJoinRequestAnswered meetOuterClass$UpdateCallJoinRequestAnswered = new MeetOuterClass$UpdateCallJoinRequestAnswered();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallJoinRequestAnswered;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallJoinRequestAnswered.class, meetOuterClass$UpdateCallJoinRequestAnswered);
    }

    private MeetOuterClass$UpdateCallJoinRequestAnswered() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearIsAllowed() {
        this.isAllowed_ = false;
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setIsAllowed(boolean z) {
        this.isAllowed_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallJoinRequestAnswered();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002\u0002", new Object[]{"isAllowed_", "callId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallJoinRequestAnswered.class) {
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

    public boolean getIsAllowed() {
        return this.isAllowed_;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallJoinRequestAnswered meetOuterClass$UpdateCallJoinRequestAnswered) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallJoinRequestAnswered);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallJoinRequestAnswered parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestAnswered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
