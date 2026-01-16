package ir.nasim;

/* renamed from: ir.nasim.i57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14549i57 extends AbstractC12724f57 {
    public static AbstractC14549i57 d(T1 t1, int i, boolean z) {
        AbstractC14549i57 c24141y67;
        switch (i) {
            case -1212997976:
                c24141y67 = new C24141y67();
                break;
            case -1012849566:
                c24141y67 = new C22961w67();
                break;
            case -69724536:
                c24141y67 = new C23551x67();
                break;
            case 1527845466:
                c24141y67 = new C22365v67();
                break;
            case 1834973166:
                c24141y67 = new C24731z67();
                break;
            default:
                c24141y67 = null;
                break;
        }
        if (c24141y67 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in BaseTheme", Integer.valueOf(i)));
        }
        if (c24141y67 != null) {
            c24141y67.b(t1, z);
        }
        return c24141y67;
    }
}
