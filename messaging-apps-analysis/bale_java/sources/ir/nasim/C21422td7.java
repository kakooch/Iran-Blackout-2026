package ir.nasim;

import android.text.TextUtils;

/* renamed from: ir.nasim.td7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C21422td7 extends C18981pa7 {
    @Override // ir.nasim.C18981pa7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.i = iE;
        this.m = (iE & 1) != 0;
        this.l = (iE & 2) != 0;
        this.j = (iE & 16) != 0;
        this.k = (iE & 32) != 0;
        this.b = t1.e(z);
        this.R = t1.e(z);
        C4937He7 c4937He7 = new C4937He7();
        this.c = c4937He7;
        c4937He7.b = t1.e(z);
        this.d = Z57.d(t1, t1.e(z), z);
        this.e = t1.e(z);
        this.g = t1.g(z);
        Q57 q57D = Q57.d(t1, t1.e(z), z);
        this.h = q57D;
        if (q57D != null && !TextUtils.isEmpty(q57D.u)) {
            this.g = this.h.u;
        }
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            N57 n57D = N57.d(t1, t1.e(z), z);
            if (n57D == null) {
                return;
            }
            this.n.add(n57D);
        }
        if ((this.i & 2048) != 0) {
            this.o = t1.g(z);
        }
        if ((this.i & 8) != 0) {
            C7533Sc7 c7533Sc7 = new C7533Sc7();
            this.C = c7533Sc7;
            c7533Sc7.h = t1.f(z);
        }
    }
}
