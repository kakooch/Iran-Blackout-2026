package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class TI extends AbstractC5918Lj7 {
    private static volatile TI c;
    private static final Executor d = new Executor() { // from class: ir.nasim.RI
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            TI.h(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: ir.nasim.SI
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            TI.i(runnable);
        }
    };
    private AbstractC5918Lj7 a;
    private final AbstractC5918Lj7 b;

    private TI() {
        DF1 df1 = new DF1();
        this.b = df1;
        this.a = df1;
    }

    public static Executor f() {
        return e;
    }

    public static TI g() {
        if (c != null) {
            return c;
        }
        synchronized (TI.class) {
            try {
                if (c == null) {
                    c = new TI();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Runnable runnable) {
        g().c(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Runnable runnable) {
        g().a(runnable);
    }

    @Override // ir.nasim.AbstractC5918Lj7
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // ir.nasim.AbstractC5918Lj7
    public boolean b() {
        return this.a.b();
    }

    @Override // ir.nasim.AbstractC5918Lj7
    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}
