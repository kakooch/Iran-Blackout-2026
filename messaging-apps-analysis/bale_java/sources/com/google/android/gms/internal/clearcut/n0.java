package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
final class n0 extends l0 {
    n0() {
    }

    private static void m(Object obj, m0 m0Var) {
        ((AbstractC2101z) obj).zzjp = m0Var;
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ void a(Object obj, int i, long j) {
        ((m0) obj).e(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ void b(Object obj, int i, AbstractC2081f abstractC2081f) {
        ((m0) obj).e((i << 3) | 2, abstractC2081f);
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ void c(Object obj, v0 v0Var) {
        ((m0) obj).g(v0Var);
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final void d(Object obj) {
        ((AbstractC2101z) obj).zzjp.k();
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ void e(Object obj, v0 v0Var) {
        ((m0) obj).b(v0Var);
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ Object f() {
        return m0.i();
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ void g(Object obj, Object obj2) {
        m(obj, (m0) obj2);
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ void h(Object obj, Object obj2) {
        m(obj, (m0) obj2);
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ Object i(Object obj, Object obj2) {
        m0 m0Var = (m0) obj;
        m0 m0Var2 = (m0) obj2;
        return m0Var2.equals(m0.h()) ? m0Var : m0.a(m0Var, m0Var2);
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ int j(Object obj) {
        return ((m0) obj).d();
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ Object k(Object obj) {
        return ((AbstractC2101z) obj).zzjp;
    }

    @Override // com.google.android.gms.internal.clearcut.l0
    final /* synthetic */ int l(Object obj) {
        return ((m0) obj).j();
    }
}
