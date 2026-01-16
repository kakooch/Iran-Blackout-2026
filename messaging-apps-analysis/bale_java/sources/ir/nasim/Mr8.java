package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class Mr8 implements InterfaceC22250uu8 {
    private final Executor a;
    private final Object b = new Object();
    private InterfaceC14681iJ4 c;

    public Mr8(Executor executor, InterfaceC14681iJ4 interfaceC14681iJ4) {
        this.a = executor;
        this.c = interfaceC14681iJ4;
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        if (task.p() || task.n()) {
            return;
        }
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new RunnableC15016ir8(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
