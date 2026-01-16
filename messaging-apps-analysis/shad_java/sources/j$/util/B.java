package j$.util;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class B extends F implements t.a {
    B() {
    }

    @Override // j$.util.t.a, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.j(this, consumer);
    }

    @Override // j$.util.t.a
    public void e(j$.util.function.f fVar) {
        fVar.getClass();
    }

    @Override // j$.util.t.a, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.b(this, consumer);
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

    @Override // j$.util.t.a
    public boolean j(j$.util.function.f fVar) {
        fVar.getClass();
        return false;
    }

    @Override // j$.util.F, j$.util.t.a, j$.util.u, j$.util.t
    public /* bridge */ /* synthetic */ t.a trySplit() {
        return null;
    }

    @Override // j$.util.F, j$.util.t.a, j$.util.u, j$.util.t
    public /* bridge */ /* synthetic */ u trySplit() {
        return null;
    }
}
