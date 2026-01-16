package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class IG1 {
    static final String d = HI3.f("DelayedWorkTracker");
    final C9660aL2 a;
    private final InterfaceC16352l76 b;
    private final Map c = new HashMap();

    class a implements Runnable {
        final /* synthetic */ C17810nb8 a;

        a(C17810nb8 c17810nb8) {
            this.a = c17810nb8;
        }

        @Override // java.lang.Runnable
        public void run() {
            HI3.c().a(IG1.d, String.format("Scheduling work %s", this.a.a), new Throwable[0]);
            IG1.this.a.f(this.a);
        }
    }

    public IG1(C9660aL2 c9660aL2, InterfaceC16352l76 interfaceC16352l76) {
        this.a = c9660aL2;
        this.b = interfaceC16352l76;
    }

    public void a(C17810nb8 c17810nb8) {
        Runnable runnable = (Runnable) this.c.remove(c17810nb8.a);
        if (runnable != null) {
            this.b.a(runnable);
        }
        a aVar = new a(c17810nb8);
        this.c.put(c17810nb8.a, aVar);
        this.b.b(c17810nb8.a() - System.currentTimeMillis(), aVar);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.c.remove(str);
        if (runnable != null) {
            this.b.a(runnable);
        }
    }
}
