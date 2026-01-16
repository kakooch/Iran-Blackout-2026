package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import com.google.protobuf.r0;
import ir.nasim.K04;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetStruct$Call extends GeneratedMessageLite implements U64 {
    public static final int ADMIN_UID_FIELD_NUMBER = 8;
    public static final int CREATE_DATE_FIELD_NUMBER = 6;
    private static final MeetStruct$Call DEFAULT_INSTANCE;
    public static final int DISCARD_REASON_FIELD_NUMBER = 11;
    public static final int DISCARD_SERVICE_MESSAGE_DATE_FIELD_NUMBER = 14;
    public static final int DISCARD_SERVICE_MESSAGE_RID_FIELD_NUMBER = 13;
    public static final int DURATION_FIELD_NUMBER = 10;
    public static final int EXTRA_FIELD_NUMBER = 15;
    public static final int EXT_FIELD_NUMBER = 16;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_LIVEKIT_FIELD_NUMBER = 12;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 9;
    public static final int ROOM_FIELD_NUMBER = 3;
    public static final int START_DATE_FIELD_NUMBER = 7;
    public static final int TOKEN_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 4;
    public static final int VIDEO_FIELD_NUMBER = 5;
    private int adminUid_;
    private int bitField0_;
    private long createDate_;
    private int discardReason_;
    private CollectionsStruct$Int64Value discardServiceMessageDate_;
    private CollectionsStruct$Int64Value discardServiceMessageRid_;
    private int duration_;
    private long id_;
    private boolean isLivekit_;
    private PeersStruct$Peer peer_;
    private long startDate_;
    private StringValue url_;
    private boolean video_;
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private String token_ = "";
    private String room_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$Call.DEFAULT_INSTANCE);
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
        MeetStruct$Call meetStruct$Call = new MeetStruct$Call();
        DEFAULT_INSTANCE = meetStruct$Call;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$Call.class, meetStruct$Call);
    }

    private MeetStruct$Call() {
    }

    private void clearAdminUid() {
        this.adminUid_ = 0;
    }

    private void clearCreateDate() {
        this.createDate_ = 0L;
    }

    private void clearDiscardReason() {
        this.discardReason_ = 0;
    }

    private void clearDiscardServiceMessageDate() {
        this.discardServiceMessageDate_ = null;
        this.bitField0_ &= -9;
    }

    private void clearDiscardServiceMessageRid() {
        this.discardServiceMessageRid_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearIsLivekit() {
        this.isLivekit_ = false;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    private void clearStartDate() {
        this.startDate_ = 0L;
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

    public static MeetStruct$Call getDefaultInstance() {
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

    private void mergeDiscardServiceMessageDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.discardServiceMessageDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.discardServiceMessageDate_ = collectionsStruct$Int64Value;
        } else {
            this.discardServiceMessageDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.discardServiceMessageDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeDiscardServiceMessageRid(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.discardServiceMessageRid_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.discardServiceMessageRid_ = collectionsStruct$Int64Value;
        } else {
            this.discardServiceMessageRid_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.discardServiceMessageRid_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.peer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.peer_ = peersStruct$Peer;
        } else {
            this.peer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.peer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.url_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.url_ = stringValue;
        } else {
            this.url_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.url_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$Call parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$Call) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$Call parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdminUid(int i) {
        this.adminUid_ = i;
    }

    private void setCreateDate(long j) {
        this.createDate_ = j;
    }

    private void setDiscardReason(K04 k04) {
        this.discardReason_ = k04.getNumber();
    }

    private void setDiscardReasonValue(int i) {
        this.discardReason_ = i;
    }

    private void setDiscardServiceMessageDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.discardServiceMessageDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 8;
    }

    private void setDiscardServiceMessageRid(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.discardServiceMessageRid_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setDuration(int i) {
        this.duration_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setIsLivekit(boolean z) {
        this.isLivekit_ = z;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 2;
    }

    private void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    private void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
    }

    private void setStartDate(long j) {
        this.startDate_ = j;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    private void setUrl(StringValue stringValue) {
        stringValue.getClass();
        this.url_ = stringValue;
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
                return new MeetStruct$Call();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0001\u0001\u0010\u0010\u0002\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005\u0007\u0006\u0002\u0007\u0002\b\u0004\tဉ\u0001\n\u0004\u000b\f\f\u0007\rဉ\u0002\u000eဉ\u0003\u000f2\u00102", new Object[]{"bitField0_", "id_", "token_", "room_", "url_", "video_", "createDate_", "startDate_", "adminUid_", "peer_", "duration_", "discardReason_", "isLivekit_", "discardServiceMessageRid_", "discardServiceMessageDate_", "extra_", c.a, "ext_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$Call.class) {
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

    public int getAdminUid() {
        return this.adminUid_;
    }

    public long getCreateDate() {
        return this.createDate_;
    }

    public K04 getDiscardReason() {
        K04 k04J = K04.j(this.discardReason_);
        return k04J == null ? K04.UNRECOGNIZED : k04J;
    }

    public int getDiscardReasonValue() {
        return this.discardReason_;
    }

    public CollectionsStruct$Int64Value getDiscardServiceMessageDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.discardServiceMessageDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$Int64Value getDiscardServiceMessageRid() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.discardServiceMessageRid_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public int getDuration() {
        return this.duration_;
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

    public boolean getIsLivekit() {
        return this.isLivekit_;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public long getStartDate() {
        return this.startDate_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public StringValue getUrl() {
        StringValue stringValue = this.url_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean getVideo() {
        return this.video_;
    }

    public boolean hasDiscardServiceMessageDate() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDiscardServiceMessageRid() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetStruct$Call meetStruct$Call) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$Call);
    }

    public static MeetStruct$Call parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$Call) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$Call parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$Call parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$Call parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$Call parseFrom(byte[] bArr) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$Call parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$Call parseFrom(InputStream inputStream) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$Call parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$Call parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$Call parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
