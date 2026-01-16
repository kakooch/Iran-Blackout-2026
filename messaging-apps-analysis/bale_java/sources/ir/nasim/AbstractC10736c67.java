package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.c67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC10736c67 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public long d;
    public long e;
    public byte[] f;
    public int g;
    public ArrayList h = new ArrayList();
    public ArrayList i = new ArrayList();
    public int j;
    public long k;
    public AbstractC21765u57 l;
    public String m;

    public static AbstractC10736c67 d(T1 t1, int i, boolean z) {
        AbstractC10736c67 c9850af7;
        switch (i) {
            case -1836524247:
                c9850af7 = new C9850af7();
                break;
            case -1673036328:
                c9850af7 = new C10470bf7();
                break;
            case -1014792074:
                c9850af7 = new C11060cf7();
                break;
            case -840088834:
                c9850af7 = new C9267Ze7();
                break;
            case -797637467:
                c9850af7 = new C9033Ye7();
                break;
            case -82216347:
                c9850af7 = new C6345Ne7();
                break;
            case 582313809:
                c9850af7 = new C11855df7();
                break;
            case 590459437:
                c9850af7 = new C7083Qe7();
                break;
            default:
                c9850af7 = null;
                break;
        }
        if (c9850af7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Photo", Integer.valueOf(i)));
        }
        if (c9850af7 != null) {
            c9850af7.b(t1, z);
        }
        return c9850af7;
    }
}
