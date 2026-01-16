package ir.nasim;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.xU1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C23765xU1 {
    private final Map a = new HashMap();
    private final b b = new b();

    /* renamed from: ir.nasim.xU1$a */
    private static class a {
        final Lock a = new ReentrantLock();
        int b;

        a() {
        }
    }

    /* renamed from: ir.nasim.xU1$b */
    private static class b {
        private final Queue a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVar;
            synchronized (this.a) {
                aVar = (a) this.a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        void b(a aVar) {
            synchronized (this.a) {
                try {
                    if (this.a.size() < 10) {
                        this.a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    C23765xU1() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            try {
                aVarA = (a) this.a.get(str);
                if (aVarA == null) {
                    aVarA = this.b.a();
                    this.a.put(str, aVarA);
                }
                aVarA.b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVarA.a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) AbstractC3322Aj5.d((a) this.a.get(str));
                int i = aVar.b;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
                }
                int i2 = i - 1;
                aVar.b = i2;
                if (i2 == 0) {
                    a aVar2 = (a) this.a.remove(str);
                    if (!aVar2.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVar2 + ", safeKey: " + str);
                    }
                    this.b.b(aVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.a.unlock();
    }
}
