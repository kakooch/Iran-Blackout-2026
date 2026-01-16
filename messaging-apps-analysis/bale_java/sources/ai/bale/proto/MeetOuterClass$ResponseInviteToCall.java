package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12090e14;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetOuterClass$ResponseInviteToCall extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$ResponseInviteToCall DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_STATES_FIELD_NUMBER = 1;
    private B.j peerStates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$ResponseInviteToCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$ResponseInviteToCall meetOuterClass$ResponseInviteToCall = new MeetOuterClass$ResponseInviteToCall();
        DEFAULT_INSTANCE = meetOuterClass$ResponseInviteToCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$ResponseInviteToCall.class, meetOuterClass$ResponseInviteToCall);
    }

    private MeetOuterClass$ResponseInviteToCall() {
    }

    private void addAllPeerStates(Iterable<? extends MeetStruct$PeerState> iterable) {
        ensurePeerStatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peerStates_);
    }

    private void addPeerStates(MeetStruct$PeerState meetStruct$PeerState) {
        meetStruct$PeerState.getClass();
        ensurePeerStatesIsMutable();
        this.peerStates_.add(meetStruct$PeerState);
    }

    private void clearPeerStates() {
        this.peerStates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePeerStatesIsMutable() {
        B.j jVar = this.peerStates_;
        if (jVar.u()) {
            return;
        }
        this.peerStates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$ResponseInviteToCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$ResponseInviteToCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeerStates(int i) {
        ensurePeerStatesIsMutable();
        this.peerStates_.remove(i);
    }

    private void setPeerStates(int i, MeetStruct$PeerState meetStruct$PeerState) {
        meetStruct$PeerState.getClass();
        ensurePeerStatesIsMutable();
        this.peerStates_.set(i, meetStruct$PeerState);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$ResponseInviteToCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"peerStates_", MeetStruct$PeerState.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$ResponseInviteToCall.class) {
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

    public MeetStruct$PeerState getPeerStates(int i) {
        return (MeetStruct$PeerState) this.peerStates_.get(i);
    }

    public int getPeerStatesCount() {
        return this.peerStates_.size();
    }

    public List<MeetStruct$PeerState> getPeerStatesList() {
        return this.peerStates_;
    }

    public InterfaceC12090e14 getPeerStatesOrBuilder(int i) {
        return (InterfaceC12090e14) this.peerStates_.get(i);
    }

    public List<? extends InterfaceC12090e14> getPeerStatesOrBuilderList() {
        return this.peerStates_;
    }

    public static a newBuilder(MeetOuterClass$ResponseInviteToCall meetOuterClass$ResponseInviteToCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$ResponseInviteToCall);
    }

    public static MeetOuterClass$ResponseInviteToCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeerStates(int i, MeetStruct$PeerState meetStruct$PeerState) {
        meetStruct$PeerState.getClass();
        ensurePeerStatesIsMutable();
        this.peerStates_.add(i, meetStruct$PeerState);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$ResponseInviteToCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$ResponseInviteToCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
