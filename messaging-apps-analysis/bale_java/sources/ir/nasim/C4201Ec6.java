package ir.nasim;

/* renamed from: ir.nasim.Ec6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4201Ec6 {
    private static final YU1 c = AbstractC20507s76.h("D_scheduler");
    private final YU1 a;
    private final C9528a7 b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.Ec6$a */
    class a implements FE0 {
        private volatile boolean a;
        private volatile EU1 b;

        public boolean a() {
            return this.a;
        }

        public synchronized void b(EU1 eu1) {
            try {
                if (this.a) {
                    eu1.cancel();
                } else {
                    this.b = eu1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // ir.nasim.FE0
        public synchronized void cancel() {
            if (!this.a) {
                this.a = true;
                if (this.b != null) {
                    this.b.cancel();
                }
            }
        }

        private a() {
            this.a = false;
        }
    }

    public C4201Ec6(C9528a7 c9528a7) {
        this(c9528a7, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(a aVar, Runnable runnable) {
        if (aVar.a()) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(final a aVar, final Runnable runnable) {
        if (aVar.a()) {
            return;
        }
        this.b.d(new Runnable() { // from class: ir.nasim.Ac6
            @Override // java.lang.Runnable
            public final void run() {
                C4201Ec6.c(aVar, runnable);
            }
        });
    }

    public FE0 e(final Runnable runnable, long j) {
        final a aVar = new a();
        aVar.b(this.a.a(new Runnable() { // from class: ir.nasim.zc6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(aVar, runnable);
            }
        }, j));
        return aVar;
    }

    public C4201Ec6(C9528a7 c9528a7, YU1 yu1) {
        this.b = c9528a7;
        this.a = yu1;
    }
}
