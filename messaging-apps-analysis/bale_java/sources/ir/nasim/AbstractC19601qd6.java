package ir.nasim;

/* renamed from: ir.nasim.qd6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19601qd6 {
    public static final void a(C7386Rm4 c7386Rm4, Object obj, Object obj2) {
        int iN = c7386Rm4.n(obj);
        boolean z = iN < 0;
        Object obj3 = z ? null : c7386Rm4.c[iN];
        if (obj3 != null) {
            if (obj3 instanceof C7620Sm4) {
                AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                ((C7620Sm4) obj3).h(obj2);
            } else if (obj3 != obj2) {
                C7620Sm4 c7620Sm4 = new C7620Sm4(0, 1, null);
                AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                c7620Sm4.h(obj3);
                c7620Sm4.h(obj2);
                obj2 = c7620Sm4;
            }
            obj2 = obj3;
        }
        if (!z) {
            c7386Rm4.c[iN] = obj2;
            return;
        }
        int i = ~iN;
        c7386Rm4.b[i] = obj;
        c7386Rm4.c[i] = obj2;
    }

    public static final void b(C7386Rm4 c7386Rm4) {
        c7386Rm4.k();
    }

    public static /* synthetic */ C7386Rm4 d(C7386Rm4 c7386Rm4, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            c7386Rm4 = AbstractC22068uc6.b();
        }
        return c(c7386Rm4);
    }

    public static final boolean e(C7386Rm4 c7386Rm4, Object obj) {
        return c7386Rm4.c(obj);
    }

    public static final int f(C7386Rm4 c7386Rm4) {
        return c7386Rm4.g();
    }

    public static final boolean g(C7386Rm4 c7386Rm4, Object obj, Object obj2) {
        Object objE = c7386Rm4.e(obj);
        if (objE == null) {
            return false;
        }
        if (!(objE instanceof C7620Sm4)) {
            if (!AbstractC13042fc3.d(objE, obj2)) {
                return false;
            }
            c7386Rm4.u(obj);
            return true;
        }
        C7620Sm4 c7620Sm4 = (C7620Sm4) objE;
        boolean zY = c7620Sm4.y(obj2);
        if (zY && c7620Sm4.d()) {
            c7386Rm4.u(obj);
        }
        return zY;
    }

    public static final void h(C7386Rm4 c7386Rm4, Object obj) {
        boolean zD;
        long[] jArr = c7386Rm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj2 = c7386Rm4.b[i4];
                        Object obj3 = c7386Rm4.c[i4];
                        if (obj3 instanceof C7620Sm4) {
                            AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            C7620Sm4 c7620Sm4 = (C7620Sm4) obj3;
                            c7620Sm4.y(obj);
                            zD = c7620Sm4.d();
                        } else {
                            zD = obj3 == obj;
                        }
                        if (zD) {
                            c7386Rm4.v(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public static final void i(C7386Rm4 c7386Rm4, Object obj, Object obj2) {
        c7386Rm4.x(obj, obj2);
    }

    public static C7386Rm4 c(C7386Rm4 c7386Rm4) {
        return c7386Rm4;
    }
}
