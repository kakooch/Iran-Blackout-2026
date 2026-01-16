package ir.nasim;

/* renamed from: ir.nasim.dX3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC11743dX3 {
    private static volatile AbstractC11743dX3 a;

    public static AbstractC11743dX3 b() {
        AbstractC11743dX3 c10979cX3 = a;
        if (c10979cX3 == null) {
            synchronized (AbstractC11743dX3.class) {
                try {
                    c10979cX3 = a;
                    if (c10979cX3 == null) {
                        c10979cX3 = new C10979cX3();
                        a = c10979cX3;
                    }
                } finally {
                }
            }
        }
        return c10979cX3;
    }

    public abstract void a();
}
