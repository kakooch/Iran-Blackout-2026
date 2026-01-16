package ir.nasim;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.JobCancellationException;

/* renamed from: ir.nasim.qJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19412qJ0 extends K0 implements InterfaceC17639nJ0 {
    private final InterfaceC17639nJ0 d;

    public AbstractC19412qJ0(InterfaceC11938do1 interfaceC11938do1, InterfaceC17639nJ0 interfaceC17639nJ0, boolean z, boolean z2) {
        super(interfaceC11938do1, z, z2);
        this.d = interfaceC17639nJ0;
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public boolean A() {
        return this.d.A();
    }

    @Override // ir.nasim.C22725vj3
    public void b0(Throwable th) {
        CancellationException cancellationExceptionW0 = C22725vj3.W0(this, th, null, 1, null);
        this.d.g(cancellationExceptionW0);
        Y(cancellationExceptionW0);
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public void f(UA2 ua2) {
        this.d.f(ua2);
    }

    @Override // ir.nasim.C22725vj3, ir.nasim.InterfaceC13730gj3
    public final void g(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(g0(), null, this);
        }
        b0(cancellationException);
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public Object h(Object obj) {
        return this.d.h(obj);
    }

    @Override // ir.nasim.VI5
    public Object i(InterfaceC20295rm1 interfaceC20295rm1) {
        return this.d.i(interfaceC20295rm1);
    }

    protected final InterfaceC17639nJ0 i1() {
        return this.d;
    }

    @Override // ir.nasim.VI5
    public CJ0 iterator() {
        return this.d.iterator();
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public Object o(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.d.o(obj, interfaceC20295rm1);
    }

    @Override // ir.nasim.VI5
    public InterfaceC13763gm6 r() {
        return this.d.r();
    }

    @Override // ir.nasim.VI5
    public InterfaceC13763gm6 t() {
        return this.d.t();
    }

    @Override // ir.nasim.VI5
    public Object v() {
        return this.d.v();
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public boolean w(Throwable th) {
        return this.d.w(th);
    }

    @Override // ir.nasim.VI5
    public Object x(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objX = this.d.x(interfaceC20295rm1);
        AbstractC14862ic3.e();
        return objX;
    }

    public final InterfaceC17639nJ0 h1() {
        return this;
    }
}
