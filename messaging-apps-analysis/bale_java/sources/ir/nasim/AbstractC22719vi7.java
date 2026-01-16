package ir.nasim;

import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: ir.nasim.vi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22719vi7 extends AbstractC12724f57 {
    public int b;
    public String c;
    public AbstractC20488s57 d;
    public int e;
    public int f;
    public int g;
    public double h;
    public ArrayList i = new ArrayList();

    public static AbstractC22719vi7 d(long j, long j2, T1 t1, int i, boolean z) {
        AbstractC22719vi7 c5432Jh7;
        switch (i) {
            case -567037804:
                c5432Jh7 = new C5432Jh7();
                break;
            case -399391402:
                c5432Jh7 = new C6372Nh7();
                break;
            case -128171716:
                c5432Jh7 = new C5666Kh7();
                break;
            case 228623102:
                c5432Jh7 = new C5900Lh7();
                break;
            case 1130084743:
                c5432Jh7 = new C6133Mh7();
                break;
            default:
                c5432Jh7 = null;
                break;
        }
        if (c5432Jh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in VideoSize", Integer.valueOf(i)));
        }
        if (c5432Jh7 != null) {
            c5432Jh7.b(t1, z);
            if (c5432Jh7.d == null) {
                if (TextUtils.isEmpty(c5432Jh7.c) || (j == 0 && j2 == 0)) {
                    c5432Jh7.d = new C19318q87();
                } else {
                    C18727p87 c18727p87 = new C18727p87();
                    c5432Jh7.d = c18727p87;
                    if (j != 0) {
                        c18727p87.c = -j;
                        c18727p87.d = c5432Jh7.c.charAt(0);
                    } else {
                        c18727p87.c = -j2;
                        c18727p87.d = c5432Jh7.c.charAt(0) + 1000;
                    }
                }
            }
        }
        return c5432Jh7;
    }
}
