package ai.bale.proto;

import ai.bale.proto.MeetOuterClass$RequestStartInternalCall;
import ai.bale.proto.MeetOuterClass$RequestStartLiveKitCall;
import ai.bale.proto.MeetOuterClass$RequestStartSipCall;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestStartCall extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$RequestStartCall DEFAULT_INSTANCE;
    public static final int INTERNAL_CALL_FIELD_NUMBER = 4;
    public static final int LIVE_KIT_CALL_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SIP_CALL_FIELD_NUMBER = 5;
    public static final int VIDEO_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$OutPeer peer_;
    private long rid_;
    private int traitCase_ = 0;
    private Object trait_;
    private boolean video_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MeetOuterClass$RequestStartLiveKitCall.a aVar) {
            q();
            ((MeetOuterClass$RequestStartCall) this.b).setLiveKitCall((MeetOuterClass$RequestStartLiveKitCall) aVar.a());
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestStartCall.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        INTERNAL_CALL(4),
        SIP_CALL(5),
        LIVE_KIT_CALL(6),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 4) {
                return INTERNAL_CALL;
            }
            if (i == 5) {
                return SIP_CALL;
            }
            if (i != 6) {
                return null;
            }
            return LIVE_KIT_CALL;
        }
    }

    static {
        MeetOuterClass$RequestStartCall meetOuterClass$RequestStartCall = new MeetOuterClass$RequestStartCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestStartCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestStartCall.class, meetOuterClass$RequestStartCall);
    }

    private MeetOuterClass$RequestStartCall() {
    }

    private void clearInternalCall() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLiveKitCall() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSipCall() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearVideo() {
        this.video_ = false;
    }

    public static MeetOuterClass$RequestStartCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInternalCall(MeetOuterClass$RequestStartInternalCall meetOuterClass$RequestStartInternalCall) {
        meetOuterClass$RequestStartInternalCall.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MeetOuterClass$RequestStartInternalCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$RequestStartInternalCall;
        } else {
            this.trait_ = ((MeetOuterClass$RequestStartInternalCall.a) MeetOuterClass$RequestStartInternalCall.newBuilder((MeetOuterClass$RequestStartInternalCall) this.trait_).v(meetOuterClass$RequestStartInternalCall)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeLiveKitCall(MeetOuterClass$RequestStartLiveKitCall meetOuterClass$RequestStartLiveKitCall) {
        meetOuterClass$RequestStartLiveKitCall.getClass();
        if (this.traitCase_ != 6 || this.trait_ == MeetOuterClass$RequestStartLiveKitCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$RequestStartLiveKitCall;
        } else {
            this.trait_ = ((MeetOuterClass$RequestStartLiveKitCall.a) MeetOuterClass$RequestStartLiveKitCall.newBuilder((MeetOuterClass$RequestStartLiveKitCall) this.trait_).v(meetOuterClass$RequestStartLiveKitCall)).j();
        }
        this.traitCase_ = 6;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSipCall(MeetOuterClass$RequestStartSipCall meetOuterClass$RequestStartSipCall) {
        meetOuterClass$RequestStartSipCall.getClass();
        if (this.traitCase_ != 5 || this.trait_ == MeetOuterClass$RequestStartSipCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$RequestStartSipCall;
        } else {
            this.trait_ = ((MeetOuterClass$RequestStartSipCall.a) MeetOuterClass$RequestStartSipCall.newBuilder((MeetOuterClass$RequestStartSipCall) this.trait_).v(meetOuterClass$RequestStartSipCall)).j();
        }
        this.traitCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestStartCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInternalCall(MeetOuterClass$RequestStartInternalCall meetOuterClass$RequestStartInternalCall) {
        meetOuterClass$RequestStartInternalCall.getClass();
        this.trait_ = meetOuterClass$RequestStartInternalCall;
        this.traitCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLiveKitCall(MeetOuterClass$RequestStartLiveKitCall meetOuterClass$RequestStartLiveKitCall) {
        meetOuterClass$RequestStartLiveKitCall.getClass();
        this.trait_ = meetOuterClass$RequestStartLiveKitCall;
        this.traitCase_ = 6;
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSipCall(MeetOuterClass$RequestStartSipCall meetOuterClass$RequestStartSipCall) {
        meetOuterClass$RequestStartSipCall.getClass();
        this.trait_ = meetOuterClass$RequestStartSipCall;
        this.traitCase_ = 5;
    }

    private void setVideo(boolean z) {
        this.video_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestStartCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0007\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"trait_", "traitCase_", "bitField0_", "peer_", "rid_", "video_", MeetOuterClass$RequestStartInternalCall.class, MeetOuterClass$RequestStartSipCall.class, MeetOuterClass$RequestStartLiveKitCall.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestStartCall.class) {
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

    public MeetOuterClass$RequestStartInternalCall getInternalCall() {
        return this.traitCase_ == 4 ? (MeetOuterClass$RequestStartInternalCall) this.trait_ : MeetOuterClass$RequestStartInternalCall.getDefaultInstance();
    }

    public MeetOuterClass$RequestStartLiveKitCall getLiveKitCall() {
        return this.traitCase_ == 6 ? (MeetOuterClass$RequestStartLiveKitCall) this.trait_ : MeetOuterClass$RequestStartLiveKitCall.getDefaultInstance();
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRid() {
        return this.rid_;
    }

    public MeetOuterClass$RequestStartSipCall getSipCall() {
        return this.traitCase_ == 5 ? (MeetOuterClass$RequestStartSipCall) this.trait_ : MeetOuterClass$RequestStartSipCall.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean getVideo() {
        return this.video_;
    }

    public boolean hasInternalCall() {
        return this.traitCase_ == 4;
    }

    public boolean hasLiveKitCall() {
        return this.traitCase_ == 6;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSipCall() {
        return this.traitCase_ == 5;
    }

    public static a newBuilder(MeetOuterClass$RequestStartCall meetOuterClass$RequestStartCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestStartCall);
    }

    public static MeetOuterClass$RequestStartCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestStartCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestStartCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
