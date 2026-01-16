package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
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
public final class MeetOuterClass$RequestStartLiveKitCall extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$RequestStartLiveKitCall DEFAULT_INSTANCE;
    public static final int INVITE_ENABLE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int VIDEO_FIELD_NUMBER = 3;
    private int bitField0_;
    private CollectionsStruct$BooleanValue inviteEnable_;
    private PeersStruct$OutPeer peer_;
    private long rid_;
    private boolean video_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
            q();
            ((MeetOuterClass$RequestStartLiveKitCall) this.b).setInviteEnable(collectionsStruct$BooleanValue);
            return this;
        }

        public a B(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((MeetOuterClass$RequestStartLiveKitCall) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        public a C(long j) {
            q();
            ((MeetOuterClass$RequestStartLiveKitCall) this.b).setRid(j);
            return this;
        }

        public a D(boolean z) {
            q();
            ((MeetOuterClass$RequestStartLiveKitCall) this.b).setVideo(z);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestStartLiveKitCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestStartLiveKitCall meetOuterClass$RequestStartLiveKitCall = new MeetOuterClass$RequestStartLiveKitCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestStartLiveKitCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestStartLiveKitCall.class, meetOuterClass$RequestStartLiveKitCall);
    }

    private MeetOuterClass$RequestStartLiveKitCall() {
    }

    private void clearInviteEnable() {
        this.inviteEnable_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearVideo() {
        this.video_ = false;
    }

    public static MeetOuterClass$RequestStartLiveKitCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInviteEnable(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.inviteEnable_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.inviteEnable_ = collectionsStruct$BooleanValue;
        } else {
            this.inviteEnable_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.inviteEnable_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 2;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInviteEnable(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.inviteEnable_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideo(boolean z) {
        this.video_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestStartLiveKitCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0007\u0004ဉ\u0001", new Object[]{"bitField0_", "peer_", "rid_", "video_", "inviteEnable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestStartLiveKitCall.class) {
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

    public CollectionsStruct$BooleanValue getInviteEnable() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.inviteEnable_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRid() {
        return this.rid_;
    }

    public boolean getVideo() {
        return this.video_;
    }

    public boolean hasInviteEnable() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestStartLiveKitCall meetOuterClass$RequestStartLiveKitCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestStartLiveKitCall);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestStartLiveKitCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestStartLiveKitCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
