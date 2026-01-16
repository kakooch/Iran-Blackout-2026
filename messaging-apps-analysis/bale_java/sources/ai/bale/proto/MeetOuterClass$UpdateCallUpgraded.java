package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.N04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateCallUpgraded extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 3;
    public static final int CURRENT_MODE_FIELD_NUMBER = 2;
    private static final MeetOuterClass$UpdateCallUpgraded DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PREVIOUS_MODE_FIELD_NUMBER = 1;
    private long callId_;
    private int currentMode_;
    private int previousMode_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallUpgraded.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallUpgraded meetOuterClass$UpdateCallUpgraded = new MeetOuterClass$UpdateCallUpgraded();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallUpgraded;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallUpgraded.class, meetOuterClass$UpdateCallUpgraded);
    }

    private MeetOuterClass$UpdateCallUpgraded() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearCurrentMode() {
        this.currentMode_ = 0;
    }

    private void clearPreviousMode() {
        this.previousMode_ = 0;
    }

    public static MeetOuterClass$UpdateCallUpgraded getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallUpgraded parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setCurrentMode(N04 n04) {
        this.currentMode_ = n04.getNumber();
    }

    private void setCurrentModeValue(int i) {
        this.currentMode_ = i;
    }

    private void setPreviousMode(N04 n04) {
        this.previousMode_ = n04.getNumber();
    }

    private void setPreviousModeValue(int i) {
        this.previousMode_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallUpgraded();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0002", new Object[]{"previousMode_", "currentMode_", "callId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallUpgraded.class) {
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

    public N04 getCurrentMode() {
        N04 n04J = N04.j(this.currentMode_);
        return n04J == null ? N04.UNRECOGNIZED : n04J;
    }

    public int getCurrentModeValue() {
        return this.currentMode_;
    }

    public N04 getPreviousMode() {
        N04 n04J = N04.j(this.previousMode_);
        return n04J == null ? N04.UNRECOGNIZED : n04J;
    }

    public int getPreviousModeValue() {
        return this.previousMode_;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallUpgraded meetOuterClass$UpdateCallUpgraded) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallUpgraded);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallUpgraded parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallUpgraded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
