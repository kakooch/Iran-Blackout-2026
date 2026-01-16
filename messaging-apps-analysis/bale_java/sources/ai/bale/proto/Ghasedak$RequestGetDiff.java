package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.PG2;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class Ghasedak$RequestGetDiff extends GeneratedMessageLite implements U64 {
    private static final Ghasedak$RequestGetDiff DEFAULT_INSTANCE;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATES_FIELD_NUMBER = 1;
    private static final B.h.a optimizations_converter_ = new a();
    private int optimizationsMemoizedSerializedSize;
    private B.j states_ = GeneratedMessageLite.emptyProtobufList();
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
            ((Ghasedak$RequestGetDiff) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(Iterable iterable) {
            q();
            ((Ghasedak$RequestGetDiff) this.b).addAllStates(iterable);
            return this;
        }

        private b() {
            super(Ghasedak$RequestGetDiff.DEFAULT_INSTANCE);
        }
    }

    static {
        Ghasedak$RequestGetDiff ghasedak$RequestGetDiff = new Ghasedak$RequestGetDiff();
        DEFAULT_INSTANCE = ghasedak$RequestGetDiff;
        GeneratedMessageLite.registerDefaultInstance(Ghasedak$RequestGetDiff.class, ghasedak$RequestGetDiff);
    }

    private Ghasedak$RequestGetDiff() {
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
    public void addAllStates(Iterable<? extends Ghasedak$RouteSeqState> iterable) {
        ensureStatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.states_);
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

    private void addStates(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        ghasedak$RouteSeqState.getClass();
        ensureStatesIsMutable();
        this.states_.add(ghasedak$RouteSeqState);
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearStates() {
        this.states_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureStatesIsMutable() {
        B.j jVar = this.states_;
        if (jVar.u()) {
            return;
        }
        this.states_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Ghasedak$RequestGetDiff getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ghasedak$RequestGetDiff parseDelimitedFrom(InputStream inputStream) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$RequestGetDiff parseFrom(ByteBuffer byteBuffer) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStates(int i) {
        ensureStatesIsMutable();
        this.states_.remove(i);
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

    private void setStates(int i, Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        ghasedak$RouteSeqState.getClass();
        ensureStatesIsMutable();
        this.states_.set(i, ghasedak$RouteSeqState);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1862i0.a[gVar.ordinal()]) {
            case 1:
                return new Ghasedak$RequestGetDiff();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002,", new Object[]{"states_", Ghasedak$RouteSeqState.class, "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ghasedak$RequestGetDiff.class) {
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

    public Ghasedak$RouteSeqState getStates(int i) {
        return (Ghasedak$RouteSeqState) this.states_.get(i);
    }

    public int getStatesCount() {
        return this.states_.size();
    }

    public List<Ghasedak$RouteSeqState> getStatesList() {
        return this.states_;
    }

    public PG2 getStatesOrBuilder(int i) {
        return (PG2) this.states_.get(i);
    }

    public List<? extends PG2> getStatesOrBuilderList() {
        return this.states_;
    }

    public static b newBuilder(Ghasedak$RequestGetDiff ghasedak$RequestGetDiff) {
        return (b) DEFAULT_INSTANCE.createBuilder(ghasedak$RequestGetDiff);
    }

    public static Ghasedak$RequestGetDiff parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$RequestGetDiff parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ghasedak$RequestGetDiff parseFrom(AbstractC2383g abstractC2383g) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStates(int i, Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        ghasedak$RouteSeqState.getClass();
        ensureStatesIsMutable();
        this.states_.add(i, ghasedak$RouteSeqState);
    }

    public static Ghasedak$RequestGetDiff parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ghasedak$RequestGetDiff parseFrom(byte[] bArr) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ghasedak$RequestGetDiff parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ghasedak$RequestGetDiff parseFrom(InputStream inputStream) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$RequestGetDiff parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$RequestGetDiff parseFrom(AbstractC2384h abstractC2384h) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ghasedak$RequestGetDiff parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ghasedak$RequestGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
