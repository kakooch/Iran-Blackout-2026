package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class Jq8 implements InterfaceC22250uu8 {
    private final Executor a;
    private final Object b = new Object();
    private WI4 c;

    public Jq8(Executor executor, WI4 wi4) {
        this.a = executor;
        this.c = wi4;
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new Np8(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
