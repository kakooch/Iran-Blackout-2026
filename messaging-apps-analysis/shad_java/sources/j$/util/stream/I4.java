package j$.util.stream;

import j$.util.AbstractC0102a;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class I4 extends K4 implements j$.util.u {
    I4(j$.util.u uVar, long j, long j2) {
        super(uVar, j, j2);
    }

    I4(j$.util.u uVar, I4 i4) {
        super(uVar, i4);
    }

    @Override // j$.util.u
    /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void e(Object obj) {
        obj.getClass();
        AbstractC0181k4 abstractC0181k4T = null;
        while (true) {
            int iR = r();
            if (iR == 1) {
                return;
            }
            if (iR != 2) {
                ((j$.util.u) this.a).e(obj);
                return;
            }
            if (abstractC0181k4T == null) {
                abstractC0181k4T = t(128);
            } else {
                abstractC0181k4T.b = 0;
            }
            long j = 0;
            while (((j$.util.u) this.a).j(abstractC0181k4T)) {
                j++;
                if (j >= 128) {
                    break;
                }
            }
            if (j == 0) {
                return;
            } else {
                abstractC0181k4T.a(obj, l(j));
            }
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

    protected abstract void s(Object obj);

    protected abstract AbstractC0181k4 t(int i);

    @Override // j$.util.u
    /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public boolean j(Object obj) {
        obj.getClass();
        while (r() != 1 && ((j$.util.u) this.a).j(this)) {
            if (l(1L) == 1) {
                s(obj);
                return true;
            }
        }
        return false;
    }
}
