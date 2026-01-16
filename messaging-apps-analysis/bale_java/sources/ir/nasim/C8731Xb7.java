package ir.nasim;

import android.text.TextUtils;

/* renamed from: ir.nasim.Xb7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8731Xb7 extends C8465Wb7 {
    @Override // ir.nasim.C8465Wb7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
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
        this.l = t1.a(z);
        this.m = t1.a(z);
        this.i |= 772;
        this.e = t1.e(z);
        this.g = t1.g(z);
        Q57 q57D = Q57.d(t1, t1.e(z), z);
        this.h = q57D;
        if (q57D == null || TextUtils.isEmpty(q57D.u)) {
            return;
        }
        this.g = this.h.u;
    }
}
