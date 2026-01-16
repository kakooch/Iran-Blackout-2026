package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.SearchStruct$SearchPieceText;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchMembers extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestSearchMembers DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 2;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    public static final int USERS_FIELD_NUMBER = 4;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private BytesValue loadMoreState_;
    private SearchStruct$SearchPieceText query_;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((SearchOuterClass$RequestSearchMembers) this.b).addAllUsers(iterable);
            return this;
        }

        public a B(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((SearchOuterClass$RequestSearchMembers) this.b).setExPeer(peersStruct$ExPeer);
            return this;
        }

        public a C(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
            q();
            ((SearchOuterClass$RequestSearchMembers) this.b).setQuery(searchStruct$SearchPieceText);
            return this;
        }

        private a() {
            super(SearchOuterClass$RequestSearchMembers.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchMembers searchOuterClass$RequestSearchMembers = new SearchOuterClass$RequestSearchMembers();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchMembers;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchMembers.class, searchOuterClass$RequestSearchMembers);
    }

    private SearchOuterClass$RequestSearchMembers() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUsers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addUsers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(peersStruct$UserOutPeer);
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -5;
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$RequestSearchMembers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeQuery(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        SearchStruct$SearchPieceText searchStruct$SearchPieceText2 = this.query_;
        if (searchStruct$SearchPieceText2 == null || searchStruct$SearchPieceText2 == SearchStruct$SearchPieceText.getDefaultInstance()) {
            this.query_ = searchStruct$SearchPieceText;
        } else {
            this.query_ = (SearchStruct$SearchPieceText) ((SearchStruct$SearchPieceText.a) SearchStruct$SearchPieceText.newBuilder(this.query_).v(searchStruct$SearchPieceText)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$RequestSearchMembers parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 2;
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        this.query_ = searchStruct$SearchPieceText;
        this.bitField0_ |= 1;
    }

    private void setUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchMembers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b", new Object[]{"bitField0_", "query_", "exPeer_", "loadMoreState_", "users_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchMembers.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public SearchStruct$SearchPieceText getQuery() {
        SearchStruct$SearchPieceText searchStruct$SearchPieceText = this.query_;
        return searchStruct$SearchPieceText == null ? SearchStruct$SearchPieceText.getDefaultInstance() : searchStruct$SearchPieceText;
    }

    public PeersStruct$UserOutPeer getUsers(int i) {
        return (PeersStruct$UserOutPeer) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<PeersStruct$UserOutPeer> getUsersList() {
        return this.users_;
    }

    public InterfaceC18084o35 getUsersOrBuilder(int i) {
        return (InterfaceC18084o35) this.users_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUsersOrBuilderList() {
        return this.users_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$RequestSearchMembers searchOuterClass$RequestSearchMembers) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchMembers);
    }

    public static SearchOuterClass$RequestSearchMembers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, peersStruct$UserOutPeer);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchMembers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
