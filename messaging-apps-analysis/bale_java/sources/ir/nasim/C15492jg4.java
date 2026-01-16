package ir.nasim;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.jg4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C15492jg4 {
    private final AtomicReference a = new AtomicReference();
    private final KJ b = new KJ();

    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        C16133kl4 c16133kl4 = (C16133kl4) this.a.getAndSet(null);
        if (c16133kl4 == null) {
            c16133kl4 = new C16133kl4(cls, cls2, cls3);
        } else {
            c16133kl4.a(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = (List) this.b.get(c16133kl4);
        }
        this.a.set(c16133kl4);
        return list;
    }

    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.b) {
            this.b.put(new C16133kl4(cls, cls2, cls3), list);
        }
    }
}
