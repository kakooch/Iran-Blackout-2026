package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.HM7;
import ir.nasim.JM7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersStruct$PuppetGroup extends GeneratedMessageLite implements HM7 {
    private static final UsersStruct$PuppetGroup DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PUPPETS_FIELD_NUMBER = 2;
    private String name_ = "";
    private B.j puppets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements HM7 {
        private a() {
            super(UsersStruct$PuppetGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$PuppetGroup usersStruct$PuppetGroup = new UsersStruct$PuppetGroup();
        DEFAULT_INSTANCE = usersStruct$PuppetGroup;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$PuppetGroup.class, usersStruct$PuppetGroup);
    }

    private UsersStruct$PuppetGroup() {
    }

    private void addAllPuppets(Iterable<? extends UsersStruct$PuppetUser> iterable) {
        ensurePuppetsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.puppets_);
    }

    private void addPuppets(UsersStruct$PuppetUser usersStruct$PuppetUser) {
        usersStruct$PuppetUser.getClass();
        ensurePuppetsIsMutable();
        this.puppets_.add(usersStruct$PuppetUser);
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearPuppets() {
        this.puppets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePuppetsIsMutable() {
        B.j jVar = this.puppets_;
        if (jVar.u()) {
            return;
        }
        this.puppets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersStruct$PuppetGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$PuppetGroup parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$PuppetGroup parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePuppets(int i) {
        ensurePuppetsIsMutable();
        this.puppets_.remove(i);
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setPuppets(int i, UsersStruct$PuppetUser usersStruct$PuppetUser) {
        usersStruct$PuppetUser.getClass();
        ensurePuppetsIsMutable();
        this.puppets_.set(i, usersStruct$PuppetUser);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$PuppetGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"name_", "puppets_", UsersStruct$PuppetUser.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$PuppetGroup.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public UsersStruct$PuppetUser getPuppets(int i) {
        return (UsersStruct$PuppetUser) this.puppets_.get(i);
    }

    public int getPuppetsCount() {
        return this.puppets_.size();
    }

    public List<UsersStruct$PuppetUser> getPuppetsList() {
        return this.puppets_;
    }

    public JM7 getPuppetsOrBuilder(int i) {
        return (JM7) this.puppets_.get(i);
    }

    public List<? extends JM7> getPuppetsOrBuilderList() {
        return this.puppets_;
    }

    public static a newBuilder(UsersStruct$PuppetGroup usersStruct$PuppetGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$PuppetGroup);
    }

    public static UsersStruct$PuppetGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$PuppetGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$PuppetGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPuppets(int i, UsersStruct$PuppetUser usersStruct$PuppetUser) {
        usersStruct$PuppetUser.getClass();
        ensurePuppetsIsMutable();
        this.puppets_.add(i, usersStruct$PuppetUser);
    }

    public static UsersStruct$PuppetGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$PuppetGroup parseFrom(byte[] bArr) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$PuppetGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$PuppetGroup parseFrom(InputStream inputStream) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$PuppetGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$PuppetGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$PuppetGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$PuppetGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
