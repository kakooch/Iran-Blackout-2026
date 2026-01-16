package ir.nasim;

/* renamed from: ir.nasim.Nl4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6405Nl4 {
    private final C7386Rm4 a;

    private /* synthetic */ C6405Nl4(C7386Rm4 c7386Rm4) {
        this.a = c7386Rm4;
    }

    public static final void a(C7386Rm4 c7386Rm4, Object obj, Object obj2) {
        int iN = c7386Rm4.n(obj);
        boolean z = iN < 0;
        Object obj3 = z ? null : c7386Rm4.c[iN];
        AbstractC19810qy7.p(obj3);
        if (obj3 != null) {
            if (obj3 instanceof C3587Bm4) {
                AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type androidx.collection.MutableObjectList<kotlin.Any>");
                C3587Bm4 c3587Bm4 = (C3587Bm4) obj3;
                c3587Bm4.n(obj2);
                obj2 = c3587Bm4;
            } else {
                obj2 = AbstractC23642xG4.h(obj3, obj2);
            }
        }
        if (!z) {
            c7386Rm4.c[iN] = obj2;
            return;
        }
        int i = ~iN;
        c7386Rm4.b[i] = obj;
        c7386Rm4.c[i] = obj2;
    }

    public static final /* synthetic */ C6405Nl4 b(C7386Rm4 c7386Rm4) {
        return new C6405Nl4(c7386Rm4);
    }

    public static final void c(C7386Rm4 c7386Rm4) {
        c7386Rm4.k();
    }

    public static /* synthetic */ C7386Rm4 e(C7386Rm4 c7386Rm4, int i, ED1 ed1) {
        int i2 = 1;
        if ((i & 1) != 0) {
            c7386Rm4 = new C7386Rm4(0, i2, null);
        }
        return d(c7386Rm4);
    }

    public static final boolean f(C7386Rm4 c7386Rm4, Object obj) {
        return c7386Rm4.b(obj);
    }

    public static boolean g(C7386Rm4 c7386Rm4, Object obj) {
        return (obj instanceof C6405Nl4) && AbstractC13042fc3.d(c7386Rm4, ((C6405Nl4) obj).o());
    }

    public static int h(C7386Rm4 c7386Rm4) {
        return c7386Rm4.hashCode();
    }

    public static final boolean i(C7386Rm4 c7386Rm4) {
        return c7386Rm4.h();
    }

    public static final boolean j(C7386Rm4 c7386Rm4) {
        return c7386Rm4.i();
    }

    public static final Object k(C7386Rm4 c7386Rm4, Object obj) {
        Object objE = c7386Rm4.e(obj);
        if (objE == null) {
            return null;
        }
        if (!(objE instanceof C3587Bm4)) {
            c7386Rm4.u(obj);
            return objE;
        }
        C3587Bm4 c3587Bm4 = (C3587Bm4) objE;
        Object objA = c3587Bm4.A(0);
        if (c3587Bm4.g()) {
            c7386Rm4.u(obj);
        }
        if (c3587Bm4.e() == 1) {
            c7386Rm4.x(obj, c3587Bm4.c());
        }
        return objA;
    }

    public static final Object l(C7386Rm4 c7386Rm4, Object obj) {
        Object objE = c7386Rm4.e(obj);
        if (objE == null) {
            return null;
        }
        if (!(objE instanceof C3587Bm4)) {
            c7386Rm4.u(obj);
            return objE;
        }
        C3587Bm4 c3587Bm4 = (C3587Bm4) objE;
        Object objA = AbstractC8019Ue2.a(c3587Bm4);
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
        if (c3587Bm4.g()) {
            c7386Rm4.u(obj);
        }
        if (c3587Bm4.e() == 1) {
            c7386Rm4.x(obj, c3587Bm4.c());
        }
        return objA;
    }

    public static final void m(C7386Rm4 c7386Rm4, Object obj, UA2 ua2) {
        Object objE = c7386Rm4.e(obj);
        if (objE != null) {
            if (!(objE instanceof C3587Bm4)) {
                if (((Boolean) ua2.invoke(objE)).booleanValue()) {
                    c7386Rm4.u(obj);
                    return;
                }
                return;
            }
            C3587Bm4 c3587Bm4 = (C3587Bm4) objE;
            int i = c3587Bm4.b;
            Object[] objArr = c3587Bm4.a;
            int i2 = 0;
            C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, i);
            int iO = c24411ya3Y.o();
            int iT = c24411ya3Y.t();
            if (iO <= iT) {
                while (true) {
                    objArr[iO - i2] = objArr[iO];
                    if (((Boolean) ua2.invoke(objArr[iO])).booleanValue()) {
                        i2++;
                    }
                    if (iO == iT) {
                        break;
                    } else {
                        iO++;
                    }
                }
            }
            AbstractC9648aK.v(objArr, null, i - i2, i);
            c3587Bm4.b -= i2;
            if (c3587Bm4.g()) {
                c7386Rm4.u(obj);
            }
            if (c3587Bm4.e() == 0) {
                c7386Rm4.x(obj, c3587Bm4.c());
            }
        }
    }

    public static String n(C7386Rm4 c7386Rm4) {
        return "MultiValueMap(map=" + c7386Rm4 + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.AbstractC23052wG4 p(ir.nasim.C7386Rm4 r14) {
        /*
            boolean r0 = r14.h()
            if (r0 == 0) goto Lb
            ir.nasim.wG4 r14 = ir.nasim.AbstractC23642xG4.f()
            return r14
        Lb:
            ir.nasim.Bm4 r0 = new ir.nasim.Bm4
            r1 = 0
            r2 = 0
            r3 = 1
            r0.<init>(r2, r3, r1)
            java.lang.Object[] r1 = r14.c
            long[] r14 = r14.a
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L69
            r4 = r2
        L1d:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L64
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L37:
            if (r9 >= r7) goto L62
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L5e
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof ir.nasim.C3587Bm4
            if (r11 == 0) goto L56
            java.lang.String r11 = "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.collection.MultiValueMap>"
            ir.nasim.AbstractC13042fc3.g(r10, r11)
            ir.nasim.Bm4 r10 = (ir.nasim.C3587Bm4) r10
            r0.p(r10)
            goto L5e
        L56:
            java.lang.String r11 = "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap"
            ir.nasim.AbstractC13042fc3.g(r10, r11)
            r0.n(r10)
        L5e:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L62:
            if (r7 != r8) goto L69
        L64:
            if (r4 == r3) goto L69
            int r4 = r4 + 1
            goto L1d
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6405Nl4.p(ir.nasim.Rm4):ir.nasim.wG4");
    }

    public boolean equals(Object obj) {
        return g(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ C7386Rm4 o() {
        return this.a;
    }

    public String toString() {
        return n(this.a);
    }

    public static C7386Rm4 d(C7386Rm4 c7386Rm4) {
        return c7386Rm4;
    }
}
