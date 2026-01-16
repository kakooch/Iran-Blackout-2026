package j$.util.stream;

import j$.util.t;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
abstract class K4 {
    protected final j$.util.t a;
    protected final boolean b;
    private final long c;
    private final AtomicLong d;

    K4(j$.util.t tVar, long j, long j2) {
        this.a = tVar;
        this.b = j2 < 0;
        this.c = j2 >= 0 ? j2 : 0L;
        this.d = new AtomicLong(j2 >= 0 ? j + j2 : j);
    }

    K4(j$.util.t tVar, K4 k4) {
        this.a = tVar;
        this.b = k4.b;
        this.d = k4.d;
        this.c = k4.c;
    }

    public final int characteristics() {
        return this.a.characteristics() & (-16465);
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    protected final long l(long j) {
        long j2;
        long jMin;
        do {
            j2 = this.d.get();
            if (j2 != 0) {
                jMin = Math.min(j2, j);
                if (jMin <= 0) {
                    break;
                }
            } else {
                if (this.b) {
                    return j;
                }
                return 0L;
            }
        } while (!this.d.compareAndSet(j2, j2 - jMin));
        if (this.b) {
            return Math.max(j - jMin, 0L);
        }
        long j3 = this.c;
        return j2 > j3 ? Math.max(jMin - (j2 - j3), 0L) : jMin;
    }

    protected abstract j$.util.t q(j$.util.t tVar);

    protected final int r() {
        if (this.d.get() > 0) {
            return 2;
        }
        return this.b ? 3 : 1;
    }

    public /* bridge */ /* synthetic */ t.a trySplit() {
        return (t.a) m540trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ t.b m538trySplit() {
        return (t.b) m540trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ t.c m539trySplit() {
        return (t.c) m540trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public final j$.util.t m540trySplit() {
        j$.util.t tVarTrySplit;
        if (this.d.get() == 0 || (tVarTrySplit = this.a.trySplit()) == null) {
            return null;
        }
        return q(tVarTrySplit);
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.u m541trySplit() {
        return (j$.util.u) m540trySplit();
    }
}
