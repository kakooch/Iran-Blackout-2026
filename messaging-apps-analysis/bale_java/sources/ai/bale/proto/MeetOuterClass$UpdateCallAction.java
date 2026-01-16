package ai.bale.proto;

import ai.bale.proto.MeetStruct$CallActionUpdateTrait;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateCallAction extends GeneratedMessageLite implements U64 {
    public static final int ACTION_FIELD_NUMBER = 3;
    public static final int ACTION_TAKER_FIELD_NUMBER = 2;
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdateCallAction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private PeersStruct$ExPeer actionTaker_;
    private MeetStruct$CallActionUpdateTrait action_;
    private int bitField0_;
    private long callId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallAction meetOuterClass$UpdateCallAction = new MeetOuterClass$UpdateCallAction();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallAction;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallAction.class, meetOuterClass$UpdateCallAction);
    }

    private MeetOuterClass$UpdateCallAction() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -3;
    }

    private void clearActionTaker() {
        this.actionTaker_ = null;
        this.bitField0_ &= -2;
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    public static MeetOuterClass$UpdateCallAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(MeetStruct$CallActionUpdateTrait meetStruct$CallActionUpdateTrait) {
        meetStruct$CallActionUpdateTrait.getClass();
        MeetStruct$CallActionUpdateTrait meetStruct$CallActionUpdateTrait2 = this.action_;
        if (meetStruct$CallActionUpdateTrait2 == null || meetStruct$CallActionUpdateTrait2 == MeetStruct$CallActionUpdateTrait.getDefaultInstance()) {
            this.action_ = meetStruct$CallActionUpdateTrait;
        } else {
            this.action_ = (MeetStruct$CallActionUpdateTrait) ((MeetStruct$CallActionUpdateTrait.a) MeetStruct$CallActionUpdateTrait.newBuilder(this.action_).v(meetStruct$CallActionUpdateTrait)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeActionTaker(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.actionTaker_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.actionTaker_ = peersStruct$ExPeer;
        } else {
            this.actionTaker_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.actionTaker_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallAction parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(MeetStruct$CallActionUpdateTrait meetStruct$CallActionUpdateTrait) {
        meetStruct$CallActionUpdateTrait.getClass();
        this.action_ = meetStruct$CallActionUpdateTrait;
        this.bitField0_ |= 2;
    }

    private void setActionTaker(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.actionTaker_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "callId_", "actionTaker_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallAction.class) {
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

    public MeetStruct$CallActionUpdateTrait getAction() {
        MeetStruct$CallActionUpdateTrait meetStruct$CallActionUpdateTrait = this.action_;
        return meetStruct$CallActionUpdateTrait == null ? MeetStruct$CallActionUpdateTrait.getDefaultInstance() : meetStruct$CallActionUpdateTrait;
    }

    public PeersStruct$ExPeer getActionTaker() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.actionTaker_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public long getCallId() {
        return this.callId_;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasActionTaker() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallAction meetOuterClass$UpdateCallAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallAction);
    }

    public static MeetOuterClass$UpdateCallAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
