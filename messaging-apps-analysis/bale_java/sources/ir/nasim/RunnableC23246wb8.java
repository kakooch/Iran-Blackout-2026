package ir.nasim;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* renamed from: ir.nasim.wb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC23246wb8 implements Runnable {
    static final String t = HI3.f("WorkerWrapper");
    Context a;
    private String b;
    private List c;
    private WorkerParameters.a d;
    C17810nb8 e;
    ListenableWorker f;
    InterfaceC5684Kj7 g;
    private androidx.work.a i;
    private InterfaceC13849gv2 j;
    private WorkDatabase k;
    private InterfaceC18401ob8 l;
    private InterfaceC11606dI1 m;
    private InterfaceC20190rb8 n;
    private List o;
    private String p;
    private volatile boolean s;
    ListenableWorker.a h = ListenableWorker.a.a();
    C5314Iu6 q = C5314Iu6.t();
    InterfaceFutureC15215jC3 r = null;

    /* renamed from: ir.nasim.wb8$a */
    class a implements Runnable {
        final /* synthetic */ InterfaceFutureC15215jC3 a;
        final /* synthetic */ C5314Iu6 b;

        a(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, C5314Iu6 c5314Iu6) {
            this.a = interfaceFutureC15215jC3;
            this.b = c5314Iu6;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.get();
                HI3.c().a(RunnableC23246wb8.t, String.format("Starting work for %s", RunnableC23246wb8.this.e.c), new Throwable[0]);
                RunnableC23246wb8 runnableC23246wb8 = RunnableC23246wb8.this;
                runnableC23246wb8.r = runnableC23246wb8.f.p();
                this.b.r(RunnableC23246wb8.this.r);
            } catch (Throwable th) {
                this.b.q(th);
            }
        }
    }

    /* renamed from: ir.nasim.wb8$b */
    class b implements Runnable {
        final /* synthetic */ C5314Iu6 a;
        final /* synthetic */ String b;

        b(C5314Iu6 c5314Iu6, String str) {
            this.a = c5314Iu6;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.a.get();
                    if (aVar == null) {
                        HI3.c().b(RunnableC23246wb8.t, String.format("%s returned a null result. Treating it as a failure.", RunnableC23246wb8.this.e.c), new Throwable[0]);
                    } else {
                        HI3.c().a(RunnableC23246wb8.t, String.format("%s returned a %s result.", RunnableC23246wb8.this.e.c, aVar), new Throwable[0]);
                        RunnableC23246wb8.this.h = aVar;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    HI3.c().b(RunnableC23246wb8.t, String.format("%s failed because it threw an exception/error", this.b), e);
                } catch (CancellationException e2) {
                    HI3.c().d(RunnableC23246wb8.t, String.format("%s was cancelled", this.b), e2);
                } catch (ExecutionException e3) {
                    e = e3;
                    HI3.c().b(RunnableC23246wb8.t, String.format("%s failed because it threw an exception/error", this.b), e);
                }
                RunnableC23246wb8.this.f();
            } catch (Throwable th) {
                RunnableC23246wb8.this.f();
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.wb8$c */
    public static class c {
        Context a;
        ListenableWorker b;
        InterfaceC13849gv2 c;
        InterfaceC5684Kj7 d;
        androidx.work.a e;
        WorkDatabase f;
        String g;
        List h;
        WorkerParameters.a i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7, InterfaceC13849gv2 interfaceC13849gv2, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.d = interfaceC5684Kj7;
            this.c = interfaceC13849gv2;
            this.e = aVar;
            this.f = workDatabase;
            this.g = str;
        }

        public RunnableC23246wb8 a() {
            return new RunnableC23246wb8(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.i = aVar;
            }
            return this;
        }

        public c c(List list) {
            this.h = list;
            return this;
        }
    }

    RunnableC23246wb8(c cVar) {
        this.a = cVar.a;
        this.g = cVar.d;
        this.j = cVar.c;
        this.b = cVar.g;
        this.c = cVar.h;
        this.d = cVar.i;
        this.f = cVar.b;
        this.i = cVar.e;
        WorkDatabase workDatabase = cVar.f;
        this.k = workDatabase;
        this.l = workDatabase.Q();
        this.m = this.k.I();
        this.n = this.k.R();
    }

    private String a(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.b);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            HI3.c().d(t, String.format("Worker result SUCCESS for %s", this.p), new Throwable[0]);
            if (this.e.d()) {
                h();
                return;
            } else {
                m();
                return;
            }
        }
        if (aVar instanceof ListenableWorker.a.b) {
            HI3.c().d(t, String.format("Worker result RETRY for %s", this.p), new Throwable[0]);
            g();
            return;
        }
        HI3.c().d(t, String.format("Worker result FAILURE for %s", this.p), new Throwable[0]);
        if (this.e.d()) {
            h();
        } else {
            l();
        }
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.l.f(str2) != Ta8.CANCELLED) {
                this.l.b(Ta8.FAILED, str2);
            }
            linkedList.addAll(this.m.b(str2));
        }
    }

    private void g() {
        this.k.e();
        try {
            this.l.b(Ta8.ENQUEUED, this.b);
            this.l.u(this.b, System.currentTimeMillis());
            this.l.l(this.b, -1L);
            this.k.F();
        } finally {
            this.k.j();
            i(true);
        }
    }

    private void h() {
        this.k.e();
        try {
            this.l.u(this.b, System.currentTimeMillis());
            this.l.b(Ta8.ENQUEUED, this.b);
            this.l.s(this.b);
            this.l.l(this.b, -1L);
            this.k.F();
        } finally {
            this.k.j();
            i(false);
        }
    }

    private void i(boolean z) {
        ListenableWorker listenableWorker;
        this.k.e();
        try {
            if (!this.k.Q().r()) {
                FS4.a(this.a, RescheduleReceiver.class, false);
            }
            if (z) {
                this.l.b(Ta8.ENQUEUED, this.b);
                this.l.l(this.b, -1L);
            }
            if (this.e != null && (listenableWorker = this.f) != null && listenableWorker.j()) {
                this.j.b(this.b);
            }
            this.k.F();
            this.k.j();
            this.q.p(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.k.j();
            throw th;
        }
    }

    private void j() {
        Ta8 ta8F = this.l.f(this.b);
        if (ta8F == Ta8.RUNNING) {
            HI3.c().a(t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.b), new Throwable[0]);
            i(true);
        } else {
            HI3.c().a(t, String.format("Status for %s is %s; not doing any work", this.b, ta8F), new Throwable[0]);
            i(false);
        }
    }

    private void k() {
        androidx.work.b bVarB;
        if (n()) {
            return;
        }
        this.k.e();
        try {
            C17810nb8 c17810nb8G = this.l.g(this.b);
            this.e = c17810nb8G;
            if (c17810nb8G == null) {
                HI3.c().b(t, String.format("Didn't find WorkSpec for id %s", this.b), new Throwable[0]);
                i(false);
                this.k.F();
                return;
            }
            if (c17810nb8G.b != Ta8.ENQUEUED) {
                j();
                this.k.F();
                HI3.c().a(t, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.e.c), new Throwable[0]);
                return;
            }
            if (c17810nb8G.d() || this.e.c()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                C17810nb8 c17810nb8 = this.e;
                if (c17810nb8.n != 0 && jCurrentTimeMillis < c17810nb8.a()) {
                    HI3.c().a(t, String.format("Delaying execution for %s because it is being executed before schedule.", this.e.c), new Throwable[0]);
                    i(true);
                    this.k.F();
                    return;
                }
            }
            this.k.F();
            this.k.j();
            if (this.e.d()) {
                bVarB = this.e.e;
            } else {
                AbstractC18142o93 abstractC18142o93B = this.i.f().b(this.e.d);
                if (abstractC18142o93B == null) {
                    HI3.c().b(t, String.format("Could not create Input Merger %s", this.e.d), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.e.e);
                    arrayList.addAll(this.l.i(this.b));
                    bVarB = abstractC18142o93B.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.b), bVarB, this.o, this.d, this.e.k, this.i.e(), this.g, this.i.m(), new C14857ib8(this.k, this.g), new Sa8(this.k, this.j, this.g));
            if (this.f == null) {
                this.f = this.i.m().b(this.a, this.e.c, workerParameters);
            }
            ListenableWorker listenableWorker = this.f;
            if (listenableWorker == null) {
                HI3.c().b(t, String.format("Could not create Worker %s", this.e.c), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.l()) {
                HI3.c().b(t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.e.c), new Throwable[0]);
                l();
                return;
            }
            this.f.o();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            C5314Iu6 c5314Iu6T = C5314Iu6.t();
            Ra8 ra8 = new Ra8(this.a, this.e, this.f, workerParameters.b(), this.g);
            this.g.a().execute(ra8);
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3A = ra8.a();
            interfaceFutureC15215jC3A.j(new a(interfaceFutureC15215jC3A, c5314Iu6T), this.g.a());
            c5314Iu6T.j(new b(c5314Iu6T, this.p), this.g.c());
        } finally {
            this.k.j();
        }
    }

    private void m() {
        this.k.e();
        try {
            this.l.b(Ta8.SUCCEEDED, this.b);
            this.l.o(this.b, ((ListenableWorker.a.c) this.h).e());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str : this.m.b(this.b)) {
                if (this.l.f(str) == Ta8.BLOCKED && this.m.c(str)) {
                    HI3.c().d(t, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.l.b(Ta8.ENQUEUED, str);
                    this.l.u(str, jCurrentTimeMillis);
                }
            }
            this.k.F();
            this.k.j();
            i(false);
        } catch (Throwable th) {
            this.k.j();
            i(false);
            throw th;
        }
    }

    private boolean n() {
        if (!this.s) {
            return false;
        }
        HI3.c().a(t, String.format("Work interrupted for %s", this.p), new Throwable[0]);
        if (this.l.f(this.b) == null) {
            i(false);
        } else {
            i(!r0.a());
        }
        return true;
    }

    private boolean o() {
        boolean z;
        this.k.e();
        try {
            if (this.l.f(this.b) == Ta8.ENQUEUED) {
                this.l.b(Ta8.RUNNING, this.b);
                this.l.t(this.b);
                z = true;
            } else {
                z = false;
            }
            this.k.F();
            this.k.j();
            return z;
        } catch (Throwable th) {
            this.k.j();
            throw th;
        }
    }

    public InterfaceFutureC15215jC3 b() {
        return this.q;
    }

    public void d() {
        boolean zIsDone;
        this.s = true;
        n();
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.r;
        if (interfaceFutureC15215jC3 != null) {
            zIsDone = interfaceFutureC15215jC3.isDone();
            this.r.cancel(true);
        } else {
            zIsDone = false;
        }
        ListenableWorker listenableWorker = this.f;
        if (listenableWorker != null && !zIsDone) {
            listenableWorker.q();
        } else {
            HI3.c().a(t, String.format("WorkSpec %s is already done. Not interrupting.", this.e), new Throwable[0]);
        }
    }

    void f() {
        if (!n()) {
            this.k.e();
            try {
                Ta8 ta8F = this.l.f(this.b);
                this.k.P().a(this.b);
                if (ta8F == null) {
                    i(false);
                } else if (ta8F == Ta8.RUNNING) {
                    c(this.h);
                } else if (!ta8F.a()) {
                    g();
                }
                this.k.F();
                this.k.j();
            } catch (Throwable th) {
                this.k.j();
                throw th;
            }
        }
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((InterfaceC4435Fc6) it.next()).a(this.b);
            }
            AbstractC10449bd6.b(this.i, this.k, this.c);
        }
    }

    void l() {
        this.k.e();
        try {
            e(this.b);
            this.l.o(this.b, ((ListenableWorker.a.C0134a) this.h).e());
            this.k.F();
        } finally {
            this.k.j();
            i(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List listA = this.n.a(this.b);
        this.o = listA;
        this.p = a(listA);
        k();
    }
}
