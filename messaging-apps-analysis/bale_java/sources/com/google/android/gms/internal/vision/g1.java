package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
final class g1 extends f1 {
    g1() {
    }

    private static void m(Object obj, h1 h1Var) {
        ((AbstractC2178j0) obj).zzb = h1Var;
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ Object a() {
        return h1.g();
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ void b(Object obj, int i, long j) {
        ((h1) obj).c(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ void c(Object obj, int i, K k) {
        ((h1) obj).c((i << 3) | 2, k);
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ void d(Object obj, q1 q1Var) {
        ((h1) obj).h(q1Var);
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* bridge */ /* synthetic */ void e(Object obj, Object obj2) {
        m(obj, (h1) obj2);
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ Object f(Object obj) {
        return ((AbstractC2178j0) obj).zzb;
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ void g(Object obj, q1 q1Var) {
        ((h1) obj).e(q1Var);
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ void h(Object obj, Object obj2) {
        m(obj, (h1) obj2);
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ Object i(Object obj, Object obj2) {
        h1 h1Var = (h1) obj;
        h1 h1Var2 = (h1) obj2;
        return h1Var2.equals(h1.a()) ? h1Var : h1.b(h1Var, h1Var2);
    }

    @Override // com.google.android.gms.internal.vision.f1
    final void j(Object obj) {
        ((AbstractC2178j0) obj).zzb.i();
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ int k(Object obj) {
        return ((h1) obj).j();
    }

    @Override // com.google.android.gms.internal.vision.f1
    final /* synthetic */ int l(Object obj) {
        return ((h1) obj).k();
    }
}
