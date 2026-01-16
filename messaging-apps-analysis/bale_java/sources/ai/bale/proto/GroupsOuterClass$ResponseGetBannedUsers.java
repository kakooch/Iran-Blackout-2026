package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16540lS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseGetBannedUsers extends GeneratedMessageLite implements U64 {
    public static final int BANNED_USERS_FIELD_NUMBER = 3;
    private static final GroupsOuterClass$ResponseGetBannedUsers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bannedUsers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetBannedUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetBannedUsers groupsOuterClass$ResponseGetBannedUsers = new GroupsOuterClass$ResponseGetBannedUsers();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetBannedUsers;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetBannedUsers.class, groupsOuterClass$ResponseGetBannedUsers);
    }

    private GroupsOuterClass$ResponseGetBannedUsers() {
    }

    private void addAllBannedUsers(Iterable<? extends GroupsStruct$BannedUser> iterable) {
        ensureBannedUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bannedUsers_);
    }

    private void addBannedUsers(GroupsStruct$BannedUser groupsStruct$BannedUser) {
        groupsStruct$BannedUser.getClass();
        ensureBannedUsersIsMutable();
        this.bannedUsers_.add(groupsStruct$BannedUser);
    }

    private void clearBannedUsers() {
        this.bannedUsers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBannedUsersIsMutable() {
        B.j jVar = this.bannedUsers_;
        if (jVar.u()) {
            return;
        }
        this.bannedUsers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBannedUsers(int i) {
        ensureBannedUsersIsMutable();
        this.bannedUsers_.remove(i);
    }

    private void setBannedUsers(int i, GroupsStruct$BannedUser groupsStruct$BannedUser) {
        groupsStruct$BannedUser.getClass();
        ensureBannedUsersIsMutable();
        this.bannedUsers_.set(i, groupsStruct$BannedUser);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetBannedUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0000\u0003\u001b", new Object[]{"bannedUsers_", GroupsStruct$BannedUser.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetBannedUsers.class) {
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

    public GroupsStruct$BannedUser getBannedUsers(int i) {
        return (GroupsStruct$BannedUser) this.bannedUsers_.get(i);
    }

    public int getBannedUsersCount() {
        return this.bannedUsers_.size();
    }

    public List<GroupsStruct$BannedUser> getBannedUsersList() {
        return this.bannedUsers_;
    }

    public InterfaceC16540lS2 getBannedUsersOrBuilder(int i) {
        return (InterfaceC16540lS2) this.bannedUsers_.get(i);
    }

    public List<? extends InterfaceC16540lS2> getBannedUsersOrBuilderList() {
        return this.bannedUsers_;
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetBannedUsers groupsOuterClass$ResponseGetBannedUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetBannedUsers);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBannedUsers(int i, GroupsStruct$BannedUser groupsStruct$BannedUser) {
        groupsStruct$BannedUser.getClass();
        ensureBannedUsersIsMutable();
        this.bannedUsers_.add(i, groupsStruct$BannedUser);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetBannedUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetBannedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
