package ir.nasim;

import androidx.work.impl.WorkDatabase;

/* loaded from: classes2.dex */
public class JN6 implements Runnable {
    private static final String d = HI3.f("StopWorkRunnable");
    private final Za8 a;
    private final String b;
    private final boolean c;

    public JN6(Za8 za8, String str, boolean z) {
        this.a = za8;
        this.b = str;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zO;
        WorkDatabase workDatabaseO = this.a.o();
        C13231fs5 c13231fs5M = this.a.m();
        InterfaceC18401ob8 interfaceC18401ob8Q = workDatabaseO.Q();
        workDatabaseO.e();
        try {
            boolean zH = c13231fs5M.h(this.b);
            if (this.c) {
                zO = this.a.m().n(this.b);
            } else {
                if (!zH && interfaceC18401ob8Q.f(this.b) == Ta8.RUNNING) {
                    interfaceC18401ob8Q.b(Ta8.ENQUEUED, this.b);
                }
                zO = this.a.m().o(this.b);
            }
            HI3.c().a(d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.b, Boolean.valueOf(zO)), new Throwable[0]);
            workDatabaseO.F();
            workDatabaseO.j();
        } catch (Throwable th) {
            workDatabaseO.j();
            throw th;
        }
    }
}
