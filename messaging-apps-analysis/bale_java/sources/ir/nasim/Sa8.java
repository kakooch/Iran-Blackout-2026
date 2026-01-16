package ir.nasim;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* loaded from: classes2.dex */
public class Sa8 implements InterfaceC14442hv2 {
    private static final String d = HI3.f("WMFgUpdater");
    private final InterfaceC5684Kj7 a;
    final InterfaceC13849gv2 b;
    final InterfaceC18401ob8 c;

    class a implements Runnable {
        final /* synthetic */ C5314Iu6 a;
        final /* synthetic */ UUID b;
        final /* synthetic */ C13258fv2 c;
        final /* synthetic */ Context d;

        a(C5314Iu6 c5314Iu6, UUID uuid, C13258fv2 c13258fv2, Context context) {
            this.a = c5314Iu6;
            this.b = uuid;
            this.c = c13258fv2;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.a.isCancelled()) {
                    String string = this.b.toString();
                    Ta8 ta8F = Sa8.this.c.f(string);
                    if (ta8F == null || ta8F.a()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    Sa8.this.b.a(string, this.c);
                    this.d.startService(androidx.work.impl.foreground.a.a(this.d, string, this.c));
                }
                this.a.p(null);
            } catch (Throwable th) {
                this.a.q(th);
            }
        }
    }

    public Sa8(WorkDatabase workDatabase, InterfaceC13849gv2 interfaceC13849gv2, InterfaceC5684Kj7 interfaceC5684Kj7) {
        this.b = interfaceC13849gv2;
        this.a = interfaceC5684Kj7;
        this.c = workDatabase.Q();
    }

    @Override // ir.nasim.InterfaceC14442hv2
    public InterfaceFutureC15215jC3 a(Context context, UUID uuid, C13258fv2 c13258fv2) {
        C5314Iu6 c5314Iu6T = C5314Iu6.t();
        this.a.b(new a(c5314Iu6T, uuid, c13258fv2, context));
        return c5314Iu6T;
    }
}
