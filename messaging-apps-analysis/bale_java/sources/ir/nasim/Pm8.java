package ir.nasim;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class Pm8 implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ C20312rn8 b;

    Pm8(C20312rn8 c20312rn8, Task task) {
        this.b = c20312rn8;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) this.b.b.a(this.a);
            if (task == null) {
                this.b.a(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = AbstractC6151Mj7.b;
            task.g(executor, this.b);
            task.e(executor, this.b);
            task.a(executor, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.b.c.r((Exception) e.getCause());
            } else {
                this.b.c.r(e);
            }
        } catch (Exception e2) {
            this.b.c.r(e2);
        }
    }
}
