package ir.nasim;

import ir.nasim.AbstractC8971Ya2;
import java.util.concurrent.locks.LockSupport;

/* renamed from: ir.nasim.Za2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9226Za2 extends AbstractC8717Xa2 {
    protected abstract Thread b1();

    protected void d1(long j, AbstractC8971Ya2.c cVar) {
        PD1.i.M1(j, cVar);
    }

    protected final void h1() {
        Thread threadB1 = b1();
        if (Thread.currentThread() != threadB1) {
            AbstractC10072b2.a();
            LockSupport.unpark(threadB1);
        }
    }
}
