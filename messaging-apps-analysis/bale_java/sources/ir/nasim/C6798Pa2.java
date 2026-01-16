package ir.nasim;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Pa2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C6798Pa2 implements InterfaceC17465n07, InterfaceC17444my5 {
    private final Map a = new HashMap();
    private Queue b = new ArrayDeque();
    private final Executor c;

    C6798Pa2(Executor executor) {
        this.c = executor;
    }

    private synchronized Set e(AbstractC17203ma2 abstractC17203ma2) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Map.Entry entry, AbstractC17203ma2 abstractC17203ma2) {
        ((InterfaceC7276Ra2) entry.getKey()).a(abstractC17203ma2);
    }

    @Override // ir.nasim.InterfaceC17465n07
    public void a(Class cls, InterfaceC7276Ra2 interfaceC7276Ra2) {
        b(cls, this.c, interfaceC7276Ra2);
    }

    @Override // ir.nasim.InterfaceC17465n07
    public synchronized void b(Class cls, Executor executor, InterfaceC7276Ra2 interfaceC7276Ra2) {
        try {
            AbstractC4263Ej5.b(cls);
            AbstractC4263Ej5.b(interfaceC7276Ra2);
            AbstractC4263Ej5.b(executor);
            if (!this.a.containsKey(cls)) {
                this.a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.a.get(cls)).put(interfaceC7276Ra2, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    void d() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.b;
                if (queue != null) {
                    this.b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                g(null);
            }
        }
    }

    public void g(final AbstractC17203ma2 abstractC17203ma2) {
        AbstractC4263Ej5.b(abstractC17203ma2);
        synchronized (this) {
            try {
                Queue queue = this.b;
                if (queue != null) {
                    queue.add(abstractC17203ma2);
                    return;
                }
                for (final Map.Entry entry : e(abstractC17203ma2)) {
                    ((Executor) entry.getValue()).execute(new Runnable(entry, abstractC17203ma2) { // from class: ir.nasim.Ma2
                        public final /* synthetic */ Map.Entry a;

                        @Override // java.lang.Runnable
                        public final void run() {
                            C6798Pa2.f(this.a, null);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
