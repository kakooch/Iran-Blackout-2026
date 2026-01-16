package ir.nasim;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class XF3 {
    private static final com.bumptech.glide.load.engine.q c = new com.bumptech.glide.load.engine.q(Object.class, Object.class, Object.class, Collections.singletonList(new com.bumptech.glide.load.engine.i(Object.class, Object.class, Object.class, Collections.emptyList(), new C23010wB7(), null)), null);
    private final KJ a = new KJ();
    private final AtomicReference b = new AtomicReference();

    private C16133kl4 b(Class cls, Class cls2, Class cls3) {
        C16133kl4 c16133kl4 = (C16133kl4) this.b.getAndSet(null);
        if (c16133kl4 == null) {
            c16133kl4 = new C16133kl4();
        }
        c16133kl4.a(cls, cls2, cls3);
        return c16133kl4;
    }

    public com.bumptech.glide.load.engine.q a(Class cls, Class cls2, Class cls3) {
        com.bumptech.glide.load.engine.q qVar;
        C16133kl4 c16133kl4B = b(cls, cls2, cls3);
        synchronized (this.a) {
            qVar = (com.bumptech.glide.load.engine.q) this.a.get(c16133kl4B);
        }
        this.b.set(c16133kl4B);
        return qVar;
    }

    public boolean c(com.bumptech.glide.load.engine.q qVar) {
        return c.equals(qVar);
    }

    public void d(Class cls, Class cls2, Class cls3, com.bumptech.glide.load.engine.q qVar) {
        synchronized (this.a) {
            KJ kj = this.a;
            C16133kl4 c16133kl4 = new C16133kl4(cls, cls2, cls3);
            if (qVar == null) {
                qVar = c;
            }
            kj.put(c16133kl4, qVar);
        }
    }
}
