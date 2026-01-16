package ir.nasim;

/* renamed from: ir.nasim.wU2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23176wU2 {
    private static final C23176wU2 c = new C23176wU2(C5833La3.a(), 0);
    private final C5833La3 a;
    private final int b;

    private C23176wU2(C5833La3 c5833La3, int i) {
        this.a = c5833La3;
        this.b = i;
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static C23176wU2 b() {
        C23176wU2 c23176wU2 = c;
        if (c23176wU2 == null) {
            a(0);
        }
        return c23176wU2;
    }

    private C5390Jd1 d(int i) {
        C5390Jd1 c5390Jd1 = (C5390Jd1) this.a.b(i);
        return c5390Jd1 == null ? C5390Jd1.h() : c5390Jd1;
    }

    private static int e(C5390Jd1 c5390Jd1, Object obj) {
        int i = 0;
        while (c5390Jd1 != null && c5390Jd1.size() > 0) {
            if (((RN3) c5390Jd1.a).a.equals(obj)) {
                return i;
            }
            c5390Jd1 = c5390Jd1.b;
            i++;
        }
        return -1;
    }

    public Object c(Object obj) {
        for (C5390Jd1 c5390Jd1D = d(obj.hashCode()); c5390Jd1D != null && c5390Jd1D.size() > 0; c5390Jd1D = c5390Jd1D.b) {
            RN3 rn3 = (RN3) c5390Jd1D.a;
            if (rn3.a.equals(obj)) {
                return rn3.b;
            }
        }
        return null;
    }

    public C23176wU2 f(Object obj, Object obj2) {
        C5390Jd1 c5390Jd1D = d(obj.hashCode());
        int size = c5390Jd1D.size();
        int iE = e(c5390Jd1D, obj);
        if (iE != -1) {
            c5390Jd1D = c5390Jd1D.j(iE);
        }
        C5390Jd1 c5390Jd1R = c5390Jd1D.r(new RN3(obj, obj2));
        return new C23176wU2(this.a.c(obj.hashCode(), c5390Jd1R), (this.b - size) + c5390Jd1R.size());
    }
}
