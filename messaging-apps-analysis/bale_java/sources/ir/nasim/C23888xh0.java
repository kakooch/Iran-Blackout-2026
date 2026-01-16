package ir.nasim;

import java.util.concurrent.locks.LockSupport;

/* renamed from: ir.nasim.xh0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C23888xh0 extends K0 {
    private final Thread d;
    private final AbstractC8717Xa2 e;

    public C23888xh0(InterfaceC11938do1 interfaceC11938do1, Thread thread, AbstractC8717Xa2 abstractC8717Xa2) {
        super(interfaceC11938do1, true, true);
        this.d = thread;
        this.e = abstractC8717Xa2;
    }

    @Override // ir.nasim.C22725vj3
    protected boolean B0() {
        return true;
    }

    @Override // ir.nasim.C22725vj3
    protected void Q(Object obj) {
        if (AbstractC13042fc3.d(Thread.currentThread(), this.d)) {
            return;
        }
        Thread thread = this.d;
        AbstractC10072b2.a();
        LockSupport.unpark(thread);
    }

    public final Object h1() throws Throwable {
        AbstractC10072b2.a();
        try {
            AbstractC8717Xa2 abstractC8717Xa2 = this.e;
            if (abstractC8717Xa2 != null) {
                AbstractC8717Xa2.N0(abstractC8717Xa2, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    AbstractC8717Xa2 abstractC8717Xa22 = this.e;
                    long jS0 = abstractC8717Xa22 != null ? abstractC8717Xa22.S0() : Long.MAX_VALUE;
                    if (p()) {
                        AbstractC8717Xa2 abstractC8717Xa23 = this.e;
                        if (abstractC8717Xa23 != null) {
                            AbstractC8717Xa2.D0(abstractC8717Xa23, false, 1, null);
                        }
                        AbstractC10072b2.a();
                        Object objH = AbstractC23321wj3.h(x0());
                        B01 b01 = objH instanceof B01 ? (B01) objH : null;
                        if (b01 == null) {
                            return objH;
                        }
                        throw b01.a;
                    }
                    AbstractC10072b2.a();
                    LockSupport.parkNanos(this, jS0);
                } catch (Throwable th) {
                    AbstractC8717Xa2 abstractC8717Xa24 = this.e;
                    if (abstractC8717Xa24 != null) {
                        AbstractC8717Xa2.D0(abstractC8717Xa24, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            Y(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            AbstractC10072b2.a();
            throw th2;
        }
    }
}
