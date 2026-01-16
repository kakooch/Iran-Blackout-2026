package ir.nasim;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.ft8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC13244ft8 implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ Rt8 b;

    RunnableC13244ft8(Rt8 rt8, Task task) {
        this.b = rt8;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task taskA = this.b.b.a(this.a.l());
            if (taskA == null) {
                this.b.a(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = AbstractC6151Mj7.b;
            taskA.g(executor, this.b);
            taskA.e(executor, this.b);
            taskA.a(executor, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.b.a((Exception) e.getCause());
            } else {
                this.b.a(e);
            }
        } catch (CancellationException unused) {
            this.b.c();
        } catch (Exception e2) {
            this.b.a(e2);
        }
    }
}
