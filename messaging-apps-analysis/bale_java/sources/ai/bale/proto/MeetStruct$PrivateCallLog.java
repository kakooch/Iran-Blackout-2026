package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC13908h14;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetStruct$PrivateCallLog extends GeneratedMessageLite implements U64 {
    private static final MeetStruct$PrivateCallLog DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$PrivateCallLog.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$PrivateCallLog meetStruct$PrivateCallLog = new MeetStruct$PrivateCallLog();
        DEFAULT_INSTANCE = meetStruct$PrivateCallLog;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$PrivateCallLog.class, meetStruct$PrivateCallLog);
    }

    private MeetStruct$PrivateCallLog() {
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    public static MeetStruct$PrivateCallLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$PrivateCallLog parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$PrivateCallLog parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStatus(EnumC13908h14 enumC13908h14) {
        this.status_ = enumC13908h14.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$PrivateCallLog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$PrivateCallLog.class) {
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

    public EnumC13908h14 getStatus() {
        EnumC13908h14 enumC13908h14J = EnumC13908h14.j(this.status_);
        return enumC13908h14J == null ? EnumC13908h14.UNRECOGNIZED : enumC13908h14J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(MeetStruct$PrivateCallLog meetStruct$PrivateCallLog) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$PrivateCallLog);
    }

    public static MeetStruct$PrivateCallLog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$PrivateCallLog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$PrivateCallLog parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$PrivateCallLog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$PrivateCallLog parseFrom(byte[] bArr) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$PrivateCallLog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$PrivateCallLog parseFrom(InputStream inputStream) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$PrivateCallLog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$PrivateCallLog parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$PrivateCallLog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$PrivateCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
