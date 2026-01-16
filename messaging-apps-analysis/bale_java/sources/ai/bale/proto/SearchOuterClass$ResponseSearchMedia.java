package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.InterfaceC3544Bh6;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$ResponseSearchMedia extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$ResponseSearchMedia DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 3;
    public static final int GROUP_OUT_PEERS_FIELD_NUMBER = 6;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int RESULT_COUNT_FIELD_NUMBER = 7;
    public static final int SEARCH_RESULTS_FIELD_NUMBER = 1;
    public static final int USERS_FIELD_NUMBER = 2;
    public static final int USER_OUT_PEERS_FIELD_NUMBER = 5;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private int resultCount_;
    private B.j searchResults_ = GeneratedMessageLite.emptyProtobufList();
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userOutPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupOutPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$ResponseSearchMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$ResponseSearchMedia searchOuterClass$ResponseSearchMedia = new SearchOuterClass$ResponseSearchMedia();
        DEFAULT_INSTANCE = searchOuterClass$ResponseSearchMedia;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$ResponseSearchMedia.class, searchOuterClass$ResponseSearchMedia);
    }

    private SearchOuterClass$ResponseSearchMedia() {
    }

    private void addAllGroupOutPeers(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupOutPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupOutPeers_);
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$Group> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addAllSearchResults(Iterable<? extends SearchStruct$MessageSearchItem> iterable) {
        ensureSearchResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.searchResults_);
    }

    private void addAllUserOutPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserOutPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userOutPeers_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addGroupOutPeers(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupOutPeersIsMutable();
        this.groupOutPeers_.add(peersStruct$GroupOutPeer);
    }

    private void addGroups(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$Group);
    }

    private void addSearchResults(SearchStruct$MessageSearchItem searchStruct$MessageSearchItem) {
        searchStruct$MessageSearchItem.getClass();
        ensureSearchResultsIsMutable();
        this.searchResults_.add(searchStruct$MessageSearchItem);
    }

    private void addUserOutPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.add(peersStruct$UserOutPeer);
    }

    private void addUsers(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(usersStruct$User);
    }

    private void clearGroupOutPeers() {
        this.groupOutPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearResultCount() {
        this.resultCount_ = 0;
    }

    private void clearSearchResults() {
        this.searchResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUserOutPeers() {
        this.userOutPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupOutPeersIsMutable() {
        B.j jVar = this.groupOutPeers_;
        if (jVar.u()) {
            return;
        }
        this.groupOutPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSearchResultsIsMutable() {
        B.j jVar = this.searchResults_;
        if (jVar.u()) {
            return;
        }
        this.searchResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUserOutPeersIsMutable() {
        B.j jVar = this.userOutPeers_;
        if (jVar.u()) {
            return;
        }
        this.userOutPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$ResponseSearchMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$ResponseSearchMedia parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroupOutPeers(int i) {
        ensureGroupOutPeersIsMutable();
        this.groupOutPeers_.remove(i);
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void removeSearchResults(int i) {
        ensureSearchResultsIsMutable();
        this.searchResults_.remove(i);
    }

    private void removeUserOutPeers(int i) {
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setGroupOutPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupOutPeersIsMutable();
        this.groupOutPeers_.set(i, peersStruct$GroupOutPeer);
    }

    private void setGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$Group);
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setResultCount(int i) {
        this.resultCount_ = i;
    }

    private void setSearchResults(int i, SearchStruct$MessageSearchItem searchStruct$MessageSearchItem) {
        searchStruct$MessageSearchItem.getClass();
        ensureSearchResultsIsMutable();
        this.searchResults_.set(i, searchStruct$MessageSearchItem);
    }

    private void setUserOutPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.set(i, peersStruct$UserOutPeer);
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$ResponseSearchMedia();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဉ\u0000\u0005\u001b\u0006\u001b\u0007\u0004", new Object[]{"bitField0_", "searchResults_", SearchStruct$MessageSearchItem.class, "users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class, "loadMoreState_", "userOutPeers_", PeersStruct$UserOutPeer.class, "groupOutPeers_", PeersStruct$GroupOutPeer.class, "resultCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$ResponseSearchMedia.class) {
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

    public PeersStruct$GroupOutPeer getGroupOutPeers(int i) {
        return (PeersStruct$GroupOutPeer) this.groupOutPeers_.get(i);
    }

    public int getGroupOutPeersCount() {
        return this.groupOutPeers_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupOutPeersList() {
        return this.groupOutPeers_;
    }

    public InterfaceC11468d35 getGroupOutPeersOrBuilder(int i) {
        return (InterfaceC11468d35) this.groupOutPeers_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupOutPeersOrBuilderList() {
        return this.groupOutPeers_;
    }

    public GroupsStruct$Group getGroups(int i) {
        return (GroupsStruct$Group) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<GroupsStruct$Group> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC23748xS2 getGroupsOrBuilder(int i) {
        return (InterfaceC23748xS2) this.groups_.get(i);
    }

    public List<? extends InterfaceC23748xS2> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public int getResultCount() {
        return this.resultCount_;
    }

    public SearchStruct$MessageSearchItem getSearchResults(int i) {
        return (SearchStruct$MessageSearchItem) this.searchResults_.get(i);
    }

    public int getSearchResultsCount() {
        return this.searchResults_.size();
    }

    public List<SearchStruct$MessageSearchItem> getSearchResultsList() {
        return this.searchResults_;
    }

    public InterfaceC3544Bh6 getSearchResultsOrBuilder(int i) {
        return (InterfaceC3544Bh6) this.searchResults_.get(i);
    }

    public List<? extends InterfaceC3544Bh6> getSearchResultsOrBuilderList() {
        return this.searchResults_;
    }

    public PeersStruct$UserOutPeer getUserOutPeers(int i) {
        return (PeersStruct$UserOutPeer) this.userOutPeers_.get(i);
    }

    public int getUserOutPeersCount() {
        return this.userOutPeers_.size();
    }

    public List<PeersStruct$UserOutPeer> getUserOutPeersList() {
        return this.userOutPeers_;
    }

    public InterfaceC18084o35 getUserOutPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.userOutPeers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUserOutPeersOrBuilderList() {
        return this.userOutPeers_;
    }

    public UsersStruct$User getUsers(int i) {
        return (UsersStruct$User) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<UsersStruct$User> getUsersList() {
        return this.users_;
    }

    public OM7 getUsersOrBuilder(int i) {
        return (OM7) this.users_.get(i);
    }

    public List<? extends OM7> getUsersOrBuilderList() {
        return this.users_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$ResponseSearchMedia searchOuterClass$ResponseSearchMedia) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$ResponseSearchMedia);
    }

    public static SearchOuterClass$ResponseSearchMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroupOutPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupOutPeersIsMutable();
        this.groupOutPeers_.add(i, peersStruct$GroupOutPeer);
    }

    private void addGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$Group);
    }

    private void addSearchResults(int i, SearchStruct$MessageSearchItem searchStruct$MessageSearchItem) {
        searchStruct$MessageSearchItem.getClass();
        ensureSearchResultsIsMutable();
        this.searchResults_.add(i, searchStruct$MessageSearchItem);
    }

    private void addUserOutPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.add(i, peersStruct$UserOutPeer);
    }

    private void addUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, usersStruct$User);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(byte[] bArr) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$ResponseSearchMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
