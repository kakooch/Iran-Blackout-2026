package ir.nasim;

import androidx.compose.runtime.ComposeRuntimeError;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.Ib1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5138Ib1 {
    private static InterfaceC16631lc1 a;
    private static final Object b = new RK4("provider");
    private static final Object c = new RK4("provider");
    private static final Object d = new RK4("compositionLocalMap");
    private static final Object e = new RK4("providerValues");
    private static final Object f = new RK4("providers");
    private static final Object g = new RK4("reference");
    private static final Comparator h = new Comparator() { // from class: ir.nasim.Hb1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC5138Ib1.b((C9826ad3) obj, (C9826ad3) obj2);
        }
    };

    public static final Object A() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object B(C23961xo3 c23961xo3) {
        return c23961xo3.d() != null ? new C8065Uj3(Integer.valueOf(c23961xo3.a()), c23961xo3.d()) : Integer.valueOf(c23961xo3.a());
    }

    public static final Object C() {
        return c;
    }

    public static final Object D() {
        return f;
    }

    public static final Object E() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(List list, int i, PJ5 pj5, Object obj) {
        int iX = x(list, i);
        if (iX < 0) {
            int i2 = -(iX + 1);
            if (!(obj instanceof InterfaceC19404qI1)) {
                obj = null;
            }
            list.add(i2, new C9826ad3(pj5, i, obj));
            return;
        }
        C9826ad3 c9826ad3 = (C9826ad3) list.get(iX);
        if (!(obj instanceof InterfaceC19404qI1)) {
            c9826ad3.e(null);
            return;
        }
        Object objA = c9826ad3.a();
        if (objA == null) {
            c9826ad3.e(obj);
        } else if (objA instanceof C7620Sm4) {
            ((C7620Sm4) objA).h(obj);
        } else {
            c9826ad3.e(AbstractC23254wc6.b(objA, obj));
        }
    }

    public static final boolean G(C21176tE6 c21176tE6) {
        return c21176tE6.k() > c21176tE6.u() + 1;
    }

    public static final boolean H(C24216yE6 c24216yE6) {
        return c24216yE6.a0() > c24216yE6.b0() + 1;
    }

    public static final boolean I() {
        InterfaceC16631lc1 interfaceC16631lc1 = a;
        return interfaceC16631lc1 != null && interfaceC16631lc1.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7386Rm4 J(int i) {
        return C6405Nl4.d(new C7386Rm4(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K(C21176tE6 c21176tE6, int i, int i2, int i3) {
        if (i == i2) {
            return i;
        }
        if (i == i3 || i2 == i3) {
            return i3;
        }
        if (c21176tE6.P(i) == i2) {
            return i2;
        }
        if (c21176tE6.P(i2) == i) {
            return i;
        }
        if (c21176tE6.P(i) == c21176tE6.P(i2)) {
            return c21176tE6.P(i);
        }
        int iV = v(c21176tE6, i, i3);
        int iV2 = v(c21176tE6, i2, i3);
        int i4 = iV - iV2;
        for (int i5 = 0; i5 < i4; i5++) {
            i = c21176tE6.P(i);
        }
        int i6 = iV2 - iV;
        for (int i7 = 0; i7 < i6; i7++) {
            i2 = c21176tE6.P(i2);
        }
        while (i != i2) {
            i = c21176tE6.P(i);
            i2 = c21176tE6.P(i2);
        }
        return i;
    }

    public static final void L(C24216yE6 c24216yE6, XM5 xm5) {
        int iD0;
        int iQ = c24216yE6.Q(c24216yE6.b, c24216yE6.g0(c24216yE6.a0() + c24216yE6.j0(c24216yE6.a0())));
        for (int iQ2 = c24216yE6.Q(c24216yE6.b, c24216yE6.g0(c24216yE6.a0())); iQ2 < iQ; iQ2++) {
            Object obj = c24216yE6.c[c24216yE6.R(iQ2)];
            int iE = -1;
            if (obj instanceof InterfaceC11014cb1) {
                xm5.f((InterfaceC11014cb1) obj, c24216yE6.d0() - iQ2, -1, -1);
            }
            if (obj instanceof ZM5) {
                int iD02 = c24216yE6.d0() - iQ2;
                ZM5 zm5 = (ZM5) obj;
                C6669Om c6669OmA = zm5.a();
                if (c6669OmA == null || !c6669OmA.b()) {
                    iD0 = -1;
                } else {
                    iE = c24216yE6.E(c6669OmA);
                    iD0 = c24216yE6.d0() - c24216yE6.Z0(iE);
                }
                xm5.g(zm5, iD02, iE, iD0);
            }
            if (obj instanceof PJ5) {
                ((PJ5) obj).A();
            }
        }
        c24216yE6.K0();
    }

    private static final void M(C24216yE6 c24216yE6, int i, Object obj) {
        Object objJ = c24216yE6.J(i);
        if (obj == objJ) {
            return;
        }
        s("Slot table is out of sync (expected " + obj + ", got " + objJ + ')');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9826ad3 N(List list, int i) {
        int iX = x(list, i);
        if (iX >= 0) {
            return (C9826ad3) list.remove(iX);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(List list, int i, int i2) {
        int iW = w(list, i);
        while (iW < list.size() && ((C9826ad3) list.get(iW)).b() < i2) {
            list.remove(iW);
        }
    }

    public static final void P() {
        InterfaceC16631lc1 interfaceC16631lc1 = a;
        if (interfaceC16631lc1 != null) {
            interfaceC16631lc1.c();
        }
    }

    public static final void Q(int i, int i2, int i3, String str) {
        InterfaceC16631lc1 interfaceC16631lc1 = a;
        if (interfaceC16631lc1 != null) {
            interfaceC16631lc1.b(i, i2, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(C9826ad3 c9826ad3, C9826ad3 c9826ad32) {
        return AbstractC13042fc3.k(c9826ad3.b(), c9826ad32.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(int i) {
        return i != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q(C21850uE6 c21850uE6, C6669Om c6669Om) {
        ArrayList arrayList = new ArrayList();
        C21176tE6 c21176tE6V = c21850uE6.V();
        try {
            r(c21176tE6V, arrayList, c21850uE6.t(c6669Om));
            C19938rB7 c19938rB7 = C19938rB7.a;
            return arrayList;
        } finally {
            c21176tE6V.d();
        }
    }

    private static final void r(C21176tE6 c21176tE6, List list, int i) {
        if (c21176tE6.J(i)) {
            list.add(c21176tE6.L(i));
            return;
        }
        int iE = i + 1;
        int iE2 = i + c21176tE6.E(i);
        while (iE < iE2) {
            r(c21176tE6, list, iE);
            iE += c21176tE6.E(iE);
        }
    }

    public static final void s(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void t(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void u(C24216yE6 c24216yE6, XM5 xm5) {
        int iD0;
        int iQ = c24216yE6.Q(c24216yE6.b, c24216yE6.g0(c24216yE6.a0() + c24216yE6.j0(c24216yE6.a0())));
        for (int iQ2 = c24216yE6.Q(c24216yE6.b, c24216yE6.g0(c24216yE6.a0())); iQ2 < iQ; iQ2++) {
            Object obj = c24216yE6.c[c24216yE6.R(iQ2)];
            int iE = -1;
            if (obj instanceof InterfaceC11014cb1) {
                xm5.e((InterfaceC11014cb1) obj, c24216yE6.d0() - iQ2, -1, -1);
            } else if (obj instanceof ZM5) {
                ZM5 zm5 = (ZM5) obj;
                if (!(zm5.b() instanceof InterfaceC24680z16)) {
                    M(c24216yE6, iQ2, obj);
                    int iD02 = c24216yE6.d0() - iQ2;
                    C6669Om c6669OmA = zm5.a();
                    if (c6669OmA == null || !c6669OmA.b()) {
                        iD0 = -1;
                    } else {
                        iE = c24216yE6.E(c6669OmA);
                        iD0 = c24216yE6.d0() - c24216yE6.Z0(iE);
                    }
                    xm5.g(zm5, iD02, iE, iD0);
                }
            } else if (obj instanceof PJ5) {
                M(c24216yE6, iQ2, obj);
                ((PJ5) obj).A();
            }
        }
    }

    private static final int v(C21176tE6 c21176tE6, int i, int i2) {
        int i3 = 0;
        while (i > 0 && i != i2) {
            i = c21176tE6.P(i);
            i3++;
        }
        return i3;
    }

    private static final int w(List list, int i) {
        int iX = x(list, i);
        return iX < 0 ? -(iX + 1) : iX;
    }

    private static final int x(List list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int iK = AbstractC13042fc3.k(((C9826ad3) list.get(i3)).b(), i);
            if (iK < 0) {
                i2 = i3 + 1;
            } else {
                if (iK <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9826ad3 y(List list, int i, int i2) {
        int iW = w(list, i);
        if (iW >= list.size()) {
            return null;
        }
        C9826ad3 c9826ad3 = (C9826ad3) list.get(iW);
        if (c9826ad3.b() < i2) {
            return c9826ad3;
        }
        return null;
    }

    public static final Object z() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(boolean z) {
        return z ? 1 : 0;
    }
}
