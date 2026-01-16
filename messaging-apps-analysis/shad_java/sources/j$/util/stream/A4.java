package j$.util.stream;

import j$.util.AbstractC0102a;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class A4 extends E4 implements j$.util.u {
    A4(j$.util.u uVar, long j, long j2) {
        super(uVar, j, j2, 0L, Math.min(uVar.estimateSize(), j2));
    }

    protected abstract Object f();

    @Override // j$.util.u
    /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void e(Object obj) {
        obj.getClass();
        long j = this.a;
        long j2 = this.e;
        if (j >= j2) {
            return;
        }
        long j3 = this.d;
        if (j3 >= j2) {
            return;
        }
        if (j3 >= j && ((j$.util.u) this.c).estimateSize() + j3 <= this.b) {
            ((j$.util.u) this.c).e(obj);
            this.d = this.e;
            return;
        }
        while (this.a > this.d) {
            ((j$.util.u) this.c).j(f());
            this.d++;
        }
        while (this.d < this.e) {
            ((j$.util.u) this.c).j(obj);
            this.d++;
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

    @Override // j$.util.u
    /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public boolean j(Object obj) {
        long j;
        obj.getClass();
        if (this.a >= this.e) {
            return false;
        }
        while (true) {
            long j2 = this.a;
            j = this.d;
            if (j2 <= j) {
                break;
            }
            ((j$.util.u) this.c).j(f());
            this.d++;
        }
        if (j >= this.e) {
            return false;
        }
        this.d = j + 1;
        return ((j$.util.u) this.c).j(obj);
    }

    A4(j$.util.u uVar, long j, long j2, long j3, long j4, AbstractC0202o1 abstractC0202o1) {
        super(uVar, j, j2, j3, j4);
    }
}
