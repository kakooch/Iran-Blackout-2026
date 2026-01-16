package ir.nasim;

import ir.nasim.HG4;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class PC3 implements HG4 {
    final C20298rm4 a = new C20298rm4();
    private final Map b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements QG4 {
        final AtomicBoolean a = new AtomicBoolean(true);
        final HG4.a b;
        final Executor c;

        a(Executor executor, HG4.a aVar) {
            this.c = executor;
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(b bVar) {
            if (this.a.get()) {
                if (bVar.a()) {
                    this.b.b(bVar.d());
                } else {
                    AbstractC4980Hj5.g(bVar.c());
                    this.b.a(bVar.c());
                }
            }
        }

        void c() {
            this.a.set(false);
        }

        @Override // ir.nasim.QG4
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(final b bVar) {
            this.c.execute(new Runnable() { // from class: ir.nasim.OC3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d(bVar);
                }
            });
        }
    }

    public static final class b {
        private final Object a;
        private final Throwable b;

        private b(Object obj, Throwable th) {
            this.a = obj;
            this.b = th;
        }

        static b b(Object obj) {
            return new b(obj, null);
        }

        public boolean a() {
            return this.b == null;
        }

        public Throwable c() {
            return this.b;
        }

        public Object d() {
            if (a()) {
                return this.a;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[Result: <");
            if (a()) {
                str = "Value: " + this.a;
            } else {
                str = "Error: " + this.b;
            }
            sb.append(str);
            sb.append(">]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(a aVar, a aVar2) {
        if (aVar != null) {
            this.a.o(aVar);
        }
        this.a.k(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(a aVar) {
        this.a.o(aVar);
    }

    @Override // ir.nasim.HG4
    public void a(Executor executor, HG4.a aVar) {
        synchronized (this.b) {
            try {
                final a aVar2 = (a) this.b.get(aVar);
                if (aVar2 != null) {
                    aVar2.c();
                }
                final a aVar3 = new a(executor, aVar);
                this.b.put(aVar, aVar3);
                AbstractC20567sE0.c().execute(new Runnable() { // from class: ir.nasim.MC3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e(aVar2, aVar3);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.HG4
    public void b(HG4.a aVar) {
        synchronized (this.b) {
            try {
                final a aVar2 = (a) this.b.remove(aVar);
                if (aVar2 != null) {
                    aVar2.c();
                    AbstractC20567sE0.c().execute(new Runnable() { // from class: ir.nasim.NC3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.f(aVar2);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(Object obj) {
        this.a.n(b.b(obj));
    }
}
