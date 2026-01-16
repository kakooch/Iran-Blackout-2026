package ir.nasim;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.wI4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23070wI4 {
    private boolean a;
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private SA2 c;

    public AbstractC23070wI4(boolean z) {
        this.a = z;
    }

    public final void a(GE0 ge0) {
        AbstractC13042fc3.i(ge0, "cancellable");
        this.b.add(ge0);
    }

    public final SA2 b() {
        return this.c;
    }

    public abstract void d();

    public void e(TV tv) {
        AbstractC13042fc3.i(tv, "backEvent");
    }

    public void f(TV tv) {
        AbstractC13042fc3.i(tv, "backEvent");
    }

    public final boolean g() {
        return this.a;
    }

    public final void h() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((GE0) it.next()).cancel();
        }
    }

    public final void i(GE0 ge0) {
        AbstractC13042fc3.i(ge0, "cancellable");
        this.b.remove(ge0);
    }

    public final void j(boolean z) {
        this.a = z;
        SA2 sa2 = this.c;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final void k(SA2 sa2) {
        this.c = sa2;
    }

    public void c() {
    }
}
