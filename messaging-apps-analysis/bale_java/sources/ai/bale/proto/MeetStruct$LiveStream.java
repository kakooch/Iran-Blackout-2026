package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetStruct$LiveStream extends GeneratedMessageLite implements U64 {
    public static final int CREATE_DATE_FIELD_NUMBER = 6;
    private static final MeetStruct$LiveStream DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 7;
    public static final int EXT_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 8;
    public static final int ROOM_FIELD_NUMBER = 2;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 4;
    public static final int VIDEO_FIELD_NUMBER = 5;
    private int bitField0_;
    private CollectionsStruct$Int64Value createDate_;
    private CollectionsStruct$Int32Value duration_;
    private long id_;
    private PeersStruct$ExPeer peer_;
    private CollectionsStruct$StringValue url_;
    private boolean video_;
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private String room_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$LiveStream.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        MeetStruct$LiveStream meetStruct$LiveStream = new MeetStruct$LiveStream();
        DEFAULT_INSTANCE = meetStruct$LiveStream;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$LiveStream.class, meetStruct$LiveStream);
    }

    private MeetStruct$LiveStream() {
    }

    private void clearCreateDate() {
        this.createDate_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDuration() {
        this.duration_ = null;
        this.bitField0_ &= -5;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -9;
    }

    private void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
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

    public static MeetStruct$LiveStream getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
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

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
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

    public static MeetStruct$LiveStream parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$LiveStream parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    private void setId(long j) {
        this.id_ = j;
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 8;
    }

    private void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    private void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$LiveStream();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0001\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005\u0007\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003\t2", new Object[]{"bitField0_", "id_", "room_", "token_", "url_", "video_", "createDate_", "duration_", "peer_", "ext_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$LiveStream.class) {
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

    public long getId() {
        return this.id_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
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

    public boolean hasPeer() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetStruct$LiveStream meetStruct$LiveStream) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$LiveStream);
    }

    public static MeetStruct$LiveStream parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$LiveStream parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$LiveStream parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$LiveStream parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$LiveStream parseFrom(byte[] bArr) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$LiveStream parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$LiveStream parseFrom(InputStream inputStream) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$LiveStream parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$LiveStream parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$LiveStream parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$LiveStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
