package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
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
import ir.nasim.X04;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetStruct$GroupCall extends GeneratedMessageLite implements U64 {
    public static final int CREATE_DATE_FIELD_NUMBER = 6;
    private static final MeetStruct$GroupCall DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 7;
    public static final int END_DATE_FIELD_NUMBER = 18;
    public static final int EXTRA_FIELD_NUMBER = 15;
    public static final int EXT_FIELD_NUMBER = 10;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INITIATOR_USER_ID_FIELD_NUMBER = 8;
    public static final int IN_CALL_PARTICIPANTS_FIELD_NUMBER = 17;
    public static final int IS_PUBLIC_FIELD_NUMBER = 13;
    public static final int LINK_FIELD_NUMBER = 12;
    public static final int MODE_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 9;
    public static final int PENDING_REQUESTS_FIELD_NUMBER = 19;
    public static final int RAISED_HANDS_USER_IDENTITIES_FIELD_NUMBER = 20;
    public static final int ROOM_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 16;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 4;
    public static final int VIDEO_FIELD_NUMBER = 5;
    private int bitField0_;
    private CollectionsStruct$Int64Value createDate_;
    private CollectionsStruct$Int32Value duration_;
    private CollectionsStruct$Int64Value endDate_;
    private long id_;
    private int initiatorUserId_;
    private boolean isPublic_;
    private int mode_;
    private PeersStruct$OutExPeer peer_;
    private CollectionsStruct$StringValue url_;
    private boolean video_;
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private String room_ = "";
    private String token_ = "";
    private String link_ = "";
    private String title_ = "";
    private B.j inCallParticipants_ = GeneratedMessageLite.emptyProtobufList();
    private B.j pendingRequests_ = GeneratedMessageLite.emptyProtobufList();
    private B.j raisedHandsUserIdentities_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$GroupCall.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    private static final class c {
        static final com.google.protobuf.I a;

        static {
            r0.b bVar = r0.b.k;
            a = com.google.protobuf.I.d(bVar, "", bVar, "");
        }
    }

    static {
        MeetStruct$GroupCall meetStruct$GroupCall = new MeetStruct$GroupCall();
        DEFAULT_INSTANCE = meetStruct$GroupCall;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$GroupCall.class, meetStruct$GroupCall);
    }

    private MeetStruct$GroupCall() {
    }

    private void addAllInCallParticipants(Iterable<? extends PeersStruct$OutExPeer> iterable) {
        ensureInCallParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.inCallParticipants_);
    }

    private void addAllPendingRequests(Iterable<? extends MeetStruct$JoinRequest> iterable) {
        ensurePendingRequestsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pendingRequests_);
    }

    private void addAllRaisedHandsUserIdentities(Iterable<String> iterable) {
        ensureRaisedHandsUserIdentitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.raisedHandsUserIdentities_);
    }

    private void addInCallParticipants(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInCallParticipantsIsMutable();
        this.inCallParticipants_.add(peersStruct$OutExPeer);
    }

    private void addPendingRequests(MeetStruct$JoinRequest meetStruct$JoinRequest) {
        meetStruct$JoinRequest.getClass();
        ensurePendingRequestsIsMutable();
        this.pendingRequests_.add(meetStruct$JoinRequest);
    }

    private void addRaisedHandsUserIdentities(String str) {
        str.getClass();
        ensureRaisedHandsUserIdentitiesIsMutable();
        this.raisedHandsUserIdentities_.add(str);
    }

    private void addRaisedHandsUserIdentitiesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureRaisedHandsUserIdentitiesIsMutable();
        this.raisedHandsUserIdentities_.add(abstractC2383g.f0());
    }

    private void clearCreateDate() {
        this.createDate_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDuration() {
        this.duration_ = null;
        this.bitField0_ &= -5;
    }

    private void clearEndDate() {
        this.endDate_ = null;
        this.bitField0_ &= -17;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearInCallParticipants() {
        this.inCallParticipants_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearInitiatorUserId() {
        this.initiatorUserId_ = 0;
    }

    private void clearIsPublic() {
        this.isPublic_ = false;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearMode() {
        this.mode_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -9;
    }

    private void clearPendingRequests() {
        this.pendingRequests_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRaisedHandsUserIdentities() {
        this.raisedHandsUserIdentities_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    private void clearUrl() {
        this.url_ = null;
        this.bitField0_ &= -2;
    }

    private void clearVideo() {
        this.video_ = false;
    }

    private void ensureInCallParticipantsIsMutable() {
        B.j jVar = this.inCallParticipants_;
        if (jVar.u()) {
            return;
        }
        this.inCallParticipants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePendingRequestsIsMutable() {
        B.j jVar = this.pendingRequests_;
        if (jVar.u()) {
            return;
        }
        this.pendingRequests_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRaisedHandsUserIdentitiesIsMutable() {
        B.j jVar = this.raisedHandsUserIdentities_;
        if (jVar.u()) {
            return;
        }
        this.raisedHandsUserIdentities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetStruct$GroupCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private Map<String, String> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetExtra() {
        return this.extra_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExtra() {
        if (!this.extra_.n()) {
            this.extra_ = this.extra_.s();
        }
        return this.extra_;
    }

    private void mergeCreateDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.createDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.createDate_ = collectionsStruct$Int64Value;
        } else {
            this.createDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.createDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeDuration(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.duration_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.duration_ = collectionsStruct$Int32Value;
        } else {
            this.duration_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.duration_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeEndDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.endDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.endDate_ = collectionsStruct$Int64Value;
        } else {
            this.endDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.endDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeUrl(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.url_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.url_ = collectionsStruct$StringValue;
        } else {
            this.url_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.url_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$GroupCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$GroupCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInCallParticipants(int i) {
        ensureInCallParticipantsIsMutable();
        this.inCallParticipants_.remove(i);
    }

    private void removePendingRequests(int i) {
        ensurePendingRequestsIsMutable();
        this.pendingRequests_.remove(i);
    }

    private void setCreateDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.createDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setDuration(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.duration_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 4;
    }

    private void setEndDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.endDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 16;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setInCallParticipants(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInCallParticipantsIsMutable();
        this.inCallParticipants_.set(i, peersStruct$OutExPeer);
    }

    private void setInitiatorUserId(int i) {
        this.initiatorUserId_ = i;
    }

    private void setIsPublic(boolean z) {
        this.isPublic_ = z;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setMode(N04 n04) {
        this.mode_ = n04.getNumber();
    }

    private void setModeValue(int i) {
        this.mode_ = i;
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 8;
    }

    private void setPendingRequests(int i, MeetStruct$JoinRequest meetStruct$JoinRequest) {
        meetStruct$JoinRequest.getClass();
        ensurePendingRequestsIsMutable();
        this.pendingRequests_.set(i, meetStruct$JoinRequest);
    }

    private void setRaisedHandsUserIdentities(int i, String str) {
        str.getClass();
        ensureRaisedHandsUserIdentitiesIsMutable();
        this.raisedHandsUserIdentities_.set(i, str);
    }

    private void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    private void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    private void setUrl(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.url_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setVideo(boolean z) {
        this.video_ = z;
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Deprecated
    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$GroupCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0013\u0000\u0001\u0001\u0014\u0013\u0002\u0003\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005\u0007\u0006ဉ\u0001\u0007ဉ\u0002\b\u0004\tဉ\u0003\n2\u000b\f\fȈ\r\u0007\u000f2\u0010Ȉ\u0011\u001b\u0012ဉ\u0004\u0013\u001b\u0014Ț", new Object[]{"bitField0_", "id_", "room_", "token_", "url_", "video_", "createDate_", "duration_", "initiatorUserId_", "peer_", "ext_", b.a, "mode_", "link_", "isPublic_", "extra_", c.a, "title_", "inCallParticipants_", PeersStruct$OutExPeer.class, "endDate_", "pendingRequests_", MeetStruct$JoinRequest.class, "raisedHandsUserIdentities_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$GroupCall.class) {
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

    public CollectionsStruct$Int64Value getCreateDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.createDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$Int32Value getDuration() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.duration_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public CollectionsStruct$Int64Value getEndDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.endDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExt() {
        return getExtMap();
    }

    public int getExtCount() {
        return internalGetExt().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtMap() {
        return Collections.unmodifiableMap(internalGetExt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        return jInternalGetExt.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExt.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        if (jInternalGetExt.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExt.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    @Deprecated
    public int getExtraCount() {
        return internalGetExtra().size();
    }

    @Deprecated
    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        return jInternalGetExtra.containsKey(str) ? (String) jInternalGetExtra.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getExtraOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        if (jInternalGetExtra.containsKey(str)) {
            return (String) jInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long getId() {
        return this.id_;
    }

    public PeersStruct$OutExPeer getInCallParticipants(int i) {
        return (PeersStruct$OutExPeer) this.inCallParticipants_.get(i);
    }

    public int getInCallParticipantsCount() {
        return this.inCallParticipants_.size();
    }

    public List<PeersStruct$OutExPeer> getInCallParticipantsList() {
        return this.inCallParticipants_;
    }

    public InterfaceC12702f35 getInCallParticipantsOrBuilder(int i) {
        return (InterfaceC12702f35) this.inCallParticipants_.get(i);
    }

    public List<? extends InterfaceC12702f35> getInCallParticipantsOrBuilderList() {
        return this.inCallParticipants_;
    }

    public int getInitiatorUserId() {
        return this.initiatorUserId_;
    }

    public boolean getIsPublic() {
        return this.isPublic_;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
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

    public MeetStruct$JoinRequest getPendingRequests(int i) {
        return (MeetStruct$JoinRequest) this.pendingRequests_.get(i);
    }

    public int getPendingRequestsCount() {
        return this.pendingRequests_.size();
    }

    public List<MeetStruct$JoinRequest> getPendingRequestsList() {
        return this.pendingRequests_;
    }

    public X04 getPendingRequestsOrBuilder(int i) {
        return (X04) this.pendingRequests_.get(i);
    }

    public List<? extends X04> getPendingRequestsOrBuilderList() {
        return this.pendingRequests_;
    }

    public String getRaisedHandsUserIdentities(int i) {
        return (String) this.raisedHandsUserIdentities_.get(i);
    }

    public AbstractC2383g getRaisedHandsUserIdentitiesBytes(int i) {
        return AbstractC2383g.N((String) this.raisedHandsUserIdentities_.get(i));
    }

    public int getRaisedHandsUserIdentitiesCount() {
        return this.raisedHandsUserIdentities_.size();
    }

    public List<String> getRaisedHandsUserIdentitiesList() {
        return this.raisedHandsUserIdentities_;
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public CollectionsStruct$StringValue getUrl() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.url_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean getVideo() {
        return this.video_;
    }

    public boolean hasCreateDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasDuration() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasEndDate() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetStruct$GroupCall meetStruct$GroupCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$GroupCall);
    }

    public static MeetStruct$GroupCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$GroupCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$GroupCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addInCallParticipants(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInCallParticipantsIsMutable();
        this.inCallParticipants_.add(i, peersStruct$OutExPeer);
    }

    private void addPendingRequests(int i, MeetStruct$JoinRequest meetStruct$JoinRequest) {
        meetStruct$JoinRequest.getClass();
        ensurePendingRequestsIsMutable();
        this.pendingRequests_.add(i, meetStruct$JoinRequest);
    }

    public static MeetStruct$GroupCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$GroupCall parseFrom(byte[] bArr) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$GroupCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$GroupCall parseFrom(InputStream inputStream) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$GroupCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$GroupCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$GroupCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$GroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
