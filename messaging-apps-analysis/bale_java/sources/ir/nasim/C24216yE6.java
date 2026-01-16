package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.yE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24216yE6 {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C21850uE6 a;
    private int[] b;
    private Object[] c;
    private ArrayList d;
    private HashMap e;
    private C16734lm4 f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private C16734lm4 s;
    private int t;
    private int u;
    private boolean w;
    private C16143km4 x;
    private final C5131Ia3 p = new C5131Ia3();
    private final C5131Ia3 q = new C5131Ia3();
    private final C5131Ia3 r = new C5131Ia3();
    private int v = -1;

    /* renamed from: ir.nasim.yE6$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final List b(C24216yE6 c24216yE6, int i, C24216yE6 c24216yE62, boolean z, boolean z2, boolean z3) {
            boolean z4;
            List listM;
            int iJ0 = c24216yE6.j0(i);
            int i2 = i + iJ0;
            int iP = c24216yE6.P(i);
            int iP2 = c24216yE6.P(i2);
            int i3 = iP2 - iP;
            boolean zM = c24216yE6.M(i);
            c24216yE62.n0(iJ0);
            c24216yE62.o0(i3, c24216yE62.a0());
            if (c24216yE6.g < i2) {
                c24216yE6.w0(i2);
            }
            if (c24216yE6.k < iP2) {
                c24216yE6.y0(iP2, i2);
            }
            int[] iArr = c24216yE62.b;
            int iA0 = c24216yE62.a0();
            int i4 = iA0 * 5;
            AbstractC9648aK.j(c24216yE6.b, iArr, i4, i * 5, i2 * 5);
            Object[] objArr = c24216yE62.c;
            int i5 = c24216yE62.i;
            System.arraycopy(c24216yE6.c, iP, objArr, i5, i3);
            int iB0 = c24216yE62.b0();
            iArr[i4 + 2] = iB0;
            int i6 = iA0 - i;
            int i7 = iA0 + iJ0;
            int iQ = i5 - c24216yE62.Q(iArr, iA0);
            int i8 = c24216yE62.m;
            int i9 = c24216yE62.l;
            int length = objArr.length;
            int i10 = i8;
            int i11 = iA0;
            while (true) {
                z4 = 0;
                if (i11 >= i7) {
                    break;
                }
                if (i11 != iA0) {
                    int i12 = (i11 * 5) + 2;
                    iArr[i12] = iArr[i12] + i6;
                }
                int i13 = iA0;
                int i14 = i7;
                iArr[(i11 * 5) + 4] = c24216yE62.S(c24216yE62.Q(iArr, i11) + iQ, i10 >= i11 ? c24216yE62.k : 0, i9, length);
                if (i11 == i10) {
                    i10++;
                }
                i11++;
                i7 = i14;
                iA0 = i13;
            }
            int i15 = i7;
            c24216yE62.m = i10;
            int iR = AbstractC23036wE6.r(c24216yE6.d, i, c24216yE6.c0());
            int iR2 = AbstractC23036wE6.r(c24216yE6.d, i2, c24216yE6.c0());
            if (iR < iR2) {
                ArrayList arrayList = c24216yE6.d;
                ArrayList arrayList2 = new ArrayList(iR2 - iR);
                for (int i16 = iR; i16 < iR2; i16++) {
                    C6669Om c6669Om = (C6669Om) arrayList.get(i16);
                    c6669Om.c(c6669Om.a() + i6);
                    arrayList2.add(c6669Om);
                }
                c24216yE62.d.addAll(AbstractC23036wE6.r(c24216yE62.d, c24216yE62.a0(), c24216yE62.c0()), arrayList2);
                arrayList.subList(iR, iR2).clear();
                listM = arrayList2;
            } else {
                listM = AbstractC10360bX0.m();
            }
            List list = listM;
            if (!list.isEmpty()) {
                HashMap map = c24216yE6.e;
                HashMap map2 = c24216yE62.e;
                if (map != null && map2 != null) {
                    int size = list.size();
                    for (int i17 = 0; i17 < size; i17++) {
                    }
                }
            }
            c24216yE62.b0();
            c24216yE62.c1(iB0);
            int iD0 = c24216yE6.D0(i);
            if (z3) {
                if (z) {
                    boolean z5 = iD0 >= 0;
                    if (z5) {
                        c24216yE6.e1();
                        c24216yE6.C(iD0 - c24216yE6.a0());
                        c24216yE6.e1();
                    }
                    c24216yE6.C(i - c24216yE6.a0());
                    boolean zK0 = c24216yE6.K0();
                    if (z5) {
                        c24216yE6.U0();
                        c24216yE6.T();
                        c24216yE6.U0();
                        c24216yE6.T();
                    }
                    z4 = zK0;
                } else {
                    boolean zL0 = c24216yE6.L0(i, iJ0);
                    c24216yE6.M0(iP, i3, i - 1);
                    z4 = zL0;
                }
            }
            if ((!z4) == 0) {
                AbstractC5138Ib1.s("Unexpectedly removed anchors");
            }
            int i18 = c24216yE62.o;
            int i19 = iArr[i4 + 1];
            c24216yE62.o = i18 + ((1073741824 & i19) == 0 ? i19 & 67108863 : 1);
            if (z2) {
                c24216yE62.t = i15;
                c24216yE62.i = i5 + i3;
            }
            if (zM) {
                c24216yE62.n1(iB0);
            }
            return listM;
        }

        static /* synthetic */ List c(a aVar, C24216yE6 c24216yE6, int i, C24216yE6 c24216yE62, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return aVar.b(c24216yE6, i, c24216yE62, z, z2, z3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24216yE6(C21850uE6 c21850uE6) {
        this.a = c21850uE6;
        this.b = c21850uE6.I();
        this.c = c21850uE6.N();
        this.d = c21850uE6.E();
        this.e = c21850uE6.P();
        this.f = c21850uE6.F();
        this.g = c21850uE6.L();
        this.h = (this.b.length / 5) - c21850uE6.L();
        this.k = c21850uE6.O();
        this.l = this.c.length - c21850uE6.O();
        this.m = c21850uE6.L();
        this.u = c21850uE6.L();
    }

    private final int C0(int[] iArr, int i) {
        return Q(iArr, i);
    }

    private final int E0(int[] iArr, int i) {
        return F0(iArr[(g0(i) * 5) + 2]);
    }

    private final int F0(int i) {
        return i > -2 ? i : c0() + i + 2;
    }

    private final int G(int[] iArr, int i) {
        return Q(iArr, i) + Integer.bitCount(iArr[(i * 5) + 1] >> 29);
    }

    private final int G0(int i, int i2) {
        return i < i2 ? i : -((c0() - i) + 2);
    }

    private final Object H0(Object obj) {
        Object objS0 = S0();
        R0(obj);
        return objS0;
    }

    private final boolean I(int i) {
        int iJ0 = i + 1;
        int iJ02 = i + j0(i);
        while (iJ0 < iJ02) {
            if ((this.b[(g0(iJ0) * 5) + 1] & 201326592) != 0) {
                return true;
            }
            iJ0 += j0(iJ0);
        }
        return false;
    }

    private final void I0() {
        C16143km4 c16143km4 = this.x;
        if (c16143km4 != null) {
            while (AbstractC7189Qq5.d(c16143km4)) {
                o1(AbstractC7189Qq5.f(c16143km4), c16143km4);
            }
        }
    }

    private final boolean J0(int i, int i2, HashMap map) {
        int i3 = i2 + i;
        int iR = AbstractC23036wE6.r(this.d, i3, Y() - this.h);
        if (iR >= this.d.size()) {
            iR--;
        }
        int i4 = iR + 1;
        int i5 = 0;
        while (iR >= 0) {
            C6669Om c6669Om = (C6669Om) this.d.get(iR);
            int iE = E(c6669Om);
            if (iE < i) {
                break;
            }
            if (iE < i3) {
                c6669Om.c(RecyclerView.UNDEFINED_DURATION);
                if (map != null) {
                }
                if (i5 == 0) {
                    i5 = iR + 1;
                }
                i4 = iR;
            }
            iR--;
        }
        boolean z2 = i4 < i5;
        if (z2) {
            this.d.subList(i4, i5).clear();
        }
        return z2;
    }

    private final void K() {
        int i = this.k;
        AbstractC9648aK.v(this.c, null, i, this.l + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0(int i, int i2) {
        if (i2 > 0) {
            ArrayList arrayList = this.d;
            w0(i);
            zJ0 = arrayList.isEmpty() ^ true ? J0(i, i2, this.e) : false;
            this.g = i;
            this.h += i2;
            int i3 = this.m;
            if (i3 > i) {
                this.m = Math.max(i, i3 - i2);
            }
            int i4 = this.u;
            if (i4 >= this.g) {
                this.u = i4 - i2;
            }
            int i5 = this.v;
            if (N(i5)) {
                n1(i5);
            }
        }
        return zJ0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(int i) {
        return i >= 0 && (this.b[(g0(i) * 5) + 1] & 201326592) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.l;
            int i5 = i + i2;
            y0(i5, i3);
            this.k = i;
            this.l = i4 + i2;
            AbstractC9648aK.v(this.c, null, i, i5);
            int i6 = this.j;
            if (i6 >= i) {
                this.j = i6 - i2;
            }
        }
    }

    private final boolean N(int i) {
        return i >= 0 && (this.b[(g0(i) * 5) + 1] & 67108864) != 0;
    }

    private final int O(int i, int i2, int i3) {
        return i < 0 ? (i3 - i2) + i + 1 : i;
    }

    private final int O0() {
        int iY = (Y() - this.h) - this.q.g();
        this.u = iY;
        return iY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P(int i) {
        return Q(this.b, g0(i));
    }

    private final void P0() {
        this.q.h((Y() - this.h) - this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q(int[] iArr, int i) {
        return i >= Y() ? this.c.length - this.l : O(iArr[(i * 5) + 4], this.l, this.c.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R(int i) {
        return i + (this.l * (i < this.k ? 0 : 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    private final void X(int i, int i2, int i3) {
        int iG0 = G0(i, this.g);
        while (i3 < i2) {
            this.b[(g0(i3) * 5) + 2] = iG0;
            int iP = AbstractC23036wE6.p(this.b, g0(i3)) + i3;
            X(i3, iP, i3 + 1);
            i3 = iP;
        }
    }

    private final int X0(int[] iArr, int i) {
        return i >= Y() ? this.c.length - this.l : O(AbstractC23036wE6.u(iArr, i), this.l, this.c.length);
    }

    private final int Y() {
        return this.b.length / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VN2 c1(int i) {
        C6669Om c6669OmJ1;
        HashMap map = this.e;
        if (map == null || (c6669OmJ1 = j1(i)) == null) {
            return null;
        }
        return (VN2) map.get(c6669OmJ1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g0(int i) {
        return i + (this.h * (i < this.g ? 0 : 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g1(int i, Object obj, boolean z2, Object obj2) {
        int iP;
        int i2 = this.v;
        Object[] objArr = this.n > 0;
        this.r.h(this.o);
        if (objArr == true) {
            int i3 = this.t;
            int iQ = Q(this.b, g0(i3));
            n0(1);
            this.i = iQ;
            this.j = iQ;
            int iG0 = g0(i3);
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            int i4 = obj != aVar.a() ? 1 : 0;
            int i5 = (z2 || obj2 == aVar.a()) ? 0 : 1;
            int iS = S(iQ, this.k, this.l, this.c.length);
            if (iS >= 0 && this.m < i3) {
                iS = -(((this.c.length - this.l) - iS) + 1);
            }
            AbstractC23036wE6.q(this.b, iG0, i, z2, i4, i5, this.v, iS);
            int i6 = (z2 ? 1 : 0) + i4 + i5;
            if (i6 > 0) {
                o0(i6, i3);
                Object[] objArr2 = this.c;
                int i7 = this.i;
                if (z2) {
                    objArr2[i7] = obj2;
                    i7++;
                }
                if (i4 != 0) {
                    objArr2[i7] = obj;
                    i7++;
                }
                if (i5 != 0) {
                    objArr2[i7] = obj2;
                    i7++;
                }
                this.i = i7;
            }
            this.o = 0;
            iP = i3 + 1;
            this.v = i3;
            this.t = iP;
            if (i2 >= 0) {
                c1(i2);
            }
        } else {
            this.p.h(i2);
            P0();
            int i8 = this.t;
            int iG02 = g0(i8);
            if (!AbstractC13042fc3.d(obj2, InterfaceC22053ub1.a.a())) {
                if (z2) {
                    r1(obj2);
                } else {
                    m1(obj2);
                }
            }
            this.i = X0(this.b, iG02);
            this.j = Q(this.b, g0(this.t + 1));
            int[] iArr = this.b;
            this.o = iArr[(iG02 * 5) + 1] & 67108863;
            this.v = i8;
            this.t = i8 + 1;
            iP = i8 + AbstractC23036wE6.p(iArr, iG02);
        }
        this.u = iP;
    }

    private final void l1(int i, int i2) {
        C6669Om c6669Om;
        int iA;
        C6669Om c6669Om2;
        int iA2;
        int i3;
        int iY = Y() - this.h;
        if (i >= i2) {
            for (int iR = AbstractC23036wE6.r(this.d, i2, iY); iR < this.d.size() && (iA = (c6669Om = (C6669Om) this.d.get(iR)).a()) >= 0; iR++) {
                c6669Om.c(-(iY - iA));
            }
            return;
        }
        for (int iR2 = AbstractC23036wE6.r(this.d, i, iY); iR2 < this.d.size() && (iA2 = (c6669Om2 = (C6669Om) this.d.get(iR2)).a()) < 0 && (i3 = iA2 + iY) < i2; iR2++) {
            c6669Om2.c(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(int i) {
        if (i > 0) {
            int i2 = this.t;
            w0(i2);
            int i3 = this.g;
            int i4 = this.h;
            int[] iArr = this.b;
            int length = iArr.length / 5;
            int i5 = length - i4;
            if (i4 < i) {
                int iMax = Math.max(Math.max(length * 2, i5 + i), 32);
                int[] iArr2 = new int[iMax * 5];
                int i6 = iMax - i5;
                AbstractC9648aK.j(iArr, iArr2, 0, 0, i3 * 5);
                AbstractC9648aK.j(iArr, iArr2, (i3 + i6) * 5, (i4 + i3) * 5, length * 5);
                this.b = iArr2;
                i4 = i6;
            }
            int i7 = this.u;
            if (i7 >= i3) {
                this.u = i7 + i;
            }
            int i8 = i3 + i;
            this.g = i8;
            this.h = i4 - i;
            int iS = S(i5 > 0 ? P(i2 + i) : 0, this.m >= i3 ? this.k : 0, this.l, this.c.length);
            for (int i9 = i3; i9 < i8; i9++) {
                this.b[(i9 * 5) + 4] = iS;
            }
            int i10 = this.m;
            if (i10 >= i3) {
                this.m = i10 + i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(int i) {
        if (i >= 0) {
            C16143km4 c16143km4C = this.x;
            if (c16143km4C == null) {
                c16143km4C = AbstractC7189Qq5.c(null, 1, null);
                this.x = c16143km4C;
            }
            AbstractC7189Qq5.a(c16143km4C, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(int i, int i2) {
        if (i > 0) {
            y0(this.i, i2);
            int i3 = this.k;
            int i4 = this.l;
            if (i4 < i) {
                Object[] objArr = this.c;
                int length = objArr.length;
                int i5 = length - i4;
                int iMax = Math.max(Math.max(length * 2, i5 + i), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i6 = 0; i6 < iMax; i6++) {
                    objArr2[i6] = null;
                }
                int i7 = iMax - i5;
                int i8 = i4 + i3;
                System.arraycopy(objArr, 0, objArr2, 0, i3);
                System.arraycopy(objArr, i8, objArr2, i3 + i7, length - i8);
                this.c = objArr2;
                i4 = i7;
            }
            int i9 = this.j;
            if (i9 >= i3) {
                this.j = i9 + i;
            }
            this.k = i3 + i;
            this.l = i4 - i;
        }
    }

    private final void o1(int i, C16143km4 c16143km4) {
        int iG0 = g0(i);
        boolean zI = I(i);
        int[] iArr = this.b;
        if (((iArr[(iG0 * 5) + 1] & 67108864) != 0) != zI) {
            AbstractC23036wE6.w(iArr, iG0, zI);
            int iD0 = D0(i);
            if (iD0 >= 0) {
                AbstractC7189Qq5.a(c16143km4, iD0);
            }
        }
    }

    private final void p1(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 4] = S(i2, this.k, this.l, this.c.length);
    }

    public static /* synthetic */ void s0(C24216yE6 c24216yE6, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c24216yE6.v;
        }
        c24216yE6.r0(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void s1(int r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.g0(r5)
            int[] r1 = r4.b
            int r2 = r1.length
            if (r0 >= r2) goto L15
            int r2 = r0 * 5
            r3 = 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r2 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r2
            if (r1 == 0) goto L15
            goto L16
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Updating the node of a group at "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " that was not created with as a node group"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            ir.nasim.AbstractC5138Ib1.s(r5)
        L31:
            java.lang.Object[] r5 = r4.c
            int[] r1 = r4.b
            int r0 = r4.C0(r1, r0)
            int r0 = r4.R(r0)
            r5[r0] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24216yE6.s1(int, java.lang.Object):void");
    }

    private final void t0(int i, int i2, int i3) {
        C6669Om c6669Om;
        int iE;
        int i4 = i3 + i;
        int iC0 = c0();
        int iR = AbstractC23036wE6.r(this.d, i, iC0);
        ArrayList arrayList = new ArrayList();
        if (iR >= 0) {
            while (iR < this.d.size() && (iE = E((c6669Om = (C6669Om) this.d.get(iR)))) >= i && iE < i4) {
                arrayList.add(c6669Om);
                this.d.remove(iR);
            }
        }
        int i5 = i2 - i;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C6669Om c6669Om2 = (C6669Om) arrayList.get(i6);
            int iE2 = E(c6669Om2) + i5;
            if (iE2 >= this.g) {
                c6669Om2.c(-(iC0 - iE2));
            } else {
                c6669Om2.c(iE2);
            }
            this.d.add(AbstractC23036wE6.r(this.d, iE2, iC0), c6669Om2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(int i) {
        int i2 = this.h;
        int i3 = this.g;
        if (i3 != i) {
            if (!this.d.isEmpty()) {
                l1(i3, i);
            }
            if (i2 > 0) {
                int[] iArr = this.b;
                int i4 = i * 5;
                int i5 = i2 * 5;
                int i6 = i3 * 5;
                if (i < i3) {
                    AbstractC9648aK.j(iArr, iArr, i5 + i4, i4, i6);
                } else {
                    AbstractC9648aK.j(iArr, iArr, i6, i6 + i5, i4 + i5);
                }
            }
            if (i < i3) {
                i3 = i + i2;
            }
            int iY = Y();
            if (!(i3 < iY)) {
                AbstractC5138Ib1.s("Check failed");
            }
            while (i3 < iY) {
                int i7 = (i3 * 5) + 2;
                int i8 = this.b[i7];
                int iG0 = G0(F0(i8), i);
                if (iG0 != i8) {
                    this.b[i7] = iG0;
                }
                i3++;
                if (i3 == i) {
                    i3 += i2;
                }
            }
        }
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(int i, int i2) {
        int i3 = this.l;
        int i4 = this.k;
        int i5 = this.m;
        if (i4 != i) {
            Object[] objArr = this.c;
            if (i < i4) {
                System.arraycopy(objArr, i, objArr, i + i3, i4 - i);
            } else {
                int i6 = i4 + i3;
                System.arraycopy(objArr, i6, objArr, i4, (i + i3) - i6);
            }
        }
        int iMin = Math.min(i2 + 1, c0());
        if (i5 != iMin) {
            int length = this.c.length - i3;
            if (iMin < i5) {
                int iG0 = g0(iMin);
                int iG02 = g0(i5);
                int i7 = this.g;
                while (iG0 < iG02) {
                    int i8 = (iG0 * 5) + 4;
                    int i9 = this.b[i8];
                    if (!(i9 >= 0)) {
                        AbstractC5138Ib1.s("Unexpected anchor value, expected a positive anchor");
                    }
                    this.b[i8] = -((length - i9) + 1);
                    iG0++;
                    if (iG0 == i7) {
                        iG0 += this.h;
                    }
                }
            } else {
                int iG03 = g0(i5);
                int iG04 = g0(iMin);
                while (iG03 < iG04) {
                    int i10 = (iG03 * 5) + 4;
                    int i11 = this.b[i10];
                    if (!(i11 < 0)) {
                        AbstractC5138Ib1.s("Unexpected anchor value, expected a negative anchor");
                    }
                    this.b[i10] = i11 + length + 1;
                    iG03++;
                    if (iG03 == this.g) {
                        iG03 += this.h;
                    }
                }
            }
            this.m = iMin;
        }
        this.k = i;
    }

    public final Object A0(C6669Om c6669Om) {
        return z0(c6669Om.e(this));
    }

    public final int B0(int i) {
        return this.b[(g0(i) * 5) + 1] & 67108863;
    }

    public final void C(int i) {
        boolean z2 = false;
        if (!(i >= 0)) {
            AbstractC5138Ib1.s("Cannot seek backwards");
        }
        if (!(this.n <= 0)) {
            AbstractC5214Ij5.b("Cannot call seek() while inserting");
        }
        if (i == 0) {
            return;
        }
        int i2 = this.t + i;
        if (i2 >= this.v && i2 <= this.u) {
            z2 = true;
        }
        if (!z2) {
            AbstractC5138Ib1.s("Cannot seek outside the current group (" + this.v + '-' + this.u + ')');
        }
        this.t = i2;
        int iQ = Q(this.b, g0(i2));
        this.i = iQ;
        this.j = iQ;
    }

    public final C6669Om D(int i) {
        ArrayList arrayList = this.d;
        int iT = AbstractC23036wE6.t(arrayList, i, c0());
        if (iT >= 0) {
            return (C6669Om) arrayList.get(iT);
        }
        if (i > this.g) {
            i = -(c0() - i);
        }
        C6669Om c6669Om = new C6669Om(i);
        arrayList.add(-(iT + 1), c6669Om);
        return c6669Om;
    }

    public final int D0(int i) {
        return E0(this.b, i);
    }

    public final int E(C6669Om c6669Om) {
        int iA = c6669Om.a();
        return iA < 0 ? iA + c0() : iA;
    }

    public final void F(C6669Om c6669Om, Object obj) {
        if (!(this.n == 0)) {
            AbstractC5138Ib1.s("Can only append a slot if not current inserting");
        }
        int i = this.i;
        int i2 = this.j;
        int iE = E(c6669Om);
        int iQ = Q(this.b, g0(iE + 1));
        this.i = iQ;
        this.j = iQ;
        o0(1, iE);
        if (i >= iQ) {
            i++;
            i2++;
        }
        this.c[iQ] = obj;
        this.i = i;
        this.j = i2;
    }

    public final void H() {
        int i = this.n;
        this.n = i + 1;
        if (i == 0) {
            P0();
        }
    }

    public final Object J(int i) {
        int iR = R(i);
        Object[] objArr = this.c;
        Object obj = objArr[iR];
        objArr[iR] = InterfaceC22053ub1.a.a();
        return obj;
    }

    public final boolean K0() {
        if (!(this.n == 0)) {
            AbstractC5138Ib1.s("Cannot remove group while inserting");
        }
        int i = this.t;
        int i2 = this.i;
        int iQ = Q(this.b, g0(i));
        int iT0 = T0();
        c1(this.v);
        C16143km4 c16143km4 = this.x;
        if (c16143km4 != null) {
            while (AbstractC7189Qq5.d(c16143km4) && AbstractC7189Qq5.e(c16143km4) >= i) {
                AbstractC7189Qq5.f(c16143km4);
            }
        }
        boolean zL0 = L0(i, this.t - i);
        M0(iQ, this.i - iQ, i - 1);
        this.t = i;
        this.i = i2;
        this.o -= iT0;
        return zL0;
    }

    public final void L(boolean z2) {
        this.w = true;
        if (z2 && this.p.b == 0) {
            w0(c0());
            y0(this.c.length - this.l, this.g);
            K();
            I0();
        }
        this.a.x(this, this.b, this.g, this.c, this.k, this.d, this.e, this.f);
    }

    public final void N0() {
        if (!(this.n == 0)) {
            AbstractC5138Ib1.s("Cannot reset when inserting");
        }
        I0();
        this.t = 0;
        this.u = Y() - this.h;
        this.i = 0;
        this.j = 0;
        this.o = 0;
    }

    public final Object Q0(int i, int i2, Object obj) {
        int iR = R(Y0(i, i2));
        Object[] objArr = this.c;
        Object obj2 = objArr[iR];
        objArr[iR] = obj;
        return obj2;
    }

    public final void R0(Object obj) {
        if (!(this.i <= this.j)) {
            AbstractC5138Ib1.s("Writing to an invalid slot");
        }
        this.c[R(this.i - 1)] = obj;
    }

    public final Object S0() {
        if (this.n > 0) {
            o0(1, this.v);
        }
        Object[] objArr = this.c;
        int i = this.i;
        this.i = i + 1;
        return objArr[R(i)];
    }

    public final int T() {
        C3587Bm4 c3587Bm4;
        boolean z2 = this.n > 0;
        int i = this.t;
        int i2 = this.u;
        int i3 = this.v;
        int iG0 = g0(i3);
        int i4 = this.o;
        int i5 = i - i3;
        int i6 = (iG0 * 5) + 1;
        boolean z3 = (this.b[i6] & 1073741824) != 0;
        if (z2) {
            C16734lm4 c16734lm4 = this.s;
            if (c16734lm4 != null && (c3587Bm4 = (C3587Bm4) c16734lm4.b(i3)) != null) {
                Object[] objArr = c3587Bm4.a;
                int i7 = c3587Bm4.b;
                for (int i8 = 0; i8 < i7; i8++) {
                    H0(objArr[i8]);
                }
            }
            AbstractC23036wE6.x(this.b, iG0, i5);
            AbstractC23036wE6.z(this.b, iG0, i4);
            this.o = this.r.g() + (z3 ? 1 : i4);
            int iE0 = E0(this.b, i3);
            this.v = iE0;
            int iC0 = iE0 < 0 ? c0() : g0(iE0 + 1);
            int iQ = iC0 >= 0 ? Q(this.b, iC0) : 0;
            this.i = iQ;
            this.j = iQ;
        } else {
            if (!(i == i2)) {
                AbstractC5138Ib1.s("Expected to be at the end of a group");
            }
            int iP = AbstractC23036wE6.p(this.b, iG0);
            int[] iArr = this.b;
            int i9 = iArr[i6] & 67108863;
            AbstractC23036wE6.x(iArr, iG0, i5);
            AbstractC23036wE6.z(this.b, iG0, i4);
            int iG = this.p.g();
            O0();
            this.v = iG;
            int iE02 = E0(this.b, i3);
            int iG2 = this.r.g();
            this.o = iG2;
            if (iE02 == iG) {
                this.o = iG2 + (z3 ? 0 : i4 - i9);
            } else {
                int i10 = i5 - iP;
                int i11 = z3 ? 0 : i4 - i9;
                if (i10 != 0 || i11 != 0) {
                    while (iE02 != 0 && iE02 != iG && (i11 != 0 || i10 != 0)) {
                        int iG02 = g0(iE02);
                        if (i10 != 0) {
                            AbstractC23036wE6.x(this.b, iG02, AbstractC23036wE6.p(this.b, iG02) + i10);
                        }
                        if (i11 != 0) {
                            int[] iArr2 = this.b;
                            AbstractC23036wE6.z(iArr2, iG02, (iArr2[(iG02 * 5) + 1] & 67108863) + i11);
                        }
                        int[] iArr3 = this.b;
                        if ((iArr3[(iG02 * 5) + 1] & 1073741824) != 0) {
                            i11 = 0;
                        }
                        iE02 = E0(iArr3, iE02);
                    }
                }
                this.o += i11;
            }
        }
        return i4;
    }

    public final int T0() {
        int iG0 = g0(this.t);
        int iP = this.t + AbstractC23036wE6.p(this.b, iG0);
        this.t = iP;
        this.i = Q(this.b, g0(iP));
        int i = this.b[(iG0 * 5) + 1];
        if ((1073741824 & i) != 0) {
            return 1;
        }
        return i & 67108863;
    }

    public final void U() {
        if (!(this.n > 0)) {
            AbstractC5214Ij5.b("Unbalanced begin/end insert");
        }
        int i = this.n - 1;
        this.n = i;
        if (i == 0) {
            if (!(this.r.b == this.p.b)) {
                AbstractC5138Ib1.s("startGroup/endGroup mismatch while inserting");
            }
            O0();
        }
    }

    public final void U0() {
        int i = this.u;
        this.t = i;
        this.i = Q(this.b, g0(i));
    }

    public final void V(int i) {
        boolean z2 = false;
        if (!(this.n <= 0)) {
            AbstractC5138Ib1.s("Cannot call ensureStarted() while inserting");
        }
        int i2 = this.v;
        if (i2 != i) {
            if (i >= i2 && i < this.u) {
                z2 = true;
            }
            if (!z2) {
                AbstractC5138Ib1.s("Started group at " + i + " must be a subgroup of the group at " + i2);
            }
            int i3 = this.t;
            int i4 = this.i;
            int i5 = this.j;
            this.t = i;
            e1();
            this.t = i3;
            this.i = i4;
            this.j = i5;
        }
    }

    public final Object V0(int i, int i2) {
        int iX0 = X0(this.b, g0(i));
        int iQ = Q(this.b, g0(i + 1));
        int i3 = i2 + iX0;
        if (iX0 > i3 || i3 >= iQ) {
            return InterfaceC22053ub1.a.a();
        }
        return this.c[R(i3)];
    }

    public final void W(C6669Om c6669Om) {
        V(c6669Om.e(this));
    }

    public final Object W0(C6669Om c6669Om, int i) {
        return V0(E(c6669Om), i);
    }

    public final int Y0(int i, int i2) {
        int iX0 = X0(this.b, g0(i));
        int i3 = iX0 + i2;
        if (!(i3 >= iX0 && i3 < Q(this.b, g0(i + 1)))) {
            AbstractC5138Ib1.s("Write to an invalid slot index " + i2 + " for group " + i);
        }
        return i3;
    }

    public final boolean Z() {
        return this.w;
    }

    public final int Z0(int i) {
        return Q(this.b, g0(i + j0(i)));
    }

    public final int a0() {
        return this.t;
    }

    public final int a1(int i) {
        return Q(this.b, g0(i + 1));
    }

    public final int b0() {
        return this.v;
    }

    public final int b1(int i) {
        return X0(this.b, g0(i));
    }

    public final int c0() {
        return Y() - this.h;
    }

    public final int d0() {
        return this.c.length - this.l;
    }

    public final void d1(int i, Object obj, Object obj2) {
        g1(i, obj, false, obj2);
    }

    public final C21850uE6 e0() {
        return this.a;
    }

    public final void e1() {
        if (!(this.n == 0)) {
            AbstractC5138Ib1.s("Key must be supplied when inserting");
        }
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        g1(0, aVar.a(), false, aVar.a());
    }

    public final Object f0(int i) {
        int iG0 = g0(i);
        int[] iArr = this.b;
        return (iArr[(iG0 * 5) + 1] & 268435456) != 0 ? this.c[G(iArr, iG0)] : InterfaceC22053ub1.a.a();
    }

    public final void f1(int i, Object obj) {
        g1(i, obj, false, InterfaceC22053ub1.a.a());
    }

    public final int h0(int i) {
        return this.b[g0(i) * 5];
    }

    public final void h1(int i, Object obj) {
        g1(i, obj, true, InterfaceC22053ub1.a.a());
    }

    public final Object i0(int i) {
        int iG0 = g0(i);
        int[] iArr = this.b;
        if ((iArr[(iG0 * 5) + 1] & 536870912) != 0) {
            return this.c[AbstractC23036wE6.s(iArr, iG0)];
        }
        return null;
    }

    public final void i1(int i) {
        if (!(i > 0)) {
            AbstractC5138Ib1.s("Check failed");
        }
        int i2 = this.v;
        int iX0 = X0(this.b, g0(i2));
        int iQ = Q(this.b, g0(i2 + 1)) - i;
        if (!(iQ >= iX0)) {
            AbstractC5138Ib1.s("Check failed");
        }
        M0(iQ, i, i2);
        int i3 = this.i;
        if (i3 >= iX0) {
            this.i = i3 - i;
        }
    }

    public final int j0(int i) {
        return AbstractC23036wE6.p(this.b, g0(i));
    }

    public final C6669Om j1(int i) {
        if (i < 0 || i >= c0()) {
            return null;
        }
        return AbstractC23036wE6.o(this.d, i, c0());
    }

    public final boolean k0(int i) {
        return l0(i, this.t);
    }

    public final Object k1(Object obj) {
        if (this.n <= 0 || this.i == this.k) {
            return H0(obj);
        }
        C16734lm4 c16734lm4 = this.s;
        ED1 ed1 = null;
        int i = 1;
        int i2 = 0;
        if (c16734lm4 == null) {
            c16734lm4 = new C16734lm4(i2, i, ed1);
        }
        this.s = c16734lm4;
        int i3 = this.v;
        Object objB = c16734lm4.b(i3);
        if (objB == null) {
            objB = new C3587Bm4(i2, i, ed1);
            c16734lm4.r(i3, objB);
        }
        ((C3587Bm4) objB).n(obj);
        return InterfaceC22053ub1.a.a();
    }

    public final boolean l0(int i, int i2) {
        int iB;
        int iY;
        if (i2 == this.v) {
            iY = this.u;
        } else if (i2 <= this.p.f(0) && (iB = this.p.b(i2)) >= 0) {
            iY = (Y() - this.h) - this.q.d(iB);
        } else {
            int iJ0 = j0(i2);
            iY = iJ0 + i2;
        }
        return i > i2 && i < iY;
    }

    public final boolean m0(int i) {
        int i2 = this.v;
        return (i > i2 && i < this.u) || (i2 == 0 && i == 0);
    }

    public final void m1(Object obj) {
        int iG0 = g0(this.t);
        if (!((this.b[(iG0 * 5) + 1] & 268435456) != 0)) {
            AbstractC5138Ib1.s("Updating the data of a group that was not created with a data slot");
        }
        this.c[R(G(this.b, iG0))] = obj;
    }

    public final boolean p0() {
        int i = this.t;
        return i < this.u && (this.b[(g0(i) * 5) + 1] & 1073741824) != 0;
    }

    public final boolean q0(int i) {
        return (this.b[(g0(i) * 5) + 1] & 1073741824) != 0;
    }

    public final void q1(C6669Om c6669Om, Object obj) {
        s1(c6669Om.e(this), obj);
    }

    public final void r0(int i) {
        int iG0 = g0(i);
        int[] iArr = this.b;
        int i2 = (iG0 * 5) + 1;
        if ((iArr[i2] & 134217728) != 0) {
            return;
        }
        AbstractC23036wE6.y(iArr, iG0, true);
        if ((this.b[i2] & 67108864) != 0) {
            return;
        }
        n1(D0(i));
    }

    public final void r1(Object obj) {
        s1(this.t, obj);
    }

    public final void t1() {
        this.e = this.a.P();
        this.f = this.a.F();
    }

    public String toString() {
        return "SlotWriter(current = " + this.t + " end=" + this.u + " size = " + c0() + " gap=" + this.g + '-' + (this.g + this.h) + ')';
    }

    public final List u0(C21850uE6 c21850uE6, int i, boolean z2) {
        if (!(this.n > 0)) {
            AbstractC5138Ib1.s("Check failed");
        }
        if (i != 0 || this.t != 0 || this.a.L() != 0 || AbstractC23036wE6.p(c21850uE6.I(), i) != c21850uE6.L()) {
            C24216yE6 c24216yE6W = c21850uE6.W();
            try {
                List listB = y.b(c24216yE6W, i, this, true, true, z2);
                c24216yE6W.L(true);
                return listB;
            } catch (Throwable th) {
                c24216yE6W.L(false);
                throw th;
            }
        }
        int[] iArr = this.b;
        Object[] objArr = this.c;
        ArrayList arrayList = this.d;
        HashMap map = this.e;
        C16734lm4 c16734lm4 = this.f;
        int[] iArrI = c21850uE6.I();
        int iL = c21850uE6.L();
        Object[] objArrN = c21850uE6.N();
        int iO = c21850uE6.O();
        HashMap mapP = c21850uE6.P();
        C16734lm4 c16734lm4F = c21850uE6.F();
        this.b = iArrI;
        this.c = objArrN;
        this.d = c21850uE6.E();
        this.g = iL;
        this.h = (iArrI.length / 5) - iL;
        this.k = iO;
        this.l = objArrN.length - iO;
        this.m = iL;
        this.e = mapP;
        this.f = c16734lm4F;
        c21850uE6.Z(iArr, 0, objArr, 0, arrayList, map, c16734lm4);
        return this.d;
    }

    public final void v0(int i) {
        if (!(this.n == 0)) {
            AbstractC5138Ib1.s("Cannot move a group while inserting");
        }
        if (!(i >= 0)) {
            AbstractC5138Ib1.s("Parameter offset is out of bounds");
        }
        if (i == 0) {
            return;
        }
        int i2 = this.t;
        int i3 = this.v;
        int i4 = this.u;
        int iP = i2;
        for (int i5 = i; i5 > 0; i5--) {
            iP += AbstractC23036wE6.p(this.b, g0(iP));
            if (!(iP <= i4)) {
                AbstractC5138Ib1.s("Parameter offset is out of bounds");
            }
        }
        int iP2 = AbstractC23036wE6.p(this.b, g0(iP));
        int iQ = Q(this.b, g0(this.t));
        int iQ2 = Q(this.b, g0(iP));
        int i6 = iP + iP2;
        int iQ3 = Q(this.b, g0(i6));
        int i7 = iQ3 - iQ2;
        o0(i7, Math.max(this.t - 1, 0));
        n0(iP2);
        int[] iArr = this.b;
        int iG0 = g0(i6) * 5;
        AbstractC9648aK.j(iArr, iArr, g0(i2) * 5, iG0, (iP2 * 5) + iG0);
        if (i7 > 0) {
            Object[] objArr = this.c;
            int iR = R(iQ2 + i7);
            System.arraycopy(objArr, iR, objArr, iQ, R(iQ3 + i7) - iR);
        }
        int i8 = iQ2 + i7;
        int i9 = i8 - iQ;
        int i10 = this.k;
        int i11 = this.l;
        int length = this.c.length;
        int i12 = this.m;
        int i13 = i2 + iP2;
        int i14 = i2;
        while (i14 < i13) {
            int iG02 = g0(i14);
            int i15 = i10;
            int i16 = i9;
            p1(iArr, iG02, S(Q(iArr, iG02) - i9, i12 < iG02 ? 0 : i15, i11, length));
            i14++;
            i10 = i15;
            i9 = i16;
        }
        t0(i6, i2, iP2);
        if (!(!L0(i6, iP2))) {
            AbstractC5138Ib1.s("Unexpectedly removed anchors");
        }
        X(i3, this.u, i2);
        if (i7 > 0) {
            M0(i8, i7, i6 - 1);
        }
    }

    public final List x0(int i, C21850uE6 c21850uE6, int i2) {
        if (!(this.n <= 0 && j0(this.t + i) == 1)) {
            AbstractC5138Ib1.s("Check failed");
        }
        int i3 = this.t;
        int i4 = this.i;
        int i5 = this.j;
        C(i);
        e1();
        H();
        C24216yE6 c24216yE6W = c21850uE6.W();
        try {
            List listC = a.c(y, c24216yE6W, i2, this, false, true, false, 32, null);
            c24216yE6W.L(true);
            U();
            T();
            this.t = i3;
            this.i = i4;
            this.j = i5;
            return listC;
        } catch (Throwable th) {
            c24216yE6W.L(false);
            throw th;
        }
    }

    public final Object z0(int i) {
        int iG0 = g0(i);
        int[] iArr = this.b;
        if ((iArr[(iG0 * 5) + 1] & 1073741824) != 0) {
            return this.c[R(C0(iArr, iG0))];
        }
        return null;
    }
}
