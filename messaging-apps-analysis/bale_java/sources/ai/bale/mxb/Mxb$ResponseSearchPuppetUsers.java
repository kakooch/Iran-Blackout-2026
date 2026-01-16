package ai.bale.mxb;

import ai.bale.proto.UsersStruct$PuppetGroup;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.HM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Mxb$ResponseSearchPuppetUsers extends GeneratedMessageLite implements U64 {
    private static final Mxb$ResponseSearchPuppetUsers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PUPPET_GROUPS_FIELD_NUMBER = 1;
    private B.j puppetGroups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Mxb$ResponseSearchPuppetUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        Mxb$ResponseSearchPuppetUsers mxb$ResponseSearchPuppetUsers = new Mxb$ResponseSearchPuppetUsers();
        DEFAULT_INSTANCE = mxb$ResponseSearchPuppetUsers;
        GeneratedMessageLite.registerDefaultInstance(Mxb$ResponseSearchPuppetUsers.class, mxb$ResponseSearchPuppetUsers);
    }

    private Mxb$ResponseSearchPuppetUsers() {
    }

    private void addAllPuppetGroups(Iterable<? extends UsersStruct$PuppetGroup> iterable) {
        ensurePuppetGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.puppetGroups_);
    }

    private void addPuppetGroups(UsersStruct$PuppetGroup usersStruct$PuppetGroup) {
        usersStruct$PuppetGroup.getClass();
        ensurePuppetGroupsIsMutable();
        this.puppetGroups_.add(usersStruct$PuppetGroup);
    }

    private void clearPuppetGroups() {
        this.puppetGroups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePuppetGroupsIsMutable() {
        B.j jVar = this.puppetGroups_;
        if (jVar.u()) {
            return;
        }
        this.puppetGroups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Mxb$ResponseSearchPuppetUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$ResponseSearchPuppetUsers parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePuppetGroups(int i) {
        ensurePuppetGroupsIsMutable();
        this.puppetGroups_.remove(i);
    }

    private void setPuppetGroups(int i, UsersStruct$PuppetGroup usersStruct$PuppetGroup) {
        usersStruct$PuppetGroup.getClass();
        ensurePuppetGroupsIsMutable();
        this.puppetGroups_.set(i, usersStruct$PuppetGroup);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$ResponseSearchPuppetUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"puppetGroups_", UsersStruct$PuppetGroup.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$ResponseSearchPuppetUsers.class) {
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

    public UsersStruct$PuppetGroup getPuppetGroups(int i) {
        return (UsersStruct$PuppetGroup) this.puppetGroups_.get(i);
    }

    public int getPuppetGroupsCount() {
        return this.puppetGroups_.size();
    }

    public List<UsersStruct$PuppetGroup> getPuppetGroupsList() {
        return this.puppetGroups_;
    }

    public HM7 getPuppetGroupsOrBuilder(int i) {
        return (HM7) this.puppetGroups_.get(i);
    }

    public List<? extends HM7> getPuppetGroupsOrBuilderList() {
        return this.puppetGroups_;
    }

    public static a newBuilder(Mxb$ResponseSearchPuppetUsers mxb$ResponseSearchPuppetUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$ResponseSearchPuppetUsers);
    }

    public static Mxb$ResponseSearchPuppetUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPuppetGroups(int i, UsersStruct$PuppetGroup usersStruct$PuppetGroup) {
        usersStruct$PuppetGroup.getClass();
        ensurePuppetGroupsIsMutable();
        this.puppetGroups_.add(i, usersStruct$PuppetGroup);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(byte[] bArr) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(InputStream inputStream) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$ResponseSearchPuppetUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$ResponseSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
