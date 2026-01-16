package ir.nasim;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
final class Ok8 implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ Ol8 b;

    Ok8(Ol8 ol8, Task task) {
        this.b = ol8;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.n()) {
            this.b.c.t();
            return;
        }
        try {
            this.b.c.s(this.b.b.a(this.a));
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
