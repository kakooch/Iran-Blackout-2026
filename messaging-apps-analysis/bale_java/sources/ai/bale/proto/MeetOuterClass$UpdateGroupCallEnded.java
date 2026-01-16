package ai.bale.proto;

import ai.bale.proto.MeetStruct$GroupCall;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateGroupCallEnded extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$UpdateGroupCallEnded DEFAULT_INSTANCE;
    public static final int GROUP_CALL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MeetStruct$GroupCall groupCall_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateGroupCallEnded.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateGroupCallEnded meetOuterClass$UpdateGroupCallEnded = new MeetOuterClass$UpdateGroupCallEnded();
        DEFAULT_INSTANCE = meetOuterClass$UpdateGroupCallEnded;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateGroupCallEnded.class, meetOuterClass$UpdateGroupCallEnded);
    }

    private MeetOuterClass$UpdateGroupCallEnded() {
    }

    private void clearGroupCall() {
        this.groupCall_ = null;
        this.bitField0_ &= -2;
    }

    public static MeetOuterClass$UpdateGroupCallEnded getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static MeetOuterClass$UpdateGroupCallEnded parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupCall(MeetStruct$GroupCall meetStruct$GroupCall) {
        meetStruct$GroupCall.getClass();
        this.groupCall_ = meetStruct$GroupCall;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateGroupCallEnded();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "groupCall_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateGroupCallEnded.class) {
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

    public MeetStruct$GroupCall getGroupCall() {
        MeetStruct$GroupCall meetStruct$GroupCall = this.groupCall_;
        return meetStruct$GroupCall == null ? MeetStruct$GroupCall.getDefaultInstance() : meetStruct$GroupCall;
    }

    public boolean hasGroupCall() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$UpdateGroupCallEnded meetOuterClass$UpdateGroupCallEnded) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateGroupCallEnded);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateGroupCallEnded parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateGroupCallEnded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
