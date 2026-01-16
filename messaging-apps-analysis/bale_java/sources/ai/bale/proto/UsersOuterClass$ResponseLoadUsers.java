package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseLoadUsers extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$ResponseLoadUsers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 1;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseLoadUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseLoadUsers usersOuterClass$ResponseLoadUsers = new UsersOuterClass$ResponseLoadUsers();
        DEFAULT_INSTANCE = usersOuterClass$ResponseLoadUsers;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseLoadUsers.class, usersOuterClass$ResponseLoadUsers);
    }

    private UsersOuterClass$ResponseLoadUsers() {
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addUsers(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(usersStruct$User);
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

    public static UsersOuterClass$ResponseLoadUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseLoadUsers parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseLoadUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"users_", UsersStruct$User.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseLoadUsers.class) {
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

    public static a newBuilder(UsersOuterClass$ResponseLoadUsers usersOuterClass$ResponseLoadUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseLoadUsers);
    }

    public static UsersOuterClass$ResponseLoadUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, usersStruct$User);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseLoadUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
