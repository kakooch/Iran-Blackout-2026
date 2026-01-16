package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ir.nasim.C4797Gp2;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: ir.nasim.mC3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16988mC3 {
    private final NV0 a;
    private final InterfaceC23757xT2 b;
    private final b c;
    private final CopyOnWriteArraySet d;
    private final ArrayDeque e;
    private final ArrayDeque f;
    private final Object g;
    private boolean h;
    private boolean i;

    /* renamed from: ir.nasim.mC3$a */
    public interface a {
        void invoke(Object obj);
    }

    /* renamed from: ir.nasim.mC3$b */
    public interface b {
        void a(Object obj, C4797Gp2 c4797Gp2);
    }

    /* renamed from: ir.nasim.mC3$c */
    private static final class c {
        public final Object a;
        private C4797Gp2.b b = new C4797Gp2.b();
        private boolean c;
        private boolean d;

        public c(Object obj) {
            this.a = obj;
        }

        public void a(int i, a aVar) {
            if (this.d) {
                return;
            }
            if (i != -1) {
                this.b.a(i);
            }
            this.c = true;
            aVar.invoke(this.a);
        }

        public void b(b bVar) {
            if (this.d || !this.c) {
                return;
            }
            C4797Gp2 c4797Gp2E = this.b.e();
            this.b = new C4797Gp2.b();
            this.c = false;
            bVar.a(this.a, c4797Gp2E);
        }

        public void c(b bVar) {
            this.d = true;
            if (this.c) {
                this.c = false;
                bVar.a(this.a, this.b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public C16988mC3(Looper looper, NV0 nv0, b bVar) {
        this(new CopyOnWriteArraySet(), looper, nv0, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(this.c);
            if (this.b.c(0)) {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i, aVar);
        }
    }

    private void m() {
        if (this.i) {
            AbstractC20011rK.g(Thread.currentThread() == this.b.getLooper().getThread());
        }
    }

    public void c(Object obj) {
        AbstractC20011rK.e(obj);
        synchronized (this.g) {
            try {
                if (this.h) {
                    return;
                }
                this.d.add(new c(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C16988mC3 d(Looper looper, NV0 nv0, b bVar) {
        return new C16988mC3(this.d, looper, nv0, bVar);
    }

    public C16988mC3 e(Looper looper, b bVar) {
        return d(looper, this.a, bVar);
    }

    public void f() {
        m();
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.b.c(0)) {
            InterfaceC23757xT2 interfaceC23757xT2 = this.b;
            interfaceC23757xT2.b(interfaceC23757xT2.a(0));
        }
        boolean z = !this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (z) {
            return;
        }
        while (!this.e.isEmpty()) {
            ((Runnable) this.e.peekFirst()).run();
            this.e.removeFirst();
        }
    }

    public void i(final int i, final a aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.d);
        this.f.add(new Runnable() { // from class: ir.nasim.kC3
            @Override // java.lang.Runnable
            public final void run() {
                C16988mC3.h(copyOnWriteArraySet, i, aVar);
            }
        });
    }

    public void j() {
        m();
        synchronized (this.g) {
            this.h = true;
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(this.c);
        }
        this.d.clear();
    }

    public void k(Object obj) {
        m();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.a.equals(obj)) {
                cVar.c(this.c);
                this.d.remove(cVar);
            }
        }
    }

    public void l(int i, a aVar) {
        i(i, aVar);
        f();
    }

    private C16988mC3(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, NV0 nv0, b bVar) {
        this.a = nv0;
        this.d = copyOnWriteArraySet;
        this.c = bVar;
        this.g = new Object();
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.b = nv0.a(looper, new Handler.Callback() { // from class: ir.nasim.lC3
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.g(message);
            }
        });
        this.i = true;
    }
}
