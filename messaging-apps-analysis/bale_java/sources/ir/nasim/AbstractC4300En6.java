package ir.nasim;

import ir.nasim.C19701qn6;

/* renamed from: ir.nasim.En6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4300En6 {

    /* renamed from: ir.nasim.En6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C9663aL5 c9663aL5) {
            super(1);
            this.e = c9663aL5;
        }

        public final void a(C8329Vm6 c8329Vm6) {
            if (c8329Vm6.c().length() > 0) {
                this.e.a = false;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C8329Vm6) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AW5 b(C13774gn7 c13774gn7, int i) {
        return e(c13774gn7, i) ? c13774gn7.y(i) : c13774gn7.c(i);
    }

    public static final InterfaceC4066Dn6 c(C13774gn7 c13774gn7, int i, int i2, int i3, long j, boolean z, boolean z2) {
        return new C24801zD6(z2, 1, 1, z ? null : new C19701qn6(new C19701qn6.a(b(c13774gn7, C4301En7.n(j)), C4301En7.n(j), 1L), new C19701qn6.a(b(c13774gn7, C4301En7.i(j)), C4301En7.i(j), 1L), C4301En7.m(j)), new C8329Vm6(1L, 1, i, i2, i3, c13774gn7));
    }

    public static final boolean d(C19701qn6 c19701qn6, InterfaceC4066Dn6 interfaceC4066Dn6) {
        if (c19701qn6 == null || interfaceC4066Dn6 == null) {
            return true;
        }
        if (c19701qn6.e().d() == c19701qn6.c().d()) {
            return c19701qn6.e().c() == c19701qn6.c().c();
        }
        if ((c19701qn6.d() ? c19701qn6.e() : c19701qn6.c()).c() != 0) {
            return false;
        }
        if (interfaceC4066Dn6.c().l() != (c19701qn6.d() ? c19701qn6.c() : c19701qn6.e()).c()) {
            return false;
        }
        C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = true;
        interfaceC4066Dn6.h(new a(c9663aL5));
        return c9663aL5.a;
    }

    private static final boolean e(C13774gn7 c13774gn7, int i) {
        if (c13774gn7.l().j().length() == 0) {
            return true;
        }
        int iQ = c13774gn7.q(i);
        return (i == 0 || iQ != c13774gn7.q(i + (-1))) && (i == c13774gn7.l().j().length() || iQ != c13774gn7.q(i + 1));
    }
}
