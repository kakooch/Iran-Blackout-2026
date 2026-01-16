package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC16902m35;
import ir.nasim.EnumC24932zS2;
import ir.nasim.GS2;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestCreateGroup extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestCreateGroup DEFAULT_INSTANCE;
    public static final int GROUP_TYPE_FIELD_NUMBER = 6;
    public static final int NICK_FIELD_NUMBER = 8;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int RESTRICTION_FIELD_NUMBER = 9;
    public static final int RID_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int USERS_FIELD_NUMBER = 3;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private int groupType_;
    private StringValue nick_;
    private int optimizationsMemoizedSerializedSize;
    private int restriction_;
    private long rid_;
    private String title_ = "";
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16902m35 a(Integer num) {
            EnumC16902m35 enumC16902m35J = EnumC16902m35.j(num.intValue());
            return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        public b A(Iterable iterable) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(Iterable iterable) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).addAllUsers(iterable);
            return this;
        }

        public b C(EnumC24932zS2 enumC24932zS2) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).setGroupType(enumC24932zS2);
            return this;
        }

        public b D(StringValue stringValue) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).setNick(stringValue);
            return this;
        }

        public b E(GS2 gs2) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).setRestriction(gs2);
            return this;
        }

        public b F(long j) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).setRid(j);
            return this;
        }

        public b G(String str) {
            q();
            ((GroupsOuterClass$RequestCreateGroup) this.b).setTitle(str);
            return this;
        }

        private b() {
            super(GroupsOuterClass$RequestCreateGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestCreateGroup groupsOuterClass$RequestCreateGroup = new GroupsOuterClass$RequestCreateGroup();
        DEFAULT_INSTANCE = groupsOuterClass$RequestCreateGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestCreateGroup.class, groupsOuterClass$RequestCreateGroup);
    }

    private GroupsOuterClass$RequestCreateGroup() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<? extends EnumC16902m35> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().getNumber());
        }
    }

    private void addAllOptimizationsValue(Iterable<Integer> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUsers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addOptimizations(EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(enumC16902m35.getNumber());
    }

    private void addOptimizationsValue(int i) {
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(i);
    }

    private void addUsers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(peersStruct$UserOutPeer);
    }

    private void clearGroupType() {
        this.groupType_ = 0;
    }

    private void clearNick() {
        this.nick_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$RequestCreateGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNick(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nick_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nick_ = stringValue;
        } else {
            this.nick_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nick_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestCreateGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupType(EnumC24932zS2 enumC24932zS2) {
        this.groupType_ = enumC24932zS2.getNumber();
    }

    private void setGroupTypeValue(int i) {
        this.groupType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNick(StringValue stringValue) {
        stringValue.getClass();
        this.nick_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setOptimizations(int i, EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, enumC16902m35.getNumber());
    }

    private void setOptimizationsValue(int i, int i2) {
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRestriction(GS2 gs2) {
        this.restriction_ = gs2.getNumber();
    }

    private void setRestrictionValue(int i) {
        this.restriction_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
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
                return new GroupsOuterClass$RequestCreateGroup();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001\u0002\u0002Ȉ\u0003\u001b\u0006\f\u0007,\bဉ\u0000\t\f", new Object[]{"bitField0_", "rid_", "title_", "users_", PeersStruct$UserOutPeer.class, "groupType_", "optimizations_", "nick_", "restriction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestCreateGroup.class) {
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

    public EnumC24932zS2 getGroupType() {
        EnumC24932zS2 enumC24932zS2J = EnumC24932zS2.j(this.groupType_);
        return enumC24932zS2J == null ? EnumC24932zS2.UNRECOGNIZED : enumC24932zS2J;
    }

    public int getGroupTypeValue() {
        return this.groupType_;
    }

    public StringValue getNick() {
        StringValue stringValue = this.nick_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC16902m35 getOptimizations(int i) {
        EnumC16902m35 enumC16902m35J = EnumC16902m35.j(this.optimizations_.getInt(i));
        return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
    }

    public int getOptimizationsCount() {
        return this.optimizations_.size();
    }

    public List<EnumC16902m35> getOptimizationsList() {
        return new B.h(this.optimizations_, optimizations_converter_);
    }

    public int getOptimizationsValue(int i) {
        return this.optimizations_.getInt(i);
    }

    public List<Integer> getOptimizationsValueList() {
        return this.optimizations_;
    }

    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    public int getRestrictionValue() {
        return this.restriction_;
    }

    public long getRid() {
        return this.rid_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
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

    public boolean hasNick() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(GroupsOuterClass$RequestCreateGroup groupsOuterClass$RequestCreateGroup) {
        return (b) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestCreateGroup);
    }

    public static GroupsOuterClass$RequestCreateGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, peersStruct$UserOutPeer);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestCreateGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
