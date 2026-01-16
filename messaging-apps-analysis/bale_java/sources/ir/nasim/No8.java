package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class No8 implements InterfaceC22250uu8 {
    private final Executor a;
    private final Object b = new Object();
    private VI4 c;

    public No8(Executor executor, VI4 vi4) {
        this.a = executor;
        this.c = vi4;
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        if (task.n()) {
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        return;
                    }
                    this.a.execute(new RunnableC13785go8(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
