package ir.nasim;

import java.util.concurrent.Executor;

/* renamed from: ir.nasim.gd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13669gd2 {
    private static final Executor a = new a();
    private static final Executor b = new b();

    /* renamed from: ir.nasim.gd2$a */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            YM7.w(runnable);
        }
    }

    /* renamed from: ir.nasim.gd2$b */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return b;
    }

    public static Executor b() {
        return a;
    }
}
