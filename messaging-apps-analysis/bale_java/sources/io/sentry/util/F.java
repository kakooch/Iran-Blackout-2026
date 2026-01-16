package io.sentry.util;

import io.sentry.B1;
import io.sentry.C3101d;
import io.sentry.C3155n3;
import io.sentry.C3199u1;
import io.sentry.D1;
import io.sentry.L0;
import io.sentry.V3;
import io.sentry.X;
import io.sentry.Z;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class F {
    public static C3101d d(C3101d c3101d, V3 v3) {
        return e(c3101d, v3 == null ? null : v3.e(), v3 == null ? null : v3.d(), v3 != null ? v3.c() : null);
    }

    public static C3101d e(C3101d c3101d, Boolean bool, Double d, Double d2) {
        if (c3101d == null) {
            c3101d = new C3101d(L0.e());
        }
        if (c3101d.i() == null) {
            Double dJ = c3101d.j();
            if (dJ != null) {
                d = dJ;
            }
            c3101d.B(y.b(d2, d, bool));
        }
        if (c3101d.q() && c3101d.r()) {
            c3101d.b();
        }
        return c3101d;
    }

    public static boolean f(List list, String str) {
        if (str != null && list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((io.sentry.G) it.next()).a().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (((io.sentry.G) it2.next()).b(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(X x, C3155n3 c3155n3, C3199u1 c3199u1) {
        C3101d c3101dA = c3199u1.a();
        if (c3101dA.q()) {
            c3101dA.H(x, c3155n3);
            c3101dA.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(X x, C3199u1 c3199u1) {
        x.I(new C3199u1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(final X x) {
        x.E(new B1.a() { // from class: io.sentry.util.E
            @Override // io.sentry.B1.a
            public final void a(C3199u1 c3199u1) {
                F.h(x, c3199u1);
            }
        });
    }

    public static C3199u1 j(final X x, final C3155n3 c3155n3) {
        return x.E(new B1.a() { // from class: io.sentry.util.C
            @Override // io.sentry.B1.a
            public final void a(C3199u1 c3199u1) {
                F.g(x, c3155n3, c3199u1);
            }
        });
    }

    public static void k(Z z) {
        z.z(new D1() { // from class: io.sentry.util.D
            @Override // io.sentry.D1
            public final void a(X x) {
                F.i(x);
            }
        });
    }
}
