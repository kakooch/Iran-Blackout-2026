package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.jX3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C15404jX3 {
    private static volatile C15404jX3[] a = new C15404jX3[1];
    private static final Object[] b = new Object[1];
    private static Pattern c = Pattern.compile("\\*\\*(.+?)\\*\\*");
    private static Pattern d = Pattern.compile("__(.+?)__");
    private static Pattern e = Pattern.compile("\\|\\|(.+?)\\|\\|");
    private static Pattern f = Pattern.compile("~~(.+?)~~");

    public C15404jX3(int i) {
    }

    public static C15404jX3 a(int i) {
        C15404jX3 c15404jX3 = a[i];
        if (c15404jX3 == null) {
            synchronized (b) {
                try {
                    c15404jX3 = a[i];
                    if (c15404jX3 == null) {
                        C15404jX3[] c15404jX3Arr = a;
                        C15404jX3 c15404jX32 = new C15404jX3(i);
                        c15404jX3Arr[i] = c15404jX32;
                        c15404jX3 = c15404jX32;
                    }
                } finally {
                }
            }
        }
        return c15404jX3;
    }

    public static int c(L57 l57) {
        if (l57 == null) {
            return -1;
        }
        if (C10743c74.W(l57) instanceof C23255wc7) {
            return 0;
        }
        if (!(C10743c74.W(l57) instanceof C16046kc7)) {
            if (!l57.n.isEmpty()) {
                for (int i = 0; i < l57.n.size(); i++) {
                    N57 n57 = (N57) l57.n.get(i);
                    if ((n57 instanceof C7761Tb7) || (n57 instanceof C7056Qb7) || (n57 instanceof C4676Gb7)) {
                        return 3;
                    }
                }
            }
            return -1;
        }
        AbstractC18106o57 abstractC18106o57 = C10743c74.W(l57).s;
        if (abstractC18106o57 == null) {
            return -1;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (int i2 = 0; i2 < abstractC18106o57.p.size(); i2++) {
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i2);
            if (abstractC18697p57 instanceof N77) {
                z = abstractC18697p57.g;
                z3 = !z;
                z2 = z;
            } else if (abstractC18697p57 instanceof B77) {
                z4 = true;
            } else if (abstractC18697p57 instanceof C77) {
                z = abstractC18697p57.o;
                z6 = !z;
            } else if (abstractC18697p57 instanceof J77) {
                z5 = true;
            }
        }
        if (z || z2) {
            return 2;
        }
        if (z3 && !z4 && !z5) {
            return 0;
        }
        if (z5) {
            return -1;
        }
        if (z4) {
            return 5;
        }
        return z6 ? 4 : 1;
    }

    public void b(long j, int i, int i2, int i3, boolean z) {
    }

    public void d(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }
}
