package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.ys8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C24596ys8 implements InterfaceC22250uu8 {
    private final Executor a;
    private final Object b = new Object();
    private InterfaceC13497gK4 c;

    public C24596ys8(Executor executor, InterfaceC13497gK4 interfaceC13497gK4) {
        this.a = executor;
        this.c = interfaceC13497gK4;
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        if (task.p()) {
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        return;
                    }
                    this.a.execute(new Ur8(this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
