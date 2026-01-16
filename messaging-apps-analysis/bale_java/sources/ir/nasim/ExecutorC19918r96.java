package ir.nasim;

import java.util.concurrent.Executor;

/* renamed from: ir.nasim.r96, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ExecutorC19918r96 implements Executor {
    private final Executor a;

    /* renamed from: ir.nasim.r96$a */
    static class a implements Runnable {
        private final Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e) {
                SI3.d("Executor", "Background execution failure.", e);
            }
        }
    }

    ExecutorC19918r96(Executor executor) {
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(new a(runnable));
    }
}
