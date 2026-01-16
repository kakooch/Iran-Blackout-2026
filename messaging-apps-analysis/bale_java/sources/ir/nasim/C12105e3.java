package ir.nasim;

import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.e3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C12105e3 {
    private final ReentrantLock a = new ReentrantLock();
    private final InterfaceC9336Zm4 b = AbstractC12281eL6.a(C14653iG3.f.a());
    private final C11462d3 c = new C11462d3();

    public final InterfaceC10258bL6 a() {
        return this.b;
    }

    public final Object b(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "block");
        ReentrantLock reentrantLock = this.a;
        try {
            reentrantLock.lock();
            Object objInvoke = ua2.invoke(this.c);
            this.b.setValue(this.c.e());
            return objInvoke;
        } finally {
            reentrantLock.unlock();
        }
    }
}
