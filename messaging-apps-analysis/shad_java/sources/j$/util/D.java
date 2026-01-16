package j$.util;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class D extends F implements t.c {
    D() {
    }

    @Override // j$.util.t.c, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.l(this, consumer);
    }

    @Override // j$.util.t.c
    /* renamed from: d */
    public void e(j$.util.function.q qVar) {
        qVar.getClass();
    }

    @Override // j$.util.t.c, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.d(this, consumer);
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0102a.e(this);
    }

    @Override // j$.util.t.c
    /* renamed from: h */
    public boolean j(j$.util.function.q qVar) {
        qVar.getClass();
        return false;
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }

    @Override // j$.util.F, j$.util.t.a, j$.util.u, j$.util.t
    public /* bridge */ /* synthetic */ t.c trySplit() {
        return null;
    }

    @Override // j$.util.F, j$.util.t.a, j$.util.u, j$.util.t
    public /* bridge */ /* synthetic */ u trySplit() {
        return null;
    }
}
