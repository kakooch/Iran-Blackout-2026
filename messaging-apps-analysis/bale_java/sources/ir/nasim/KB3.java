package ir.nasim;

import ir.nasim.AbstractC16967mA0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class KB3 implements InterfaceFutureC15215jC3 {
    List a;
    List b;
    private final boolean c;
    private final AtomicInteger d;
    private final InterfaceFutureC15215jC3 e = AbstractC16967mA0.a(new a());
    AbstractC16967mA0.a f;

    class a implements AbstractC16967mA0.c {
        a() {
        }

        @Override // ir.nasim.AbstractC16967mA0.c
        public Object a(AbstractC16967mA0.a aVar) {
            AbstractC4980Hj5.j(KB3.this.f == null, "The result can only set once!");
            KB3.this.f = aVar;
            return "ListFuture[" + this + "]";
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            KB3 kb3 = KB3.this;
            kb3.b = null;
            kb3.a = null;
        }
    }

    class c implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ InterfaceFutureC15215jC3 b;

        c(int i, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = i;
            this.b = interfaceFutureC15215jC3;
        }

        @Override // java.lang.Runnable
        public void run() {
            KB3.this.e(this.a, this.b);
        }
    }

    KB3(List list, boolean z, Executor executor) {
        this.a = (List) AbstractC4980Hj5.g(list);
        this.b = new ArrayList(list.size());
        this.c = z;
        this.d = new AtomicInteger(list.size());
        d(executor);
    }

    private void a() throws InterruptedException {
        List<InterfaceFutureC15215jC3> list = this.a;
        if (list == null || isDone()) {
            return;
        }
        for (InterfaceFutureC15215jC3 interfaceFutureC15215jC3 : list) {
            while (!interfaceFutureC15215jC3.isDone()) {
                try {
                    interfaceFutureC15215jC3.get();
                } catch (Error e) {
                    throw e;
                } catch (InterruptedException e2) {
                    throw e2;
                } catch (Throwable unused) {
                    if (this.c) {
                        return;
                    }
                }
            }
        }
    }

    private void d(Executor executor) {
        j(new b(), AbstractC20567sE0.a());
        if (this.a.isEmpty()) {
            this.f.c(new ArrayList(this.b));
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.b.add(null);
        }
        List list = this.a;
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = (InterfaceFutureC15215jC3) list.get(i2);
            interfaceFutureC15215jC3.j(new c(i2, interfaceFutureC15215jC3), executor);
        }
    }

    @Override // java.util.concurrent.Future
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List get() throws InterruptedException {
        a();
        return (List) this.e.get();
    }

    @Override // java.util.concurrent.Future
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List get(long j, TimeUnit timeUnit) {
        return (List) this.e.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        List list = this.a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((InterfaceFutureC15215jC3) it.next()).cancel(z);
            }
        }
        return this.e.cancel(z);
    }

    void e(int i, Future future) {
        AbstractC16967mA0.a aVar;
        ArrayList arrayList;
        int iDecrementAndGet;
        List list = this.b;
        if (isDone() || list == null) {
            AbstractC4980Hj5.j(this.c, "Future was done before all dependencies completed");
            return;
        }
        try {
            try {
                try {
                    try {
                        AbstractC4980Hj5.j(future.isDone(), "Tried to set value from future which is not done");
                        list.set(i, WB2.i(future));
                        iDecrementAndGet = this.d.decrementAndGet();
                        AbstractC4980Hj5.j(iDecrementAndGet >= 0, "Less than 0 remaining futures");
                    } catch (RuntimeException e) {
                        if (this.c) {
                            this.f.f(e);
                        }
                        int iDecrementAndGet2 = this.d.decrementAndGet();
                        AbstractC4980Hj5.j(iDecrementAndGet2 >= 0, "Less than 0 remaining futures");
                        if (iDecrementAndGet2 != 0) {
                            return;
                        }
                        List list2 = this.b;
                        if (list2 != null) {
                            aVar = this.f;
                            arrayList = new ArrayList(list2);
                        }
                    }
                } catch (ExecutionException e2) {
                    if (this.c) {
                        this.f.f(e2.getCause());
                    }
                    int iDecrementAndGet3 = this.d.decrementAndGet();
                    AbstractC4980Hj5.j(iDecrementAndGet3 >= 0, "Less than 0 remaining futures");
                    if (iDecrementAndGet3 != 0) {
                        return;
                    }
                    List list3 = this.b;
                    if (list3 != null) {
                        aVar = this.f;
                        arrayList = new ArrayList(list3);
                    }
                }
            } catch (Error e3) {
                this.f.f(e3);
                int iDecrementAndGet4 = this.d.decrementAndGet();
                AbstractC4980Hj5.j(iDecrementAndGet4 >= 0, "Less than 0 remaining futures");
                if (iDecrementAndGet4 != 0) {
                    return;
                }
                List list4 = this.b;
                if (list4 != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list4);
                }
            } catch (CancellationException unused) {
                if (this.c) {
                    cancel(false);
                }
                int iDecrementAndGet5 = this.d.decrementAndGet();
                AbstractC4980Hj5.j(iDecrementAndGet5 >= 0, "Less than 0 remaining futures");
                if (iDecrementAndGet5 != 0) {
                    return;
                }
                List list5 = this.b;
                if (list5 != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list5);
                }
            }
            if (iDecrementAndGet == 0) {
                List list6 = this.b;
                if (list6 != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list6);
                    aVar.c(arrayList);
                    return;
                }
                AbstractC4980Hj5.i(isDone());
            }
        } catch (Throwable th) {
            int iDecrementAndGet6 = this.d.decrementAndGet();
            AbstractC4980Hj5.j(iDecrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet6 == 0) {
                List list7 = this.b;
                if (list7 != null) {
                    this.f.c(new ArrayList(list7));
                } else {
                    AbstractC4980Hj5.i(isDone());
                }
            }
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.e.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.e.isDone();
    }

    @Override // ir.nasim.InterfaceFutureC15215jC3
    public void j(Runnable runnable, Executor executor) {
        this.e.j(runnable, executor);
    }
}
