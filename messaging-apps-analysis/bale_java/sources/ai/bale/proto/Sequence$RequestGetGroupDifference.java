package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.InterfaceC8356Vp6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Sequence$RequestGetGroupDifference extends GeneratedMessageLite implements U64 {
    private static final Sequence$RequestGetGroupDifference DEFAULT_INSTANCE;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
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
        private b() {
            super(Sequence$RequestGetGroupDifference.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$RequestGetGroupDifference sequence$RequestGetGroupDifference = new Sequence$RequestGetGroupDifference();
        DEFAULT_INSTANCE = sequence$RequestGetGroupDifference;
        GeneratedMessageLite.registerDefaultInstance(Sequence$RequestGetGroupDifference.class, sequence$RequestGetGroupDifference);
    }

    private Sequence$RequestGetGroupDifference() {
    }

    private void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
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

    private void addAllStates(Iterable<? extends SequenceStruct$SeqState> iterable) {
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

    private void addStates(SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        ensureStatesIsMutable();
        this.states_.add(sequenceStruct$SeqState);
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

    public static Sequence$RequestGetGroupDifference getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$RequestGetGroupDifference parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setStates(int i, SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        ensureStatesIsMutable();
        this.states_.set(i, sequenceStruct$SeqState);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$RequestGetGroupDifference();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u001b\u0003,", new Object[]{"states_", SequenceStruct$SeqState.class, "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$RequestGetGroupDifference.class) {
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

    public SequenceStruct$SeqState getStates(int i) {
        return (SequenceStruct$SeqState) this.states_.get(i);
    }

    public int getStatesCount() {
        return this.states_.size();
    }

    public List<SequenceStruct$SeqState> getStatesList() {
        return this.states_;
    }

    public InterfaceC8356Vp6 getStatesOrBuilder(int i) {
        return (InterfaceC8356Vp6) this.states_.get(i);
    }

    public List<? extends InterfaceC8356Vp6> getStatesOrBuilderList() {
        return this.states_;
    }

    public static b newBuilder(Sequence$RequestGetGroupDifference sequence$RequestGetGroupDifference) {
        return (b) DEFAULT_INSTANCE.createBuilder(sequence$RequestGetGroupDifference);
    }

    public static Sequence$RequestGetGroupDifference parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStates(int i, SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        ensureStatesIsMutable();
        this.states_.add(i, sequenceStruct$SeqState);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(byte[] bArr) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(InputStream inputStream) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$RequestGetGroupDifference parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$RequestGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
