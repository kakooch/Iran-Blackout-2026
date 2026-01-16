package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestLeaveGroup extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestLeaveGroup DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    public static final int MAKE_ORPHAN_FIELD_NUMBER = 4;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 2;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private BoolValue makeOrphan_;
    private int optimizationsMemoizedSerializedSize;
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();
    private long rid_;

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
            ((GroupsOuterClass$RequestLeaveGroup) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestLeaveGroup) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public b C(BoolValue boolValue) {
            q();
            ((GroupsOuterClass$RequestLeaveGroup) this.b).setMakeOrphan(boolValue);
            return this;
        }

        public b D(long j) {
            q();
            ((GroupsOuterClass$RequestLeaveGroup) this.b).setRid(j);
            return this;
        }

        private b() {
            super(GroupsOuterClass$RequestLeaveGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestLeaveGroup groupsOuterClass$RequestLeaveGroup = new GroupsOuterClass$RequestLeaveGroup();
        DEFAULT_INSTANCE = groupsOuterClass$RequestLeaveGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestLeaveGroup.class, groupsOuterClass$RequestLeaveGroup);
    }

    private GroupsOuterClass$RequestLeaveGroup() {
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

    private void clearMakeOrphan() {
        this.makeOrphan_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static GroupsOuterClass$RequestLeaveGroup getDefaultInstance() {
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

    private void mergeMakeOrphan(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.makeOrphan_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.makeOrphan_ = boolValue;
        } else {
            this.makeOrphan_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.makeOrphan_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestLeaveGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setMakeOrphan(BoolValue boolValue) {
        boolValue.getClass();
        this.makeOrphan_ = boolValue;
        this.bitField0_ |= 2;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestLeaveGroup();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0003,\u0004ဉ\u0001", new Object[]{"bitField0_", "groupPeer_", "rid_", "optimizations_", "makeOrphan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestLeaveGroup.class) {
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

    public BoolValue getMakeOrphan() {
        BoolValue boolValue = this.makeOrphan_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
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

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMakeOrphan() {
        return (this.bitField0_ & 2) != 0;
    }

    public static b newBuilder(GroupsOuterClass$RequestLeaveGroup groupsOuterClass$RequestLeaveGroup) {
        return (b) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestLeaveGroup);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestLeaveGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestLeaveGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
