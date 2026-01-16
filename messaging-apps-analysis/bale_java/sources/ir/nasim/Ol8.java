package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class Ol8 implements InterfaceC22250uu8 {
    private final Executor a;
    private final InterfaceC20886sm1 b;
    private final yv8 c;

    public Ol8(Executor executor, InterfaceC20886sm1 interfaceC20886sm1, yv8 yv8Var) {
        this.a = executor;
        this.b = interfaceC20886sm1;
        this.c = yv8Var;
    }

    @Override // ir.nasim.InterfaceC22250uu8
    public final void b(Task task) {
        this.a.execute(new Ok8(this, task));
    }
}
