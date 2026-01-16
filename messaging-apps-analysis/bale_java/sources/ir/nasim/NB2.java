package ir.nasim;

import ir.nasim.AbstractC16967mA0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class NB2 implements InterfaceFutureC15215jC3 {
    private final InterfaceFutureC15215jC3 a;
    AbstractC16967mA0.a b;

    class a implements AbstractC16967mA0.c {
        a() {
        }

        @Override // ir.nasim.AbstractC16967mA0.c
        public Object a(AbstractC16967mA0.a aVar) {
            AbstractC4980Hj5.j(NB2.this.b == null, "The result can only set once!");
            NB2.this.b = aVar;
            return "FutureChain[" + NB2.this + "]";
        }
    }

    NB2(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        this.a = (InterfaceFutureC15215jC3) AbstractC4980Hj5.g(interfaceFutureC15215jC3);
    }

    public static NB2 a(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        return interfaceFutureC15215jC3 instanceof NB2 ? (NB2) interfaceFutureC15215jC3 : new NB2(interfaceFutureC15215jC3);
    }

    boolean b(Object obj) {
        AbstractC16967mA0.a aVar = this.b;
        if (aVar != null) {
            return aVar.c(obj);
        }
        return false;
    }

    boolean c(Throwable th) {
        AbstractC16967mA0.a aVar = this.b;
        if (aVar != null) {
            return aVar.f(th);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    public final NB2 d(InterfaceC21819uB2 interfaceC21819uB2, Executor executor) {
        return (NB2) WB2.y(this, interfaceC21819uB2, executor);
    }

    public final NB2 e(FK fk, Executor executor) {
        return (NB2) WB2.z(this, fk, executor);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.isDone();
    }

    @Override // ir.nasim.InterfaceFutureC15215jC3
    public void j(Runnable runnable, Executor executor) {
        this.a.j(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.a.get(j, timeUnit);
    }

    NB2() {
        this.a = AbstractC16967mA0.a(new a());
    }
}
