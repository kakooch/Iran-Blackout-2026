package ir.nasim;

import android.text.TextUtils;

/* renamed from: ir.nasim.Wb7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8465Wb7 extends L57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.i = iE;
        this.m = (iE & 1) != 0;
        this.l = (iE & 2) != 0;
        this.j = (iE & 16) != 0;
        this.k = (iE & 32) != 0;
        this.b = t1.e(z);
        C9006Yb7 c9006Yb7 = new C9006Yb7();
        this.A = c9006Yb7;
        c9006Yb7.d = new C4937He7();
        this.A.d.b = t1.e(z);
        P57 p57 = this.A;
        p57.b |= 1;
        p57.f = t1.e(z);
        C4937He7 c4937He7 = new C4937He7();
        this.c = c4937He7;
        c4937He7.b = t1.e(z);
        this.d = Z57.d(t1, t1.e(z), z);
        this.e = t1.e(z);
        this.g = t1.g(z);
        this.i |= 772;
        Q57 q57D = Q57.d(t1, t1.e(z), z);
        this.h = q57D;
        if (q57D == null || TextUtils.isEmpty(q57D.u)) {
            return;
        }
        this.g = this.h.u;
    }
}
