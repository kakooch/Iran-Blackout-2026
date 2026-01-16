package androidx.compose.ui.platform;

import android.graphics.Rect;
import ir.nasim.AW5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.C13774gn7;
import ir.nasim.C7631Sn6;
import ir.nasim.CK5;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
public final class d extends AbstractC1931a {
    private static d h;
    private C13774gn7 c;
    private C7631Sn6 d;
    private Rect e;
    public static final a f = new a(null);
    public static final int g = 8;
    private static final AW5 i = AW5.b;
    private static final AW5 j = AW5.a;

    public static final class a {
        private a() {
        }

        public final d a() {
            if (d.h == null) {
                d.h = new d(null);
            }
            d dVar = d.h;
            AbstractC13042fc3.g(dVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            return dVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ d(ED1 ed1) {
        this();
    }

    private final int i(int i2, AW5 aw5) {
        C13774gn7 c13774gn7 = this.c;
        C13774gn7 c13774gn72 = null;
        if (c13774gn7 == null) {
            AbstractC13042fc3.y("layoutResult");
            c13774gn7 = null;
        }
        int iU = c13774gn7.u(i2);
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
            return c13774gn72.u(i2);
        }
        C13774gn7 c13774gn75 = this.c;
        if (c13774gn75 == null) {
            AbstractC13042fc3.y("layoutResult");
            c13774gn75 = null;
        }
        return C13774gn7.p(c13774gn75, i2, false, 2, null) - 1;
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] a(int i2) {
        int iN;
        C13774gn7 c13774gn7 = null;
        if (d().length() <= 0 || i2 >= d().length()) {
            return null;
        }
        try {
            C7631Sn6 c7631Sn6 = this.d;
            if (c7631Sn6 == null) {
                AbstractC13042fc3.y("node");
                c7631Sn6 = null;
            }
            CK5 ck5I = c7631Sn6.i();
            int iRound = Math.round(ck5I.e() - ck5I.l());
            int iE = AbstractC23053wG5.e(0, i2);
            C13774gn7 c13774gn72 = this.c;
            if (c13774gn72 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn72 = null;
            }
            int iQ = c13774gn72.q(iE);
            C13774gn7 c13774gn73 = this.c;
            if (c13774gn73 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn73 = null;
            }
            float fV = c13774gn73.v(iQ) + iRound;
            C13774gn7 c13774gn74 = this.c;
            if (c13774gn74 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn74 = null;
            }
            C13774gn7 c13774gn75 = this.c;
            if (c13774gn75 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn75 = null;
            }
            if (fV < c13774gn74.v(c13774gn75.n() - 1)) {
                C13774gn7 c13774gn76 = this.c;
                if (c13774gn76 == null) {
                    AbstractC13042fc3.y("layoutResult");
                } else {
                    c13774gn7 = c13774gn76;
                }
                iN = c13774gn7.r(fV);
            } else {
                C13774gn7 c13774gn77 = this.c;
                if (c13774gn77 == null) {
                    AbstractC13042fc3.y("layoutResult");
                } else {
                    c13774gn7 = c13774gn77;
                }
                iN = c13774gn7.n();
            }
            return c(iE, i(iN - 1, j) + 1);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] b(int i2) {
        int iR;
        C13774gn7 c13774gn7 = null;
        if (d().length() <= 0 || i2 <= 0) {
            return null;
        }
        try {
            C7631Sn6 c7631Sn6 = this.d;
            if (c7631Sn6 == null) {
                AbstractC13042fc3.y("node");
                c7631Sn6 = null;
            }
            CK5 ck5I = c7631Sn6.i();
            int iRound = Math.round(ck5I.e() - ck5I.l());
            int i3 = AbstractC23053wG5.i(d().length(), i2);
            C13774gn7 c13774gn72 = this.c;
            if (c13774gn72 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn72 = null;
            }
            int iQ = c13774gn72.q(i3);
            C13774gn7 c13774gn73 = this.c;
            if (c13774gn73 == null) {
                AbstractC13042fc3.y("layoutResult");
                c13774gn73 = null;
            }
            float fV = c13774gn73.v(iQ) - iRound;
            if (fV > 0.0f) {
                C13774gn7 c13774gn74 = this.c;
                if (c13774gn74 == null) {
                    AbstractC13042fc3.y("layoutResult");
                } else {
                    c13774gn7 = c13774gn74;
                }
                iR = c13774gn7.r(fV);
            } else {
                iR = 0;
            }
            if (i3 == d().length() && iR < iQ) {
                iR++;
            }
            return c(i(iR, i), i3);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final void j(String str, C13774gn7 c13774gn7, C7631Sn6 c7631Sn6) {
        f(str);
        this.c = c13774gn7;
        this.d = c7631Sn6;
    }

    private d() {
        this.e = new Rect();
    }
}
