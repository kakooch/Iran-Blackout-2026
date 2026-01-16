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
public final class MeetOuterClass$ResponseGenerateCallLink extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$ResponseGenerateCallLink DEFAULT_INSTANCE;
    public static final int GROUP_CALL_FIELD_NUMBER = 1;
    public static final int LINK_EXPIRATION_PERIOD_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MeetStruct$GroupCall groupCall_;
    private long linkExpirationPeriod_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$ResponseGenerateCallLink.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$ResponseGenerateCallLink meetOuterClass$ResponseGenerateCallLink = new MeetOuterClass$ResponseGenerateCallLink();
        DEFAULT_INSTANCE = meetOuterClass$ResponseGenerateCallLink;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$ResponseGenerateCallLink.class, meetOuterClass$ResponseGenerateCallLink);
    }

    private MeetOuterClass$ResponseGenerateCallLink() {
    }

    private void clearGroupCall() {
        this.groupCall_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLinkExpirationPeriod() {
        this.linkExpirationPeriod_ = 0L;
    }

    public static MeetOuterClass$ResponseGenerateCallLink getDefaultInstance() {
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

    public static MeetOuterClass$ResponseGenerateCallLink parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupCall(MeetStruct$GroupCall meetStruct$GroupCall) {
        meetStruct$GroupCall.getClass();
        this.groupCall_ = meetStruct$GroupCall;
        this.bitField0_ |= 1;
    }

    private void setLinkExpirationPeriod(long j) {
        this.linkExpirationPeriod_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$ResponseGenerateCallLink();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002", new Object[]{"bitField0_", "groupCall_", "linkExpirationPeriod_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$ResponseGenerateCallLink.class) {
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

    public long getLinkExpirationPeriod() {
        return this.linkExpirationPeriod_;
    }

    public boolean hasGroupCall() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$ResponseGenerateCallLink meetOuterClass$ResponseGenerateCallLink) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$ResponseGenerateCallLink);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(byte[] bArr) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$ResponseGenerateCallLink parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$ResponseGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
