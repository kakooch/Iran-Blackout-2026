package androidx.compose.ui.platform;

import ir.nasim.AW5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C13774gn7;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
public final class c extends AbstractC1931a {
    private static c f;
    private C13774gn7 c;
    public static final a d = new a(null);
    public static final int e = 8;
    private static final AW5 g = AW5.b;
    private static final AW5 h = AW5.a;

    public static final class a {
        private a() {
        }

        public final c a() {
            if (c.f == null) {
                c.f = new c(null);
            }
            c cVar = c.f;
            AbstractC13042fc3.g(cVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
            return cVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ c(ED1 ed1) {
        this();
    }

    private final int i(int i, AW5 aw5) {
        C13774gn7 c13774gn7 = this.c;
        C13774gn7 c13774gn72 = null;
        if (c13774gn7 == null) {
            AbstractC13042fc3.y("layoutResult");
            c13774gn7 = null;
        }
        int iU = c13774gn7.u(i);
        C13774gn7 c13774gn73 = this.c;
        if (c13774gn73 == null) {
            AbstractC13042fc3.y("layoutResult");
            c13774gn73 = null;
        }
        if (aw5 != c13774gn73.y(iU)) {
            C13774gn7 c13774gn74 = this.c;
            if (c13774gn74 == null) {
                AbstractC13042fc3.y("layoutResult");
            } else {
                c13774gn72 = c13774gn74;
            }
            return c13774gn72.u(i);
        }
        C13774gn7 c13774gn75 = this.c;
        if (c13774gn75 == null) {
            AbstractC13042fc3.y("layoutResult");
            c13774gn75 = null;
        }
        return C13774gn7.p(c13774gn75, i, false, 2, null) - 1;
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] a(int i) {
        int iQ;
        if (d().length() <= 0 || i >= d().length()) {
            return null;
        }
        if (i < 0) {
            C13774gn7 c13774gn7 = this.c;
            if (c13774gn7 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn7 = null;
            }
            iQ = c13774gn7.q(0);
        } else {
            C13774gn7 c13774gn72 = this.c;
            if (c13774gn72 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn72 = null;
            }
            int iQ2 = c13774gn72.q(i);
            iQ = i(iQ2, g) == i ? iQ2 : iQ2 + 1;
        }
        C13774gn7 c13774gn73 = this.c;
        if (c13774gn73 == null) {
            AbstractC13042fc3.y("layoutResult");
            c13774gn73 = null;
        }
        if (iQ >= c13774gn73.n()) {
            return null;
        }
        return c(i(iQ, g), i(iQ, h) + 1);
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] b(int i) {
        int iQ;
        if (d().length() <= 0 || i <= 0) {
            return null;
        }
        if (i > d().length()) {
            C13774gn7 c13774gn7 = this.c;
            if (c13774gn7 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn7 = null;
            }
            iQ = c13774gn7.q(d().length());
        } else {
            C13774gn7 c13774gn72 = this.c;
            if (c13774gn72 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn72 = null;
            }
            int iQ2 = c13774gn72.q(i);
            iQ = i(iQ2, h) + 1 == i ? iQ2 : iQ2 - 1;
        }
        if (iQ < 0) {
            return null;
        }
        return c(i(iQ, g), i(iQ, h) + 1);
    }

    public final void j(String str, C13774gn7 c13774gn7) {
        f(str);
        this.c = c13774gn7;
    }

    private c() {
    }
}
