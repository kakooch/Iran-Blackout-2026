package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.t;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* renamed from: j$.util.stream.k2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0179k2 implements j$.util.t {
    A1 a;
    int b;
    j$.util.t c;
    j$.util.t d;
    Deque e;

    AbstractC0179k2(A1 a1) {
        this.a = a1;
    }

    protected final A1 b(Deque deque) {
        while (true) {
            A1 a1 = (A1) deque.pollFirst();
            if (a1 == null) {
                return null;
            }
            if (a1.q() != 0) {
                for (int iQ = a1.q() - 1; iQ >= 0; iQ--) {
                    deque.addFirst(a1.c(iQ));
                }
            } else if (a1.count() > 0) {
                return a1;
            }
        }
    }

    @Override // j$.util.t
    public final int characteristics() {
        return 64;
    }

    @Override // j$.util.t
    public final long estimateSize() {
        long jCount = 0;
        if (this.a == null) {
            return 0L;
        }
        j$.util.t tVar = this.c;
        if (tVar != null) {
            return tVar.estimateSize();
        }
        for (int i = this.b; i < this.a.q(); i++) {
            jCount += this.a.c(i).count();
        }
        return jCount;
    }

    protected final Deque f() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int iQ = this.a.q();
        while (true) {
            iQ--;
            if (iQ < this.b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.a.c(iQ));
        }
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0102a.e(this);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }

    protected final boolean i() {
        if (this.a == null) {
            return false;
        }
        if (this.d != null) {
            return true;
        }
        j$.util.t tVarSpliterator = this.c;
        if (tVarSpliterator == null) {
            Deque dequeF = f();
            this.e = dequeF;
            A1 a1B = b(dequeF);
            if (a1B == null) {
                this.a = null;
                return false;
            }
            tVarSpliterator = a1B.spliterator();
        }
        this.d = tVarSpliterator;
        return true;
    }

    @Override // j$.util.t
    public /* bridge */ /* synthetic */ t.a trySplit() {
        return (t.a) trySplit();
    }

    @Override // j$.util.t
    public /* bridge */ /* synthetic */ t.b trySplit() {
        return (t.b) trySplit();
    }

    @Override // j$.util.t
    public /* bridge */ /* synthetic */ t.c trySplit() {
        return (t.c) trySplit();
    }

    @Override // j$.util.t
    public final j$.util.t trySplit() {
        A1 a1 = this.a;
        if (a1 == null || this.d != null) {
            return null;
        }
        j$.util.t tVar = this.c;
        if (tVar != null) {
            return tVar.trySplit();
        }
        if (this.b < a1.q() - 1) {
            A1 a12 = this.a;
            int i = this.b;
            this.b = i + 1;
            return a12.c(i).spliterator();
        }
        A1 a1C = this.a.c(this.b);
        this.a = a1C;
        if (a1C.q() == 0) {
            j$.util.t tVarSpliterator = this.a.spliterator();
            this.c = tVarSpliterator;
            return tVarSpliterator.trySplit();
        }
        this.b = 0;
        A1 a13 = this.a;
        this.b = 1;
        return a13.c(0).spliterator();
    }

    @Override // j$.util.t
    public /* bridge */ /* synthetic */ j$.util.u trySplit() {
        return (j$.util.u) trySplit();
    }
}
