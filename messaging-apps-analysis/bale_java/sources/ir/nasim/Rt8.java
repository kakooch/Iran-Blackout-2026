package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class Rt8 implements InterfaceC13497gK4, InterfaceC14681iJ4, VI4, InterfaceC22250uu8 {
    private final Executor a;
    private final G07 b;
    private final yv8 c;

    public Rt8(Executor executor, G07 g07, yv8 yv8Var) {
        this.a = executor;
        this.b = g07;
        this.c = yv8Var;
    }

    @Override // ir.nasim.InterfaceC14681iJ4
    public final void a(Exception exc) {
        this.c.r(exc);
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        this.a.execute(new RunnableC13244ft8(this, task));
    }

    @Override // ir.nasim.VI4
    public final void c() {
        this.c.t();
    }

    @Override // ir.nasim.InterfaceC13497gK4
    public final void onSuccess(Object obj) {
        this.c.s(obj);
    }
}
