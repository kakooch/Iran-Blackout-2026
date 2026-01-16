package j$.util.stream;

import j$.util.function.Consumer;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.s2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0226s2 extends CountedCompleter implements InterfaceC0192m3 {
    protected final j$.util.t a;
    protected final AbstractC0256y2 b;
    protected final long c;
    protected long d;
    protected long e;
    protected int f;
    protected int g;

    AbstractC0226s2(AbstractC0226s2 abstractC0226s2, j$.util.t tVar, long j, long j2, int i) {
        super(abstractC0226s2);
        this.a = tVar;
        this.b = abstractC0226s2.b;
        this.c = abstractC0226s2.c;
        this.d = j;
        this.e = j2;
        if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
        }
    }

    AbstractC0226s2(j$.util.t tVar, AbstractC0256y2 abstractC0256y2, int i) {
        this.a = tVar;
        this.b = abstractC0256y2;
        this.c = AbstractC0146f.h(tVar.estimateSize());
        this.d = 0L;
        this.e = i;
    }

    abstract AbstractC0226s2 a(j$.util.t tVar, long j, long j2);

    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        AbstractC0202o1.d(this);
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        AbstractC0202o1.e(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        j$.util.t tVarTrySplit;
        j$.util.t tVar = this.a;
        AbstractC0226s2 abstractC0226s2A = this;
        while (tVar.estimateSize() > abstractC0226s2A.c && (tVarTrySplit = tVar.trySplit()) != null) {
            abstractC0226s2A.setPendingCount(1);
            long jEstimateSize = tVarTrySplit.estimateSize();
            abstractC0226s2A.a(tVarTrySplit, abstractC0226s2A.d, jEstimateSize).fork();
            abstractC0226s2A = abstractC0226s2A.a(tVar, abstractC0226s2A.d + jEstimateSize, abstractC0226s2A.e - jEstimateSize);
        }
        AbstractC0128c abstractC0128c = (AbstractC0128c) abstractC0226s2A.b;
        abstractC0128c.getClass();
        abstractC0128c.o0(abstractC0128c.w0(abstractC0226s2A), tVar);
        abstractC0226s2A.propagateCompletion();
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        long j2 = this.e;
        if (j > j2) {
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }
        int i = (int) this.d;
        this.f = i;
        this.g = i + ((int) j2);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
