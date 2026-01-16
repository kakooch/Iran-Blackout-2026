package ai.bale.mxb;

import ai.bale.proto.UsersStruct$PuppetUser;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.JM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Mxb$ResponseGetUserPuppets extends GeneratedMessageLite implements U64 {
    private static final Mxb$ResponseGetUserPuppets DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PUPPET_USERS_FIELD_NUMBER = 1;
    private B.j puppetUsers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Mxb$ResponseGetUserPuppets.DEFAULT_INSTANCE);
        }
    }

    static {
        Mxb$ResponseGetUserPuppets mxb$ResponseGetUserPuppets = new Mxb$ResponseGetUserPuppets();
        DEFAULT_INSTANCE = mxb$ResponseGetUserPuppets;
        GeneratedMessageLite.registerDefaultInstance(Mxb$ResponseGetUserPuppets.class, mxb$ResponseGetUserPuppets);
    }

    private Mxb$ResponseGetUserPuppets() {
    }

    private void addAllPuppetUsers(Iterable<? extends UsersStruct$PuppetUser> iterable) {
        ensurePuppetUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.puppetUsers_);
    }

    private void addPuppetUsers(UsersStruct$PuppetUser usersStruct$PuppetUser) {
        usersStruct$PuppetUser.getClass();
        ensurePuppetUsersIsMutable();
        this.puppetUsers_.add(usersStruct$PuppetUser);
    }

    private void clearPuppetUsers() {
        this.puppetUsers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePuppetUsersIsMutable() {
        B.j jVar = this.puppetUsers_;
        if (jVar.u()) {
            return;
        }
        this.puppetUsers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Mxb$ResponseGetUserPuppets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$ResponseGetUserPuppets parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePuppetUsers(int i) {
        ensurePuppetUsersIsMutable();
        this.puppetUsers_.remove(i);
    }

    private void setPuppetUsers(int i, UsersStruct$PuppetUser usersStruct$PuppetUser) {
        usersStruct$PuppetUser.getClass();
        ensurePuppetUsersIsMutable();
        this.puppetUsers_.set(i, usersStruct$PuppetUser);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$ResponseGetUserPuppets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"puppetUsers_", UsersStruct$PuppetUser.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$ResponseGetUserPuppets.class) {
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

    public UsersStruct$PuppetUser getPuppetUsers(int i) {
        return (UsersStruct$PuppetUser) this.puppetUsers_.get(i);
    }

    public int getPuppetUsersCount() {
        return this.puppetUsers_.size();
    }

    public List<UsersStruct$PuppetUser> getPuppetUsersList() {
        return this.puppetUsers_;
    }

    public JM7 getPuppetUsersOrBuilder(int i) {
        return (JM7) this.puppetUsers_.get(i);
    }

    public List<? extends JM7> getPuppetUsersOrBuilderList() {
        return this.puppetUsers_;
    }

    public static a newBuilder(Mxb$ResponseGetUserPuppets mxb$ResponseGetUserPuppets) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$ResponseGetUserPuppets);
    }

    public static Mxb$ResponseGetUserPuppets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPuppetUsers(int i, UsersStruct$PuppetUser usersStruct$PuppetUser) {
        usersStruct$PuppetUser.getClass();
        ensurePuppetUsersIsMutable();
        this.puppetUsers_.add(i, usersStruct$PuppetUser);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(byte[] bArr) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(InputStream inputStream) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$ResponseGetUserPuppets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$ResponseGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
