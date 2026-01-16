package ai.bale.proto;

import ai.bale.proto.MeetStruct$LowerHand;
import ai.bale.proto.MeetStruct$RaiseHand;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestTakeCallAction extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestTakeCallAction DEFAULT_INSTANCE;
    public static final int LOWER_HAND_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RAISE_HAND_FIELD_NUMBER = 3;
    private int actionCase_ = 0;
    private Object action_;
    private long callId_;

    public enum a {
        LOWER_HAND(2),
        RAISE_HAND(3),
        ACTION_NOT_SET(0);

        private final int a;

        a(int i) {
            this.a = i;
        }

        public static a j(int i) {
            if (i == 0) {
                return ACTION_NOT_SET;
            }
            if (i == 2) {
                return LOWER_HAND;
            }
            if (i != 3) {
                return null;
            }
            return RAISE_HAND;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(MeetOuterClass$RequestTakeCallAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestTakeCallAction meetOuterClass$RequestTakeCallAction = new MeetOuterClass$RequestTakeCallAction();
        DEFAULT_INSTANCE = meetOuterClass$RequestTakeCallAction;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestTakeCallAction.class, meetOuterClass$RequestTakeCallAction);
    }

    private MeetOuterClass$RequestTakeCallAction() {
    }

    private void clearAction() {
        this.actionCase_ = 0;
        this.action_ = null;
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearLowerHand() {
        if (this.actionCase_ == 2) {
            this.actionCase_ = 0;
            this.action_ = null;
        }
    }

    private void clearRaiseHand() {
        if (this.actionCase_ == 3) {
            this.actionCase_ = 0;
            this.action_ = null;
        }
    }

    public static MeetOuterClass$RequestTakeCallAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLowerHand(MeetStruct$LowerHand meetStruct$LowerHand) {
        meetStruct$LowerHand.getClass();
        if (this.actionCase_ != 2 || this.action_ == MeetStruct$LowerHand.getDefaultInstance()) {
            this.action_ = meetStruct$LowerHand;
        } else {
            this.action_ = ((MeetStruct$LowerHand.a) MeetStruct$LowerHand.newBuilder((MeetStruct$LowerHand) this.action_).v(meetStruct$LowerHand)).j();
        }
        this.actionCase_ = 2;
    }

    private void mergeRaiseHand(MeetStruct$RaiseHand meetStruct$RaiseHand) {
        meetStruct$RaiseHand.getClass();
        if (this.actionCase_ != 3 || this.action_ == MeetStruct$RaiseHand.getDefaultInstance()) {
            this.action_ = meetStruct$RaiseHand;
        } else {
            this.action_ = ((MeetStruct$RaiseHand.a) MeetStruct$RaiseHand.newBuilder((MeetStruct$RaiseHand) this.action_).v(meetStruct$RaiseHand)).j();
        }
        this.actionCase_ = 3;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestTakeCallAction parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setLowerHand(MeetStruct$LowerHand meetStruct$LowerHand) {
        meetStruct$LowerHand.getClass();
        this.action_ = meetStruct$LowerHand;
        this.actionCase_ = 2;
    }

    private void setRaiseHand(MeetStruct$RaiseHand meetStruct$RaiseHand) {
        meetStruct$RaiseHand.getClass();
        this.action_ = meetStruct$RaiseHand;
        this.actionCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestTakeCallAction();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002<\u0000\u0003<\u0000", new Object[]{"action_", "actionCase_", "callId_", MeetStruct$LowerHand.class, MeetStruct$RaiseHand.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestTakeCallAction.class) {
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

    public a getActionCase() {
        return a.j(this.actionCase_);
    }

    public long getCallId() {
        return this.callId_;
    }

    public MeetStruct$LowerHand getLowerHand() {
        return this.actionCase_ == 2 ? (MeetStruct$LowerHand) this.action_ : MeetStruct$LowerHand.getDefaultInstance();
    }

    public MeetStruct$RaiseHand getRaiseHand() {
        return this.actionCase_ == 3 ? (MeetStruct$RaiseHand) this.action_ : MeetStruct$RaiseHand.getDefaultInstance();
    }

    public boolean hasLowerHand() {
        return this.actionCase_ == 2;
    }

    public boolean hasRaiseHand() {
        return this.actionCase_ == 3;
    }

    public static b newBuilder(MeetOuterClass$RequestTakeCallAction meetOuterClass$RequestTakeCallAction) {
        return (b) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestTakeCallAction);
    }

    public static MeetOuterClass$RequestTakeCallAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestTakeCallAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
