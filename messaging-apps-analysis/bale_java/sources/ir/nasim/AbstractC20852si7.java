package ir.nasim;

import android.graphics.drawable.BitmapDrawable;

/* renamed from: ir.nasim.si7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC20852si7 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public long d;
    public AbstractC20488s57 e;
    public AbstractC20488s57 f;
    public byte[] g;
    public int h;
    public boolean i;
    public BitmapDrawable j;

    public static AbstractC20852si7 d(T1 t1, int i, boolean z) {
        AbstractC20852si7 c13714gh7;
        switch (i) {
            case -2100168954:
                c13714gh7 = new C13714gh7();
                break;
            case -1727196013:
                c13714gh7 = new C17278mh7();
                break;
            case -865771401:
                c13714gh7 = new C16096kh7();
                break;
            case -715532088:
                c13714gh7 = new C16687lh7();
                break;
            case -321430132:
                c13714gh7 = new C14915ih7();
                break;
            case 1326562017:
                c13714gh7 = new C14305hh7();
                break;
            case 1775479590:
                c13714gh7 = new C15505jh7();
                break;
            default:
                c13714gh7 = null;
                break;
        }
        if (c13714gh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in UserProfilePhoto", Integer.valueOf(i)));
        }
        if (c13714gh7 != null) {
            c13714gh7.b(t1, z);
        }
        return c13714gh7;
    }
}
