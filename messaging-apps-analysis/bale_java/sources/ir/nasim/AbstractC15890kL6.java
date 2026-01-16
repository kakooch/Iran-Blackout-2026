package ir.nasim;

import ir.nasim.HG4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.kL6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15890kL6 implements HG4 {
    private final AtomicReference b;
    private final Object a = new Object();
    private int c = 0;
    private boolean d = false;
    private final Map e = new HashMap();
    private final CopyOnWriteArraySet f = new CopyOnWriteArraySet();

    /* renamed from: ir.nasim.kL6$a */
    static abstract class a {
        a() {
        }

        static a b(Throwable th) {
            return new BT(th);
        }

        public abstract Throwable a();
    }

    /* renamed from: ir.nasim.kL6$b */
    private static final class b implements Runnable {
        private static final Object h = new Object();
        private final Executor a;
        private final HG4.a b;
        private final AtomicReference d;
        private final AtomicBoolean c = new AtomicBoolean(true);
        private Object e = h;
        private int f = -1;
        private boolean g = false;

        b(AtomicReference atomicReference, Executor executor, HG4.a aVar) {
            this.d = atomicReference;
            this.a = executor;
            this.b = aVar;
        }

        void a() {
            this.c.set(false);
        }

        void b(int i) {
            synchronized (this) {
                try {
                    if (!this.c.get()) {
                        return;
                    }
                    if (i <= this.f) {
                        return;
                    }
                    this.f = i;
                    if (this.g) {
                        return;
                    }
                    this.g = true;
                    try {
                        this.a.execute(this);
                    } finally {
                        synchronized (this) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (!this.c.get()) {
                        this.g = false;
                        return;
                    }
                    Object obj = this.d.get();
                    int i = this.f;
                    while (true) {
                        if (!Objects.equals(this.e, obj)) {
                            this.e = obj;
                            if (obj instanceof a) {
                                this.b.a(((a) obj).a());
                            } else {
                                this.b.b(obj);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (i == this.f || !this.c.get()) {
                                    break;
                                }
                                obj = this.d.get();
                                i = this.f;
                            } finally {
                            }
                        }
                    }
                    this.g = false;
                } finally {
                }
            }
        }
    }

    AbstractC15890kL6(Object obj, boolean z) {
        if (!z) {
            this.b = new AtomicReference(obj);
        } else {
            AbstractC4980Hj5.b(obj instanceof Throwable, "Initial errors must be Throwable");
            this.b = new AtomicReference(a.b((Throwable) obj));
        }
    }

    private void d(HG4.a aVar) {
        b bVar = (b) this.e.remove(aVar);
        if (bVar != null) {
            bVar.a();
            this.f.remove(bVar);
        }
    }

    private void f(Object obj) {
        Iterator it;
        int i;
        synchronized (this.a) {
            try {
                if (Objects.equals(this.b.getAndSet(obj), obj)) {
                    return;
                }
                int i2 = this.c + 1;
                this.c = i2;
                if (this.d) {
                    return;
                }
                this.d = true;
                Iterator it2 = this.f.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ((b) it2.next()).b(i2);
                    } else {
                        synchronized (this.a) {
                            try {
                                if (this.c == i2) {
                                    this.d = false;
                                    return;
                                } else {
                                    it = this.f.iterator();
                                    i = this.c;
                                }
                            } finally {
                            }
                        }
                        it2 = it;
                        i2 = i;
                    }
                }
            } finally {
            }
        }
    }

    @Override // ir.nasim.HG4
    public void a(Executor executor, HG4.a aVar) {
        b bVar;
        synchronized (this.a) {
            d(aVar);
            bVar = new b(this.b, executor, aVar);
            this.e.put(aVar, bVar);
            this.f.add(bVar);
        }
        bVar.b(0);
    }

    @Override // ir.nasim.HG4
    public void b(HG4.a aVar) {
        synchronized (this.a) {
            d(aVar);
        }
    }

    public InterfaceFutureC15215jC3 c() {
        Object obj = this.b.get();
        return obj instanceof a ? WB2.j(((a) obj).a()) : WB2.l(obj);
    }

    void e(Object obj) {
        f(obj);
    }
}
