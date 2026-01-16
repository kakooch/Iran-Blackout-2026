package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class u1 extends s1 {
    u1() {
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* synthetic */ int a(Object obj) {
        return ((t1) obj).a();
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* synthetic */ int b(Object obj) {
        return ((t1) obj).b();
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* bridge */ /* synthetic */ Object c(Object obj) {
        P0 p0 = (P0) obj;
        t1 t1Var = p0.zzc;
        if (t1Var != t1.c()) {
            return t1Var;
        }
        t1 t1VarF = t1.f();
        p0.zzc = t1VarF;
        return t1VarF;
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* synthetic */ Object d(Object obj) {
        return ((P0) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        if (t1.c().equals(obj2)) {
            return obj;
        }
        if (t1.c().equals(obj)) {
            return t1.e((t1) obj, (t1) obj2);
        }
        ((t1) obj).d((t1) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* bridge */ /* synthetic */ void f(Object obj, int i, long j) {
        ((t1) obj).j(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final void g(Object obj) {
        ((P0) obj).zzc.h();
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* synthetic */ void h(Object obj, Object obj2) {
        ((P0) obj).zzc = (t1) obj2;
    }

    @Override // com.google.android.gms.internal.measurement.s1
    final /* synthetic */ void i(Object obj, F1 f1) {
        ((t1) obj).k(f1);
    }
}
