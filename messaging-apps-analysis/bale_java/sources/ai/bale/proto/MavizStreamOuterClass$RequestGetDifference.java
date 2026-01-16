package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.SV3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$RequestGetDifference extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$RequestGetDifference DEFAULT_INSTANCE;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int ROUTE_SEQUENCES_FIELD_NUMBER = 1;
    private static final B.h.a optimizations_converter_ = new a();
    private int optimizationsMemoizedSerializedSize;
    private B.j routeSequences_ = GeneratedMessageLite.emptyProtobufList();
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
            super(MavizStreamOuterClass$RequestGetDifference.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$RequestGetDifference mavizStreamOuterClass$RequestGetDifference = new MavizStreamOuterClass$RequestGetDifference();
        DEFAULT_INSTANCE = mavizStreamOuterClass$RequestGetDifference;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$RequestGetDifference.class, mavizStreamOuterClass$RequestGetDifference);
    }

    private MavizStreamOuterClass$RequestGetDifference() {
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

    private void addAllRouteSequences(Iterable<? extends MavizStreamOuterClass$RouteSeq> iterable) {
        ensureRouteSequencesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.routeSequences_);
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

    private void addRouteSequences(MavizStreamOuterClass$RouteSeq mavizStreamOuterClass$RouteSeq) {
        mavizStreamOuterClass$RouteSeq.getClass();
        ensureRouteSequencesIsMutable();
        this.routeSequences_.add(mavizStreamOuterClass$RouteSeq);
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearRouteSequences() {
        this.routeSequences_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureRouteSequencesIsMutable() {
        B.j jVar = this.routeSequences_;
        if (jVar.u()) {
            return;
        }
        this.routeSequences_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MavizStreamOuterClass$RequestGetDifference getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$RequestGetDifference parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRouteSequences(int i) {
        ensureRouteSequencesIsMutable();
        this.routeSequences_.remove(i);
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

    private void setRouteSequences(int i, MavizStreamOuterClass$RouteSeq mavizStreamOuterClass$RouteSeq) {
        mavizStreamOuterClass$RouteSeq.getClass();
        ensureRouteSequencesIsMutable();
        this.routeSequences_.set(i, mavizStreamOuterClass$RouteSeq);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$RequestGetDifference();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002,", new Object[]{"routeSequences_", MavizStreamOuterClass$RouteSeq.class, "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$RequestGetDifference.class) {
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

    public MavizStreamOuterClass$RouteSeq getRouteSequences(int i) {
        return (MavizStreamOuterClass$RouteSeq) this.routeSequences_.get(i);
    }

    public int getRouteSequencesCount() {
        return this.routeSequences_.size();
    }

    public List<MavizStreamOuterClass$RouteSeq> getRouteSequencesList() {
        return this.routeSequences_;
    }

    public SV3 getRouteSequencesOrBuilder(int i) {
        return (SV3) this.routeSequences_.get(i);
    }

    public List<? extends SV3> getRouteSequencesOrBuilderList() {
        return this.routeSequences_;
    }

    public static b newBuilder(MavizStreamOuterClass$RequestGetDifference mavizStreamOuterClass$RequestGetDifference) {
        return (b) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$RequestGetDifference);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRouteSequences(int i, MavizStreamOuterClass$RouteSeq mavizStreamOuterClass$RouteSeq) {
        mavizStreamOuterClass$RouteSeq.getClass();
        ensureRouteSequencesIsMutable();
        this.routeSequences_.add(i, mavizStreamOuterClass$RouteSeq);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$RequestGetDifference parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
