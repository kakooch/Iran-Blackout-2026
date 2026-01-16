package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CS2;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseFetchGroupAdmins extends GeneratedMessageLite implements U64 {
    public static final int ADMINS_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$ResponseFetchGroupAdmins DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 1;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j admins_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseFetchGroupAdmins.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseFetchGroupAdmins groupsOuterClass$ResponseFetchGroupAdmins = new GroupsOuterClass$ResponseFetchGroupAdmins();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseFetchGroupAdmins;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseFetchGroupAdmins.class, groupsOuterClass$ResponseFetchGroupAdmins);
    }

    private GroupsOuterClass$ResponseFetchGroupAdmins() {
    }

    private void addAdmins(GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureAdminsIsMutable();
        this.admins_.add(groupsStruct$Member);
    }

    private void addAllAdmins(Iterable<? extends GroupsStruct$Member> iterable) {
        ensureAdminsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.admins_);
    }

    private void addAllUsers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addUsers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(peersStruct$UserOutPeer);
    }

    private void clearAdmins() {
        this.admins_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAdminsIsMutable() {
        B.j jVar = this.admins_;
        if (jVar.u()) {
            return;
        }
        this.admins_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAdmins(int i) {
        ensureAdminsIsMutable();
        this.admins_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setAdmins(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureAdminsIsMutable();
        this.admins_.set(i, groupsStruct$Member);
    }

    private void setUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseFetchGroupAdmins();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"users_", PeersStruct$UserOutPeer.class, "admins_", GroupsStruct$Member.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseFetchGroupAdmins.class) {
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

    public GroupsStruct$Member getAdmins(int i) {
        return (GroupsStruct$Member) this.admins_.get(i);
    }

    public int getAdminsCount() {
        return this.admins_.size();
    }

    public List<GroupsStruct$Member> getAdminsList() {
        return this.admins_;
    }

    public CS2 getAdminsOrBuilder(int i) {
        return (CS2) this.admins_.get(i);
    }

    public List<? extends CS2> getAdminsOrBuilderList() {
        return this.admins_;
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

    public static a newBuilder(GroupsOuterClass$ResponseFetchGroupAdmins groupsOuterClass$ResponseFetchGroupAdmins) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseFetchGroupAdmins);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAdmins(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureAdminsIsMutable();
        this.admins_.add(i, groupsStruct$Member);
    }

    private void addUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, peersStruct$UserOutPeer);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseFetchGroupAdmins parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
