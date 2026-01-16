package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class Ghasedak$RequestGetRoutesStates extends GeneratedMessageLite implements U64 {
    private static final Ghasedak$RequestGetRoutesStates DEFAULT_INSTANCE;
    public static final int GROUP_PEERS_FIELD_NUMBER = 1;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private static final B.h.a optimizations_converter_ = new a();
    private int optimizationsMemoizedSerializedSize;
    private B.j groupPeers_ = GeneratedMessageLite.emptyProtobufList();
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
            ((Ghasedak$RequestGetRoutesStates) this.b).addAllGroupPeers(iterable);
            return this;
        }

        public b B(Iterable iterable) {
            q();
            ((Ghasedak$RequestGetRoutesStates) this.b).addAllOptimizations(iterable);
            return this;
        }

        private b() {
            super(Ghasedak$RequestGetRoutesStates.DEFAULT_INSTANCE);
        }
    }

    static {
        Ghasedak$RequestGetRoutesStates ghasedak$RequestGetRoutesStates = new Ghasedak$RequestGetRoutesStates();
        DEFAULT_INSTANCE = ghasedak$RequestGetRoutesStates;
        GeneratedMessageLite.registerDefaultInstance(Ghasedak$RequestGetRoutesStates.class, ghasedak$RequestGetRoutesStates);
    }

    private Ghasedak$RequestGetRoutesStates() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllGroupPeers(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupPeers_);
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

    private void addGroupPeers(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.add(peersStruct$GroupOutPeer);
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

    private void clearGroupPeers() {
        this.groupPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureGroupPeersIsMutable() {
        B.j jVar = this.groupPeers_;
        if (jVar.u()) {
            return;
        }
        this.groupPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static Ghasedak$RequestGetRoutesStates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ghasedak$RequestGetRoutesStates parseDelimitedFrom(InputStream inputStream) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(ByteBuffer byteBuffer) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroupPeers(int i) {
        ensureGroupPeersIsMutable();
        this.groupPeers_.remove(i);
    }

    private void setGroupPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.set(i, peersStruct$GroupOutPeer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1862i0.a[gVar.ordinal()]) {
            case 1:
                return new Ghasedak$RequestGetRoutesStates();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002,", new Object[]{"groupPeers_", PeersStruct$GroupOutPeer.class, "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ghasedak$RequestGetRoutesStates.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeers(int i) {
        return (PeersStruct$GroupOutPeer) this.groupPeers_.get(i);
    }

    public int getGroupPeersCount() {
        return this.groupPeers_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupPeersList() {
        return this.groupPeers_;
    }

    public InterfaceC11468d35 getGroupPeersOrBuilder(int i) {
        return (InterfaceC11468d35) this.groupPeers_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupPeersOrBuilderList() {
        return this.groupPeers_;
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

    public static b newBuilder(Ghasedak$RequestGetRoutesStates ghasedak$RequestGetRoutesStates) {
        return (b) DEFAULT_INSTANCE.createBuilder(ghasedak$RequestGetRoutesStates);
    }

    public static Ghasedak$RequestGetRoutesStates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(AbstractC2383g abstractC2383g) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroupPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.add(i, peersStruct$GroupOutPeer);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(byte[] bArr) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(InputStream inputStream) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(AbstractC2384h abstractC2384h) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ghasedak$RequestGetRoutesStates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ghasedak$RequestGetRoutesStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
