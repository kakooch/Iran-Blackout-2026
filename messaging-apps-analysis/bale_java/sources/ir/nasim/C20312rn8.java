package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.rn8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C20312rn8 implements InterfaceC13497gK4, InterfaceC14681iJ4, VI4, InterfaceC22250uu8 {
    private final Executor a;
    private final InterfaceC20886sm1 b;
    private final yv8 c;

    public C20312rn8(Executor executor, InterfaceC20886sm1 interfaceC20886sm1, yv8 yv8Var) {
        this.a = executor;
        this.b = interfaceC20886sm1;
        this.c = yv8Var;
    }

    @Override // ir.nasim.InterfaceC14681iJ4
    public final void a(Exception exc) {
        this.c.r(exc);
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        this.a.execute(new Pm8(this, task));
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
