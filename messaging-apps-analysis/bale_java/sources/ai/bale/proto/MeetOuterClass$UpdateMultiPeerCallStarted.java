package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.InterfaceC12702f35;
import ir.nasim.KW4;
import ir.nasim.N04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdateMultiPeerCallStarted extends GeneratedMessageLite implements U64 {
    public static final int CALL_CREATE_DATE_FIELD_NUMBER = 8;
    private static final MeetOuterClass$UpdateMultiPeerCallStarted DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INITIATOR_FIELD_NUMBER = 4;
    public static final int MODE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 10;
    public static final int PEER_FIELD_NUMBER = 5;
    public static final int ROOM_FIELD_NUMBER = 2;
    public static final int UPDATE_CREATE_DATE_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 3;
    private int bitField0_;
    private long callCreateDate_;
    private long id_;
    private int initiator_;
    private int mode_;
    private PeersStruct$OutExPeer peer_;
    private long updateCreateDate_;
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private String room_ = "";
    private String url_ = "";
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateMultiPeerCallStarted.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        MeetOuterClass$UpdateMultiPeerCallStarted meetOuterClass$UpdateMultiPeerCallStarted = new MeetOuterClass$UpdateMultiPeerCallStarted();
        DEFAULT_INSTANCE = meetOuterClass$UpdateMultiPeerCallStarted;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateMultiPeerCallStarted.class, meetOuterClass$UpdateMultiPeerCallStarted);
    }

    private MeetOuterClass$UpdateMultiPeerCallStarted() {
    }

    private void addAllParticipants(Iterable<? extends PeersStruct$OutExPeer> iterable) {
        ensureParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.participants_);
    }

    private void addParticipants(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(peersStruct$OutExPeer);
    }

    private void clearCallCreateDate() {
        this.callCreateDate_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearInitiator() {
        this.initiator_ = 0;
    }

    private void clearMode() {
        this.mode_ = 0;
    }

    private void clearParticipants() {
        this.participants_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    private void clearUpdateCreateDate() {
        this.updateCreateDate_ = 0L;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void ensureParticipantsIsMutable() {
        B.j jVar = this.participants_;
        if (jVar.u()) {
            return;
        }
        this.participants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private com.google.protobuf.J internalGetExtra() {
        return this.extra_;
    }

    private com.google.protobuf.J internalGetMutableExtra() {
        if (!this.extra_.n()) {
            this.extra_ = this.extra_.s();
        }
        return this.extra_;
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

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeParticipants(int i) {
        ensureParticipantsIsMutable();
        this.participants_.remove(i);
    }

    private void setCallCreateDate(long j) {
        this.callCreateDate_ = j;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setInitiator(int i) {
        this.initiator_ = i;
    }

    private void setMode(N04 n04) {
        this.mode_ = n04.getNumber();
    }

    private void setModeValue(int i) {
        this.mode_ = i;
    }

    private void setParticipants(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.set(i, peersStruct$OutExPeer);
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    private void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    private void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
    }

    private void setUpdateCreateDate(long j) {
        this.updateCreateDate_ = j;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateMultiPeerCallStarted();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0001\u0001\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004\u0004\u0005ဉ\u0000\u0006\f\u00072\b\u0002\t\u0002\n\u001b", new Object[]{"bitField0_", "id_", "room_", "url_", "initiator_", "peer_", "mode_", "extra_", b.a, "callCreateDate_", "updateCreateDate_", "participants_", PeersStruct$OutExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateMultiPeerCallStarted.class) {
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

    public long getCallCreateDate() {
        return this.callCreateDate_;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExtra() {
        return getExtraMap();
    }

    public int getExtraCount() {
        return internalGetExtra().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtraOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        return jInternalGetExtra.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExtra.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtraOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        if (jInternalGetExtra.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long getId() {
        return this.id_;
    }

    public int getInitiator() {
        return this.initiator_;
    }

    public N04 getMode() {
        N04 n04J = N04.j(this.mode_);
        return n04J == null ? N04.UNRECOGNIZED : n04J;
    }

    public int getModeValue() {
        return this.mode_;
    }

    public PeersStruct$OutExPeer getParticipants(int i) {
        return (PeersStruct$OutExPeer) this.participants_.get(i);
    }

    public int getParticipantsCount() {
        return this.participants_.size();
    }

    public List<PeersStruct$OutExPeer> getParticipantsList() {
        return this.participants_;
    }

    public InterfaceC12702f35 getParticipantsOrBuilder(int i) {
        return (InterfaceC12702f35) this.participants_.get(i);
    }

    public List<? extends InterfaceC12702f35> getParticipantsOrBuilderList() {
        return this.participants_;
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public long getUpdateCreateDate() {
        return this.updateCreateDate_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$UpdateMultiPeerCallStarted meetOuterClass$UpdateMultiPeerCallStarted) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateMultiPeerCallStarted);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addParticipants(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, peersStruct$OutExPeer);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateMultiPeerCallStarted parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateMultiPeerCallStarted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
