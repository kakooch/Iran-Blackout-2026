package ir.nasim;

/* renamed from: ir.nasim.gQ0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC13547gQ0 {
    public static boolean a(AbstractC15742k57 abstractC15742k57, int i) {
        boolean z;
        if (abstractC15742k57 == null) {
            return false;
        }
        if (abstractC15742k57.g) {
            return true;
        }
        U67 u67 = abstractC15742k57.L;
        if (u67 != null) {
            if (i == 0) {
                z = u67.i;
            } else if (i == 1) {
                z = u67.c;
            } else if (i == 2) {
                z = u67.g;
            } else if (i == 3) {
                z = u67.h;
            } else if (i == 4) {
                z = u67.j;
            } else if (i != 5) {
                switch (i) {
                    case 12:
                        z = u67.e;
                        break;
                    case 13:
                        z = u67.f;
                        break;
                    case 14:
                        z = u67.l;
                        break;
                    case 15:
                        z = u67.n;
                        break;
                    default:
                        z = false;
                        break;
                }
            } else {
                z = u67.d;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(V67 v67, int i) {
        if (v67 == null) {
            return false;
        }
        if (i == 0) {
            return v67.n;
        }
        if (i == 1) {
            return v67.l;
        }
        if (i == 3) {
            return v67.m;
        }
        switch (i) {
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            default:
                switch (i) {
                }
        }
        return false;
    }

    public static boolean c(AbstractC15742k57 abstractC15742k57) {
        U67 u67;
        return abstractC15742k57 != null && (abstractC15742k57.g || !((u67 = abstractC15742k57.L) == null || u67.b == 0));
    }

    public static boolean d(AbstractC15742k57 abstractC15742k57, int i) {
        return abstractC15742k57 != null && (b(abstractC15742k57.M, i) || b(abstractC15742k57.N, i));
    }

    public static boolean e(AbstractC15742k57 abstractC15742k57) {
        return (abstractC15742k57 instanceof C67) || (abstractC15742k57 instanceof F67);
    }

    public static boolean f(long j, int i) {
        return g(ir.nasim.tgwidgets.editor.messenger.C.n(i).i(Long.valueOf(j)));
    }

    public static boolean g(AbstractC15742k57 abstractC15742k57) {
        return e(abstractC15742k57) && !h(abstractC15742k57);
    }

    public static boolean h(AbstractC15742k57 abstractC15742k57) {
        return ((abstractC15742k57 instanceof C67) || (abstractC15742k57 instanceof F67)) && abstractC15742k57.q;
    }

    public static boolean i(AbstractC15742k57 abstractC15742k57) {
        return abstractC15742k57 == null || (abstractC15742k57 instanceof W67) || (abstractC15742k57 instanceof Y67) || (abstractC15742k57 instanceof F67) || abstractC15742k57.j || abstractC15742k57.h || abstractC15742k57.i;
    }
}
