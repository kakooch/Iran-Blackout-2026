package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestInviteUser extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestInviteUser DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    public static final int MESSAGE_COUNT_FIELD_NUMBER = 6;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 4;
    public static final int USER_FIELD_NUMBER = 3;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private Int32Value messageCount_;
    private int optimizationsMemoizedSerializedSize;
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();
    private long rid_;
    private PeersStruct$UserOutPeer user_;

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
            ((GroupsOuterClass$RequestInviteUser) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestInviteUser) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public b C(Int32Value int32Value) {
            q();
            ((GroupsOuterClass$RequestInviteUser) this.b).setMessageCount(int32Value);
            return this;
        }

        public b D(long j) {
            q();
            ((GroupsOuterClass$RequestInviteUser) this.b).setRid(j);
            return this;
        }

        public b E(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
            q();
            ((GroupsOuterClass$RequestInviteUser) this.b).setUser(peersStruct$UserOutPeer);
            return this;
        }

        private b() {
            super(GroupsOuterClass$RequestInviteUser.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestInviteUser groupsOuterClass$RequestInviteUser = new GroupsOuterClass$RequestInviteUser();
        DEFAULT_INSTANCE = groupsOuterClass$RequestInviteUser;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestInviteUser.class, groupsOuterClass$RequestInviteUser);
    }

    private GroupsOuterClass$RequestInviteUser() {
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

    private void addOptimizations(EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(enumC16902m35.getNumber());
    }

    private void addOptimizationsValue(int i) {
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(i);
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessageCount() {
        this.messageCount_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearUser() {
        this.user_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static GroupsOuterClass$RequestInviteUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMessageCount(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.messageCount_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.messageCount_ = int32Value;
        } else {
            this.messageCount_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.messageCount_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.user_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.user_ = peersStruct$UserOutPeer;
        } else {
            this.user_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.user_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestInviteUser parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageCount(Int32Value int32Value) {
        int32Value.getClass();
        this.messageCount_ = int32Value;
        this.bitField0_ |= 4;
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
    public void setRid(long j) {
        this.rid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.user_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestInviteUser();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0003ဉ\u0001\u0004\u0002\u0005,\u0006ဉ\u0002", new Object[]{"bitField0_", "groupPeer_", "user_", "rid_", "optimizations_", "messageCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestInviteUser.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public Int32Value getMessageCount() {
        Int32Value int32Value = this.messageCount_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
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

    public long getRid() {
        return this.rid_;
    }

    public PeersStruct$UserOutPeer getUser() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.user_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMessageCount() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasUser() {
        return (this.bitField0_ & 2) != 0;
    }

    public static b newBuilder(GroupsOuterClass$RequestInviteUser groupsOuterClass$RequestInviteUser) {
        return (b) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestInviteUser);
    }

    public static GroupsOuterClass$RequestInviteUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestInviteUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
