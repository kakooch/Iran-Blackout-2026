package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18855pM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseLoadFullUsers extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$ResponseLoadFullUsers DEFAULT_INSTANCE;
    public static final int FULL_USERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j fullUsers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseLoadFullUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseLoadFullUsers usersOuterClass$ResponseLoadFullUsers = new UsersOuterClass$ResponseLoadFullUsers();
        DEFAULT_INSTANCE = usersOuterClass$ResponseLoadFullUsers;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseLoadFullUsers.class, usersOuterClass$ResponseLoadFullUsers);
    }

    private UsersOuterClass$ResponseLoadFullUsers() {
    }

    private void addAllFullUsers(Iterable<? extends UsersStruct$FullUserLegacy> iterable) {
        ensureFullUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fullUsers_);
    }

    private void addFullUsers(UsersStruct$FullUserLegacy usersStruct$FullUserLegacy) {
        usersStruct$FullUserLegacy.getClass();
        ensureFullUsersIsMutable();
        this.fullUsers_.add(usersStruct$FullUserLegacy);
    }

    private void clearFullUsers() {
        this.fullUsers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFullUsersIsMutable() {
        B.j jVar = this.fullUsers_;
        if (jVar.u()) {
            return;
        }
        this.fullUsers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$ResponseLoadFullUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFullUsers(int i) {
        ensureFullUsersIsMutable();
        this.fullUsers_.remove(i);
    }

    private void setFullUsers(int i, UsersStruct$FullUserLegacy usersStruct$FullUserLegacy) {
        usersStruct$FullUserLegacy.getClass();
        ensureFullUsersIsMutable();
        this.fullUsers_.set(i, usersStruct$FullUserLegacy);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseLoadFullUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"fullUsers_", UsersStruct$FullUserLegacy.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseLoadFullUsers.class) {
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

    public UsersStruct$FullUserLegacy getFullUsers(int i) {
        return (UsersStruct$FullUserLegacy) this.fullUsers_.get(i);
    }

    public int getFullUsersCount() {
        return this.fullUsers_.size();
    }

    public List<UsersStruct$FullUserLegacy> getFullUsersList() {
        return this.fullUsers_;
    }

    public InterfaceC18855pM7 getFullUsersOrBuilder(int i) {
        return (InterfaceC18855pM7) this.fullUsers_.get(i);
    }

    public List<? extends InterfaceC18855pM7> getFullUsersOrBuilderList() {
        return this.fullUsers_;
    }

    public static a newBuilder(UsersOuterClass$ResponseLoadFullUsers usersOuterClass$ResponseLoadFullUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseLoadFullUsers);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFullUsers(int i, UsersStruct$FullUserLegacy usersStruct$FullUserLegacy) {
        usersStruct$FullUserLegacy.getClass();
        ensureFullUsersIsMutable();
        this.fullUsers_.add(i, usersStruct$FullUserLegacy);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseLoadFullUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadFullUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
