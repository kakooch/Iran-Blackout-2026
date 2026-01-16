package ir.nasim;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.mA0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16967mA0 {

    /* renamed from: ir.nasim.mA0$a */
    public static final class a {
        Object a;
        d b;
        private C24971zW5 c = C24971zW5.r();
        private boolean d;

        a() {
        }

        private void e() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public void a(Runnable runnable, Executor executor) {
            C24971zW5 c24971zW5 = this.c;
            if (c24971zW5 != null) {
                c24971zW5.j(runnable, executor);
            }
        }

        void b() {
            this.a = null;
            this.b = null;
            this.c.o(null);
        }

        public boolean c(Object obj) {
            this.d = true;
            d dVar = this.b;
            boolean z = dVar != null && dVar.b(obj);
            if (z) {
                e();
            }
            return z;
        }

        public boolean d() {
            this.d = true;
            d dVar = this.b;
            boolean z = dVar != null && dVar.a(true);
            if (z) {
                e();
            }
            return z;
        }

        public boolean f(Throwable th) {
            this.d = true;
            d dVar = this.b;
            boolean z = dVar != null && dVar.c(th);
            if (z) {
                e();
            }
            return z;
        }

        protected void finalize() {
            C24971zW5 c24971zW5;
            d dVar = this.b;
            if (dVar != null && !dVar.isDone()) {
                dVar.c(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a));
            }
            if (this.d || (c24971zW5 = this.c) == null) {
                return;
            }
            c24971zW5.o(null);
        }
    }

    /* renamed from: ir.nasim.mA0$b */
    static final class b extends Throwable {
        b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: ir.nasim.mA0$c */
    public interface c {
        Object a(a aVar);
    }

    /* renamed from: ir.nasim.mA0$d */
    private static final class d implements InterfaceFutureC15215jC3 {
        final WeakReference a;
        private final E1 b = new a();

        /* renamed from: ir.nasim.mA0$d$a */
        class a extends E1 {
            a() {
            }

            @Override // ir.nasim.E1
            protected String l() {
                a aVar = (a) d.this.a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.a + "]";
            }
        }

        d(a aVar) {
            this.a = new WeakReference(aVar);
        }

        boolean a(boolean z) {
            return this.b.cancel(z);
        }

        boolean b(Object obj) {
            return this.b.o(obj);
        }

        boolean c(Throwable th) {
            return this.b.p(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            a aVar = (a) this.a.get();
            boolean zCancel = this.b.cancel(z);
            if (zCancel && aVar != null) {
                aVar.b();
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.b.isDone();
        }

        @Override // ir.nasim.InterfaceFutureC15215jC3
        public void j(Runnable runnable, Executor executor) {
            this.b.j(runnable, executor);
        }

        public String toString() {
            return this.b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            return this.b.get(j, timeUnit);
        }
    }

    public static InterfaceFutureC15215jC3 a(c cVar) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.b = dVar;
        aVar.a = cVar.getClass();
        try {
            Object objA = cVar.a(aVar);
            if (objA != null) {
                aVar.a = objA;
            }
        } catch (Exception e) {
            dVar.c(e);
        }
        return dVar;
    }
}
