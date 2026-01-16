package ir.nasim;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class A48 {
    private final C12544en4 a = new C12544en4(new Reference[16], 0);
    private final ReferenceQueue b = new ReferenceQueue();

    private final void a() {
        Reference referencePoll;
        do {
            referencePoll = this.b.poll();
            if (referencePoll != null) {
                this.a.t(referencePoll);
            }
        } while (referencePoll != null);
    }

    public final Object b() {
        a();
        while (this.a.o() != 0) {
            Object obj = ((Reference) this.a.w(r0.o() - 1)).get();
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    public final void c(Object obj) {
        a();
        this.a.d(new WeakReference(obj, this.b));
    }
}
