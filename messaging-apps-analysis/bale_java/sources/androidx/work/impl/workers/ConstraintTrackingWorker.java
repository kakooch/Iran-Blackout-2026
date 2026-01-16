package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import ir.nasim.C17810nb8;
import ir.nasim.C5314Iu6;
import ir.nasim.HI3;
import ir.nasim.InterfaceC5684Kj7;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.Ma8;
import ir.nasim.Na8;
import ir.nasim.Za8;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements Ma8 {
    private static final String k = HI3.f("ConstraintTrkngWrkr");
    private WorkerParameters f;
    final Object g;
    volatile boolean h;
    C5314Iu6 i;
    private ListenableWorker j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    class b implements Runnable {
        final /* synthetic */ InterfaceFutureC15215jC3 a;

        b(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = interfaceFutureC15215jC3;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.g) {
                try {
                    if (ConstraintTrackingWorker.this.h) {
                        ConstraintTrackingWorker.this.t();
                    } else {
                        ConstraintTrackingWorker.this.i.r(this.a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f = workerParameters;
        this.g = new Object();
        this.h = false;
        this.i = C5314Iu6.t();
    }

    @Override // ir.nasim.Ma8
    public void b(List list) {
        HI3.c().a(k, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.g) {
            this.h = true;
        }
    }

    @Override // ir.nasim.Ma8
    public void e(List list) {
    }

    @Override // androidx.work.ListenableWorker
    public InterfaceC5684Kj7 h() {
        return Za8.k(a()).p();
    }

    @Override // androidx.work.ListenableWorker
    public boolean j() {
        ListenableWorker listenableWorker = this.j;
        return listenableWorker != null && listenableWorker.j();
    }

    @Override // androidx.work.ListenableWorker
    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.j;
        if (listenableWorker == null || listenableWorker.k()) {
            return;
        }
        this.j.q();
    }

    @Override // androidx.work.ListenableWorker
    public InterfaceFutureC15215jC3 p() {
        c().execute(new a());
        return this.i;
    }

    public WorkDatabase r() {
        return Za8.k(a()).o();
    }

    void s() {
        this.i.p(ListenableWorker.a.a());
    }

    void t() {
        this.i.p(ListenableWorker.a.b());
    }

    void u() {
        String strM = g().m("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(strM)) {
            HI3.c().b(k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        ListenableWorker listenableWorkerB = i().b(a(), strM, this.f);
        this.j = listenableWorkerB;
        if (listenableWorkerB == null) {
            HI3.c().a(k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        C17810nb8 c17810nb8G = r().Q().g(f().toString());
        if (c17810nb8G == null) {
            s();
            return;
        }
        Na8 na8 = new Na8(a(), h(), this);
        na8.d(Collections.singletonList(c17810nb8G));
        if (!na8.c(f().toString())) {
            HI3.c().a(k, String.format("Constraints not met for delegate %s. Requesting retry.", strM), new Throwable[0]);
            t();
            return;
        }
        HI3.c().a(k, String.format("Constraints met for delegate %s", strM), new Throwable[0]);
        try {
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3P = this.j.p();
            interfaceFutureC15215jC3P.j(new b(interfaceFutureC15215jC3P), c());
        } catch (Throwable th) {
            HI3 hi3C = HI3.c();
            String str = k;
            hi3C.a(str, String.format("Delegated worker %s threw exception in startWork.", strM), th);
            synchronized (this.g) {
                try {
                    if (this.h) {
                        HI3.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        t();
                    } else {
                        s();
                    }
                } finally {
                }
            }
        }
    }
}
