package ir.nasim;

/* renamed from: ir.nasim.vI7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C22477vI7 extends F90 {
    public static int f;
    private static volatile C22477vI7[] g = new C22477vI7[1];
    public long c;
    private final Object d;
    private AbstractC19652qi7 e;

    /* renamed from: ir.nasim.vI7$a */
    class a extends AbstractC19652qi7 {
        a() {
        }
    }

    public C22477vI7(int i) {
        super(i);
        this.c = 0L;
        this.d = new Object();
    }

    public static C22477vI7 j(int i) {
        C22477vI7 c22477vI7 = g[i];
        if (c22477vI7 == null) {
            synchronized (C22477vI7.class) {
                try {
                    c22477vI7 = g[i];
                    if (c22477vI7 == null) {
                        C22477vI7[] c22477vI7Arr = g;
                        C22477vI7 c22477vI72 = new C22477vI7(i);
                        c22477vI7Arr[i] = c22477vI72;
                        c22477vI7 = c22477vI72;
                    }
                } finally {
                }
            }
        }
        return c22477vI7;
    }

    public static boolean l(int i) {
        return i >= 0 && i < 1 && j(i).k();
    }

    public long h() {
        return 0L;
    }

    public AbstractC19652qi7 i() {
        return new a();
    }

    public boolean k() {
        boolean z;
        synchronized (this.d) {
            z = this.e != null;
        }
        return z;
    }
}
