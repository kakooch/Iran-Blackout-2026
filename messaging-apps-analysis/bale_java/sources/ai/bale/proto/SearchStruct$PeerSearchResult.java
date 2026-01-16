package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC4246Eh6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$PeerSearchResult extends GeneratedMessageLite implements InterfaceC4246Eh6 {
    public static final int CREATOR_FIELD_NUMBER = 6;
    public static final int DATE_CREATED_FIELD_NUMBER = 5;
    private static final SearchStruct$PeerSearchResult DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int IS_JOINED_FIELD_NUMBER = 8;
    public static final int IS_PUBLIC_FIELD_NUMBER = 7;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int bitField0_;
    private Int32Value creator_;
    private CollectionsStruct$Int64Value dateCreated_;
    private StringValue description_;
    private BoolValue isJoined_;
    private BoolValue isPublic_;
    private Int32Value membersCount_;
    private PeersStruct$Peer peer_;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4246Eh6 {
        private a() {
            super(SearchStruct$PeerSearchResult.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$PeerSearchResult searchStruct$PeerSearchResult = new SearchStruct$PeerSearchResult();
        DEFAULT_INSTANCE = searchStruct$PeerSearchResult;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$PeerSearchResult.class, searchStruct$PeerSearchResult);
    }

    private SearchStruct$PeerSearchResult() {
    }

    private void clearCreator() {
        this.creator_ = null;
        this.bitField0_ &= -17;
    }

    private void clearDateCreated() {
        this.dateCreated_ = null;
        this.bitField0_ &= -9;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
    }

    private void clearIsJoined() {
        this.isJoined_ = null;
        this.bitField0_ &= -65;
    }

    private void clearIsPublic() {
        this.isPublic_ = null;
        this.bitField0_ &= -33;
    }

    private void clearMembersCount() {
        this.membersCount_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static SearchStruct$PeerSearchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCreator(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.creator_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.creator_ = int32Value;
        } else {
            this.creator_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.creator_).v(int32Value)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeDateCreated(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.dateCreated_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.dateCreated_ = collectionsStruct$Int64Value;
        } else {
            this.dateCreated_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.dateCreated_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeIsJoined(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isJoined_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isJoined_ = boolValue;
        } else {
            this.isJoined_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isJoined_).v(boolValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeIsPublic(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isPublic_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isPublic_ = boolValue;
        } else {
            this.isPublic_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isPublic_).v(boolValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeMembersCount(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.membersCount_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.membersCount_ = int32Value;
        } else {
            this.membersCount_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.membersCount_).v(int32Value)).j();
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
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$PeerSearchResult parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$PeerSearchResult parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreator(Int32Value int32Value) {
        int32Value.getClass();
        this.creator_ = int32Value;
        this.bitField0_ |= 16;
    }

    private void setDateCreated(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.dateCreated_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 8;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setIsJoined(BoolValue boolValue) {
        boolValue.getClass();
        this.isJoined_ = boolValue;
        this.bitField0_ |= 64;
    }

    private void setIsPublic(BoolValue boolValue) {
        boolValue.getClass();
        this.isPublic_ = boolValue;
        this.bitField0_ |= 32;
    }

    private void setMembersCount(Int32Value int32Value) {
        int32Value.getClass();
        this.membersCount_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$PeerSearchResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006ဉ\u0004\u0007ဉ\u0005\bဉ\u0006", new Object[]{"bitField0_", "peer_", "title_", "description_", "membersCount_", "dateCreated_", "creator_", "isPublic_", "isJoined_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$PeerSearchResult.class) {
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

    public Int32Value getCreator() {
        Int32Value int32Value = this.creator_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public CollectionsStruct$Int64Value getDateCreated() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.dateCreated_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public BoolValue getIsJoined() {
        BoolValue boolValue = this.isJoined_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsPublic() {
        BoolValue boolValue = this.isPublic_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public Int32Value getMembersCount() {
        Int32Value int32Value = this.membersCount_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasCreator() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasDateCreated() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIsJoined() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasIsPublic() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasMembersCount() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchStruct$PeerSearchResult searchStruct$PeerSearchResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$PeerSearchResult);
    }

    public static SearchStruct$PeerSearchResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$PeerSearchResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$PeerSearchResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$PeerSearchResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$PeerSearchResult parseFrom(byte[] bArr) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$PeerSearchResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$PeerSearchResult parseFrom(InputStream inputStream) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$PeerSearchResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$PeerSearchResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$PeerSearchResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$PeerSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
