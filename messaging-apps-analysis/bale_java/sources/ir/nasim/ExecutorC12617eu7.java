package ir.nasim;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.eu7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ExecutorC12617eu7 implements Executor {
    private final Executor a;
    private final ArrayDeque b;
    private Runnable c;
    private final Object d;

    public ExecutorC12617eu7(Executor executor) {
        AbstractC13042fc3.i(executor, "executor");
        this.a = executor;
        this.b = new ArrayDeque();
        this.d = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable, ExecutorC12617eu7 executorC12617eu7) {
        AbstractC13042fc3.i(runnable, "$command");
        AbstractC13042fc3.i(executorC12617eu7, "this$0");
        try {
            runnable.run();
        } finally {
            executorC12617eu7.c();
        }
    }

    public final void c() {
        synchronized (this.d) {
            try {
                Object objPoll = this.b.poll();
                Runnable runnable = (Runnable) objPoll;
                this.c = runnable;
                if (objPoll != null) {
                    this.a.execute(runnable);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        AbstractC13042fc3.i(runnable, "command");
        synchronized (this.d) {
            try {
                this.b.offer(new Runnable() { // from class: ir.nasim.du7
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExecutorC12617eu7.b(runnable, this);
                    }
                });
                if (this.c == null) {
                    c();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
