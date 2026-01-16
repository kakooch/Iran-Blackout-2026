package j$.util;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class C extends F implements t.b {
    C() {
    }

    @Override // j$.util.t.b, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.k(this, consumer);
    }

    @Override // j$.util.t.b
    /* renamed from: c */
    public void e(j$.util.function.l lVar) {
        lVar.getClass();
    }

    @Override // j$.util.t.b, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.c(this, consumer);
    }

    @Override // j$.util.t.b
    /* renamed from: g */
    public boolean j(j$.util.function.l lVar) {
        lVar.getClass();
        return false;
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

    @Override // j$.util.F, j$.util.t.a, j$.util.u, j$.util.t
    public /* bridge */ /* synthetic */ t.b trySplit() {
        return null;
    }

    @Override // j$.util.F, j$.util.t.a, j$.util.u, j$.util.t
    public /* bridge */ /* synthetic */ u trySplit() {
        return null;
    }
}
