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
public final class MeetOuterClass$UpdatePeersStateChanged extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdatePeersStateChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_STATES_FIELD_NUMBER = 2;
    private long callId_;
    private B.j peerStates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdatePeersStateChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdatePeersStateChanged meetOuterClass$UpdatePeersStateChanged = new MeetOuterClass$UpdatePeersStateChanged();
        DEFAULT_INSTANCE = meetOuterClass$UpdatePeersStateChanged;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdatePeersStateChanged.class, meetOuterClass$UpdatePeersStateChanged);
    }

    private MeetOuterClass$UpdatePeersStateChanged() {
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

    private void clearCallId() {
        this.callId_ = 0L;
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

    public static MeetOuterClass$UpdatePeersStateChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeerStates(int i) {
        ensurePeerStatesIsMutable();
        this.peerStates_.remove(i);
    }

    private void setCallId(long j) {
        this.callId_ = j;
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
                return new MeetOuterClass$UpdatePeersStateChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0002\u0002\u001b", new Object[]{"callId_", "peerStates_", MeetStruct$PeerState.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdatePeersStateChanged.class) {
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

    public static a newBuilder(MeetOuterClass$UpdatePeersStateChanged meetOuterClass$UpdatePeersStateChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdatePeersStateChanged);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeerStates(int i, MeetStruct$PeerState meetStruct$PeerState) {
        meetStruct$PeerState.getClass();
        ensurePeerStatesIsMutable();
        this.peerStates_.add(i, meetStruct$PeerState);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdatePeersStateChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
