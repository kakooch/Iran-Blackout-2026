package j$.util.stream;

import j$.util.t;

/* loaded from: classes2.dex */
abstract class E4 {
    final long a;
    final long b;
    j$.util.t c;
    long d;
    long e;

    E4(j$.util.t tVar, long j, long j2, long j3, long j4) {
        this.c = tVar;
        this.a = j;
        this.b = j2;
        this.d = j3;
        this.e = j4;
    }

    protected abstract j$.util.t b(j$.util.t tVar, long j, long j2, long j3, long j4);

    public int characteristics() {
        return this.c.characteristics();
    }

    public long estimateSize() {
        long j = this.a;
        long j2 = this.e;
        if (j < j2) {
            return j2 - Math.max(j, this.d);
        }
        return 0L;
    }

    public /* bridge */ /* synthetic */ t.a trySplit() {
        return (t.a) m536trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ t.b m534trySplit() {
        return (t.b) m536trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ t.c m535trySplit() {
        return (t.c) m536trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public j$.util.t m536trySplit() {
        long j = this.a;
        long j2 = this.e;
        if (j >= j2 || this.d >= j2) {
            return null;
        }
        while (true) {
            j$.util.t tVarTrySplit = this.c.trySplit();
            if (tVarTrySplit == null) {
                return null;
            }
            long jEstimateSize = tVarTrySplit.estimateSize() + this.d;
            long jMin = Math.min(jEstimateSize, this.b);
            long j3 = this.a;
            if (j3 >= jMin) {
                this.d = jMin;
            } else {
                long j4 = this.b;
                if (jMin < j4) {
                    long j5 = this.d;
                    if (j5 < j3 || jEstimateSize > j4) {
                        this.d = jMin;
                        return b(tVarTrySplit, j3, j4, j5, jMin);
                    }
                    this.d = jMin;
                    return tVarTrySplit;
                }
                this.c = tVarTrySplit;
                this.e = jMin;
            }
        }
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.u m537trySplit() {
        return (j$.util.u) m536trySplit();
    }
}
