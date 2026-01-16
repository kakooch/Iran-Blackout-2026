package ir.nasim;

/* renamed from: ir.nasim.e83, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12159e83 {
    public static void a(TA4 ta4) {
        if (ta4.c() == ta4.d()) {
            return;
        }
        d(ta4.c(), ta4.d());
    }

    public static void b(C5693Kk7 c5693Kk7, C5693Kk7 c5693Kk72, int i) {
        if (c5693Kk7 == null || c5693Kk72 == null || c5693Kk7 == c5693Kk72) {
            return;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(c5693Kk7.m());
        TA4 ta4E = c5693Kk7.e();
        TA4 ta4E2 = c5693Kk72.e();
        while (ta4E != ta4E2) {
            sb.append(((C5693Kk7) ta4E).m());
            TA4 ta4E3 = ta4E.e();
            ta4E.l();
            ta4E = ta4E3;
        }
        c5693Kk7.n(sb.toString());
    }

    public static void c(TA4 ta4, TA4 ta42) {
        if (ta4 == ta42 || ta4.e() == ta42) {
            return;
        }
        d(ta4.e(), ta42.g());
    }

    public static void d(TA4 ta4, TA4 ta42) {
        C5693Kk7 c5693Kk7 = null;
        C5693Kk7 c5693Kk72 = null;
        int length = 0;
        while (ta4 != null) {
            if (ta4 instanceof C5693Kk7) {
                c5693Kk72 = (C5693Kk7) ta4;
                if (c5693Kk7 == null) {
                    c5693Kk7 = c5693Kk72;
                }
                length += c5693Kk72.m().length();
            } else {
                b(c5693Kk7, c5693Kk72, length);
                c5693Kk7 = null;
                c5693Kk72 = null;
                length = 0;
            }
            if (ta4 == ta42) {
                break;
            } else {
                ta4 = ta4.e();
            }
        }
        b(c5693Kk7, c5693Kk72, length);
    }
}
