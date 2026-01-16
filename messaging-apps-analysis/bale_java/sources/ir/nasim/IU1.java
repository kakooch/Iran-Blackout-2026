package ir.nasim;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class IU1 {
    private boolean b;
    private boolean c;
    private boolean a = true;
    private final Queue d = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IU1 iu1, Runnable runnable) {
        AbstractC13042fc3.i(iu1, "this$0");
        AbstractC13042fc3.i(runnable, "$runnable");
        iu1.f(runnable);
    }

    private final void f(Runnable runnable) {
        if (!this.d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
        e();
    }

    public final boolean b() {
        return this.b || !this.a;
    }

    public final void c(InterfaceC11938do1 interfaceC11938do1, final Runnable runnable) {
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        AbstractC13042fc3.i(runnable, "runnable");
        WM3 wm3C0 = C12366eV1.c().C0();
        if (wm3C0.A0(interfaceC11938do1) || b()) {
            wm3C0.x0(interfaceC11938do1, new Runnable() { // from class: ir.nasim.GU1
                @Override // java.lang.Runnable
                public final void run() {
                    IU1.d(this.a, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (this.c) {
            return;
        }
        try {
            this.c = true;
            while ((!this.d.isEmpty()) && b()) {
                Runnable runnable = (Runnable) this.d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } finally {
            this.c = false;
        }
    }

    public final void g() {
        this.b = true;
        e();
    }

    public final void h() {
        this.a = true;
    }

    public final void i() {
        if (this.a) {
            if (!(!this.b)) {
                throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.a = false;
            e();
        }
    }
}
