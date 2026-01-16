package ir.nasim;

import android.content.Context;
import androidx.work.ListenableWorker;

/* loaded from: classes2.dex */
public class Ra8 implements Runnable {
    static final String g = HI3.f("WorkForegroundRunnable");
    final C5314Iu6 a = C5314Iu6.t();
    final Context b;
    final C17810nb8 c;
    final ListenableWorker d;
    final InterfaceC14442hv2 e;
    final InterfaceC5684Kj7 f;

    class a implements Runnable {
        final /* synthetic */ C5314Iu6 a;

        a(C5314Iu6 c5314Iu6) {
            this.a = c5314Iu6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.r(Ra8.this.d.d());
        }
    }

    class b implements Runnable {
        final /* synthetic */ C5314Iu6 a;

        b(C5314Iu6 c5314Iu6) {
            this.a = c5314Iu6;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C13258fv2 c13258fv2 = (C13258fv2) this.a.get();
                if (c13258fv2 == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", Ra8.this.c.c));
                }
                HI3.c().a(Ra8.g, String.format("Updating notification for %s", Ra8.this.c.c), new Throwable[0]);
                Ra8.this.d.n(true);
                Ra8 ra8 = Ra8.this;
                ra8.a.r(ra8.e.a(ra8.b, ra8.d.f(), c13258fv2));
            } catch (Throwable th) {
                Ra8.this.a.q(th);
            }
        }
    }

    public Ra8(Context context, C17810nb8 c17810nb8, ListenableWorker listenableWorker, InterfaceC14442hv2 interfaceC14442hv2, InterfaceC5684Kj7 interfaceC5684Kj7) {
        this.b = context;
        this.c = c17810nb8;
        this.d = listenableWorker;
        this.e = interfaceC14442hv2;
        this.f = interfaceC5684Kj7;
    }

    public InterfaceFutureC15215jC3 a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.c.q || C7139Ql0.c()) {
            this.a.p(null);
            return;
        }
        C5314Iu6 c5314Iu6T = C5314Iu6.t();
        this.f.a().execute(new a(c5314Iu6T));
        c5314Iu6T.j(new b(c5314Iu6T), this.f.a());
    }
}
