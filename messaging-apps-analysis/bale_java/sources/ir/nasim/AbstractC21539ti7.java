package ir.nasim;

/* renamed from: ir.nasim.ti7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21539ti7 extends AbstractC12724f57 {
    public int b;

    public static AbstractC21539ti7 d(T1 t1, int i, boolean z) {
        AbstractC21539ti7 c23895xh7;
        switch (i) {
            case -496024847:
                c23895xh7 = new C23895xh7();
                break;
            case -306628279:
                c23895xh7 = new C23305wh7();
                break;
            case 9203775:
                c23895xh7 = new C22709vh7();
                break;
            case 129960444:
                c23895xh7 = new C22119uh7();
                break;
            case 164646985:
                c23895xh7 = new C20842sh7();
                break;
            case 2011940674:
                c23895xh7 = new C21529th7();
                break;
            default:
                c23895xh7 = null;
                break;
        }
        if (c23895xh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in UserStatus", Integer.valueOf(i)));
        }
        if (c23895xh7 != null) {
            c23895xh7.b(t1, z);
        }
        return c23895xh7;
    }
}
