package ir.nasim;

import android.text.TextUtils;

/* renamed from: ir.nasim.d67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC11500d67 extends AbstractC12724f57 {
    public String b;
    public AbstractC20488s57 c;
    public int d;
    public int e;
    public int f;
    public byte[] g;

    public static AbstractC11500d67 d(long j, long j2, long j3, T1 t1, int i, boolean z) {
        AbstractC11500d67 c7317Re7;
        switch (i) {
            case -668906175:
                c7317Re7 = new C7317Re7();
                break;
            case -525288402:
                c7317Re7 = new C8758Xe7();
                break;
            case -374917894:
                c7317Re7 = new C6839Pe7();
                break;
            case -96535659:
                c7317Re7 = new C8024Ue7();
                break;
            case 35527382:
                c7317Re7 = new C6600Oe7();
                break;
            case 236446268:
                c7317Re7 = new C7788Te7();
                break;
            case 1520986705:
                c7317Re7 = new C8258Ve7();
                break;
            case 1976012384:
                c7317Re7 = new C7551Se7();
                break;
            case 2009052699:
                c7317Re7 = new C8492We7();
                break;
            default:
                c7317Re7 = null;
                break;
        }
        if (c7317Re7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PhotoSize", Integer.valueOf(i)));
        }
        if (c7317Re7 != null) {
            c7317Re7.b(t1, z);
            if (c7317Re7.c == null) {
                if (TextUtils.isEmpty(c7317Re7.b) || (j == 0 && j2 == 0 && j3 == 0)) {
                    c7317Re7.c = new C19318q87();
                } else {
                    C18727p87 c18727p87 = new C18727p87();
                    c7317Re7.c = c18727p87;
                    if (j != 0) {
                        c18727p87.c = -j;
                        c18727p87.d = c7317Re7.b.charAt(0);
                    } else if (j2 != 0) {
                        c18727p87.c = -j2;
                        c18727p87.d = c7317Re7.b.charAt(0) + 1000;
                    } else if (j3 != 0) {
                        c18727p87.c = -j3;
                        c18727p87.d = c7317Re7.b.charAt(0) + 2000;
                    }
                }
            }
        }
        return c7317Re7;
    }
}
