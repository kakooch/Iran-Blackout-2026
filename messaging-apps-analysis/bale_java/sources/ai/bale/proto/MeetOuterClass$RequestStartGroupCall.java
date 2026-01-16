package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12702f35;
import ir.nasim.KW4;
import ir.nasim.N04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestStartGroupCall extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$RequestStartGroupCall DEFAULT_INSTANCE;
    public static final int INVITEES_FIELD_NUMBER = 5;
    public static final int MODE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RANDOM_ID_FIELD_NUMBER = 2;
    public static final int VIDEO_FIELD_NUMBER = 3;
    private int bitField0_;
    private B.j invitees_ = GeneratedMessageLite.emptyProtobufList();
    private int mode_;
    private PeersStruct$OutExPeer peer_;
    private long randomId_;
    private boolean video_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MeetOuterClass$RequestStartGroupCall) this.b).addAllInvitees(iterable);
            return this;
        }

        public a B(N04 n04) {
            q();
            ((MeetOuterClass$RequestStartGroupCall) this.b).setMode(n04);
            return this;
        }

        public a C(PeersStruct$OutExPeer peersStruct$OutExPeer) {
            q();
            ((MeetOuterClass$RequestStartGroupCall) this.b).setPeer(peersStruct$OutExPeer);
            return this;
        }

        public a D(boolean z) {
            q();
            ((MeetOuterClass$RequestStartGroupCall) this.b).setVideo(z);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestStartGroupCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestStartGroupCall meetOuterClass$RequestStartGroupCall = new MeetOuterClass$RequestStartGroupCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestStartGroupCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestStartGroupCall.class, meetOuterClass$RequestStartGroupCall);
    }

    private MeetOuterClass$RequestStartGroupCall() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllInvitees(Iterable<? extends PeersStruct$OutExPeer> iterable) {
        ensureInviteesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.invitees_);
    }

    private void addInvitees(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInviteesIsMutable();
        this.invitees_.add(peersStruct$OutExPeer);
    }

    private void clearInvitees() {
        this.invitees_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMode() {
        this.mode_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    private void clearVideo() {
        this.video_ = false;
    }

    private void ensureInviteesIsMutable() {
        B.j jVar = this.invitees_;
        if (jVar.u()) {
            return;
        }
        this.invitees_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$RequestStartGroupCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestStartGroupCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInvitees(int i) {
        ensureInviteesIsMutable();
        this.invitees_.remove(i);
    }

    private void setInvitees(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInviteesIsMutable();
        this.invitees_.set(i, peersStruct$OutExPeer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(N04 n04) {
        this.mode_ = n04.getNumber();
    }

    private void setModeValue(int i) {
        this.mode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    private void setRandomId(long j) {
        this.randomId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideo(boolean z) {
        this.video_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestStartGroupCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0007\u0004\f\u0005\u001b", new Object[]{"bitField0_", "peer_", "randomId_", "video_", "mode_", "invitees_", PeersStruct$OutExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestStartGroupCall.class) {
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

    public PeersStruct$OutExPeer getInvitees(int i) {
        return (PeersStruct$OutExPeer) this.invitees_.get(i);
    }

    public int getInviteesCount() {
        return this.invitees_.size();
    }

    public List<PeersStruct$OutExPeer> getInviteesList() {
        return this.invitees_;
    }

    public InterfaceC12702f35 getInviteesOrBuilder(int i) {
        return (InterfaceC12702f35) this.invitees_.get(i);
    }

    public List<? extends InterfaceC12702f35> getInviteesOrBuilderList() {
        return this.invitees_;
    }

    public N04 getMode() {
        N04 n04J = N04.j(this.mode_);
        return n04J == null ? N04.UNRECOGNIZED : n04J;
    }

    public int getModeValue() {
        return this.mode_;
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public boolean getVideo() {
        return this.video_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestStartGroupCall meetOuterClass$RequestStartGroupCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestStartGroupCall);
    }

    public static MeetOuterClass$RequestStartGroupCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addInvitees(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInviteesIsMutable();
        this.invitees_.add(i, peersStruct$OutExPeer);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestStartGroupCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestStartGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
