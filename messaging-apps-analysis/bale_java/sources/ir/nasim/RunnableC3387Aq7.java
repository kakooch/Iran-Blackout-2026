package ir.nasim;

/* renamed from: ir.nasim.Aq7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class RunnableC3387Aq7 extends C18419od6 implements Runnable {
    public final long e;

    public RunnableC3387Aq7(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC20295rm1.getContext(), interfaceC20295rm1);
        this.e = j;
    }

    @Override // ir.nasim.K0, ir.nasim.C22725vj3
    public String I0() {
        return super.I0() + "(timeMillis=" + this.e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        Y(AbstractC3860Cq7.a(this.e, HG1.d(getContext()), this));
    }
}
