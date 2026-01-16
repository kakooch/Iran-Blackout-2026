package ir.nasim;

/* renamed from: ir.nasim.b01, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10054b01 {
    private static final C9528a7 e;
    private static final C4201Ec6 f;
    private final Runnable a;
    private FE0 b;
    private boolean c;
    private long d;

    static {
        C9528a7 c9528a7D = C12736f7.n().d("common_timer", new V6() { // from class: ir.nasim.a01
            @Override // ir.nasim.V6
            public final K6 create() {
                return new K6();
            }
        });
        e = c9528a7D;
        f = new C4201Ec6(c9528a7D);
    }

    public C10054b01(Runnable runnable) {
        this.a = runnable;
    }

    public void a() {
        FE0 fe0 = this.b;
        if (fe0 != null) {
            fe0.cancel();
        }
    }

    public void b() {
        this.c = true;
        a();
    }

    public long c() {
        return this.d;
    }

    public void d(long j) {
        if (this.c) {
            return;
        }
        FE0 fe0 = this.b;
        if (fe0 != null) {
            fe0.cancel();
        }
        this.d = AbstractC20507s76.p() + j;
        this.b = f.e(this.a, j);
    }
}
