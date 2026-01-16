package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0156n1;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class Y2<P_IN, P_OUT, T_BUFFER extends AbstractC0156n1> implements Spliterator<P_OUT> {
    final boolean a;
    final V1 b;
    private j$.util.function.L c;
    Spliterator d;
    C2 e;
    j$.util.function.q f;
    long g;
    AbstractC0156n1 h;
    boolean i;

    Y2(V1 v1, Spliterator spliterator, boolean z) {
        this.b = v1;
        this.c = null;
        this.d = spliterator;
        this.a = z;
    }

    Y2(V1 v1, j$.util.function.L l, boolean z) {
        this.b = v1;
        this.c = l;
        this.d = null;
        this.a = z;
    }

    private boolean f() {
        while (this.h.count() == 0) {
            if (this.e.o() || !this.f.a()) {
                if (this.i) {
                    return false;
                }
                this.e.l();
                this.i = true;
            }
        }
        return true;
    }

    final boolean a() {
        AbstractC0156n1 abstractC0156n1 = this.h;
        if (abstractC0156n1 == null) {
            if (this.i) {
                return false;
            }
            h();
            j();
            this.g = 0L;
            this.e.m(this.d.getExactSizeIfKnown());
            return f();
        }
        long j = this.g + 1;
        this.g = j;
        boolean z = j < abstractC0156n1.count();
        if (z) {
            return z;
        }
        this.g = 0L;
        this.h.clear();
        return f();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        h();
        int iW = V2.w(this.b.q0()) & V2.a;
        return (iW & 64) != 0 ? (iW & (-16449)) | (this.d.characteristics() & 16448) : iW;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        h();
        return this.d.estimateSize();
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        if (j$.time.a.h(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        h();
        if (V2.SIZED.n(this.b.q0())) {
            return this.d.getExactSizeIfKnown();
        }
        return -1L;
    }

    final void h() {
        if (this.d == null) {
            this.d = (Spliterator) this.c.get();
            this.c = null;
        }
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.time.a.h(this, i);
    }

    abstract void j();

    abstract Y2 k(Spliterator spliterator);

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.d);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        if (!this.a || this.i) {
            return null;
        }
        h();
        Spliterator spliteratorTrySplit = this.d.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return k(spliteratorTrySplit);
    }
}
