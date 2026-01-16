package ir.nasim;

import android.graphics.drawable.BitmapDrawable;

/* renamed from: ir.nasim.l57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC16333l57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public AbstractC20488s57 d;
    public AbstractC20488s57 e;
    public byte[] f;
    public int g;
    public long h;
    public BitmapDrawable i;

    public static AbstractC16333l57 d(T1 t1, int i, boolean z) {
        return e(t1, i, z, true);
    }

    public static AbstractC16333l57 e(T1 t1, int i, boolean z, boolean z2) {
        AbstractC16333l57 c12153e77;
        switch (i) {
            case -770990276:
                c12153e77 = new C12153e77();
                break;
            case 476978193:
                c12153e77 = new C10130b77();
                break;
            case 935395612:
                c12153e77 = new C10746c77();
                break;
            case 1197267925:
                c12153e77 = new C11510d77();
                break;
            case 1200680453:
                c12153e77 = new C12744f77();
                break;
            case 1632839530:
                c12153e77 = new C13380g77();
                break;
            default:
                c12153e77 = null;
                break;
        }
        if (c12153e77 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatPhoto", Integer.valueOf(i)));
        }
        if (c12153e77 != null) {
            c12153e77.b(t1, z);
        }
        return c12153e77;
    }
}
